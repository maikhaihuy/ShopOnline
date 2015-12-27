package com.h2.model.dao.implementation;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h2.model.dao.interfaces.DetailOrderDao;
import com.h2.model.dao.interfaces.DiscountDao;
import com.h2.model.pojo.Discount;

import junit.framework.TestCase;

public class DiscountDaoImpTest extends TestCase{
	@Test
	public void testCreateDiscount(){
		System.out.println("createDiscount");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
        DiscountDao instance = (DiscountDao)appCtx.getBean("discountDao");
		
        Date startDate = new Date();
        Date endDate = null;
        Calendar cal  = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DATE, 3);
        endDate = cal.getTime();
        Discount discount = instance.createDiscount(1, 1, startDate, endDate);
     
        System.out.println("order id: " + discount.getDiscountId());
	}
	
	@Test
	public void testGetListDiscount(){
		System.out.println("getListDiscount");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
        DiscountDao instance = (DiscountDao)appCtx.getBean("discountDao");
		
        List<Discount> listDiscount = instance.getListDiscount();
        if (listDiscount.size() == 0){
        	System.out.println("List rỗng ");
        }
     
        System.out.println("size: " + listDiscount.size());
	}
	
	@Test
	public void testUpdateTimeDiscount(){
		System.out.println("updateTimeDiscount");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
        DiscountDao instance = (DiscountDao)appCtx.getBean("discountDao");
		
        Date startDate = new Date();
        Date endDate = null;
        Calendar cal  = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DATE, 4);
        endDate = cal.getTime();
        instance.updateTimeDiscount(1, startDate, endDate);
        
	}
}
