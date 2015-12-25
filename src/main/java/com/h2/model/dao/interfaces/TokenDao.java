package com.h2.model.dao.interfaces;

import com.h2.model.pojo.Token;

public interface TokenDao extends Dao<Token>{
	public String getRegisterTokenStringByUserName(String userName);
	public String getForgotTokenStringByUserName(String userName);
}
