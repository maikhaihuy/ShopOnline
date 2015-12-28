package com.h2.model.dao.interfaces;

import com.h2.model.pojo.User;

public interface UserDao extends Dao<User> {
	public User getUserByUserName(String userName);
	public User getUserByUserEmail(String userEmail);
	public User createNewUser(String userName, String userEmail, String userPassword, int roleId);
	public User updateUserPassword(String userName, String userPassword);
	public void updateVerifiedUser(String userName);
	public User login(String userName, String userPassword);
	public String hashPassword(String userPassword);
	public boolean checkUserNameExist(String userName);
	public boolean checkUserEmailExist(String userEmail);
	public User getUserByOrderId(int orderId);
	public User getUserByTokenId(int tokenId);
}
