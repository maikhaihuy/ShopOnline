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
	
}
