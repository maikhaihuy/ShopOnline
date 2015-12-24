package com.h2.model.dao.implementation;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.ColorDao;
import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.pojo.Color;
import com.h2.model.pojo.Product;

@Repository ("colorDao")
@Transactional
public class ColorDaoImp extends AbstractHbnDao<Color> implements ColorDao{
	@Autowired
	private ProductDao productDao;
	
	// Get list of colors
	public List<Color> getListColor() {
		// TODO Auto-generated method stub
		return getAllOrderBy(Color.class.getName(), "colorName");
	}
	
	// Get list color of product by product id
	public List<Color> getListColorOfProduct(int productId) {
		List<Color> listColor = new ArrayList<Color>();
        String hql = "";         
        Product product = productDao.get(productId, Product.class);
        Query query = null;
               
        try{          	
            hql =  "SELECT d.color FROM DetailProduct d WHERE d.product = :product ORDER BY d.color.colorName";
            query = getSession().createQuery(hql);
            query.setParameter("product", product);
            listColor = query.list();
      
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);           
        } 
        return listColor;
	}
	
}
