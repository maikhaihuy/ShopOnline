package com.h2.model.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.DiscountInfoDao;
import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.pojo.Color;
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

	// Get discountInfo by discount id
	public DiscountInfo getDiscountInfoByDiscountId(int discountId) {
		DiscountInfo discountInfo = new DiscountInfo();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.discountInfo from Discount p  WHERE p.discountId = :discountId ";
            query = getSession().createQuery(hql);
            query.setParameter("discountId", discountId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	discountInfo = (DiscountInfo) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return discountInfo;
	}
	
	public DiscountInfo getDiscountInfoByProductId(int productId) {
		DiscountInfo discountInfo = new DiscountInfo();
		Product product = productDao.get(productId, Product.class);
		String hql = "";
		Query query = null; 
		try{                	
			hql = "SELECT DISTINCT p.discountInfo FROM Discount p WHERE p.discountEndDate > :date AND p.product = :product ";
            query = getSession().createQuery(hql);
            query.setParameter("product", product);
            query.setParameter("date", new Date());
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	discountInfo = (DiscountInfo) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return discountInfo;
	}
}
