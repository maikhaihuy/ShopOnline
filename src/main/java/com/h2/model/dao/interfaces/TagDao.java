package com.h2.model.dao.interfaces;

import java.util.List;

import com.h2.model.pojo.Tag;

public interface TagDao  extends Dao<Tag>{
	public List<Tag> getListTag();
	public void updateTagValue(String tagName, String tagValue);
}
