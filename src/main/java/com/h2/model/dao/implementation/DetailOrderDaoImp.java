package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.DetailOrderDao;
import com.h2.model.pojo.DetailOrder;

@Repository ("detailOrderDao")
@Transactional
public class DetailOrderDaoImp extends AbstractHbnDao<DetailOrder> implements DetailOrderDao {
	
}
