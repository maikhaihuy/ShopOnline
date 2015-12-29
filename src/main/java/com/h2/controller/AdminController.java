package com.h2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	@RequestMapping(value={"/order.do"}, method = RequestMethod.GET)
	public String doPage1(){
		return "IndexOrder";
	}
}
