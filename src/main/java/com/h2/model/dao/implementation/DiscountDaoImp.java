package com.h2.model.dao.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.DiscountDao;
import com.h2.model.dao.interfaces.DiscountInfoDao;
import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.pojo.Discount;
import com.h2.model.pojo.DiscountInfo;
import com.h2.model.pojo.Product;

@Repository ("discountDao")
@Transactional
public class DiscountDaoImp extends AbstractHbnDao<Discount> implements DiscountDao {
	@Autowired
	DiscountInfoDao discountInfoDao;
	@Autowired
	ProductDao productDao;
	// Get list of discounts which are valid 
	public List<Discount> getListDiscount() {
		List<Discount> listDiscount = new ArrayList<Discount>();
		String hql = "";
		Query query = null; 
	
		try{ 
			hql =  "from Discount d WHERE d.discountEndDate > :date ORDER BY d.discountEndDate DESC" ;  
			query = getSession().createQuery(hql); 
			query.setParameter("date", new Date());
			listDiscount = query.list();
		} catch (Exception e) {
			e.printStackTrace();          
			//log.error(e);            
		} 
		if (listDiscount.size() == 0){
			return null;
		}
		return listDiscount;
	}

	// Create a new discount
	public Discount createDiscount(int discountInfoId, int productId,
			Date discountStartDate, Date discountEndDate) {
		Discount discount = new Discount();
		// Get discountInfo
		DiscountInfo discountInfo = discountInfoDao.get(discountInfoId, DiscountInfo.class);
		discount.setDiscountInfo(discountInfo);
		// Get product
		Product product = productDao.get(productId, Product.class);
		discount.setProduct(product);
		discount.setDiscountStartDate(discountStartDate);
		discount.setDiscountEndDate(discountEndDate);
		save(discount);
		return discount;
	}

	// Update time of discount
	public void updateTimeDiscount(int discountId, Date discountStartDate,
			Date discountEndDate) {
		Query query= null;
	    String hql = "";
	   
	    try{                  	
	        hql = "UPDATE Discount set discountStartDate = :discountStartDate , discountEndDate = :discountEndDate WHERE discountId = :discountId ";
	        query = getSession().createQuery(hql);
	        query.setParameter("discountStartDate", discountStartDate);
	        query.setParameter("discountEndDate", discountEndDate);	  
	        query.setParameter("discountId", discountId);
	        query.executeUpdate();
	  
	    } catch (Exception e) {
	        e.printStackTrace();
	        //log.error(e);
	
	    } 
	}
	
}
