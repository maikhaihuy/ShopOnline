package com.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.dao.interfaces.TokenDao;
import com.h2.model.pojo.Token;

@RestController
@RequestMapping("/token")
public class TokenController {
	@Autowired
	private TokenDao tokenDao;
	
	@RequestMapping(value="/{strtoken}/registration/{username}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Token> GetRegisterToken(@PathVariable("username") String username,
													@PathVariable("strtoken") String strtoken){
		Token token = tokenDao.getRegisterTokenStringByUserName(username);
		Token confirmToken = tokenDao.verifyToken(strtoken);
		if (token != null && confirmToken != null && token.getTokenString().equals(strtoken)){
			tokenDao.updateVerifiedToken(token.getTokenId());
			tokenDao.updateVerifiedUser(username);
			return new ResponseEntity<Token>(token, HttpStatus.OK);
		}
		else
			return new ResponseEntity<Token>(token, HttpStatus.GONE);
	}
	
	@RequestMapping(value="/{strtoken}/forgotpassword/{username}",
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Token> GetForgotPasswordToken(@PathVariable("username") String username,
														@PathVariable("strtoken") String strtoken){
		Token token = tokenDao.getForgotTokenStringByUserName(username);
		Token confirmToken = tokenDao.verifyToken(strtoken);
		if (token != null && confirmToken != null && token.getTokenString().equals(strtoken)){
			//tokenDao.updateVerifiedToken(token.getTokenId());
			return new ResponseEntity<Token>(token, HttpStatus.OK);
		}
		else
			return new ResponseEntity<Token>(token, HttpStatus.GONE);
	}
}
