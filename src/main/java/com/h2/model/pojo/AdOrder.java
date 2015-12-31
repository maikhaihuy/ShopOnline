package com.h2.model.pojo;

import java.util.List;

public class AdOrder {
	private Order order;
	private int orderStatusId;	
	private String orderStatusName;
	
	public AdOrder(){}
	public AdOrder(Order order, int orderStatusId, String orderStatusName) {
		super();
		this.order = order;
		this.orderStatusId = orderStatusId;
		this.orderStatusName = orderStatusName;
	}
	public String getOrderStatusName() {
		return orderStatusName;
	}
	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getOrderStatusId() {
		return orderStatusId;
	}
	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	
	
	
}
