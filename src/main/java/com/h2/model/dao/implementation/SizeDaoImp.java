package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.SizeDao;
import com.h2.model.pojo.Size;

@Repository ("sizeDao")
@Transactional
public class SizeDaoImp  extends AbstractHbnDao<Size> implements SizeDao {
	
}
