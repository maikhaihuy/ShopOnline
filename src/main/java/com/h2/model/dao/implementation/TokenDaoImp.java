package com.h2.model.dao.implementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.TokenDao;
import com.h2.model.dao.interfaces.TokenTypeDao;
import com.h2.model.dao.interfaces.UserDao;
import com.h2.model.pojo.Token;
import com.h2.model.pojo.TokenType;
import com.h2.model.pojo.User;

@Repository ("tokenDao")
@Transactional
public class TokenDaoImp extends AbstractHbnDao<Token> implements TokenDao {
	@Autowired
	private UserDao userDao;
	@Autowired
	private TokenTypeDao tokenTypeDao;
			
	private static int EXPIRY_AUTHENTIC_EMAIL;
	
	// Load property : EXPIRY_AUTHENTIC_EMAIL (days)
	private void loadProperties(){
		Properties prop = new Properties();
		InputStream input = null;
		try{			
			// load a properties file
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("app.properties").getFile());
			if (file != null) {
				input = new FileInputStream(file);
				prop.load(input);
				// get the property value 
				this.EXPIRY_AUTHENTIC_EMAIL = Integer.parseInt(prop.getProperty("EXPIRY_AUTHENTIC_EMAIL"));
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
		
	// Get token string of user name when registering (tokenTypeId = 1)
	public Token getRegisterTokenStringByUserName(String userName) {
		String tokenString = null;
		Query query = null;
		String hql = "";
		Date date = new Date();
		List<Token> listToken = new ArrayList<Token>();
		// Get user by user name
		User user = userDao.getUserByUserName(userName);
		// Get token type of register
		TokenType tokenType = tokenTypeDao.get(1, TokenType.class);
		
		try{                	
            hql = "FROM Token t WHERE t.user = :user AND t.tokenType = :tokenType AND t.expiryDate > :date AND t.isVerified = :isVerified";
            query = getSession().createQuery(hql);
            query.setParameter("user", user);
            query.setParameter("tokenType", tokenType);
            query.setParameter("date", date);
            query.setParameter("isVerified", 0);
            listToken =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		if (listToken.size() == 1){
			return listToken.get(0);
		}
		return null;
	}
	
	// Get token string of user name when forgot password  (tokenTypeId = 2)
	public Token getForgotTokenStringByUserName(String userName) {
		String tokenString = null;
		Query query = null;
		String hql = "";
		Date date = new Date();
		List<Token> listToken = new ArrayList<Token>();
		// Get user by user name
		User user = userDao.getUserByUserName(userName);
		// Get token type of forgot paassword
		TokenType tokenType = tokenTypeDao.get(2, TokenType.class);
		try{                	
            hql = "FROM Token t WHERE t.user = :user AND t.tokenType = :tokenType AND t.expiryDate > :date AND t.isVerified = :isVerified";
            query = getSession().createQuery(hql);
            query.setParameter("user", user);
            query.setParameter("tokenType", tokenType);
            query.setParameter("date", date);
            query.setParameter("isVerified", 0);
            listToken =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		if (listToken.size() == 1){
			return listToken.get(0);
		}
		return null;
	}
	
	// Create token when user registers
	public Token createRegisterTokenByUserName(String userName) {
		Token token = new Token();
	
		try{     
			// Create token string
	        UUID tokenString = UUID.randomUUID();
	        token.setTokenString(tokenString.toString());
	        // Set user by userName
	        User user = userDao.getUserByUserName(userName);
	        token.setUser(user);
	        // Set token type (= 1)
	        TokenType tokenType = tokenTypeDao.get(1, TokenType.class);
	        token.setTokenType(tokenType);
	        // Set expiry date = today + EXPIRY_AUTHENTIC_EMAIL
	        loadProperties();
	        Calendar c = Calendar.getInstance();
	        c.setTime(new Date()); // Now use today date.
	        c.add(Calendar.DATE, EXPIRY_AUTHENTIC_EMAIL); // Adding  days
	        Date exprityDate = c.getTime();
	        token.setExpiryDate(exprityDate);
	        
	        this.save(token);
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return token;
	}

	// Create token when user forgets password
	public Token createForgotPasswordTokenByUserName(String userName) {
		Token token = new Token();
		
		try{     
			// Create token string
	        UUID tokenString = UUID.randomUUID();
	        token.setTokenString(tokenString.toString());
	        // Set user by userName
	        User user = userDao.getUserByUserName(userName);
	        token.setUser(user);
	        // Set token type (= 2)
	        TokenType tokenType = tokenTypeDao.get(2, TokenType.class);
	        token.setTokenType(tokenType);
	        // Set expiry date = today + EXPIRY_AUTHENTIC_EMAIL
	        loadProperties();
	        Calendar c = Calendar.getInstance();
	        c.setTime(new Date()); // Now use today date.
	        c.add(Calendar.DATE, EXPIRY_AUTHENTIC_EMAIL); // Adding  days
	        Date exprityDate = c.getTime();
	        token.setExpiryDate(exprityDate);
	        
	        this.save(token);
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return token;
	}

	// Verify token string
	// Return token if it exists and enables, null if not
	public Token verifyToken(String tokenString) {
		Token token = null;
		Query query = null;
		String hql = "";
		Date date = new Date();
		List<Token> listToken = new ArrayList<Token>();

		try{                	
            hql = "FROM Token t WHERE t.tokenString = :tokenString AND t.expiryDate > :date AND t.isVerified = :isVerified";
            query = getSession().createQuery(hql);
            query.setParameter("tokenString", tokenString);
            query.setParameter("date", date);
            query.setParameter("isVerified", 0);
            listToken =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		if (listToken.size() == 1){
			return listToken.get(0);
		}
		
		return token;
	}

	// Update isVerified property of Token is 1 after checking token is verified
	public void updateVerifiedToken(int tokenId) {
		Query query = null;
		String hql = "";
		Date date = new Date();
		List<Token> listToken = new ArrayList<Token>();
		
		try{                	
			hql = "UPDATE Token set isVerified = :isVerified  WHERE tokenId = :tokenId";
            query = getSession().createQuery(hql);
            query.setParameter("isVerified", 1);
            query.setParameter("tokenId", tokenId);
            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
	}
	
	public void updateVerifiedUser(String userName){
		userDao.updateVerifiedUser(userName);
	}
	
}
