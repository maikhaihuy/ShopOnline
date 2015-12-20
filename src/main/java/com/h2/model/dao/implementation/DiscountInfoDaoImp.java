package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.BrandDao;
import com.h2.model.dao.interfaces.DiscountInfoDao;
import com.h2.model.pojo.Brand;
import com.h2.model.pojo.DiscountInfo;

@Repository ("discountInfoDao")
@Transactional
public class DiscountInfoDaoImp extends AbstractHbnDao<DiscountInfo> implements DiscountInfoDao {

}
