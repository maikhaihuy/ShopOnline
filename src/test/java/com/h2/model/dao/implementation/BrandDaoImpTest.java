package com.h2.model.dao.implementation;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h2.model.dao.interfaces.BrandDao;
import com.h2.model.pojo.Brand;

import junit.framework.TestCase;


public class BrandDaoImpTest extends TestCase{
	@Test
    public void testGetListBrand() {
        System.out.println("getListBrand");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		BrandDao instance = (BrandDao)appCtx.getBean("brandDao");
		
        List<Brand> expResult = null;
        String name = Brand.class.getName();
        List<Brand> result = instance.getAll(name);
        if (result.size() == 0){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.size());
    }
	
	@Test
    public void testGetBrandById() {
        System.out.println("getBrandById");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		BrandDao instance = (BrandDao)appCtx.getBean("brandDao");
		
        Brand result = instance.get(1, Brand.class);
        if (result == null){
            fail("The test case is a prototype.");
        }
        System.out.println("brand name: " + result.getBrandName());
    }
	
	@Test
    public void testLoadBrandById() {
        System.out.println("loadBrandById");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		BrandDao instance = (BrandDao)appCtx.getBean("brandDao");
		
        Brand result = instance.load(1, Brand.class);
        if (result == null){
            fail("The test case is a prototype.");
        }
    }
	
	@Test
    public void testCountBrand() {
        System.out.println("countBrand");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		BrandDao instance = (BrandDao)appCtx.getBean("brandDao");
		
        int result = -1;
        String name = Brand.class.getName();
        result = instance.count(name);
        
        if (result == -1){
            fail("The test case is a prototype.");
        }
        System.out.println("Size of Brand: " + result);
    }
	
	@Test
    public void testExistsBrand() {
		System.out.println("exitsBrandById");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		BrandDao instance = (BrandDao)appCtx.getBean("brandDao");
		
        boolean result = instance.exists(1, Brand.class);
        if (result == false){
            fail("The test case is a prototype.");
        }
        
    }
	
	@Test
    public void testUpdateBrand() {
		System.out.println("updateBrand");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		BrandDao instance = (BrandDao)appCtx.getBean("brandDao");
		
		Brand brand = instance.get(1, Brand.class);
		brand.setBrandName("New brand");
		brand.setIsDeleted(1);
		
        instance.update(brand);
        
    }
}
