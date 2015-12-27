package com.h2.model.dao.implementation;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h2.model.dao.interfaces.DiscountInfoDao;
import com.h2.model.pojo.DiscountInfo;

import junit.framework.TestCase;

public class DiscountInfoDaoImpTest extends TestCase{
	@Test
	public void testCreateDiscountInfo(){
		System.out.println("createDiscountInfo");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
        DiscountInfoDao instance = (DiscountInfoDao)appCtx.getBean("discountInfoDao");
		
        DiscountInfo discountInfo = instance.createDiscountInfo(10, 0);
     
        System.out.println("order id: " + discountInfo.getDiscountInfoId());
	}
	
	
	@Test
	public void testUpdateDiscountInfo(){
		System.out.println("updateDiscountInfo");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
        DiscountInfoDao instance = (DiscountInfoDao)appCtx.getBean("discountInfoDao");
		
        instance.updateDiscountInfo(10, 1, 1);
        
	}
}
