package com.h2.model.dao.interfaces;

import java.security.NoSuchAlgorithmException;

import com.h2.model.pojo.User;

public interface UserDao extends Dao<User> {
	public User getUserByUserName(String userName);
	public User getUserByUserEmail(String userEmail);
	public User createNewUser(String userName, String userEmail, String userPassword, int roleId);
	public User createToken(String userName);
	public User updateUserPassword(String userName, String userPassword, String tokenStr);
	public void updateVerifiedUser(String userName);
	public User login(String userName, String userPassword);
	public String hashPassword(String userPassword);
	public boolean checkUserNameExist(String userName);
	public boolean checkUserEmailExist(String userEmail);
	public User getUserByOrderId(int orderId);
	public User getUserByTokenId(int tokenId);
	public String getRegisterToken(String username);
	public String getForgotPasswordToken(String username);
}
