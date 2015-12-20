package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.OrderDao;
import com.h2.model.pojo.Order;

@Repository ("orderDao")
@Transactional
public class OrderDaoImp extends AbstractHbnDao<Order> implements OrderDao{
	public OrderDaoImp(){
		this.setDomainClass(Order.class);
	}
}
