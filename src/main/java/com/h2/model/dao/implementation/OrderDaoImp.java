package com.h2.model.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.OrderDao;
import com.h2.model.dao.interfaces.UserDao;
import com.h2.model.pojo.City;
import com.h2.model.pojo.District;
import com.h2.model.pojo.Order;
import com.h2.model.pojo.User;

@Repository ("orderDao")
@Transactional
public class OrderDaoImp extends AbstractHbnDao<Order> implements OrderDao{
	@Autowired
	private UserDao userDao;
	
	public Order getOrderById(int orderId) {	
		Order order = null;
		order = get(orderId, Order.class);
		return order;
	}

	public List<Order> getListOrderByUserName(String userName) {
		Query query = null;
        List<Order> listOrder = new ArrayList<Order>();
        String hql = "";
        
        //Get user by user name
        User user = userDao.getUserByUserName(userName);
        
        try{                	
            hql = "FROM Order d WHERE d.user = :user AND d.isDeleted = :isDeleted ORDER BY d.orderDate DESC";
            query = getSession().createQuery(hql);
            query.setParameter("user", user);
            query.setParameter("isDeleted", 0);
            listOrder =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
        return listOrder;
	}
	
}
