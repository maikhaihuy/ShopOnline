package com.h2.model.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.CityDao;
import com.h2.model.pojo.Category;
import com.h2.model.pojo.City;

@Repository ("cityDao")
@Transactional
public class CityDaoImp extends AbstractHbnDao<City> implements CityDao {

	public List<City> getListCity() {
		// TODO Auto-generated method stub
		return getAllOrderBy(City.class.getName(), "cityName");
	}

	// Get city by district id
	public City getCityByDistrictId(int districtId) {
		City city = new City();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.city from District p  WHERE p.districtId = :districtId ";
            query = getSession().createQuery(hql);
            query.setParameter("districtId", districtId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	city = (City) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return city;
	}
	
}
