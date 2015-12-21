package com.h2.model.dao.interfaces;

import java.util.List;

import com.h2.model.pojo.City;

public interface CityDao extends Dao<City>{
	public List<City> getListCity();
}
