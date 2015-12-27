package com.h2.model.dao.implementation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h2.model.dao.interfaces.TokenDao;
import com.h2.model.pojo.Token;

import junit.framework.TestCase;

public class TokenDaoImpTest extends TestCase{
	@Test
    public void testCreateForgotTokenByUserName() {
        System.out.println("createForgotTokenByUserName");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		TokenDao instance = (TokenDao)appCtx.getBean("tokenDao");
		
		Token expResult = null;      
        Token result = instance.createForgotPasswordTokenByUserName("user1");
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.getTokenString());
    }
	
	@Test
    public void testCreateRegisterTokenByUserName() {
        System.out.println("createRegisterTokenByUserName");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		TokenDao instance = (TokenDao)appCtx.getBean("tokenDao");
		
		Token expResult = null;      
        Token result = instance.createRegisterTokenByUserName("user3");
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.getTokenString());
    }

	@Test
    public void testVerifyToken() {
        System.out.println("verifyToken");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		TokenDao instance = (TokenDao)appCtx.getBean("tokenDao");
		
		Token expResult = null;      
        Token result = instance.verifyToken("123455");
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result.getTokenString());
    }
	
	@Test
    public void testUpdateVerifiedToken() {
        System.out.println("updateVerifiedToken");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		TokenDao instance = (TokenDao)appCtx.getBean("tokenDao");
			
        instance.updateVerifiedToken(1);
	}
       
	@Test
    public void testGetForgotTokenStringByUserName() {
        System.out.println("getForgotTokenStringByUserName");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		TokenDao instance = (TokenDao)appCtx.getBean("tokenDao");
		
		String expResult = null;      
        String result = instance.getForgotTokenStringByUserName("user1");
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result);
    }
	
	@Test
    public void testGetRegisterStringByUserName() {
        System.out.println("getRegisterTokenStringByUserName");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		TokenDao instance = (TokenDao)appCtx.getBean("tokenDao");
		
		String expResult = null;      
        String result = instance.getRegisterTokenStringByUserName("user1");
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("list size: " + result);
    }
}
