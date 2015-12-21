package com.h2.model.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.UserDao;
import com.h2.model.pojo.City;
import com.h2.model.pojo.District;
import com.h2.model.pojo.User;

@Repository ("userDao")
@Transactional
public class UserDaoImp extends AbstractHbnDao<User> implements UserDao {
	
	public User getUserByUserName(String userName) {		
		Query query = null;
        List<User> listUser = new ArrayList<User>();
        String hql = "";       
        try{          
        	
            hql = "FROM User u WHERE u.userName = :userName";
            query = getSession().createQuery(hql);
            query.setParameter("userName", userName);
            listUser =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);
           
        } 
        
        if (listUser.size() != 0)
        	return listUser.get(0);
		return null;
	}

	public User createUser(User newUser) {
		newUser = save(newUser);
		return newUser;
	}

	public void updateUser(User updateUser) {
		update(updateUser);
	}
	
}
