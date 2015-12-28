package com.h2.model.dao.interfaces;

import java.util.List;

import com.h2.model.pojo.District;

public interface DistrictDao extends Dao<District> {
	public List<District> getDistrictByIdCity(int cityId);
	public District getDistrictByRecipientId(int recipientId);
	public District getDistrictByUserId(int userId);
}
