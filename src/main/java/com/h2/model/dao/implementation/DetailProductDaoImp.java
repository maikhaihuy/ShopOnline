package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.DetailProductDao;
import com.h2.model.pojo.DetailProduct;

@Repository ("detailProductDao")
@Transactional
public class DetailProductDaoImp extends AbstractHbnDao<DetailProduct> implements DetailProductDao {
	public DetailProductDaoImp(){
		this.setDomainClass(DetailProduct.class);
	}
}
