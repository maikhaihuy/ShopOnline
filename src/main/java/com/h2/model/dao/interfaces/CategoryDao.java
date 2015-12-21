package com.h2.model.dao.interfaces;

import java.util.List;

import com.h2.model.pojo.Category;

public interface CategoryDao extends Dao<Category>{
	public List<Category> getListCategory();
}
