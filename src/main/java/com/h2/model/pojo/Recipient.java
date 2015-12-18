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
@Table(name = "recipient", catalog="shoedb")
public class Recipient implements Serializable{
	private int recipientId;
	private String recipientName;
	private String recipientEmail;
	private String recipientPhoneNumber;
	private String recipientAddress;
	private District district;
	private List<Order> orderList = new ArrayList<Order>(0);
	
	public Recipient(){}

	public Recipient(int recipientId, String recipientName,
			String recipientEmail, String recipientPhoneNumber,
			String recipientAddress, District district, List<Order> orderList) {
		super();
		this.recipientId = recipientId;
		this.recipientName = recipientName;
		this.recipientEmail = recipientEmail;
		this.recipientPhoneNumber = recipientPhoneNumber;
		this.recipientAddress = recipientAddress;
		this.district = district;
		this.orderList = orderList;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "recipientId", unique = true, nullable = false)
	public int getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}

	@Column(name = "recipientName", nullable = false)
	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	@Column(name = "recipientEmail", nullable = false)
	public String getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

	@Column(name = "recipientPhoneNumber", nullable = false)
	public String getRecipientPhoneNumber() {
		return recipientPhoneNumber;
	}

	public void setRecipientPhoneNumber(String recipientPhoneNumber) {
		this.recipientPhoneNumber = recipientPhoneNumber;
	}
	
	@Column(name = "recipientAddress", nullable = false)
	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "districtId", nullable = false)
	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "recipient")
	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	
	
}
