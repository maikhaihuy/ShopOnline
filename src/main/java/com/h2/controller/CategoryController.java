package com.h2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.pojo.Category;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@RequestMapping(value="/all",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Category>> GetAll(){
		return new ResponseEntity<List<Category>>(null);
	}
}
