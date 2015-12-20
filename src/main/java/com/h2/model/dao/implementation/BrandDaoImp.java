package com.h2.model.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.BrandDao;
import com.h2.model.pojo.Brand;

@Repository ("brandDao")
@Transactional
public class BrandDaoImp extends AbstractHbnDao<Brand> implements BrandDao {	
	
	public List<Brand> getListBrand() {
		return this.getAll(Brand.class.getName());
	}

}
