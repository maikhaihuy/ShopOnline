package com.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.common.SendMail;
import com.h2.model.dao.interfaces.UserDao;
import com.h2.model.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> GetUser(@PathVariable("username") String username) {
		User user = userDao.getUserByUserName(username);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST, consumes = { "application/json" })
	@ResponseBody
	public ResponseEntity<User> AddUser(@RequestBody User user) {
		User newUser = userDao.createNewUser(user.getUserName(), user.getUserEmail(), user.getUserPassword(), 3);
		if (newUser != null) {
			sendConfirmationMail(newUser.getUserName(), newUser.getUserEmail());
			return new ResponseEntity<User>(newUser, HttpStatus.OK);
		} else
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = { "application/json" })
	@ResponseBody
	public ResponseEntity<User> LoginUser(@RequestBody User user) {
		User newUser = userDao.login(user.getUserName(), user.getUserPassword());
		if (newUser == null)
			return new ResponseEntity<User>(newUser, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<User>(newUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/update/token/{token}", method = RequestMethod.POST, consumes = { "application/json" })
	@ResponseBody
	public ResponseEntity<User> UpdateUserPassword(@RequestBody User user, @PathVariable("token") String token) {
		User reUser = userDao.updateUserPassword(user.getUserName(), user.getUserPassword(), token);
		if (reUser == null)
			return new ResponseEntity<User>(reUser, HttpStatus.NOT_FOUND);
		return new ResponseEntity<User>(reUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST, consumes = { "application/json" })
	@ResponseBody
	public ResponseEntity<User> ForgotPassword(@RequestBody User userEmail) {
		User user = userDao.createToken(userEmail.getUserEmail());
		if (user == null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		sendGetPasswordMail(user.getUserName(), user.getUserEmail());
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	// Support function

	private void sendConfirmationMail(String username, String email) {
		String subject = "Verify";
		String token = userDao.getRegisterToken(username);
		String content = "http://localhost:8000/#/ShopOnline/token/"+ token +"/registration/" + username;
		SendMail send = new SendMail();
		send.SendTo(username, email, "RegisterContent.html", subject, content);
	}

	private void sendGetPasswordMail(String username, String email) {
		String subject = "Forgot";
		String token = userDao.getForgotPasswordToken(username);
		String content = "http://localhost:8000/#/ShopOnline/token/" + token + "/forgotpassword/" + username;

		SendMail send = new SendMail();
		send.SendTo(username, email, "ResetPassContent.html", subject, content);
	}
}
