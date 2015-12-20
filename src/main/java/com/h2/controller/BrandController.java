package com.h2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.pojo.Brand;

@RestController
@RequestMapping("/brand")
public class BrandController {
	@RequestMapping(value="/all",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Brand>> GetAll(){
		return new ResponseEntity<List<Brand>>(null);
	}
}
