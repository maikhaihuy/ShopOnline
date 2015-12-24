package com.h2.model.dao.implementation;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h2.model.dao.interfaces.SizeDao;
import com.h2.model.pojo.Size;

public class SizeDaoImpTest extends TestCase{
	@Test
    public void testGetListSizeOfProduct() {
        System.out.println("getListSizeOfProduct");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
        SizeDao instance = (SizeDao)appCtx.getBean("sizeDao");
	       
        List<Size> result = instance.getListSizeOfProduct(1);
        if (result.size() == 0){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.size());
    }
}
