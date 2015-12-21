package com.h2.model.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.TokenDao;
import com.h2.model.dao.interfaces.UserDao;
import com.h2.model.pojo.Token;

@Repository ("tokenDao")
@Transactional
public class TokenDaoImp extends AbstractHbnDao<Token> implements TokenDao {
	@Autowired
	private UserDao userDao;
	
	public String getTokenStringByUserName(String userName) {
		String tokenString = null;
		/*Query query = null;
		String hql = "";
		
		List<Token> 
		// Get user by user name
		User user = userDao.getUserByUserName(userName);
		// Get token string
		try{                	
            hql = "FROM Token t WHERE t.user = :user";
            query = getSession().createQuery(hql);
            query.setParameter("user", user);
            listOrder =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } */
		return tokenString;
	}
	
}
