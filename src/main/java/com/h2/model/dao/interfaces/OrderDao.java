package com.h2.model.dao.interfaces;

import java.util.List;

import com.h2.model.pojo.Order;

public interface OrderDao extends Dao<Order>{
	public Order createNewOrder(String userName, int recipientId, float orderTotal);
	public Order getOrderById(int orderId);
	public List<Order> getListOrderOfUser(String userName);
	public List<Order> getListOrder();
	public void updateStatusOfOrder(int orderId, int orderStatusId);
	public float getTransferCost(int districtId);
}
