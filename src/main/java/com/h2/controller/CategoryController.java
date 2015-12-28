package com.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.dao.interfaces.CategoryDao;
import com.h2.model.pojo.Category;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping(value="/all",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Category>> GetAll(){
		List<Category> listCategory = categoryDao.getListCategory();
		return new ResponseEntity<List<Category>>(listCategory, HttpStatus.OK);
	}
}
