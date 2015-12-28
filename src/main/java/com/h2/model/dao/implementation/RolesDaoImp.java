package com.h2.model.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.RolesDao;
import com.h2.model.pojo.Brand;
import com.h2.model.pojo.Roles;

@Repository ("rolesDao")
@Transactional
public class RolesDaoImp extends AbstractHbnDao<Roles> implements RolesDao {
	// Get role by userId
	public Roles getRoleByUserId(int userId) {
		Roles role = new Roles();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.role from  User p  WHERE p.userId = :userId ";
            query = getSession().createQuery(hql);
            query.setParameter("userId", userId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	role = (Roles) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return role;
	}
	
}
