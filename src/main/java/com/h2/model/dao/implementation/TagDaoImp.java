package com.h2.model.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.TagDao;
import com.h2.model.pojo.Tag;

@Repository ("tagDao")
@Transactional
public class TagDaoImp  extends AbstractHbnDao<Tag> implements TagDao{
	// Get list of tag
	public List<Tag> getListTag() {
		return getAll(Tag.class.getName());
	}

	// Update tag value by tag name
	public void updateTagValue(String tagName, String tagValue) {
		Query query= null;
        String hql = "";
        try{                  	
            hql = "UPDATE Tag set tagValue = :tagValue  WHERE tagName = :tagName";
            query = getSession().createQuery(hql);
            query.setParameter("tagValue", tagValue);
            query.setParameter("tagName", tagName);
            query.executeUpdate();
      
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);

        } 
	}

}
