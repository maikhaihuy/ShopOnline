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
@Table(name = "product", catalog="shoedb")
public class Product implements Serializable{
	private int productId;
	private String productName;
	private float productPrice;
	private String productImage;
	private String productLargeImage;
	private String productDescribe;
	private int productNew;
	private int productView;
	private int productGender;
	private Category category;
	private Brand brand;
	private int isDeleted;
	private String productCode;
	private List<DetailProduct> detailProductList = new ArrayList<DetailProduct>(0);
	private List<DiscountInfo> discountInfoList = new ArrayList<DiscountInfo>(0);
	private List<Discount> discountList = new ArrayList<Discount>(0);
	
	public Product(){}

	public Product(int productId, String productName, float productPrice,
			String productImage, String productLargeImage,
			String productDescribe, int productNew, int productView,
			int productGender, Category category, Brand brand, int isDeleted,
			String productCode, List<DetailProduct> detailProductList,
			List<DiscountInfo> discountInfoList, List<Discount> discountList) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.productLargeImage = productLargeImage;
		this.productDescribe = productDescribe;
		this.productNew = productNew;
		this.productView = productView;
		this.productGender = productGender;
		this.category = category;
		this.brand = brand;
		this.isDeleted = isDeleted;
		this.productCode = productCode;
		this.detailProductList = detailProductList;
		this.discountInfoList = discountInfoList;
		this.discountList = discountList;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "productId", unique = true, nullable = false)
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name = "productName", nullable = false)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "productPrice", nullable = false)
	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	@Column(name = "productImage", nullable = false)
	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	@Column(name = "productLargeImage", nullable = false)
	public String getProductLargeImage() {
		return productLargeImage;
	}

	public void setProductLargeImage(String productLargeImage) {
		this.productLargeImage = productLargeImage;
	}

	@Column(name = "productDescribe", nullable = false)
	public String getProductDescribe() {
		return productDescribe;
	}

	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}

	@Column(name = "productNew", nullable = false)
	public int getProductNew() {
		return productNew;
	}

	public void setProductNew(int productNew) {
		this.productNew = productNew;
	}

	@Column(name = "productView", nullable = false)
	public int getProductView() {
		return productView;
	}

	public void setProductView(int productView) {
		this.productView = productView;
	}

	@Column(name = "productGender", nullable = false)
	public int getProductGender() {
		return productGender;
	}

	public void setProductGender(int productGender) {
		this.productGender = productGender;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId", nullable = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brandId", nullable = false)
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Column(name = "isDeleted", nullable = false)
	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "productCode", nullable = false)
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public List<DetailProduct> getDetailProductList() {
		return detailProductList;
	}

	public void setDetailProductList(List<DetailProduct> detailProductList) {
		this.detailProductList = detailProductList;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public List<DiscountInfo> getDiscountInfoList() {
		return discountInfoList;
	}

	public void setDiscountInfoList(List<DiscountInfo> discountInfoList) {
		this.discountInfoList = discountInfoList;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public List<Discount> getDiscountList() {
		return discountList;
	}

	public void setDiscountList(List<Discount> discountList) {
		this.discountList = discountList;
	}
	
	
}
