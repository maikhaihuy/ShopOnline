package com.h2.model.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.DetailOrderDao;
import com.h2.model.dao.interfaces.DetailProductDao;
import com.h2.model.dao.interfaces.OrderDao;
import com.h2.model.pojo.DetailOrder;
import com.h2.model.pojo.DetailProduct;
import com.h2.model.pojo.Order;
import com.h2.model.pojo.OrderStatus;
import com.h2.model.pojo.User;

@Repository ("detailOrderDao")
@Transactional
public class DetailOrderDaoImp extends AbstractHbnDao<DetailOrder> implements DetailOrderDao {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private DetailProductDao detailProductDao;
	
	// Create detail order for every product in CartItem
	public DetailOrder createNewDetailOder(float productPrice, int quantity, int orderId, int detailProductId) {
		DetailOrder detailOrder = new DetailOrder();
		detailOrder.setDetailOrderPrice(productPrice);
		detailOrder.setDetailOrderQuantity(quantity);
		// Get order by orderId
		Order order = orderDao.getOrderById(orderId);
		detailOrder.setOrder(order);
		// Get detail product by id
		DetailProduct detailProduct = detailProductDao.get(detailProductId, DetailProduct.class);
		detailOrder.setDetailProduct(detailProduct);
		detailOrder.setIsDeleted(0);
		save(detailOrder);
		return detailOrder;
	}

	// Get list of detailOrder by orderId
	public List<DetailOrder> getListDetailOrderByOrderId(int orderId) {
		Query query = null;
        List<DetailOrder> listDetailOrder = new ArrayList<DetailOrder>();
        String hql = "";
        Order order = orderDao.get(orderId, Order.class);
        try{                	
            hql = "FROM DetailOrder d WHERE d.order = :order AND d.isDeleted = :isDeleted ";
            query = getSession().createQuery(hql);
            query.setParameter("order", order);
            query.setParameter("isDeleted", 0);
            listDetailOrder =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
        if (listDetailOrder.size() == 0)
        	return null;
        return listDetailOrder;
	}

	// Update status of DetailOrder when Order is cancelled by user or admin
	public void updateStatusOfDetailOrder(int detailOrderId) {
		Query query= null;
	    String hql = "";
	   
	    try{                  	
	        hql = "UPDATE DetailOrder set isDeleted = :isDeleted  WHERE detailOrderId = :detailOrderId ";
	        query = getSession().createQuery(hql);
	        query.setParameter("isDeleted", 1);
	        query.setParameter("detailOrderId", detailOrderId);	        
	        query.executeUpdate();
	  
	    } catch (Exception e) {
	        e.printStackTrace();
	        //log.error(e);
	
	    } 
	}

	// Update quantity of product in order
	public void updateQuantityOfDetailOrder(int detailOrderId,	int detailOrderQuantity) {
		Query query= null;
	    String hql = "";
	   
	    try{                  	
	        hql = "UPDATE DetailOrder set detailOrderQuantity = :detailOrderQuantity  WHERE detailOrderId = :detailOrderId ";
	        query = getSession().createQuery(hql);
	        query.setParameter("detailOrderQuantity", detailOrderQuantity);
	        query.setParameter("detailOrderId", detailOrderId);	        
	        query.executeUpdate();
	  
	    } catch (Exception e) {
	        e.printStackTrace();
	        //log.error(e);
	
	    } 
	}

}
