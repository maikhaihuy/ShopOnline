package com.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.dao.interfaces.CityDao;
import com.h2.model.dao.interfaces.DistrictDao;
import com.h2.model.pojo.City;
import com.h2.model.pojo.District;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private CityDao cityDao;
	@Autowired
	private DistrictDao districtDao;
	
	@RequestMapping(value="/cities",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<City>> GetCities(){
		List<City> listCity = cityDao.getListCity();
		return new ResponseEntity<List<City>>(listCity, HttpStatus.OK);
	}
	
	@RequestMapping(value="/districts/{idCity}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<District>> GetDistricts(@PathVariable("idCity") int idCity){
		List<District> listDistrict = districtDao.getDistrictByIdCity(idCity);
		return new ResponseEntity<List<District>>(listDistrict, HttpStatus.OK);
	}
}
