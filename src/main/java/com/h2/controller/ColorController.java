package com.h2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.pojo.Color;

@RestController
@RequestMapping("/color")
public class ColorController {
	@RequestMapping(value="/all")
	@ResponseBody
	public ResponseEntity<List<Color>> GetAll(){
		return new ResponseEntity<List<Color>>(null);
	}
}
