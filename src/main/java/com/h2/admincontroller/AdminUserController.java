package com.h2.admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value={"/user"})
public class AdminUserController {
	
	@RequestMapping(value={"/userList.do"}, method = RequestMethod.GET)
	public String doPage1(){
		return "IndexUser";
	}
	
	@RequestMapping(value={"/userAdd.do"}, method = RequestMethod.GET)
	public String doPage2(){
		return "AddUser";
	}
	
	

}
