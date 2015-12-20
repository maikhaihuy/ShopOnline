package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.DistrictDao;
import com.h2.model.pojo.District;

@Repository ("districtDao")
@Transactional
public class DistrictDaoImp extends AbstractHbnDao<District> implements DistrictDao {

}
