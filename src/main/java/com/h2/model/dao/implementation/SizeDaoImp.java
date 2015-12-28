package com.h2.model.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.dao.interfaces.SizeDao;
import com.h2.model.pojo.Color;
import com.h2.model.pojo.Product;
import com.h2.model.pojo.Size;

@Repository ("sizeDao")
@Transactional
public class SizeDaoImp  extends AbstractHbnDao<Size> implements SizeDao {
	@Autowired
	private ProductDao productDao;
	// get list size
	public List<Size> getListSize() {
		List<Size> listSize = null;
		listSize = getAllOrderBy(Size.class.getName(), "sizeName");
		return listSize;
	}

	// Get list size of product by product id
	public List<Size> getListSizeOfProduct(int productId) {
		List<Size> listSize = new ArrayList<Size>();
        String hql = "";         
        Product product = productDao.get(productId, Product.class);
        Query query = null;
               
        try{          	
            hql =  "SELECT DISTINCT d.size FROM DetailProduct d WHERE d.product = :product ORDER BY d.size.sizeName";
            query = getSession().createQuery(hql);
            query.setParameter("product", product);
            listSize = query.list();
      
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);           
        } 
        return listSize;
	}
	
}
