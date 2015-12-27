package com.h2.model.dao.interfaces;

import com.h2.model.pojo.DiscountInfo;

public interface DiscountInfoDao extends Dao<DiscountInfo>{
	public DiscountInfo createDiscountInfo(int discountPercentValue, int discountProductId);
	public void updateDiscountInfo(int discountPercentValue, int discountProductId, int discountInfoId);
}
