package com.h2.model.dao.implementation;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h2.model.dao.interfaces.TagDao;
import com.h2.model.pojo.Tag;

import junit.framework.TestCase;

public class TagDaoImpTest extends TestCase{
	@Test
    public void testGetListTag() {
        System.out.println("getListTag");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		TagDao instance = (TagDao)appCtx.getBean("tagDao");
	       
        List<Tag> result = instance.getListTag();
        if (result.size() == 0){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.size());
    }
	
	@Test
    public void testUpdateTagValue() {
        System.out.println("updateTagValue");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		TagDao instance = (TagDao)appCtx.getBean("tagDao");
	       
        instance.updateTagValue("icon", "value of icon");
       
    }
}
