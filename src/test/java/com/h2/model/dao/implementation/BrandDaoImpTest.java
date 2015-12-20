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
        List<Brand> result = instance.getListBrand();
        if (result.size() == 0){
            fail("The test case is a prototype.");
        }
    }
}
