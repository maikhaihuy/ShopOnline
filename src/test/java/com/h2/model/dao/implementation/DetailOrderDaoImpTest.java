package com.h2.model.dao.implementation;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h2.model.dao.interfaces.DetailOrderDao;
import com.h2.model.pojo.DetailOrder;
import junit.framework.TestCase;

public class DetailOrderDaoImpTest extends TestCase{
	
	@Test
	public void testCreateNewDetailOder(){
		System.out.println("createNewOrder");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
        DetailOrderDao instance = (DetailOrderDao)appCtx.getBean("detailOrderDao");
		        
        DetailOrder detailOrder = instance.createNewDetailOder(50000, 2, 1, 1);
     
        System.out.println("order id: " + detailOrder.getDetailOrderId());
	}
	
	@Test
	public void testgetListDetailOrderByOrderId(){
		System.out.println("getListDetailOrderByOrderId");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
        DetailOrderDao instance = (DetailOrderDao)appCtx.getBean("detailOrderDao");
		        
        List<DetailOrder> listDetailOrder = instance.getListDetailOrderByOrderId(1);
        if (listDetailOrder.size() == 0)
        	System.out.println("list null");
        System.out.println("size: " + listDetailOrder.size());
	}
	
	@Test
	public void testUpdateStatusOfDetailOrder(){
		System.out.println("updateStatusOfDetailOrder");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		DetailOrderDao instance = (DetailOrderDao)appCtx.getBean("detailOrderDao");
		        
        instance.updateStatusOfDetailOrder(1);
	}
	
	@Test
	public void testUpdateQuantityOfDetailOrder(){
		System.out.println("updateQuantityOfDetailOrder");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		DetailOrderDao instance = (DetailOrderDao)appCtx.getBean("detailOrderDao");
		        
        instance.updateQuantityOfDetailOrder(1, 2);
     
	}
}
