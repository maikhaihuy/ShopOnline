package com.h2.model.dao.interfaces;

import java.util.List;

import com.h2.model.pojo.Color;

public interface ColorDao extends Dao<Color> {
	public List<Color> getListColor();
	public List<Color> getListColorOfProduct(int productId);
	public Color getColorByDetailProductId(int detailProductId);
}
