package com.h2.model.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.DistrictDao;
import com.h2.model.pojo.City;
import com.h2.model.pojo.District;

@Repository ("districtDao")
@Transactional
public class DistrictDaoImp extends AbstractHbnDao<District> implements DistrictDao {
	
	// Get list of districts in city by cityId
	public List<District> getDistrictByIdCity(int cityId) {
		Query query = null;
        List<District> listDistrict = new ArrayList<District>();
        String hql = "";
        City city = (City)getSession().get(City.class, cityId);
        try{          
        	
            hql = "FROM District d WHERE d.city = :city ";
            query = getSession().createQuery(hql);
            query.setParameter("city", city);
            listDistrict =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);
           
        } 
        return listDistrict;
	}

	// Get District by recipient Id
	public District getDistrictByRecipientId(int recipientId) {
		District district = new District();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.district from Recipient p  WHERE p.recipientId = :recipientId ";
            query = getSession().createQuery(hql);
            query.setParameter("recipientId", recipientId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	district = (District) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return district;
	}

	// Get District by user Id
	public District getDistrictByUserId(int userId) {
		District district = new District();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.district from User p  WHERE p.userId = :userId ";
            query = getSession().createQuery(hql);
            query.setParameter("userId", userId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	district = (District) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return district;
	}

	
	
}
