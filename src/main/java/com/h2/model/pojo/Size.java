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
@Table(name = "size", catalog = "shoedb",uniqueConstraints = {@UniqueConstraint(columnNames = "sizeName")})
public class Size implements Serializable{
	private int sizeId;
	private String sizeName;
	private List<DetailProduct> detailProductList = new ArrayList<DetailProduct>(0);
	
	public Size(){}

	public Size(int sizeId, String sizeName,
			List<DetailProduct> detailProductList) {
		super();
		this.sizeId = sizeId;
		this.sizeName = sizeName;
		this.detailProductList = detailProductList;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sizeId", unique = true, nullable = false)
	public int getSizeId() {
		return sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	@Column(name = "sizeName", nullable = false)
	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "size")
	@JsonIgnore
	public List<DetailProduct> getDetailProductList() {
		return detailProductList;
	}

	public void setDetailProductList(List<DetailProduct> detailProductList) {
		this.detailProductList = detailProductList;
	}
	
	
}
