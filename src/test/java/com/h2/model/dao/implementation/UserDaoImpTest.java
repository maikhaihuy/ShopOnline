package com.h2.model.dao.implementation;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h2.model.dao.interfaces.DistrictDao;
import com.h2.model.dao.interfaces.RolesDao;
import com.h2.model.dao.interfaces.UserDao;
import com.h2.model.pojo.District;
import com.h2.model.pojo.Roles;
import com.h2.model.pojo.User;

public class UserDaoImpTest extends TestCase{
	@Test
    public void testGetUserByUserName() {
        System.out.println("getUserByUserName");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		UserDao instance = (UserDao)appCtx.getBean("userDao");
		
        User expResult = null;      
        User result = instance.getUserByUserName("user1");
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("user name: " + result.getUserName());
    }
	
	@Test
    public void testGetUserByUserEmail() {
        System.out.println("getUserByUserEmail");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		UserDao instance = (UserDao)appCtx.getBean("userDao");
		
        User expResult = null;      
        User result = instance.getUserByUserEmail("email2");
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("user name: " + result.getUserName());
    }
	
	
	@Test
    public void testCreateNewUser() {
        System.out.println("createNewUser");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		UserDao instance = (UserDao)appCtx.getBean("userDao");
		
        instance.createNewUser("user4", "email4", "pass5", 3);
      
    }
	
	@Test
    public void testUpdateUserPassword() {
        System.out.println("updateUserPassword");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		UserDao instance = (UserDao)appCtx.getBean("userDao");
		
        instance.updateUserPassword("user1", "pass1","abc");
       
    }
	
	@Test
    public void testVerifiedUser() {
        System.out.println("VerifiedUser");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		UserDao instance = (UserDao)appCtx.getBean("userDao");
		
        User result = instance.get(1, User.class);
       
        instance.updateVerifiedUser("user1");
        System.out.println("user name: " + result.getUserId());
    }
	
	@Test
    public void testLogin() {
        System.out.println("Login");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		UserDao instance = (UserDao)appCtx.getBean("userDao");
		
        User result = instance.get(1, User.class);
       
        instance.login("user1", "pass1");
        System.out.println("user name: " + result.getUserId());
    }
	
	@Test
    public void testCheckUserNameExist() {
        System.out.println("checkUserNameExist");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		UserDao instance = (UserDao)appCtx.getBean("userDao");
		
        Boolean result = instance.checkUserNameExist("user1");

        if (result){
        	System.out.println("User name exists");
        }else
        System.out.println("User name doesn't exist");
    }
	
	@Test
    public void testCheckUserEmailExist() {
        System.out.println("checkUserEmailExist");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		UserDao instance = (UserDao)appCtx.getBean("userDao");
		
        Boolean result = instance.checkUserEmailExist("email1");

        if (result){
        	System.out.println("User email exists");
        }else
        System.out.println("User email doesn't exist");
    }
	
	@Test
    public void testTokenForgetPassword() {
        System.out.println("TokenForgetPassword");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		UserDao instance = (UserDao)appCtx.getBean("userDao");
		// create forgot pass token 
		User user = instance.createToken("email1");
		String token = instance.getForgotPasswordToken(user.getUserName());
       
        System.out.println(token);
    }
    
}
