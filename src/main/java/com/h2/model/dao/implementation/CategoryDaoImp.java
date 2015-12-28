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

@Repository ("categoryDao")
@Transactional
public class CategoryDaoImp extends AbstractHbnDao<Category> implements CategoryDao {
	@Autowired
	ProductDao productDao;
	
	public List<Category> getListCategory() {
		// TODO Auto-generated method stub
		return getAllOrderBy(Category.class.getName(), "categoryName");
	}

	
}
