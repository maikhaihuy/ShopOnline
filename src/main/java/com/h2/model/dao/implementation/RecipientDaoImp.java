package com.h2.model.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.RecipientDao;
import com.h2.model.pojo.Recipient;

@Repository ("recipientDao")
@Transactional
public class RecipientDaoImp extends AbstractHbnDao<Recipient> implements RecipientDao {

}
