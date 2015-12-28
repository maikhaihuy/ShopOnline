package com.h2.model.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.OrderStatusDao;
import com.h2.model.pojo.OrderStatus;

@Repository ("orderStatusDao")
@Transactional
public class OrderStatusDaoImp extends AbstractHbnDao<OrderStatus> implements OrderStatusDao{

	public OrderStatus getOrderStatusByOrderId(int orderId) {
		OrderStatus orderStatus = new OrderStatus();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.orderStatus from  Order p  WHERE p.orderId = :orderId ";
            query = getSession().createQuery(hql);
            query.setParameter("orderId", orderId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	orderStatus = (OrderStatus) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return orderStatus;
	}

}
