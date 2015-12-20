package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.CityDao;
import com.h2.model.pojo.City;

@Repository ("cityDao")
@Transactional
public class CityDaoImp extends AbstractHbnDao<City> implements CityDao {

}
