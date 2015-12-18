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
@Table(name = "user", catalog="shoedb")
public class User implements Serializable{
	private int userId;
	private String userName;
	private String userEmail;
	private String userPhoneNumber;
	private String userAddress;
	private String userPassword;
	private int isDeleted;
	private int isVerified;
	private District district;
	private Roles role;
	private List<Order> orderList = new ArrayList<Order>(0);
	private List<Token> tokenList = new ArrayList<Token>(0);
	
	public User(){}

	public User(int userId, String userName, String userEmail,
			String userPhoneNumber, String userAddress, String userPassword,
			int isDeleted, int isVerified, District district, Roles role,
			List<Order> orderList, List<Token> tokenList) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhoneNumber = userPhoneNumber;
		this.userAddress = userAddress;
		this.userPassword = userPassword;
		this.isDeleted = isDeleted;
		this.isVerified = isVerified;
		this.district = district;
		this.role = role;
		this.orderList = orderList;
		this.tokenList = tokenList;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userId", unique = true, nullable = false)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "userName", nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "userEmail", nullable = false)
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "userPhoneNumber", nullable = false)
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	@Column(name = "userAddress", nullable = false)
	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Column(name = "userPassword", nullable = false)
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "isDeleted", nullable = false)
	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "isVerified", nullable = false)
	public int getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(int isVerified) {
		this.isVerified = isVerified;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "districtId", nullable = false)
	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId", nullable = false)
	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public List<Token> getTokenList() {
		return tokenList;
	}

	public void setTokenList(List<Token> tokenList) {
		this.tokenList = tokenList;
	}
	
	
}
