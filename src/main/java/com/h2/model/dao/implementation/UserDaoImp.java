package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.UserDao;
import com.h2.model.pojo.User;

@Repository ("userDao")
@Transactional
public class UserDaoImp extends AbstractHbnDao<User> implements UserDao {
	public UserDaoImp(){
		this.setDomainClass(User.class);
	}
}
