package com.h2.model.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.DistrictDao;
import com.h2.model.dao.interfaces.RolesDao;
import com.h2.model.dao.interfaces.UserDao;
import com.h2.model.pojo.City;
import com.h2.model.pojo.District;
import com.h2.model.pojo.Roles;
import com.h2.model.pojo.User;

@Repository ("userDao")
@Transactional
public class UserDaoImp extends AbstractHbnDao<User> implements UserDao {
	@Autowired
	private RolesDao rolesDao;
	@Autowired
	private DistrictDao districtDao;
	
	// Get User by userName
	public User getUserByUserName(String userName) {		
		Query query = null;
        List<User> listUser = new ArrayList<User>();
        String hql = "";       
        try{                  	
            hql = "FROM User u WHERE u.userName = :userName";
            query = getSession().createQuery(hql);
            query.setParameter("userName", userName);
            listUser =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);
           
        } 
        
        if (listUser.size() == 1)
        	return listUser.get(0);
		return null;
	}

	// Get User by userEmail
	public User getUserByUserEmail(String userEmail) {
		Query query = null;
        List<User> listUser = new ArrayList<User>();
        String hql = "";       
        try{                  	
            hql = "FROM User u WHERE u.userEmail = :userEmail";
            query = getSession().createQuery(hql);
            query.setParameter("userEmail", userEmail);
            listUser =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);
           
        } 
        
        if (listUser.size() == 1)
        	return listUser.get(0);
		return null;
	}

	// Update userPassword with userName
	public void updateUserPassword(String userName, String userPassword) {
		Query query= null;
        String hql = "";
        
        // Check userName exists
        if (getUserByUserName(userName) != null){
	        try{                  	
	            hql = "UPDATE User set userPassword = :userPassword  WHERE userName = :userName";
	            query = getSession().createQuery(hql);
	            query.setParameter("userPassword", userPassword);
	            query.setParameter("userName", userName);
	            query.executeUpdate();
	      
	        } catch (Exception e) {
	            e.printStackTrace();
	            //log.error(e);
	
	        } 
        }
	}

	// Create new user
	// Return register token string
	public String createNewUser(String userName, String userEmail,
			String userPassword, int roleId) {
		User user = new User();
        user.setUserName(userName);
        user.setUserEmail(userEmail);
        user.setUserPhoneNumber("");
        user.setUserAddress("");
        user.setUserPassword(userPassword);
        user.setIsDeleted(0);
        user.setDistrict(districtDao.get(1, District.class));
        user.setIsVerified(0);
        user.setRole(rolesDao.get(roleId, Roles.class));
        // Create token
        return repository.save(user);
		return null;
	}


	// Return user, set password null
	public User login(String userName, String userPassword) {
		Query query = null;
        List<User> listUser = new ArrayList<User>();
        String hql = "";   
        String hashPassword = hashPassword(userPassword);
        try{                  	
            hql = "FROM User u WHERE u.userName = :userName AND u.userPassword = :hashPassword";
            query = getSession().createQuery(hql);
            query.setParameter("userName", userName);
            query.setParameter("userPassword", hashPassword);
            listUser =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
        
        if (listUser.size() == 1){
        	listUser.get(0).setUserPassword(null);
        	return listUser.get(0);
        }
		return null;
	}

	
	// Hash password
	public String hashPassword(String password) {
		String hasspassword = password;
		//
		return hasspassword;
	}

	// Check userName exists when register
	// Return false if not
	public boolean checkUserNameExist(String userName) {		
        if (getUserByUserName(userName) == null)
        	return true;
		return false;
	}

	// Check userEmail exists when register
	// Return false if not
	public boolean checkUserEmailExist(String userEmail) {		
        if (getUserByUserEmail(userEmail) == null)
        	return true;
		return false;
	}

	
	

	
}
