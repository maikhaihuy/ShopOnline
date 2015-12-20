package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.ColorDao;
import com.h2.model.pojo.Color;

@Repository ("colorDao")
@Transactional
public class ColorDaoImp extends AbstractHbnDao<Color> implements ColorDao{

}