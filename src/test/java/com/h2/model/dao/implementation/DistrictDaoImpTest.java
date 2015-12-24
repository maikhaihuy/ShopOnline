package com.h2.model.dao.implementation;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h2.model.dao.interfaces.DistrictDao;
import com.h2.model.pojo.District;

public class DistrictDaoImpTest extends TestCase{
	@Test
    public void testGetListDistrictByIdCity() {
        System.out.println("getListDistrictByIdCity");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		DistrictDao instance = (DistrictDao)appCtx.getBean("districtDao");
		
        List<District> expResult = null;      
        List<District> result = instance.getDistrictByIdCity(1);
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.size());
    }
}
