package com.h2.model.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.TokenTypeDao;
import com.h2.model.pojo.TokenType;
import com.h2.model.pojo.User;

@Repository ("tokenTypeDao")
@Transactional
public class TokenTypeDaoImp extends AbstractHbnDao<TokenType> implements TokenTypeDao{

	// Get token type by token id
	public TokenType getTokenTypeByTokenId(int tokenId) {
		TokenType tokenType = new TokenType();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.tokenType from  Token p  WHERE p.tokenId = :tokenId ";
            query = getSession().createQuery(hql);
            query.setParameter("tokenId", tokenId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	tokenType = (TokenType) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return tokenType;
	}
	
}
