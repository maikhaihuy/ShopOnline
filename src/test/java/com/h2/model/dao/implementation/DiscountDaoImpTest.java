package com.h2.model.dao.implementation;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h2.model.dao.interfaces.DetailOrderDao;
import com.h2.model.dao.interfaces.DiscountDao;
import com.h2.model.dao.interfaces.DiscountInfoDao;
import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.pojo.Discount;
import com.h2.model.pojo.DiscountInfo;
import com.h2.model.pojo.Product;

import junit.framework.TestCase;

public class DiscountDaoImpTest extends TestCase{
	/*@Test
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
        
	}*/
	
	@Test
	public void testUpdateDiscount(){
		System.out.println("updateTimeDiscount");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
        DiscountDao discountDao = (DiscountDao)appCtx.getBean("discountDao");
        DiscountInfoDao discountInfoDao = (DiscountInfoDao)appCtx.getBean("discountInfoDao");
        ProductDao productDao = (ProductDao)appCtx.getBean("productDao");
		
        Date startDate = new Date();
        Date endDate = null;
        Calendar cal  = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DATE, 4);
        endDate = cal.getTime();
        
        int discountId = 3;
        int discountInfoId = 1;
        int productDiscountValue = 10;
        // Get product
 		Product product = new Product();
 		product = productDao.getProductByDiscountId(discountId);
 		// Get discount product
 		Product discountProduct = new Product();
 		discountProduct = productDao.getProductByDiscountInfoId(discountInfoId);
 		
 		// update discount info
 		DiscountInfo discountInfo = new DiscountInfo();
 		discountInfo = discountInfoDao.get(discountInfoId, DiscountInfo.class);
 		discountInfo.setDiscountPercentValue(productDiscountValue);
 		discountInfo.setDiscountRate(1);
 		discountInfo.setProduct(discountProduct);
 		discountInfoDao.update(discountInfo);
 				
 				
 		// update discount 
 		Discount discount = new Discount();
 		discount = discountDao.get(discountId, Discount.class);
 		discount.setProduct(product);
 		discount.setDiscountStartDate(startDate);
 		discount.setDiscountEndDate(endDate);
 		discount.setDiscountInfo(discountInfo);
 		discountDao.update(discount);
        
	}
}
