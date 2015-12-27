package com.h2.model.dao.implementation;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.pojo.Product;

public class ProductDaoImpTest extends TestCase{
	
	@Test
    public void testGetProductById() {
        System.out.println("getProductById");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		ProductDao instance = (ProductDao)appCtx.getBean("productDao");
		
        Product expResult = null;      
        Product result = instance.getProductById(1);
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("productName: " + result.getProductName());
    }
	
	@Test
    public void testGetListProduct() {
        System.out.println("getListProduct");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		ProductDao instance = (ProductDao)appCtx.getBean("productDao");
		
        List<Product> expResult = null;      
        List<Product> result = instance.getListProduct(1);
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.size());
    }
	
	@Test
    public void testGetListNewProduct() {
        System.out.println("getListNewProduct");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		ProductDao instance = (ProductDao)appCtx.getBean("productDao");
		
        List<Product> expResult = null;      
        List<Product> result = instance.getListNewProduct();
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.size());
    }
	
	@Test
    public void testGetListDiscountProduct() {
        System.out.println("getListDiscountProduct");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		ProductDao instance = (ProductDao)appCtx.getBean("productDao");
		
        List<Product> expResult = null;      
        List<Product> result = instance.getListDiscountProduct();
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.size());
    }
	
	@Test
    public void testGetListProductByIdCategoryProductName() {
        System.out.println("getListListProductByIdCategoryProductName");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		ProductDao instance = (ProductDao)appCtx.getBean("productDao");
		
        List<Product> expResult = null;      
        List<Product> result = instance.getListProductByIdCategoryProductName(1, "pro", 2);
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.size());
    }
	
	@Test
    public void testGetListProductByCategoryId() {
        System.out.println("getListProductByCategoryId");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		ProductDao instance = (ProductDao)appCtx.getBean("productDao");
		
        List<Product> expResult = null;      
        List<Product> result = instance.getListProductByIdCategory(1, 1);
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.size());
    }
	
	
	
	@Test
    public void testSearchProduct() {
        System.out.println("getSearchProduct");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		ProductDao instance = (ProductDao)appCtx.getBean("productDao");
		
        List<Product> expResult = null;      
        List<Product> result = instance.searchProductByCategoryBrandColorSizePriceName(1, 1, 1, 1, 0, 100, "", 1);
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.size());
    }
	
	
}
