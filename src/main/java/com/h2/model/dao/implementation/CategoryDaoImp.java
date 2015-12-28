package com.h2.model.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.CategoryDao;
import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.pojo.Category;

@Repository ("categoryDao")
@Transactional
public class CategoryDaoImp extends AbstractHbnDao<Category> implements CategoryDao {
	@Autowired
	ProductDao productDao;
	
	public List<Category> getListCategory() {
		// TODO Auto-generated method stub
		return getAllOrderBy(Category.class.getName(), "categoryName");
	}

	public Category getCategoryByProductId(int productId) {
		Category category = new Category();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.category from  Product p  WHERE p.productId = :productId ";
            query = getSession().createQuery(hql);
            query.setParameter("productId", productId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	category = (Category) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return category;
	}

	
}
