package com.h2.model.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.TaxDao;
import com.h2.model.pojo.Tax;

@Repository ("taxDao")
@Transactional
public class TaxDaoImp extends AbstractHbnDao<Tax> implements TaxDao {

	public Tax getTaxByCategoryId(int categoryId) {
		Tax tax = new Tax();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.tax from  Category p  WHERE p.categoryId = :categoryId ";
            query = getSession().createQuery(hql);
            query.setParameter("categoryId", categoryId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	tax = (Tax) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return tax;
	}
	
}
