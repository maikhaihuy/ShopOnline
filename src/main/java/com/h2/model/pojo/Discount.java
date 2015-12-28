package com.h2.model.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "discount", catalog="shoedb")
public class Discount implements Serializable {
	private int discountId;
	private DiscountInfo discountInfo;
	private Product product;	
	private Date discountStartDate;
	private Date discountEndDate;
	
	public Discount(){}

	
	public Discount(int discountId, DiscountInfo discountInfo, Product product,
			Date discountStartDate, Date discountEndDate) {
		super();
		this.discountId = discountId;
		this.discountInfo = discountInfo;
		this.product = product;
		this.discountStartDate = discountStartDate;
		this.discountEndDate = discountEndDate;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "discountId", unique = true, nullable = false)
	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "discountInfoId", nullable = false)
	@JsonIgnore
	public DiscountInfo getDiscountInfo() {
		return discountInfo;
	}

	public void setDiscountInfo(DiscountInfo discountInfo) {
		this.discountInfo = discountInfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId", nullable = false)
	@JsonIgnore
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "discountStartDate", nullable = false)
	public Date getDiscountStartDate() {
		return discountStartDate;
	}

	public void setDiscountStartDate(Date discountStartDate) {
		this.discountStartDate = discountStartDate;
	}

	@Column(name = "discountEndDate", nullable = false)
	public Date getDiscountEndDate() {
		return discountEndDate;
	}

	public void setDiscountEndDate(Date discountEndDate) {
		this.discountEndDate = discountEndDate;
	}

	
	
}
