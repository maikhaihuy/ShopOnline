package com.h2.model.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface Dao <T extends Object>{
	//public void create(T t);
	public T get(Serializable id, Class<T> domainClass);
	public T load(Serializable id, Class<T> domainClass);
	public List<T> getAll(String className);
	public void update(T t);
	public void delete(T t);
	public void deleteById(Serializable id, Class<T> domainClass);
	public void deleteAll(Class<T> domainClass);
	public int count(String className);
	public boolean exists(Serializable id, Class<T> domainClass);
	public T save(T t);
}
