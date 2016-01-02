package com.h2.model.dao.implementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.CityDao;
import com.h2.model.dao.interfaces.DetailOrderDao;
import com.h2.model.dao.interfaces.DetailProductDao;
import com.h2.model.dao.interfaces.DistrictDao;
import com.h2.model.dao.interfaces.OrderDao;
import com.h2.model.dao.interfaces.OrderStatusDao;
import com.h2.model.dao.interfaces.RecipientDao;
import com.h2.model.dao.interfaces.UserDao;
import com.h2.model.pojo.City;
import com.h2.model.pojo.DetailOrder;
import com.h2.model.pojo.DetailProduct;
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
	@Autowired
	private DetailOrderDao detailOrderDao;
	@Autowired
	private DetailProductDao detailProductDao;
	
	private static int TIME_CANCEL_ORDER;
	
	// Load property : EXPIRY_AUTHENTIC_EMAIL (days)
	private void loadProperties(){
		Properties prop = new Properties();
		InputStream input = null;
		try{			
			// load a properties file
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("app.properties").getFile());
			if (file != null) {
				input = new FileInputStream(file);
				prop.load(input);
				// get the property value 
				this.TIME_CANCEL_ORDER = Integer.parseInt(prop.getProperty("TIME_CANCEL_ORDER"));
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
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
	
	public Recipient createRecipient(String recipientName,
			String recipientEmail, String recipientPhoneNumber,
			String recipientAddress, int districtId){
		return recipientDao.createNewRecipient(recipientName, recipientEmail, recipientPhoneNumber, recipientAddress, districtId);
	}
	public DetailOrder createDetailOrder(float productPrice, int quantity, int orderId, int productId, int colorId, int sizeId){
		DetailProduct dpTemp = getDetailProduct(productId, colorId, sizeId);
		return detailOrderDao.createNewDetailOder(productPrice, quantity, orderId, dpTemp.getDetailProductId());
	}
	
	public DetailProduct getDetailProduct(int productId, int colorId, int sizeId){
		return detailProductDao.getDetailProductByProductColorSizeId(productId, colorId, sizeId);
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
        // Check if time of order is greater than 3 hours and order status = 1 then update orderStatus = 2
        for (int i = 0; i < listOrder.size(); i++){
        	int orderId = listOrder.get(i).getOrderId();
        	if (!checkTimeCancelOrder(orderId)){
        		OrderStatus orderStatus = orderStatusDao.getOrderStatusByOrderId(orderId);
        		if (orderStatus.getOrderStatusId() == 1){
        			updateStatusOfOrder(orderId, 2);
        		}
        	}
        }
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
        for (int i = 0; i < listOrder.size(); i++){
        	int orderId = listOrder.get(i).getOrderId();
        	if (!checkTimeCancelOrder(orderId)){
        		OrderStatus orderStatus = orderStatusDao.getOrderStatusByOrderId(orderId);
        		if (orderStatus.getOrderStatusId() == 1){
        			updateStatusOfOrder(orderId, 2);
        		}
        	}
        }
        return listOrder;
	}

	// Update status of order
	// If status == 5, 6, setting isDeleted = 1
	public Order updateStatusOfOrder(int orderId, int orderStatusId) {
		Query query= null;
        String hql = "";
        Order order = get(orderId, Order.class);
        // Check if orderStatusId = 5 and time to cancel order is over then do nothing
        if (orderStatusId == 5){
        	if (!checkTimeCancelOrder(orderId)){
        		return order;
        	}
        }
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
    
        return order = get(orderId, Order.class);
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

	// Get order by detail order id
	public Order getOrderByDetailOrderId(int detailOrderId) {
		Order order = new Order();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.order from  DetailOrder p  WHERE p.detailOrderId = :detailOrderId ";
            query = getSession().createQuery(hql);
            query.setParameter("detailOrderId", detailOrderId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	order = (Order) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return order;
	}
	
	
	// Check if cancel date > current date return true
	public boolean checkTimeCancelOrder(int orderId){
		Order order = get(orderId, Order.class);
		Date orderDate = order.getOrderDate();
		loadProperties();
		
		Calendar cal = Calendar.getInstance(); // creates calendar
	    cal.setTime(orderDate); // sets calendar time/date
	    cal.add(Calendar.HOUR_OF_DAY, this.TIME_CANCEL_ORDER); // adds one hour
	    Date cancelDate = cal.getTime();
	    
	    Calendar cal1 = Calendar.getInstance();
    	Calendar cal2 = Calendar.getInstance();
    	cal1.setTime(cancelDate);// cancel date
    	cal2.getTime();// current date
    	
    	if(cal1.after(cal2)){
    		return true;
    	}
    	
		return false;
	}


	// Get list order by status id
	// If id = 0 get all
	public List<Order> getListOrderByStatusId(int statusId) {
		Query query = null;
        List<Order> listOrder = new ArrayList<Order>();
        String hql = "";
        OrderStatus orderStatus = new OrderStatus();
        if (statusId != 0){
        	//Get user by user name
        	orderStatus = orderStatusDao.get(statusId, OrderStatus.class);
        }
        
        try{                	
            hql = "FROM Order d WHERE ";
            if (statusId != 0){
            	hql += " d.orderStatus = :orderStatus AND ";
            	
            }
            hql += " d.isDeleted = :isDeleted ORDER BY d.orderDate DESC";
            query = getSession().createQuery(hql);
            if (statusId != 0){
            	query.setParameter("orderStatus", orderStatus);
            }
            
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


	public List<Order> getListOrderByStatusIdPaging(int statusId, int page,
			int numPerPage) {
		Query query = null;
        List<Order> listOrder = new ArrayList<Order>();
        String hql = "";
        int n = (page - 1)*numPerPage;
        int m = page*numPerPage;
        
        OrderStatus orderStatus = new OrderStatus();
        if (statusId != 0){
        	//Get user by user name
        	orderStatus = orderStatusDao.get(statusId, OrderStatus.class);
        }
        
        try{                	
            hql = "FROM Order d WHERE ";
            if (statusId != 0){
            	hql += " d.orderStatus = :orderStatus AND ";
            	
            }
            hql += " d.isDeleted = :isDeleted ORDER BY d.orderDate DESC";
            query = getSession().createQuery(hql);
            if (statusId != 0){
            	query.setParameter("orderStatus", orderStatus);
            }
            
            query.setParameter("isDeleted", 0);
            query.setFirstResult(n);
			query.setMaxResults(m);
            listOrder =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
        if (listOrder.size() == 0)
        	return null;
        
        return listOrder;
	}
	
}
