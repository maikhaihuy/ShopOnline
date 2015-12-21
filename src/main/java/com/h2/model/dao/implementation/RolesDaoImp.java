package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.RolesDao;
import com.h2.model.pojo.Roles;

@Repository ("rolesDao")
@Transactional
public class RolesDaoImp extends AbstractHbnDao<Roles> implements RolesDao {
	
}
