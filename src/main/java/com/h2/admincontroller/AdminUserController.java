package com.h2.admincontroller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.h2.model.dao.interfaces.RolesDao;
import com.h2.model.dao.interfaces.UserDao;
import com.h2.model.pojo.Roles;
import com.h2.model.pojo.User;

@Controller
@RequestMapping(value={"/user"})
public class AdminUserController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RolesDao rolesDao;
	
	@RequestMapping(value={"/list.do"}, method = RequestMethod.GET)
	public String getListAdmin(Model model){
		List<User> listUser = new ArrayList<User>();
		listUser = userDao.getListSubAdmin();
		if (listUser.size() != 0){
			for (int i = 0; i < listUser.size(); i++){
				listUser.get(i).setUserPassword("");
			}
		}
		model.addAttribute("listSubAdmin", listUser);
		
		return "IndexUser";
	}
	
	@RequestMapping(value={"/add.do"}, method = RequestMethod.GET)
	public String addSubAdminView(){
		return "AddUser";
	}
	
	@RequestMapping(value={"/create.do"}, method = RequestMethod.GET)
	public String addSubAdmin(@RequestParam("username") String username, @RequestParam("email") String email){
		User user = userDao.createNewUser(username, email, "12345", 2);
		return "IndexUser";
	}
	
	@RequestMapping(value={"/load.do"}, method = RequestMethod.GET)
	public String initLogin(Model model){	
		model.addAttribute("command", new User());
		return "Index";
	}
	
	@RequestMapping(value={"/login.do"}, method = RequestMethod.POST)
	public String login(@ModelAttribute("command") User loginUser, HttpServletRequest request){
		User user = new User();
		user = userDao.login(loginUser.getUserName(), loginUser.getUserPassword());
		if (user == null)
			return "Index";
		else{
			Roles role = rolesDao.getRoleByUserId(user.getUserId());
			if (role.getRoleId() == 1 || role.getRoleId() == 2){
				// admin,subadmin
				request.getSession().setAttribute("userName", loginUser.getUserName());
				return "redirect:/admin/order/list.do?id=0&page=1&numPerPage=10";
			}
			if (role.getRoleId() == 3){
				// user
				return "Index";
			}
			
		}
		
		return "Index";
	}
	
	@RequestMapping(value={"/logout.do"}, method = RequestMethod.GET)
	public String logout(HttpServletRequest request, @ModelAttribute("command") User loginUser){
		
		request.getSession().removeAttribute("userName");
		return "Index";
	}
	

}
