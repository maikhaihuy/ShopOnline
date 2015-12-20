package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.DiscountDao;
import com.h2.model.pojo.Discount;

@Repository ("discountDao")
@Transactional
public class DiscountDaoImp extends AbstractHbnDao<Discount> implements DiscountDao {

}
