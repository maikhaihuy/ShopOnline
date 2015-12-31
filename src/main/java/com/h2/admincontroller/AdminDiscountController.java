package com.h2.admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value={"/discount"})
public class AdminDiscountController {
	@RequestMapping(value={"/list.do"}, method = RequestMethod.GET)
	public String doPage3(){
		return "IndexDiscount";
	}
	
	@RequestMapping(value={"/add.do"}, method = RequestMethod.GET)
	public String doPage4(){
		return "AddDiscount";
	}
	
	
	
}
