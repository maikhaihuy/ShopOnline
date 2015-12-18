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


@Entity
@Table(name = "color", catalog="shoedb", uniqueConstraints = {@UniqueConstraint(columnNames = "colorName")})
public class Color implements Serializable{
	private int colorId;
	private String colorName;
	private List<DetailProduct> detailProductList = new ArrayList<DetailProduct>(0);
	
	public Color(){}
	
	public Color(int colorId, String colorName,
			List<DetailProduct> detailProductList) {
		super();
		this.colorId = colorId;
		this.colorName = colorName;
		this.detailProductList = detailProductList;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "colorId", unique = true, nullable = false)
	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	@Column(name = "colorName", nullable = false)
	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "color")
	public List<DetailProduct> getDetailProductList() {
		return detailProductList;
	}

	public void setDetailProductList(List<DetailProduct> detailProductList) {
		this.detailProductList = detailProductList;
	}
	
	
	
	

}
