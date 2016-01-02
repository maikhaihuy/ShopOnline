package com.h2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.pojo.Product;
import com.h2.model.pojo.SubProduct;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value="/category/{idCate}/name/{namePro}/session/{session}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<SubProduct>> GetProducts(@PathVariable("idCate") int idCate, 
			@PathVariable("namePro") String namePro,@PathVariable("session") int session){
		List<SubProduct> listSubProduct = null;
		List<Product> listProduct = productDao.getListProductByIdCategoryProductName(idCate, namePro, session);
		
		listSubProduct = initSubProduct(listProduct);
		
		return new ResponseEntity<List<SubProduct>>(listSubProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value="/newproducts",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<SubProduct>> GetNewProducts(){
		List<SubProduct> listSubProduct = null;
		List<Product> listNewProduct = productDao.getListNewProduct();
		
		listSubProduct = initSubProduct(listNewProduct);
		
		return new ResponseEntity<List<SubProduct>>(listSubProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value="/discountproducts",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<SubProduct>> GetDiscountProducts(){
		List<SubProduct> listSubProduct = null;
		List<Product> listDiscountProduct = productDao.getListDiscountProduct();
		
		listSubProduct = initSubProduct(listDiscountProduct);
		
		return new ResponseEntity<List<SubProduct>>(listSubProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{idProduct}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<SubProduct> GetProduct(@PathVariable("idProduct") int idProduct){
		SubProduct subProduct = null;
		Product product = productDao.getProductById(idProduct);
		
		List<String> listImages = new ArrayList<String>();
		for (String str : product.getProductLargeImage().split(";"))
			listImages.add(str);
		
		subProduct= productDao.getInfoOfProductByProductId(product.getProductId());
		subProduct.setProduct(product);
		subProduct.setListImages(listImages);
		
		// FIx bug: Discount
		if (subProduct.getDiscountInfo() != null && subProduct.getDiscountInfo().getDiscountPercentValue() != 0) {
			float p = subProduct.getProduct().getProductPrice();
			subProduct.getProduct().setProductPrice( p * (100 - subProduct.getDiscountInfo().getDiscountPercentValue())/100);
		}
		
		return new ResponseEntity<SubProduct>(subProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllProduct/session/{session}",
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<SubProduct>> GetAllProduct(@PathVariable("session") int session){
		List<SubProduct> listSubProduct = null;
		List<Product> listProduct = productDao.getListProduct(session);
		
		listSubProduct = initSubProduct(listProduct);
		
		return new ResponseEntity<List<SubProduct>>(listSubProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value="/brand/{idBrand}/session/{session}",
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<SubProduct>> GetProductByBrand(@PathVariable("idBrand") int idBrand, @PathVariable("session") int session){
		List<SubProduct> listSubProduct = null;
		List<Product> listProduct = productDao.getListProductByIdBrand(idBrand, session);
		
		listSubProduct = initSubProduct(listProduct);
		
		return new ResponseEntity<List<SubProduct>>(listSubProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value="/category/{idCategory}/session/{session}",
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<SubProduct>> GetProductByCategory(@PathVariable("idCategory") int idCategory, @PathVariable("session") int session){
		List<SubProduct> listSubProduct = null;
		List<Product> listProduct = productDao.getListProductByIdCategory(idCategory, session);
		
		listSubProduct = initSubProduct(listProduct);
		
		return new ResponseEntity<List<SubProduct>>(listSubProduct, HttpStatus.OK);
	}
	
	// Support get Subproduct
	private List<SubProduct> initSubProduct(List<Product> listProduct) {
		List<SubProduct> listSubProduct = new ArrayList<SubProduct>();
		
		for (Product product : listProduct) {
			SubProduct subProduct = productDao.getInfoOfProductByProductId(product.getProductId());
			subProduct.setProduct(product);
			
			// FIx bug: Discount
			if (subProduct.getDiscountInfo() != null && subProduct.getDiscountInfo().getDiscountPercentValue() != 0) {
				float p = subProduct.getProduct().getProductPrice();
				subProduct.getProduct().setProductPrice( p * (100 - subProduct.getDiscountInfo().getDiscountPercentValue())/100);
			}
			
			listSubProduct.add(subProduct);
		}
		return listSubProduct;
	}
}
