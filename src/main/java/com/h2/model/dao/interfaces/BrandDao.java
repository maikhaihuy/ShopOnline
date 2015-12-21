package com.h2.model.dao.interfaces;

import java.util.List;

import com.h2.model.pojo.Brand;

public interface BrandDao extends Dao<Brand>{
	public List<Brand> getListBrand();
}
