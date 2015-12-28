package com.h2.model.dao.interfaces;

import com.h2.model.pojo.Tax;

public interface TaxDao extends Dao<Tax>{
	public Tax getTaxByCategoryId(int categoryId);
}
