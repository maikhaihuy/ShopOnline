package com.h2.model.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.BrandDao;
import com.h2.model.pojo.Brand;

@Repository ("brandDao")
@Transactional
public class BrandDaoImp extends AbstractHbnDao<Brand> implements BrandDao {

	// Get list brand
	public List<Brand> getListBrand() {
		return getAllOrderBy(Brand.class.getName(), "brandName");
	}

	// Get brand by product Id
	public Brand getBrandByProductId(int productId) {
		Brand brand = new Brand();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.brand from  Product p  WHERE p.productId = :productId ";
            query = getSession().createQuery(hql);
            query.setParameter("productId", productId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	brand = (Brand) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return brand;
	}		
	
}
