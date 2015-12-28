package com.h2.model.dao.implementation;

import java.util.List;

import org.hibernate.Query;
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
	
	// Get recipient by order id
	public Recipient getRecipientByOrderId(int orderId) {
		Recipient recipient = new Recipient();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.recipient from  Order p  WHERE p.orderId = :orderId ";
            query = getSession().createQuery(hql);
            query.setParameter("orderId", orderId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	recipient = (Recipient) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return recipient;
	}
	
}
