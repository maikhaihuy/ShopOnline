package com.h2.model.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.CategoryDao;
import com.h2.model.pojo.Category;

@Repository ("categoryDao")
@Transactional
public class CategoryDaoImp extends AbstractHbnDao<Category> implements CategoryDao {

	public List<Category> getListCategory() {
		// TODO Auto-generated method stub
		return getAllOrderBy(Category.class.getName(), "categoryName");
	}
	
}
