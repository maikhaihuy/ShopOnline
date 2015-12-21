package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.TaxDao;
import com.h2.model.pojo.Tax;

@Repository ("taxDao")
@Transactional
public class TaxDaoImp extends AbstractHbnDao<Tax> implements TaxDao {
	
}
