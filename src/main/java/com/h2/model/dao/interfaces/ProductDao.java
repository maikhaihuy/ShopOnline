package com.h2.model.dao.interfaces;

import java.util.List;

import com.h2.model.pojo.Product;

public interface ProductDao extends Dao<Product>{
	public List<Product> getListProduct();
	public Product getProductById(int productId);
	public List<Product> getListNewProduct();
	public List<Product> getListDiscountProduct();
	public List<Product> getListProductByIdCategoryProductName(int categoryId, String productName);
}
