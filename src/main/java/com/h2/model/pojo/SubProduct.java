package com.h2.model.pojo;

import java.util.List;

public class SubProduct {
	private List<Size> listSize;
	private List<Color> listColor;
	private Category category;
	private Brand brand;
	private Product product;
	private List<String> listImages;
	private DiscountInfo discountInfo;
	
	public SubProduct(){}

	public SubProduct(List<Size> listSize, List<Color> listColor,
			Category category, Brand brand) {
		super();
		this.listSize = listSize;
		this.listColor = listColor;
		this.category = category;
		this.brand = brand;
	}

	public List<Size> getListSize() {
		return listSize;
	}

	public void setListSize(List<Size> listSize) {
		this.listSize = listSize;
	}

	public List<Color> getListColor() {
		return listColor;
	}

	public void setListColor(List<Color> listColor) {
		this.listColor = listColor;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<String> getListImages() {
		return listImages;
	}

	public void setListImages(List<String> listImages) {
		this.listImages = listImages;
	}

	public DiscountInfo getDiscountInfo() {
		return discountInfo;
	}

	public void setDiscountInfo(DiscountInfo discountInfo) {
		this.discountInfo = discountInfo;
	}
	
	
}
