package com.h2.model.dao.interfaces;

import com.h2.model.pojo.Token;

public interface TokenDao extends Dao<Token>{
	public Token getRegisterTokenStringByUserName(String userName);
	public Token getForgotTokenStringByUserName(String userName);
	public Token createRegisterTokenByUserName(String userName);
	public Token createForgotPasswordTokenByUserName(String userName);
	public Token verifyToken(String tokenString);	
	public void updateVerifiedToken(int tokenId);
}
