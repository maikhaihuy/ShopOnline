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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "district", catalog="shoedb")
public class District implements Serializable{
	private int districtId;
	private String districtName;
	private int districtCost;
	private City city;
	private List<User> userList = new ArrayList<User>(0);
	private List<Recipient> recipientList = new ArrayList<Recipient>(0);
	
	public District(){}

	public District(int districtId, String districtName, int districtCost,
			City city, List<User> userList, List<Recipient> recipientList) {
		super();
		this.districtId = districtId;
		this.districtName = districtName;
		this.districtCost = districtCost;
		this.city = city;
		this.userList = userList;
		this.recipientList = recipientList;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "districtId", unique = true, nullable = false)
	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	@Column(name = "districtName", nullable = false)
	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	@Column(name = "districtCost", nullable = false)
	public int getDistrictCost() {
		return districtCost;
	}

	public void setDistrictCost(int districtCost) {
		this.districtCost = districtCost;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cityId", nullable = false)
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
	public List<Recipient> getRecipientList() {
		return recipientList;
	}

	public void setRecipientList(List<Recipient> recipientList) {
		this.recipientList = recipientList;
	}
	
	
}
