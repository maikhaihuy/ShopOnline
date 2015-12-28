package com.h2.model.dao.interfaces;

import com.h2.model.pojo.TokenType;

public interface TokenTypeDao extends Dao<TokenType>{
	public TokenType getTokenTypeByTokenId(int tokenId);
}
