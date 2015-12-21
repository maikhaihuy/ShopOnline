package com.h2.model.dao.interfaces;

import java.util.List;

import com.h2.model.pojo.Order;

public interface OrderDao extends Dao<Order>{
	public Order getOrderById(int orderId);
	public List<Order> getListOrderByUserName(String userName);
}
