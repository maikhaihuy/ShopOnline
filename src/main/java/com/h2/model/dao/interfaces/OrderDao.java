package com.h2.model.dao.interfaces;

import java.util.List;

import com.h2.model.pojo.DetailOrder;
import com.h2.model.pojo.DetailProduct;
import com.h2.model.pojo.Order;
import com.h2.model.pojo.Recipient;

public interface OrderDao extends Dao<Order>{
	public Order createNewOrder(String userName, int recipientId, float orderTotal);
	public Recipient createRecipient(String recipientName,
			String recipientEmail, String recipientPhoneNumber,
			String recipientAddress, int districtId);
	public DetailOrder createDetailOrder(float productPrice,
											int quantity,
											int orderId,
											int productId, int colorId, int sizeId);
	public DetailProduct getDetailProduct(int productId, int colorId, int sizeId);
	public Order getOrderById(int orderId);
	public List<Order> getListOrderOfUser(String userName);
	public List<Order> getListOrder();
	public List<Order> getListOrderByStatusId(int statusId);
	public List<Order> getListOrderByStatusIdPaging(int statusId, int page, int numPerPage);
	public Order updateStatusOfOrder(int orderId, int orderStatusId);
	public float getTransferCost(int districtId);
	public Order getOrderByDetailOrderId(int detailOrderId);
}
