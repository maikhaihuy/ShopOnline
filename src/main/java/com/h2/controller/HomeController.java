package com.h2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	// Welcome page: get list of discouting product + best seller product (Pagging)
	// Params: None
	// Set var: LstDiscount + LstBestSeller
	@RequestMapping("/index")
	public void Index(){
		
	}
	
	@RequestMapping("search/{nameProduct}")
	public void Search(){
		
	}
	
}
