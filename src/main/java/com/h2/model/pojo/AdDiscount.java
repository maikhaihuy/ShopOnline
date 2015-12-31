package com.h2.model.pojo;

public class AdDiscount {
	private Discount discount;
	private DiscountInfo discountInfo;
	private Product product;
	private Product discountProduct;
	
	public AdDiscount(){}

	public AdDiscount(Discount discount, DiscountInfo discountInfo,
			Product product, Product discountProduct) {
		super();
		this.discount = discount;
		this.discountInfo = discountInfo;
		this.product = product;
		this.discountProduct = discountProduct;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public DiscountInfo getDiscountInfo() {
		return discountInfo;
	}

	public void setDiscountInfo(DiscountInfo discountInfo) {
		this.discountInfo = discountInfo;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getDiscountProduct() {
		return discountProduct;
	}

	public void setDiscountProduct(Product discountProduct) {
		this.discountProduct = discountProduct;
	}
	
	
}
