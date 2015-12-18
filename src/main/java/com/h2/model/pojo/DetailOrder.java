package com.h2.model.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detailorder", catalog="shoedb")
public class DetailOrder implements Serializable{
	private int detailOrderId;
	private float detailOrderPrice;
	private int detailOrderQuantity;
	private int isDeleted;
	private Order order;
	private DetailProduct detailProduct;
	
	public DetailOrder(){}

	public DetailOrder(int detailOrderId, float detailOrderPrice,
			int detailOrderQuantity, int isDeleted, Order order,
			DetailProduct detailProduct) {
		super();
		this.detailOrderId = detailOrderId;
		this.detailOrderPrice = detailOrderPrice;
		this.detailOrderQuantity = detailOrderQuantity;
		this.isDeleted = isDeleted;
		this.order = order;
		this.detailProduct = detailProduct;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "detailOrderId", unique = true, nullable = false)
	public int getDetailOrderId() {
		return detailOrderId;
	}

	public void setDetailOrderId(int detailOrderId) {
		this.detailOrderId = detailOrderId;
	}

	@Column(name = "detailOrderPrice", nullable = false)
	public float getDetailOrderPrice() {
		return detailOrderPrice;
	}

	public void setDetailOrderPrice(float detailOrderPrice) {
		this.detailOrderPrice = detailOrderPrice;
	}

	@Column(name = "detailOrderQuantity", nullable = false)
	public int getDetailOrderQuantity() {
		return detailOrderQuantity;
	}

	public void setDetailOrderQuantity(int detailOrderQuantity) {
		this.detailOrderQuantity = detailOrderQuantity;
	}

	@Column(name = "isDeleted", nullable = false)
	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId", nullable = false)
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "detailProductId", nullable = false)
	public DetailProduct getDetailProduct() {
		return detailProduct;
	}

	public void setDetailProduct(DetailProduct detailProduct) {
		this.detailProduct = detailProduct;
	}
	
	

}
