package com.h2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.pojo.Token;

@RestController
@RequestMapping("/token")
public class TokenController {
	@RequestMapping(value="/{username}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Token> GetToken(@PathVariable("username") String username){
		return new ResponseEntity<Token>(null);
	}
}
