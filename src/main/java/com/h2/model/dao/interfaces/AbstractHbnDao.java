package com.h2.model.dao.interfaces;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

public abstract class AbstractHbnDao <T extends Object> implements Dao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> domainClass;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> getDomainClass() {
		if (domainClass == null) {			
			this.domainClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractHbnDao.class);
		}
		return domainClass;
	}
	
	private String getDomainClassName() {
		return getDomainClass().getName();
	}

	public T get(Serializable id) {
		// TODO Auto-generated method stub
		return (T) getSession().get(getDomainClass(), id);
	}

	public T load(Serializable id) {
		// TODO Auto-generated method stub
		return (T) getSession().load(getDomainClass(), id);
	}

	public List<T> getAll() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from " + getDomainClassName()).list();
	}

	public void update(T t) {
		// TODO Auto-generated method stub
		getSession().update(t);
	}

	public void delete(T t) {
		// TODO Auto-generated method stub
		getSession().delete(t);
	}

	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		delete(load(id));
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		getSession().createQuery("delete " +  getDomainClassName()).executeUpdate();
	}

	public long count() {
		// TODO Auto-generated method stub
		return (Long) getSession().createQuery(
				"select count(*) from " +
				getDomainClassName()).uniqueResult();
	}

	public boolean exists(Serializable id) {
		// TODO Auto-generated method stub
		return (get(id) != null);
	}
	
	
}
