/**
 * 
 */
package com.h2.model.pojo;

import java.io.Serializable;

/**
 * @author AnhHong
 *
 */
public class CartItem implements Serializable{
	private DetailProduct detailProduct;
	private Product product;
	private int orderQuantity;
	
	public CartItem(){};
	
	public CartItem(DetailProduct detailProduct, int orderQuantity){
		this.detailProduct = detailProduct;
		this.orderQuantity = orderQuantity;
	}

	public DetailProduct getDetailProduct() {
		return detailProduct;
	}

	public void setDetailProduct(DetailProduct detailProduct) {
		this.detailProduct = detailProduct;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	
	
}
