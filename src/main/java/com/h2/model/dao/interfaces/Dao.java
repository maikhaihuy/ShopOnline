package com.h2.model.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface Dao <T extends Object>{
	//public void create(T t);
	public T get(Serializable id);
	public T load(Serializable id);
	public List<T> getAll(String className);
	public void update(T t);
	public void delete(T t);
	public void deleteById(Serializable id);
	public void deleteAll();
	public long count();
	public boolean exists(Serializable id);

}
