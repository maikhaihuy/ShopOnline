package com.h2.model.dao.interfaces;

import java.util.List;

import com.h2.model.pojo.Size;

public interface SizeDao extends Dao<Size>{
	public List<Size> getListSize();
	public List<Size> getListSizeOfProduct(int productId);
	public Size getSizeByDetailProductId(int detailProductId);
}
