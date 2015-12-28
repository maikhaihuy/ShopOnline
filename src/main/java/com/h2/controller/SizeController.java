package com.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.dao.interfaces.SizeDao;
import com.h2.model.pojo.Size;

@RestController
@RequestMapping("/size")
public class SizeController {
	@Autowired
	private SizeDao sizeDao;
	
	@RequestMapping(value="/all")
	@ResponseBody
	public ResponseEntity<List<Size>> GetAll(){
		List<Size> listSize = sizeDao.getListSize();
		return new ResponseEntity<List<Size>>(listSize, HttpStatus.OK);
	}
}
