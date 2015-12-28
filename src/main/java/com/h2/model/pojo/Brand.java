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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "brand", catalog = "shoedb",uniqueConstraints = {@UniqueConstraint(columnNames = "brandName")})
public class Brand implements Serializable{
	private int brandId;
	private String brandName;
	private int isDeleted;
	private List<Product> productList = new ArrayList<Product>(0);
	
	public Brand(){}
	
	public Brand(int brandId, String brandName, List<Product> productList){
		this.brandId = brandId;
		this.brandName = brandName;
		this.productList = productList;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "brandId", unique = true, nullable = false)
	public int getBrandId() {
		return this.brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}	
	
	@Column(name = "brandName", nullable = false)
	public String getBrandName(){
		return this.brandName;
	}
	
	public void setBrandName(String brandName){
		this.brandName = brandName;
	}
	
	
	@Column(name = "isDeleted", nullable = false)
	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
	@JsonIgnore
	public List<Product> getProductList() {
		return this.productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}