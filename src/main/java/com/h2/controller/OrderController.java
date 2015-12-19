package com.h2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.pojo.Order;

@RestController
@RequestMapping("/order")
public class OrderController {
	@RequestMapping(value="/{username}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Order>> GetOrders(@PathVariable("username") String username){
		return new ResponseEntity<List<Order>>(null);
	}
	
	@RequestMapping(value="/{idOrder}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Order> GetOrder(@PathVariable("idOrder") String idOrder){
		return new ResponseEntity<Order>(null);
	}
}
