package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.OrderStatusDao;
import com.h2.model.pojo.OrderStatus;

@Repository ("orderStatusDao")
@Transactional
public class OrderStatusDaoImp extends AbstractHbnDao<OrderStatus> implements OrderStatusDao{

}
