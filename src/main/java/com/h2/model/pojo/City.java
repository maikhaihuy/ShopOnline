package com.h2.model.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city", catalog="shoedb")
public class City implements Serializable {
	private int cityId;
	private String cityName;
	private int cityCost;
	private List<District> districtList = new ArrayList<District>(0);
	
	public City(){}

	public City(int cityId, String cityName, int cityCost,
			List<District> districtList) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.cityCost = cityCost;
		this.districtList = districtList;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cityId", unique = true, nullable = false)
	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	@Column(name = "cityName", nullable = false)
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Column(name = "cityCost", nullable = false)
	public int getCityCost() {
		return cityCost;
	}

	public void setCityCost(int cityCost) {
		this.cityCost = cityCost;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	public List<District> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<District> districtList) {
		this.districtList = districtList;
	}
	
	
}
