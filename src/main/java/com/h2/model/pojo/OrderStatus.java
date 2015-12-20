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
@Table(name = "orderstatus", catalog="shoedb")
public class OrderStatus implements Serializable{
	private int orderStatusId;
	private String orderStatusName;
	private List<Order> orderList = new ArrayList<Order>(0);
	
	public OrderStatus(){}

	public OrderStatus(int orderStatusId, String orderStatusName,
			List<Order> orderList) {
		super();
		this.orderStatusId = orderStatusId;
		this.orderStatusName = orderStatusName;
		this.orderList = orderList;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "orderStatusId", unique = true, nullable = false)
	public int getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	@Column(name = "orderStatusName", nullable = false)
	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderStatus")
	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	
	

}
