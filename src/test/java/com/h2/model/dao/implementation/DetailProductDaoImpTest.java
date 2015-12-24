package com.h2.model.dao.implementation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h2.model.dao.interfaces.DetailProductDao;
import com.h2.model.pojo.DetailProduct;
import junit.framework.TestCase;

public class DetailProductDaoImpTest extends TestCase{
	@Test
    public void testGetDetailProductById() {
        System.out.println("getDettailProductById");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		DetailProductDao instance = (DetailProductDao)appCtx.getBean("detailProductDao");
		
        DetailProduct expResult = null;      
        DetailProduct result = instance.getDetailProductById(1);
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        //System.out.println("productName: " + result.getProduct().getProductName());
    }
	
	@Test
    public void testGetDetailProductByProductColorSize() {
        System.out.println("getDettailProductByByProductColorSize");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		DetailProductDao instance = (DetailProductDao)appCtx.getBean("detailProductDao");
		
        DetailProduct expResult = null;      
        DetailProduct result = instance.getDetailProductByProductColorSizeId(1, 1, 2);
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("productName: " + result.getDetailProductId());
    }
	
	@Test
    public void testUpdateQuantityOfDetailProduct() {
        System.out.println("updateQuantityOfDetailProduct");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		DetailProductDao instance = (DetailProductDao)appCtx.getBean("detailProductDao");
		
         
        instance.updateQuantityOfDetailProduct(1, 500);
        
    }
}
