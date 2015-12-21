package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.TokenDao;
import com.h2.model.pojo.Token;

@Repository ("tokenDao")
@Transactional
public class TokenDaoImp extends AbstractHbnDao<Token> implements TokenDao {
	
}
