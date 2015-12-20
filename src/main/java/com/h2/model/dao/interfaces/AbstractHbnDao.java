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
	
	public void setDomainClass( final Class< T > classToSet ){
	      this.domainClass = classToSet;
	}
	
	

	public T get(Serializable id) {
		// TODO Auto-generated method stub
		return (T) getSession().get(domainClass, id);
	}

	public T load(Serializable id) {
		// TODO Auto-generated method stub
		return (T) getSession().load(domainClass, id);
	}

	public List<T> getAll(String className) {
		// TODO Auto-generated method stub		
		return getSession().createQuery("from " + className).list();
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
		getSession().createQuery("delete " +  domainClass.getName()).executeUpdate();
	}

	public long count() {
		// TODO Auto-generated method stub
		return (Long) getSession().createQuery(
				"select count(*) from " +	this.domainClass).uniqueResult();
	}

	public boolean exists(Serializable id) {
		// TODO Auto-generated method stub
		return (get(id) != null);
	}
	
	
}
