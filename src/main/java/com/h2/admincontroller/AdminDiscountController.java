package com.h2.admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value={"/discount"})
public class AdminDiscountController {
	@RequestMapping(value={"/list.do"}, method = RequestMethod.GET)
	public String getListDiscount(){
		return "IndexDiscount";
	}
	
	@RequestMapping(value={"/viewAdd.do"}, method = RequestMethod.GET)
	public String loadAddPage(Model model){
		return "AddDiscount";
	}
	
	@RequestMapping(value={"/add.do"}, method = RequestMethod.GET)
	public String addDiscount(){
		return "IndexDiscount";
	}
	
	@RequestMapping(value={"/update.do"}, method = RequestMethod.GET)
	public String updateDiscount(){
		return "IndexDiscount";
	}
	
}
