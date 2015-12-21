package com.h2.model.dao.interfaces;

import com.h2.model.pojo.User;

public interface UserDao extends Dao<User> {
	public User getUserByUserName(String userName);
	public User createUser(User newUser);
	public void updateUser(User updateUser);
}
