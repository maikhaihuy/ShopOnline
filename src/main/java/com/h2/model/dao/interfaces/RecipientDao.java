package com.h2.model.dao.interfaces;

import com.h2.model.pojo.Recipient;

public interface RecipientDao extends Dao<Recipient>{
	public Recipient createNewRecipient(String recipientName, String recipientEmail,
			String recipientPhoneNumber, String recipientAddress, int districtId);
	public Recipient getRecipientByOrderId(int orderId);
}
