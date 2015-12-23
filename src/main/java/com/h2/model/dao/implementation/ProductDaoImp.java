package com.h2.model.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.CategoryDao;
import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.pojo.Category;
import com.h2.model.pojo.Product;

@Repository ("productDao")
@Transactional
public class ProductDaoImp extends AbstractHbnDao<Product> implements ProductDao {
	@Autowired
	private CategoryDao categoryDao;
	
	public List<Product> getListProduct() {
		return getAll(Product.class.getName());
	}

	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return get(productId, Product.class);
	}

	public List<Product> getListNewProduct() {
		Query query = null;
        List<Product> listProduct = new ArrayList<Product>();
        String hql = "";      
        
        try{                	
            hql = "FROM Product p WHERE p.productNew = :productNew ORDER BY p.productName";
            query = getSession().createQuery(hql);
            query.setParameter("productNew", 1);
            listProduct =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
        return listProduct;
	}

	public List<Product> getListDiscountProduct() {
		Query query = null;
        List<Product> listProduct = new ArrayList<Product>();
        String hql = "";      
        
        try{                	
            hql = "FROM Product p WHERE p.productNew = :productNew ORDER BY p.productName";
            query = getSession().createQuery(hql);
            query.setParameter("productNew", 1);
            listProduct =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
        return listProduct;
	}

	public List<Product> getListProductByIdCategoryProductName(int categoryId, String productName) {
		Query query = null;
        List<Product> listProduct = new ArrayList<Product>();
        String hql = "";    
        
        // Get category by categoryId
        Category category = categoryDao.get(categoryId, Category.class);
        
        try{                	
            hql = "FROM Product p WHERE p.productName LIKE :productName AND p.category = :category ORDER BY p.productName";
            query = getSession().createQuery(hql);   
            query.setString("productName", "%"+productName+"%");
            query.setParameter("category", category);
            listProduct =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
        return listProduct;
	}
	
}
