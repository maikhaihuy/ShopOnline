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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "discountinfo", catalog="shoedb")
public class DiscountInfo implements Serializable{
	private int discountInfoId;
	private int discountPercentValue;
	private int discountRate;
	private Product product;
	private List<Discount> discountList = new ArrayList<Discount>(0);
	
	public DiscountInfo(){}

	public DiscountInfo(int discountInfoId, int discountPercentValue,
			int discountRate, Product product, List<Discount> discountList) {
		super();
		this.discountInfoId = discountInfoId;
		this.discountPercentValue = discountPercentValue;
		this.discountRate = discountRate;
		this.product = product;
		this.discountList = discountList;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "discountInfoId", unique = true, nullable = false)
	public int getDiscountInfoId() {
		return discountInfoId;
	}

	public void setDiscountInfoId(int discountInfoId) {
		this.discountInfoId = discountInfoId;
	}

	@Column(name = "discountPercentValue", nullable = false)
	public int getDiscountPercentValue() {
		return discountPercentValue;
	}

	public void setDiscountPercentValue(int discountPercentValue) {
		this.discountPercentValue = discountPercentValue;
	}

	@Column(name = "discountRate", nullable = false)
	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "discountProductId", nullable = true)
	@JsonIgnore
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "discountInfo")
	@JsonIgnore
	public List<Discount> getDiscountList() {
		return discountList;
	}

	public void setDiscountList(List<Discount> discountList) {
		this.discountList = discountList;
	}
	
	
}
