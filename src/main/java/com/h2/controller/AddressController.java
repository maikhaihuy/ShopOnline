package com.h2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.pojo.City;
import com.h2.model.pojo.District;

@RestController
@RequestMapping("/address")
public class AddressController {
	@RequestMapping(value="/cities")
	@ResponseBody
	public ResponseEntity<List<City>> GetCities(){
		return new ResponseEntity<List<City>>(null);
	}
	
	@RequestMapping(value="/districts/{idCity}")
	@ResponseBody
	public ResponseEntity<List<District>> GetDistricts(@PathVariable("idCity") int idCity){
		return new ResponseEntity<List<District>>(null);
	}
}
