package com.h2.model.dao.implementation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.DistrictDao;
import com.h2.model.dao.interfaces.RolesDao;
import com.h2.model.dao.interfaces.TokenDao;
import com.h2.model.dao.interfaces.UserDao;
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
	@Autowired
	private TokenDao tokenDao;
	
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
	// Return user with password = ""
	public User updateUserPassword(String userName, String userPassword, String tokenStr) {
		User user = new User();
		Query query= null;
        String hql = "";
        String hashPassword = hashPassword(userPassword);
        // Check userName existst
        if(tokenDao.getForgotTokenStringByUserName(userName).equals(tokenStr)) {
	        if (getUserByUserName(userName) != null){
		        try{                  	
		            hql = "UPDATE User set userPassword = :userPassword  WHERE userName = :userName";
		            query = getSession().createQuery(hql);
		            query.setParameter("userPassword", hashPassword);
		            query.setParameter("userName", userName);
		            query.executeUpdate();
		      
		        } catch (Exception e) {
		            e.printStackTrace();
		            //log.error(e);
		
		        } 
	        }
	        user = getUserByUserName(userName);
	        user.setUserPassword("");
        }
        return user;
	}

	// Create new user
	public User createNewUser(String userName, String userEmail,
			String userPassword, int roleId) {
		User user = new User();
        user.setUserName(userName);
        user.setUserEmail(userEmail);
        user.setUserPhoneNumber("");
        user.setUserAddress("");
        user.setUserPassword(hashPassword(userPassword));
        user.setIsDeleted(0);
        user.setDistrict(districtDao.get(1, District.class));
        user.setIsVerified(0);
        user.setRole(rolesDao.get(roleId, Roles.class));
        save(user);
        
        // Create token
        // Can kiem tra add thanh cong
        tokenDao.createRegisterTokenByUserName(userName);
        
		return user;
	}

	// Forgot password: call create token
	public User createToken(String userName) {
		tokenDao.createForgotPasswordTokenByUserName(userName);
		return getUserByUserName(userName);
	}

	// Return user, set password = ""
	public User login(String userName, String userPassword) {
		Query query = null;
        List<User> listUser = new ArrayList<User>();
        String hql = "";   
        String hashPassword = hashPassword(userPassword);
        try{                  	
            hql = "FROM User u WHERE u.userName = :userName AND u.userPassword = :hashPassword AND u.isVerified = :isVerified";
            query = getSession().createQuery(hql);
            query.setParameter("userName", userName);
            query.setParameter("hashPassword", hashPassword);
            query.setParameter("isVerified", 1);
            listUser =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
        
        if (listUser.size() == 1){
        	//listUser.get(0).setUserPassword("");
        	return listUser.get(0);
        }
		return null;
	}

	
	// Hash password
	public String hashPassword(String password) {
		String hashpassword = password;
		
		SecureRandom sr;
		try {
			// SALT
			sr = SecureRandom.getInstance("SHA1PRNG");
			
			byte[] salt = new byte[16];
	        sr.nextBytes(salt);
			
	        // Hash by SHA-1
			MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt);
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashpassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return hashpassword;
	}

	// Check userName exists when register
	// Return false if not
	public boolean checkUserNameExist(String userName) {		
        if (getUserByUserName(userName) == null)
        	return false;
		return true;
	}

	// Check userEmail exists when register
	// Return false if not
	public boolean checkUserEmailExist(String userEmail) {		
        if (getUserByUserEmail(userEmail) == null)
        	return false;
		return true;
	}

	
	// Update isVerified property of user after checking token is verified when registering
	public void updateVerifiedUser(String userName) {
		Query query= null;
        String hql = "";
        
        // Check userName exists
        if (getUserByUserName(userName) != null){
	        try{                  	
	            hql = "UPDATE User set isVerified = :isVerified  WHERE userName = :userName";
	            query = getSession().createQuery(hql);
	            query.setParameter("isVerified", 1);
	            query.setParameter("userName", userName);
	            query.executeUpdate();
	      
	        } catch (Exception e) {
	            e.printStackTrace();
	            //log.error(e);
	
	        } 
        }
	}

	// Get user by order Id
	public User getUserByOrderId(int orderId) {
		User user = new User();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.user from  Order p  WHERE p.orderId = :orderId ";
            query = getSession().createQuery(hql);
            query.setParameter("orderId", orderId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	user = (User) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return user;
	}		

	// Get user by token id
	public User getUserByTokenId(int tokenId) {
		User user = new User();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.user from  Token p  WHERE p.tokenId = :tokenId ";
            query = getSession().createQuery(hql);
            query.setParameter("tokenId", tokenId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	user = (User) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return user;
	}

	public String getRegisterToken(String username) {
		return tokenDao.getRegisterTokenStringByUserName(username).getTokenString();
	}
	
	public String getForgotPasswordToken(String username) {
		return tokenDao.getForgotTokenStringByUserName(username).getTokenString();
	}
}
