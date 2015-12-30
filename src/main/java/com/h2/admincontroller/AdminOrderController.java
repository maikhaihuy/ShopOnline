package com.h2.admincontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.h2.model.dao.interfaces.OrderDao;
import com.h2.model.pojo.Order;

@Controller
@RequestMapping(value={"/order"})
public class AdminOrderController {
	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping(value={"/orderList.do"}, method = RequestMethod.GET)
	public String getListOrderByAdmin(Model model){
		List<Order> listOrder = new ArrayList<Order>();
		listOrder = orderDao.getListOrder();
		model.addAttribute("listOrder", listOrder);
		return "IndexOrder";
	}
	
	@RequestMapping(value={"/detailOrder.do"}, method = RequestMethod.GET)
	public String doPage7(@RequestParam("id") Integer id, Model model){
		return "DetailOrder";
	}
	
	
}
