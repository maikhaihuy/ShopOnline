package com.h2.model.dao.interfaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;








import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbstractHbnDao <T extends Object> implements Dao<T> {

	@Autowired
	private SessionFactory sessionFactory;
		
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	


	public T get(Serializable id, Class<T> domainClass) {
		// TODO Auto-generated method stub
		T result = null;
	       
        try{ 
        	result =  (T) getSession().get(domainClass, id);     
        } catch (Exception e) {
            e.printStackTrace();          
            //log.error(e);            
        } 
        
        return result;		
	}

	public T load(Serializable id, Class<T> domainClass) {
		// TODO Auto-generated method stub
		T result = null;
	       
        try{ 
        	result =  (T) getSession().load(domainClass, id);   
        } catch (Exception e) {
            e.printStackTrace();          
            //log.error(e);            
        } 
        
        return result;				
	}
	
	public List<T> getAll(String className) {
		// TODO Auto-generated method stub	
		List<T> result = new ArrayList<T>();
		String hql = "";
		Query query = null; 
		
		try{ 
			hql =  "from " + className;  
			query = getSession().createQuery(hql); 		
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();          
			//log.error(e);            
		} 
		
		 return result;
	}

	public List<T> getAllOrderBy(String className, String orderBy) {
		// TODO Auto-generated method stub	
		List<T> result = new ArrayList<T>();
		String hql = "";
		Query query = null; 
		
		try{ 
			hql =  "from " + className + " ORDER BY " + orderBy;  
			query = getSession().createQuery(hql); 			
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();          
			//log.error(e);            
		} 
		
		 return result;
	}

	public void update(T t) {
		// TODO Auto-generated method stub
		try{ 
			getSession().update(t);  
	    } catch (Exception e) {
	         e.printStackTrace();          
	         //log.error(e);            
	    } 		
	}

	public void delete(T t) {
		// TODO Auto-generated method stub
		try{ 
			getSession().delete(t);
	    } catch (Exception e) {
	         e.printStackTrace();          
	         //log.error(e);            
	    } 		
		
	}

	public void deleteById(Serializable id, Class<T> domainClass) {
		// TODO Auto-generated method stub
		try{ 
			delete(load(id, domainClass));
	    } catch (Exception e) {
	         e.printStackTrace();          
	         //log.error(e);            
	    } 		
		
	}

	public void deleteAll(Class<T> domainClass) {
		// TODO Auto-generated method stub
		try{ 
			getSession().createQuery("delete " +  domainClass.getName()).executeUpdate();
	    } catch (Exception e) {
	         e.printStackTrace();          
	         //log.error(e);            
	    } 		

	}

	public int count(String className) {
		// TODO Auto-generated method stub
		int result = 0; 
		try{ 
			result =  getAll(className).size();
	    } catch (Exception e) {
	         e.printStackTrace();          
	         //log.error(e);            
	    } 		
		return result;
	}

	public boolean exists(Serializable id, Class<T> domainClass) {
		// TODO Auto-generated method stub
		boolean result = false; 
		try{ 
			result = (get(id, domainClass) != null);
	    } catch (Exception e) {
	         e.printStackTrace();          
	         //log.error(e);            
	    } 		
		return result;		
	}
	
	public T save(T t){
		try{                	          
            getSession().save(t); 
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		return t;
	}
	
	
	
}
