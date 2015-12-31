package com.h2.model.pojo;

public class AdDetailOrder {
	private int detailOrderId;
	private float detailOrderPrice;
	private int detailOrderQuantity;
	private String productName;
	private String sizeName;
	private String colorName;
	private float tax;
	private float sum;
	
	
	public AdDetailOrder(){}


	public AdDetailOrder(int detailOrderId, float detailOrderPrice,
			int detailOrderQuantity, String productName, String sizeName,
			String colorName, float tax, float sum) {
		super();
		this.detailOrderId = detailOrderId;
		this.detailOrderPrice = detailOrderPrice;
		this.detailOrderQuantity = detailOrderQuantity;
		this.productName = productName;
		this.sizeName = sizeName;
		this.colorName = colorName;
		this.tax = tax;
		this.sum = sum;
	}


	public int getDetailOrderId() {
		return detailOrderId;
	}


	public void setDetailOrderId(int detailOrderId) {
		this.detailOrderId = detailOrderId;
	}


	public float getDetailOrderPrice() {
		return detailOrderPrice;
	}


	public void setDetailOrderPrice(float detailOrderPrice) {
		this.detailOrderPrice = detailOrderPrice;
	}


	public int getDetailOrderQuantity() {
		return detailOrderQuantity;
	}


	public void setDetailOrderQuantity(int detailOrderQuantity) {
		this.detailOrderQuantity = detailOrderQuantity;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getSizeName() {
		return sizeName;
	}


	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}


	public String getColorName() {
		return colorName;
	}


	public void setColorName(String colorName) {
		this.colorName = colorName;
	}


	public float getTax() {
		return tax;
	}


	public void setTax(float tax) {
		this.tax = tax;
	}


	public float getSum() {
		return sum;
	}


	public void setSum(float sum) {
		this.sum = sum;
	}

	
}
