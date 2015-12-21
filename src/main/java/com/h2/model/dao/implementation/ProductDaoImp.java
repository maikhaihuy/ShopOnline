package com.h2.model.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.pojo.Product;

@Repository ("productDao")
@Transactional
public class ProductDaoImp extends AbstractHbnDao<Product> implements ProductDao {

	public List<Product> getListProduct() {
		return getAll(Product.class.getName());
	}

	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getListNewProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getListDiscountProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getListProductByIdCategoryProductName(int categoryId,
			String productName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
