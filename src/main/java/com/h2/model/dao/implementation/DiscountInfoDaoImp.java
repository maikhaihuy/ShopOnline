package com.h2.model.dao.implementation;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.DiscountInfoDao;
import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.pojo.DiscountInfo;
import com.h2.model.pojo.Product;

@Repository ("discountInfoDao")
@Transactional
public class DiscountInfoDaoImp extends AbstractHbnDao<DiscountInfo> implements DiscountInfoDao {
	@Autowired
	ProductDao productDao;
	// create discount info
	// If discountProductId = 0, discountRate = 0 and discountProductId = null
	// If discountProductId != 0, discountRate = 1
	public DiscountInfo createDiscountInfo(int discountPercentValue,
			int discountProductId) {
		DiscountInfo discountInfo = new DiscountInfo();
		discountInfo.setDiscountPercentValue(discountPercentValue);
		if (discountProductId == 0){
			discountInfo.setDiscountRate(0);			
		}else{
			discountInfo.setDiscountRate(1);
			// Get product
			Product product = productDao.get(discountProductId, Product.class);
			discountInfo.setProduct(product);
		}
		save(discountInfo);
		return discountInfo;
	}

	public void updateDiscountInfo(int discountPercentValue,
			int discountProductId, int discountInfoId) {
		Query query= null;
	    String hql = "";
	    Product product = productDao.get(discountProductId, Product.class);
	    try{                  	
	        hql = "UPDATE DiscountInfo set discountPercentValue = :discountPercentValue , product = :product WHERE discountInfoId = :discountInfoId ";
	        query = getSession().createQuery(hql);
	        query.setParameter("discountPercentValue", discountPercentValue);
	        query.setParameter("product", product);	  
	        query.setParameter("discountInfoId", discountInfoId);
	        query.executeUpdate();
	  
	    } catch (Exception e) {
	        e.printStackTrace();
	        //log.error(e);
	
	    } 
	}
	
}
