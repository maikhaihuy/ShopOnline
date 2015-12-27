package com.h2.model.dao.interfaces;

import java.util.Date;
import java.util.List;

import com.h2.model.pojo.Discount;

public interface DiscountDao extends Dao<Discount>{
	public List<Discount> getListDiscount();
	public Discount createDiscount(int discountInfoId, int productId, Date discountStartDate, Date discountEndDate);
	public void updateTimeDiscount(int discountId, Date discountStartDate, Date discountEndDate);
}
