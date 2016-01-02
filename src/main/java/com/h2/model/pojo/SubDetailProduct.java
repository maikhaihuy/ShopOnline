package com.h2.model.pojo;

public class SubDetailProduct {
	private float productPrice;
	private int quantity;
	private int orderId;
	private int detailProductId;
	private int productId;
	private int sizeId;
	private int colorId;
	
	public SubDetailProduct(){}
	public SubDetailProduct(float productPrice, int quantity, int orderId, int productId, int colorId, int sizeId){
		this.productPrice =productPrice;
		this.setQuantity(quantity);
		this.orderId = orderId;
		this.productId = productId;
		this.colorId = colorId;
		this.sizeId = sizeId;
	}
	public int getDetailProductId() {
		return detailProductId;
	}
	public void setDetailProductId(int detailProductId) {
		this.detailProductId = detailProductId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
}
