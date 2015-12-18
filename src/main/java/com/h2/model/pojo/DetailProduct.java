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
@Table(name = "detailproduct", catalog="shoedb")
public class DetailProduct implements Serializable{
	private int detailProductId;
	private int detailProductQuantity;
	private Product product;
	private Color color;
	private Size size;
	private int isDeleted;
	private List<DetailOrder> detailOrderList = new ArrayList<DetailOrder>(0);
	
	public DetailProduct(){}

	public DetailProduct(int detailProductId, int detailProductQuantity,
			Product product, Color color, Size size, int isDeleted,
			List<DetailOrder> detailOrderList) {
		super();
		this.detailProductId = detailProductId;
		this.detailProductQuantity = detailProductQuantity;
		this.product = product;
		this.color = color;
		this.size = size;
		this.isDeleted = isDeleted;
		this.detailOrderList = detailOrderList;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "detailProductId", unique = true, nullable = false)
	public int getDetailProductId() {
		return detailProductId;
	}

	public void setDetailProductId(int detailProductId) {
		this.detailProductId = detailProductId;
	}

	@Column(name = "detailProductQuantity", nullable = false)
	public int getDetailProductQuantity() {
		return detailProductQuantity;
	}

	public void setDetailProductQuantity(int detailProductQuantity) {
		this.detailProductQuantity = detailProductQuantity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId", nullable = false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "colorId", nullable = false)
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sizeId", nullable = false)
	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Column(name = "isDeleted", nullable = false)
	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "detailproduct")
	public List<DetailOrder> getDetailOrderList() {
		return detailOrderList;
	}

	public void setDetailOrderList(List<DetailOrder> detailOrderList) {
		this.detailOrderList = detailOrderList;
	}
	
	
}
