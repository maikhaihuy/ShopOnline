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
@Table(name = "tax", catalog="shoedb")
public class Tax implements Serializable{
	private int taxId;
	private int taxValue;
	private List<Category> categoryList = new ArrayList<Category>(0);
	
	public Tax(){}

	public Tax(int taxId, int taxValue, List<Category> categoryList) {
		super();
		this.taxId = taxId;
		this.taxValue = taxValue;
		this.categoryList = categoryList;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "taxId", unique = true, nullable = false)
	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	@Column(name = "taxValue",  nullable = false)
	public int getTaxValue() {
		return taxValue;
	}

	public void setTaxValue(int taxValue) {
		this.taxValue = taxValue;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tax")
	@JsonIgnore
	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
	
}
