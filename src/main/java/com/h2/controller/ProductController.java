package com.h2.controller;

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

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value="/category/{idCate}/name/{namePro}/session/{session}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Product>> GetProducts(@PathVariable("idCate") int idCate, 
			@PathVariable("namePro") String namePro,@PathVariable("session") int session){
		List<Product> listProduct = productDao.getListProductByIdCategoryProductName(idCate, namePro, session);
		return new ResponseEntity<List<Product>>(listProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value="/newproducts",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Product>> GetNewProducts(){
		//ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans-service.xml");
		//ProductDao instance = (ProductDao)appCtx.getBean("productDao");
		//this.productDao = instance;
		List<Product> listNewProduct = productDao.getListNewProduct();
		return new ResponseEntity<List<Product>>(listNewProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value="/discountproducts",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Product>> GetDiscountProducts(){
		List<Product> listDiscountProduct = productDao.getListDiscountProduct();
		return new ResponseEntity<List<Product>>(listDiscountProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{idProduct}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Product> GetProduct(@PathVariable("idProduct") int idProduct){
		Product product = productDao.getProductById(idProduct);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllProduct/session/{session}",
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Product>> GetAllProduct(@PathVariable("session") int session){
		List<Product> listProduct = productDao.getListProduct(session);
		return new ResponseEntity<List<Product>>(listProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value="/brand/{idBrand}/session/{session}",
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Product>> GetProductByBrand(@PathVariable("idBrand") int idBrand, @PathVariable("session") int session){
		List<Product> listProduct = productDao.getListProductByIdBrand(idBrand, session);
		return new ResponseEntity<List<Product>>(listProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value="/category/{idCategory}/session/{session}",
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Product>> GetProductByCategory(@PathVariable("idCategory") int idCategory, @PathVariable("session") int session){
		List<Product> listProduct = productDao.getListProductByIdCategory(idCategory, session);
		return new ResponseEntity<List<Product>>(listProduct, HttpStatus.OK);
	}
}
