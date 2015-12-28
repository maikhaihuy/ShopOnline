package com.h2.model.dao.interfaces;

import com.h2.model.pojo.OrderStatus;

public interface OrderStatusDao extends Dao<OrderStatus>{
	public OrderStatus getOrderStatusByOrderId(int orderId);
}
