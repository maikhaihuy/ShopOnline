package com.h2.model.dao.interfaces;

import java.util.List;

import com.h2.model.pojo.Brand;
import com.h2.model.pojo.Category;

public interface BrandDao extends Dao<Brand>{
	public List<Brand> getListBrand();
	public Brand getBrandByProductId(int productId);
}
