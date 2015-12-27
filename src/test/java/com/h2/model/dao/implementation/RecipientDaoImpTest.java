package com.h2.model.dao.implementation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h2.model.dao.interfaces.RecipientDao;
import com.h2.model.pojo.Recipient;

import junit.framework.TestCase;

public class RecipientDaoImpTest extends TestCase {
	@Test
	public void testCreateNewRecipient(){
		System.out.println("CreateNewRecipient");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		RecipientDao instance = (RecipientDao)appCtx.getBean("recipientDao");
		
		Recipient expResult = null;      
		Recipient result = instance.createNewRecipient("reName1", "123", "124", "124", 1);
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("Recipient id: " + result.getRecipientId());
	}
}
