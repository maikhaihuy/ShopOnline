package com.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.dao.interfaces.ColorDao;
import com.h2.model.pojo.Color;

@RestController
@RequestMapping("/color")
public class ColorController {
	@Autowired
	private ColorDao colorDao;
	
	@RequestMapping(value="/all")
	@ResponseBody
	public ResponseEntity<List<Color>> GetAll(){
		List<Color> listColor = colorDao.getListColor();
		return new ResponseEntity<List<Color>>(listColor, HttpStatus.OK);
	}
}
