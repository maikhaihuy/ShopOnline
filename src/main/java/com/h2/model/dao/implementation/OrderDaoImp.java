package com.h2.model.dao.implementation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.CityDao;
import com.h2.model.dao.interfaces.DistrictDao;
import com.h2.model.dao.interfaces.OrderDao;
import com.h2.model.dao.interfaces.OrderStatusDao;
import com.h2.model.dao.interfaces.RecipientDao;
import com.h2.model.dao.interfaces.UserDao;
import com.h2.model.pojo.City;
import com.h2.model.pojo.District;
import com.h2.model.pojo.Order;
import com.h2.model.pojo.OrderStatus;
import com.h2.model.pojo.Recipient;
import com.h2.model.pojo.User;

@Repository ("orderDao")
@Transactional
public class OrderDaoImp extends AbstractHbnDao<Order> implements OrderDao{
	@Autowired
	private UserDao userDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	private DistrictDao districtDao;
	@Autowired
	private OrderStatusDao orderStatusDao;
	@Autowired
	private RecipientDao recipientDao;
	
	// Create a new order with :
	// orderStatus = 1
	public Order createNewOrder(String userName, int recipientId, float orderTotal) {
		Order order = new Order();
		// Get orderStatus has orderStatusId = 1
		OrderStatus orderStatus = orderStatusDao.get(1, OrderStatus.class);
		order.setOrderStatus(orderStatus);
		// Get date
		Date orderDate = new Date();
		order.setOrderDate(orderDate);
		order.setOrderTotal(orderTotal);
		// Get recipient by recipientId
		Recipient recipient = recipientDao.get(recipientId, Recipient.class);
		order.setRecipient(recipient);
		// Get user by userName
		User user = userDao.getUserByUserName(userName);
		order.setUser(user);
		order.setIsDeleted(0);
		// Get orderCode
		DateFormat df = new SimpleDateFormat("MMddyyHHmmss");
		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();        		
		String orderCode = "OD" + df.format(today);
		order.setOrderCode(orderCode);
		order.setOrderTransferCost(this.getTransferCost(recipient.getDistrict().getDistrictId()));
		save(order);		
		return order;
	}
	
	// Get order by order Id
	public Order getOrderById(int orderId) {	
		Order order = null;
		order = get(orderId, Order.class);
		return order;
	}

	// Get list of orders which in't cancelled or deleted
	// Order by date
	public List<Order> getListOrderOfUser(String userName) {
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
        if (listOrder.size() == 0)
        	return null;
        return listOrder;
	}

	
	// Get list of orders  which isn't deleted
	// Order by date
	public List<Order> getListOrder() {
		Query query = null;
        List<Order> listOrder = new ArrayList<Order>();
        String hql = "";
      
        try{                	
            hql = "FROM Order d WHERE  d.isDeleted = :isDeleted ORDER BY d.orderDate DESC";
            query = getSession().createQuery(hql);
            query.setParameter("isDeleted", 0);
            listOrder =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
        if (listOrder.size() == 0)
        	return null;
        return listOrder;
	}

	// Update status of order
	// If status == 5, 6, setting isDeleted = 1
	public void updateStatusOfOrder(int orderId, int orderStatusId) {
		Query query= null;
        String hql = "";
        // Get orderStatus
        OrderStatus orderStatus = orderStatusDao.get(orderStatusId, OrderStatus.class);
   
        try{                  	
            hql = "UPDATE Order set orderStatus = :orderStatus ";
            if (orderStatusId == 5 || orderStatusId == 6){
            	hql += " , isDeleted = :isDeleted ";
            	
            }
            hql += " WHERE orderId = :orderId ";
            query = getSession().createQuery(hql);
            query.setParameter("orderStatus", orderStatus);
            if (orderStatusId == 5 || orderStatusId == 6){
            	query.setParameter("isDeleted", 1);
            }
            
            query.setParameter("orderId", orderId);
            query.executeUpdate();
      
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);

        } 
    
		
	}
	
	// Get transfer cost of order by districtId and cityId
	public float getTransferCost(int districtId) {
		float cost = 0;
		District district = districtDao.get(districtId, District.class);
		cost = cost + district.getDistrictCost();
		City city = cityDao.get(district.getCity().getCityId(), City.class);
		cost = cost + city.getCityCost();
		return cost;
	}
	
}
