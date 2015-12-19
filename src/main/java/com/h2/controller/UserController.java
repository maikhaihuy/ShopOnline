package com.h2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@RequestMapping(value="/{username}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> GetUser(@PathVariable("username") String username){
		return new ResponseEntity<User>(null);
	}
	
	@RequestMapping(value="/new",
					method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> AddUser(){
		return new ResponseEntity<User>(null);
	}
	
	@RequestMapping(value="/update",
					method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<User> UpdateUser(){
		return new ResponseEntity<User>(null);
	}
}
