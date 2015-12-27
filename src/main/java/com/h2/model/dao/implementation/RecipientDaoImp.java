package com.h2.model.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.DistrictDao;
import com.h2.model.dao.interfaces.RecipientDao;
import com.h2.model.pojo.District;
import com.h2.model.pojo.Recipient;

@Repository ("recipientDao")
@Transactional
public class RecipientDaoImp extends AbstractHbnDao<Recipient> implements RecipientDao {
	@Autowired
	private DistrictDao districtDao;
	// Create a new recipient for order
	public Recipient createNewRecipient(String recipientName,
			String recipientEmail, String recipientPhoneNumber,
			String recipientAddress, int districtId) {
		Recipient recipient = new Recipient();
		recipient.setRecipientName(recipientName);
		recipient.setRecipientEmail(recipientEmail);
		recipient.setRecipientPhoneNumber(recipientPhoneNumber);
		recipient.setRecipientAddress(recipientAddress);
		// Get district by districtId
		District district = districtDao.get(districtId, District.class);
		recipient.setDistrict(district);
		
		save(recipient);
		
		return recipient;
	}
	
}
