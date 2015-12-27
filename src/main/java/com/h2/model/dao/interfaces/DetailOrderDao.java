package com.h2.model.dao.interfaces;

import java.util.List;

import com.h2.model.pojo.DetailOrder;

public interface DetailOrderDao extends Dao<DetailOrder>{
	public DetailOrder createNewDetailOder(float productPrice, int quantity, int orderId, int detailProductId);
	public List<DetailOrder> getListDetailOrderByOrderId(int orderId);
	public void updateStatusOfDetailOrder(int detailOrderId);// cancel by user or admin
	public void updateQuantityOfDetailOrder(int detailOrderId, int detailOrderQuantity);
}
