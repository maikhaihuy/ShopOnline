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
        User result = instance.getUserByUserName("user");
        if (result == expResult){
            fail("The test case is a prototype.");
        }
        System.out.println("user name: " + result.getUserName());
    }
	
	@Test
    public void testCreateUser() {
        System.out.println("createUser");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		UserDao instance = (UserDao)appCtx.getBean("userDao");
		DistrictDao disDao = (DistrictDao)appCtx.getBean("districtDao");
		RolesDao rolesDao = (RolesDao)appCtx.getBean("rolesDao");
		
		District district = disDao.get(1, District.class);
		Roles role = rolesDao.get(1, Roles.class);
		
        User result = new User();
        result.setUserName("user2");
        result.setUserEmail("mail2");
        result.setUserAddress("add2");
        result.setUserPhoneNumber("phone2");
        result.setUserPassword("Pass2");
        result.setIsDeleted(0);
        result.setIsVerified(0);
        result.setDistrict(district);
        result.setRole(role);
        
        instance.save(result);
        System.out.println("user name: " + result.getUserId());
    }
	
	@Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		UserDao instance = (UserDao)appCtx.getBean("userDao");
		
        User result = instance.get(1, User.class);
        result.setUserName("user1");
        
        instance.update(result);
        System.out.println("user name: " + result.getUserId());
    }
}
