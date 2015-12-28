package com.h2.model.dao.implementation;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h2.model.dao.interfaces.ColorDao;
import com.h2.model.pojo.Color;

public class ColorDaoImpTest extends TestCase{
	@Test
    public void testGetListColor() {
        System.out.println("getListColor");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		ColorDao instance = (ColorDao)appCtx.getBean("colorDao");
	       
        List<Color> result = instance.getListColor();
        if (result.size() == 0){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.size());
    }
	
	@Test
    public void testGetListColorOfProduct() {
        System.out.println("getListColorOfProduct");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
        ColorDao instance = (ColorDao)appCtx.getBean("colorDao");
	       
        List<Color> result = instance.getListColorOfProduct(1);
        if (result.size() == 0){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.size());
    }
	
	@Test
    public void testgetColorByDetailProductId() {
        System.out.println("getColorByDetailProductId");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
        ColorDao instance = (ColorDao)appCtx.getBean("colorDao");
	       
        Color result = instance.getColorByDetailProductId(264);
        if (result == null){
            fail("The test case is a prototype.");
        }
        System.out.println("color name: " + result.getColorName());
    }
}
