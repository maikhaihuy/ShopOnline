package com.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.dao.interfaces.UserDao;
import com.h2.model.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/{username}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> GetUser(@PathVariable("username") String username){
		User user = userDao.getUserByUserName(username);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/new",
					method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> AddUser(@PathVariable("username") String username,
			@PathVariable("useremail") String useremail, @PathVariable("userpassword") String userpassword){
		User user = userDao.createNewUser(username, useremail, userpassword, 3);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update",
					method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<User> UpdateUserPassword(@PathVariable("username") String username, @PathVariable("userpassword") String userpassword){
		User user = userDao.updateUserPassword(username, userpassword);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
