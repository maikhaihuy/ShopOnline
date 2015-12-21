package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.pojo.Product;

@Repository ("productDao")
@Transactional
public class ProductDaoImp extends AbstractHbnDao<Product> implements ProductDao {
	
}
