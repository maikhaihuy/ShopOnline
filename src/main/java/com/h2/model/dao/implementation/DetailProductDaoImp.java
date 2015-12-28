package com.h2.model.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.ColorDao;
import com.h2.model.dao.interfaces.DetailProductDao;
import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.dao.interfaces.SizeDao;
import com.h2.model.pojo.Color;
import com.h2.model.pojo.DetailProduct;
import com.h2.model.pojo.Product;
import com.h2.model.pojo.Size;

@Repository ("detailProductDao")
@Transactional
public class DetailProductDaoImp extends AbstractHbnDao<DetailProduct> implements DetailProductDao {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ColorDao colorDao;
	@Autowired
	private SizeDao sizeDao;
	
	// Get Detail product by id
	public DetailProduct getDetailProductById(int detailProductId) {		
		return get(detailProductId, DetailProduct.class);
	}

	// Get Detail Product by product, color, size id
	public DetailProduct getDetailProductByProductColorSizeId(int productId,
			int colorId, int sizeId) {
		Product product = productDao.get(productId, Product.class);
		Color color = colorDao.get(colorId, Color.class);
		Size size = sizeDao.get(sizeId, Size.class);
        
		Query query = null;
	    List<DetailProduct> listDetailProduct = new ArrayList<DetailProduct>();
        String hql = "";
        try{                  	
            hql = "FROM DetailProduct d WHERE d.product = :product AND d.color = :color AND d.size = :size";
            query = getSession().createQuery(hql);
            query.setParameter("product", product);
            query.setParameter("color", color);
            query.setParameter("size", size);
            listDetailProduct =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);
            
        } 
        if (listDetailProduct.size() != 0)
        	return listDetailProduct.get(0);
        else
        	return null;
	}

	// Update quantity of detailProduct after confirm order
	public void updateQuantityOfDetailProduct(int detailProductId, int quantity) {
		Query query= null;
        String hql = "";
        try{                  	
            hql = "UPDATE DetailProduct set detailProductQuantity = :quantity  WHERE detailProductId = :detailProductId";
            query = getSession().createQuery(hql);
            query.setParameter("quantity", quantity);
            query.setParameter("detailProductId", detailProductId);
            query.executeUpdate();
      
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);

        } 
	}

	// Get detail product by order id
	public DetailProduct getDetailProductByDetailOrderId(int detailOrderId) {
		DetailProduct detailProduct = new DetailProduct();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.detailProduct from  DetailOrder p  WHERE p.detailOrderId = :detailOrderId ";
            query = getSession().createQuery(hql);
            query.setParameter("detailOrderId", detailOrderId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	detailProduct = (DetailProduct) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return detailProduct;
	}
	
}
