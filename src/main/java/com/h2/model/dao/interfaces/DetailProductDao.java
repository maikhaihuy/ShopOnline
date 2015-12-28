package com.h2.model.dao.interfaces;

import com.h2.model.pojo.DetailProduct;

public interface DetailProductDao extends Dao<DetailProduct>{
	public DetailProduct getDetailProductById(int detailProductId);
	public DetailProduct getDetailProductByProductColorSizeId(int productId, int colorId, int sizeId);
	public void updateQuantityOfDetailProduct(int detailProductId, int quantity);
	public DetailProduct getDetailProductByDetailOrderId(int detailOrderId);
}
