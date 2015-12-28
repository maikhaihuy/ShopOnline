package com.h2.model.dao.interfaces;

import java.util.List;

import com.h2.model.pojo.Product;
import com.h2.model.pojo.SubProduct;

public interface ProductDao extends Dao<Product>{
	public List<Product> getListProduct(int times);
	public List<Product> getListProductWithPaging(int pageNumber, int productPerPage);
	
	public Product getProductById(int productId);	
	public List<Product> getListNewProduct();
	public List<Product> getListDiscountProduct();
	
	public List<Product> getListProductByIdCategoryProductName(int categoryId, String productName, int times);
	//public List<Product> getListProductByIdCategoryProductNamePaging(int categoryId, String productName, int pageNumber, int productPerPage);
	
	public List<Product> getListProductByIdCategory(int categoryId, int times);
	//public List<Product> getListProductByIdCategoryPaging(int categoryId, int pageNumber, int productPerPage);
	
	public List<Product> getListProductByIdBrand(int brandId, int times);
	
	public List<Product> searchProductByCategoryBrandColorSizePriceName(
			int categoryId, int brandId, int colorId, int sizeId, 
			float fromPrice, float toPrice, String productName, int times);
	
	public float countPriceOfProductByProductId(int productId);
	
	public SubProduct getInfoOfProductByProductId(int productId);
	
}
