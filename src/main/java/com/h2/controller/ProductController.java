package com.h2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.pojo.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
	@RequestMapping(value="/category/{idCate}/name/{namePro}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Product>> GetProducts(@PathVariable("idCate") int idCate, @PathVariable("namePro") String namePro){
		return new ResponseEntity<List<Product>>(null);
	}
	
	@RequestMapping(value="/newproducts",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Product>> GetNewProducts(){
		return new ResponseEntity<List<Product>>(null);
	}
	
	@RequestMapping(value="/discountproducts",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Product>> GetDiscountProducts(){
		return new ResponseEntity<List<Product>>(null);
	}
	
	@RequestMapping(value="/{idProduct}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Product> GetProduct(@PathVariable("idProduct") int idProduct){
		return new ResponseEntity<Product>(null);
	}
}
