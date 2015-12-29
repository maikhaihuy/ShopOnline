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

import com.h2.model.dao.interfaces.OrderDao;
import com.h2.model.pojo.Order;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderDao orderDao;
	
	// User
	@RequestMapping(value="/username/{username}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Order>> GetOrders(@PathVariable("username") String username){
		List<Order> listOrder = orderDao.getListOrderOfUser(username);
		if (listOrder == null)
			return new ResponseEntity<List<Order>>(listOrder, HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Order>>(listOrder, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{idOrder}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Order> GetOrder(@PathVariable("idOrder") int idOrder){
		Order order = orderDao.getOrderById(idOrder);
		if (order == null)
			return new ResponseEntity<Order>(order, HttpStatus.NOT_FOUND);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
	@RequestMapping(value="/new/{username}/{idrecipient}/{total}",
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Order> GetNewOrder(@PathVariable("username") String username, 
			@PathVariable("idrecipient") int idrecipient, @PathVariable("total") float total){
		Order order = orderDao.createNewOrder(username, idrecipient, total);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update/{orderid}/{orderstatus}",
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Order> UpdateOrder(@PathVariable("orderid") int orderid, @PathVariable("orderstatus") int orderstatus){
		Order order = orderDao.updateStatusOfOrder(orderid, orderstatus);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
	// Admin
	@RequestMapping(value="/all",
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Order>> GetOrdersAdmin(){
		List<Order> listOrder = orderDao.getListOrder();
		return new ResponseEntity<List<Order>>(listOrder, HttpStatus.OK);
	}
}
