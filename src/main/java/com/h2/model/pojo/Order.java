package com.h2.model.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "order", catalog="shoedb")
public class Order implements Serializable{
	private int orderId;
	private OrderStatus orderStatus;
	private Date orderDate;
	private float orderTotal;
	private Recipient recipient;
	private User user;
	private int isDeleted;
	private String orderCode;
	private float orderTransferCost;
	private List<DetailOrder> detailOrderList = new ArrayList<DetailOrder>(0);
	
	public Order(){}

	public Order(int orderId, OrderStatus orderStatus, Date orderDate,
			float orderTotal, Recipient recipient, User user, int isDeleted,
			String orderCode, float orderTransferCost, List<DetailOrder> detailOrderList) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
		this.recipient = recipient;
		this.user = user;
		this.isDeleted = isDeleted;
		this.orderCode = orderCode;
		this.orderTransferCost = orderTransferCost;
		this.detailOrderList = detailOrderList;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "orderId", unique = true, nullable = false)
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderStatusId", nullable = false)
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "orderDate", nullable = false)
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "orderTotal", nullable = false)
	public float getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipientId", nullable = false)
	public Recipient getRecipient() {
		return recipient;
	}

	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "isDeleted", nullable = false)
	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "orderCode", nullable = false)
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	@Column(name = "orderTransferCost", nullable = false)
	public float getOrderTransferCost() {
		return orderTransferCost;
	}

	public void setOrderTransferCost(float orderTransferCost) {
		this.orderTransferCost = orderTransferCost;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	public List<DetailOrder> getDetailOrderList() {
		return detailOrderList;
	}

	public void setDetailOrderList(List<DetailOrder> detailOrderList) {
		this.detailOrderList = detailOrderList;
	}
	
	
}
