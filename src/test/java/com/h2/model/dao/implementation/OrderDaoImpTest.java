package com.h2.model.dao.implementation;

import java.util.List;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h2.model.dao.interfaces.OrderDao;
import com.h2.model.pojo.Order;

import junit.framework.TestCase;

public class OrderDaoImpTest extends TestCase{
	@Test
    public void testGetTransferCost() {
        System.out.println("getTransferCost");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		OrderDao instance = (OrderDao)appCtx.getBean("orderDao");
		
        float expResult = 0;      
        float result = instance.getTransferCost(1);
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result);
    }
	
	@Test
    public void testCreateNewOrder() {
        System.out.println("createNewOrder");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		OrderDao instance = (OrderDao)appCtx.getBean("orderDao");
		        
        Order order = instance.createNewOrder("user1", 1, 200000);
     
        System.out.println("order id: " + order.getOrderId());
    }
	
	@Test
    public void testGetOrderById() {
        System.out.println("getOrderById");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		OrderDao instance = (OrderDao)appCtx.getBean("orderDao");
		        
        Order order = instance.getOrderById(1);
     
        System.out.println("order code: " + order.getOrderCode());
    }
	
	@Test
    public void testGetListOrderOfUser() {
        System.out.println("getListOrderOfUser");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		OrderDao instance = (OrderDao)appCtx.getBean("orderDao");
		List<Order> expResult = null;             
        List<Order> result = instance.getListOrderOfUser("user1");
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.size());
    }
	
	@Test
    public void testGetListOrder() {
        System.out.println("getListOrder");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		OrderDao instance = (OrderDao)appCtx.getBean("orderDao");
		List<Order> expResult = null;             
        List<Order> result = instance.getListOrder();
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.size());
    }
	
	@Test
    public void testUpdateStatusOfOrder() {
        System.out.println("updateStatusOfOrder");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		OrderDao instance = (OrderDao)appCtx.getBean("orderDao");
		            
        instance.updateStatusOfOrder(3, 6);
        
    }
}
