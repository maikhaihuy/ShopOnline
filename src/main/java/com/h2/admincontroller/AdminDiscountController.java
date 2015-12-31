package com.h2.admincontroller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.h2.model.dao.interfaces.DiscountDao;
import com.h2.model.dao.interfaces.DiscountInfoDao;
import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.pojo.AdDiscount;
import com.h2.model.pojo.Discount;
import com.h2.model.pojo.DiscountInfo;
import com.h2.model.pojo.Product;

@Controller
@RequestMapping(value={"/discount"})
public class AdminDiscountController {
	@Autowired
	private DiscountDao discountDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private DiscountInfoDao discountInfoDao;
	
	@RequestMapping(value={"/list.do"}, method = RequestMethod.GET)
	public String getListDiscount(Model model){
		List<Discount> listDiscount = new ArrayList<Discount>();
		listDiscount = discountDao.getListDiscount();
		List<AdDiscount> listAdDiscount = new ArrayList<AdDiscount>();
		if (listDiscount != null){
			for (int i = 0; i < listDiscount.size(); i++){
				AdDiscount ad = new AdDiscount();
				ad = convertDiscount(listDiscount.get(i));
				listAdDiscount.add(ad);
			}
		}
		model.addAttribute("listAdDiscount", listAdDiscount);
		return "IndexDiscount";
	}
	
	private AdDiscount convertDiscount(Discount discount) {
		AdDiscount ad = new AdDiscount();
		ad.setDiscount(discount);
		// Get discount if
		DiscountInfo discountInfo = discountInfoDao.getDiscountInfoByDiscountId(discount.getDiscountId());
		ad.setDiscountInfo(discountInfo);;
		// Get product
		Product product = productDao.getProductByDiscountId(discount.getDiscountId());
		ad.setProduct(product);
		// Get discoutn product
		Product discountProduct = productDao.getProductByDiscountInfoId(discountInfo.getDiscountInfoId());
		ad.setDiscountProduct(discountProduct);
		return ad;
	}

	@RequestMapping(value={"/viewAdd.do"}, method = RequestMethod.GET)
	public String loadAddPage(Model model){
		List<Product> listProduct = new ArrayList<Product>();
		listProduct = productDao.getAll(Product.class.getName());
		model.addAttribute("listProduct", listProduct);
		return "AddDiscount";
	}
	
	@RequestMapping(value={"/add.do"}, method = RequestMethod.GET)
	public String addDiscount(Model model, @RequestParam("productId") Integer productId, 
			@RequestParam("productDiscountValue") Integer productDiscountValue,
			@RequestParam("productDiscountId") Integer productDiscountId,
			@RequestParam("startDate") Date startDate,
			@RequestParam("endDate") Date endDate){
		// Get product
		Product product = new Product();
		product = productDao.getProductById(productId);
		// Get discount product
		Product discountProduct = new Product();
		if (productDiscountId == 0){
			discountProduct = null;
		}else
			discountProduct = productDao.getProductById(productDiscountId);
		// Save discount info
		DiscountInfo discountInfo = new DiscountInfo();
		discountInfo.setDiscountPercentValue(productDiscountValue);
		discountInfo.setDiscountRate(1);
		discountInfo.setProduct(discountProduct);
		discountInfo = discountInfoDao.save(discountInfo);
		// Save discount
		Discount discount = new Discount();
		discount.setProduct(product);
		discount.setDiscountStartDate(startDate);
		discount.setDiscountEndDate(endDate);
		discount.setDiscountInfo(discountInfo);
		discountDao.save(discount);
		
		return "redirect:list.do";
	}
	
	@RequestMapping(value={"/update.do"}, method = RequestMethod.GET)
	public String updateDiscount( Model model, HttpServletRequest request,
			@RequestParam("productDiscountValue") Integer productDiscountValue,
			@RequestParam("startDate") Date startDate,
			@RequestParam("endDate") Date endDate,
			@RequestParam("discountId") Integer discountId,
			@RequestParam("discountInfoId") Integer discountInfoId){
		// Get product
		Product product = new Product();
		product = productDao.getProductByDiscountId(discountId);
		// Get discount product
		Product discountProduct = new Product();
		discountProduct = productDao.getProductByDiscountInfoId(discountInfoId);
		
		// update discount info
		DiscountInfo discountInfo = new DiscountInfo();
		discountInfo = discountInfoDao.get(discountInfoId, DiscountInfo.class);
		discountInfo.setDiscountPercentValue(productDiscountValue);
		discountInfo.setDiscountRate(1);
		discountInfo.setProduct(discountProduct);
		discountInfoDao.update(discountInfo);
				
				
		// update discount 
		Discount discount = new Discount();
		discount = discountDao.get(discountId, Discount.class);
		discount.setProduct(product);
		discount.setDiscountStartDate(startDate);
		discount.setDiscountEndDate(endDate);
		discount.setDiscountInfo(discountInfo);
		discountDao.update(discount);
		
		
		return "redirect:list.do";
	}
	
}
