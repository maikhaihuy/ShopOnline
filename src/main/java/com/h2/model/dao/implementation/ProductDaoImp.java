package com.h2.model.dao.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.model.dao.interfaces.AbstractHbnDao;
import com.h2.model.dao.interfaces.BrandDao;
import com.h2.model.dao.interfaces.CategoryDao;
import com.h2.model.dao.interfaces.ColorDao;
import com.h2.model.dao.interfaces.DetailProductDao;
import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.dao.interfaces.SizeDao;
import com.h2.model.pojo.Brand;
import com.h2.model.pojo.Category;
import com.h2.model.pojo.Color;
import com.h2.model.pojo.Product;
import com.h2.model.pojo.Size;
import com.h2.model.pojo.SubProduct;

@Repository ("productDao")
@Transactional
public class ProductDaoImp extends AbstractHbnDao<Product> implements ProductDao {
	@Autowired
	private CategoryDao categoryDao;	
	@Autowired
	private BrandDao brandDao;
	@Autowired
	private ColorDao colorDao;
	@Autowired
	private SizeDao sizeDao;
	@Autowired
	private DetailProductDao detailProductDao;
	
	// Get list of product with times, every time 50 products
	public List<Product> getListProduct(int times) {
		List<Product> listProduct = new ArrayList<Product>();
		String hql = "";
		Query query = null; 
		int n = (times - 1)*50;
        int m = times*50;
		
		try{ 
			hql =  "from Product p ORDER BY p.productName" ;  
			query = getSession().createQuery(hql); 
			if (times > 0){
				query.setFirstResult(n);
				query.setMaxResults(m);
			}
			listProduct = query.list();
		} catch (Exception e) {
			e.printStackTrace();          
			//log.error(e);            
		} 
		
		 return listProduct;
	}
	
	// Get list of products with paging	
	public List<Product> getListProductWithPaging(int pageNumber, int productPerPage) {
		List<Product> listProduct = new ArrayList<Product>();
		String hql = "";
		Query query = null; 
		int n = (pageNumber - 1)*productPerPage;
        int m = productPerPage*pageNumber;
		
		try{ 
			hql =  "from Product p ORDER BY p.productName" ;  
			query = getSession().createQuery(hql); 
			query.setFirstResult(n);
			query.setMaxResults(m);
			listProduct = query.list();
		} catch (Exception e) {
			e.printStackTrace();          
			//log.error(e);            
		} 
		
		 return listProduct;
	}

	// Get list of products by product id
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return get(productId, Product.class);
	}

	// Get list of new product (newProduct = 1)
	public List<Product> getListNewProduct() {
		Query query = null;
        List<Product> listProduct = new ArrayList<Product>();
        String hql = "";      
        
        try{                	
            hql = "FROM Product p WHERE p.productNew = :productNew ORDER BY p.productName";
            query = getSession().createQuery(hql);
            query.setParameter("productNew", 1);
            listProduct =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
        return listProduct;
	}

	// Get list product has discount date > current date
	public List<Product> getListDiscountProduct() {
		Query query = null;
        List<Product> listProduct = new ArrayList<Product>();
        String hql = "";   
        Date date = new Date();
        
        try{                	
            hql = "SELECT DISTINCT d.product FROM Discount d WHERE d.discountEndDate > :currentDate ORDER BY d.product.productName";
            query = getSession().createQuery(hql);
            query.setParameter("currentDate", date);
            listProduct =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
        return listProduct;
	}

	// Get list of products by category and product name
	// with times, every time 50 products
	public List<Product> getListProductByIdCategoryProductName(int categoryId, String productName, int times) {
		Query query = null;
        List<Product> listProduct = new ArrayList<Product>();
        String hql = "";    
        int n = (times - 1)*50;
        int m = times*50;
        
        // Get category by categoryId
        Category category = categoryDao.get(categoryId, Category.class);
        
        try{                	
            hql = "FROM Product p WHERE p.productName LIKE :productName AND p.category = :category ORDER BY p.productName ";         
            query = getSession().createQuery(hql);   
            query.setString("productName", "%"+productName+"%");
            query.setParameter("category", category);
            if (times > 0){
	            query.setFirstResult(n);
				query.setMaxResults(m);
            }
            listProduct =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
        return listProduct;
	}

	
	// Get list of product by category
	// with times, every time 50 products
	public List<Product> getListProductByIdCategory(int categoryId, int times) {
		Query query = null;
        List<Product> listProduct = new ArrayList<Product>();
        String hql = "";    
        int n = (times - 1)*50;
        int m = times*50;
        // Get category by categoryId
        Category category = categoryDao.get(categoryId, Category.class);
        
        try{                	
            hql = "FROM Product p WHERE  p.category = :category ORDER BY  p.productName ";         
            query = getSession().createQuery(hql);              
            query.setParameter("category", category);
            if (times > 0){
	            query.setFirstResult(n);
				query.setMaxResults(m);
            }
            listProduct =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
        return listProduct;
	}
	
	
	// Get list of product by category
	// with times, every time 50 products
	public List<Product> getListProductByIdBrand(int brandId, int times) {
		Query query = null;
        List<Product> listProduct = new ArrayList<Product>();
        String hql = "";    
        int n = (times - 1)*50;
        int m = times*50;
        // Get brand by brandId
        Brand brand = brandDao.get(brandId, Brand.class);
        
        try{                	
            hql = "FROM Product p WHERE  p.brand = :brand ORDER BY  p.productName ";         
            query = getSession().createQuery(hql);              
            query.setParameter("brand", brand);
            if (times > 0){
	            query.setFirstResult(n);
				query.setMaxResults(m);
            }
            listProduct =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
        return listProduct;
	}
		
	// Search product by category, brand, color, size, price, name 
	//with times, every time 50 products
	public List<Product> searchProductByCategoryBrandColorSizePriceName(
			int categoryId, int brandId, int colorId, int sizeId,
			float fromPrice, float toPrice, String productName, int times) {
		Query query = null;
        List<Product> listProduct = new ArrayList<Product>();
        String hql = "";    
        int n = (times - 1)*50;
        int m = times*50;
        
        // Get category by categoryId
        Category category = categoryDao.get(categoryId, Category.class);       
        // Get brand by brandId
        Brand brand = brandDao.get(brandId, Brand.class);
        // Get color by colorId
        Color color = colorDao.get(colorId, Color.class);
        // Get size by sizeId
        Size size = sizeDao.get(sizeId, Size.class);
        
        
        try{                	
            //hql = "FROM Product p WHERE p.productName LIKE :productName ";
            hql = "SELECT DISTINCT d.product FROM DetailProduct d WHERE d.product.productName LIKE :productName";
            if (category != null){
            	hql = hql + " AND d.product.category = :category "; 
            }           
            if (brand != null){
            	hql = hql + " AND d.product.brand = :brand "; 
            }           
            if (color != null){
            	hql = hql + " AND d.color = :color "; 
            }
            if (size != null){
            	hql = hql + " AND d.size = :size "; 
            }
            
            hql = hql +" AND d.product.productPrice >= :fromPrice "; 
            if (toPrice > 0){
            	 hql = hql + " AND d.product.productPrice <= :toPrice ";
            }

            hql +=  " ORDER BY  d.product.productName " ; 
            
            
            query = getSession().createQuery(hql);   
            query.setString("productName", "%"+productName+"%");
            
            if (category != null){
            	query.setParameter("category", category);
            }           
            if (brand != null){
            	query.setParameter("brand", brand);
            }           
            if (color != null){
            	query.setParameter("color", color);
            }
            if (size != null){
            	query.setParameter("size", size);
            }
            
            query.setParameter("fromPrice", fromPrice);
            if (toPrice > 0){
            	query.setParameter("toPrice", toPrice);
            }
            
            if (times > 0){
	            query.setFirstResult(n);
				query.setMaxResults(m);
            }
            listProduct =  query.list();
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
        return listProduct;
	}

	
	// count price of product = productPrice + Tax*productPrice
	public float countPriceOfProductByProductId(int productId){
		float price = 0;	
		
		Product product = getProductById(productId);
		price = product.getProductPrice();
		// Get tax value
		int taxValue = product.getCategory().getTax().getTaxValue();
		price = price + price*taxValue/100;
		
		return price;
	}

	
	// Get information of product
	public SubProduct getInfoOfProductByProductId(int productId) {
		SubProduct subProduct = new SubProduct();
		Category category = new Category();
		Brand brand = new Brand();
		String hql = "";
		Query query = null; 
		// Get product and category and brand
		try{                	
			hql = "select p.category, p.brand from  Product p  WHERE p.productId = :productId ";
            query = getSession().createQuery(hql);
            query.setParameter("productId", productId);
            List<Object[]> ds = query.list();
            if (ds.size() == 1){
            	Object[] obj = ds.get(0);
            	category = (Category) obj[0];
            	brand = (Brand)obj[1];
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		List<Color> listColorOfProduct = colorDao.getListColorOfProduct(productId);
		List<Size> listSizeOfProduct = sizeDao.getListSizeOfProduct(productId);
		subProduct.setListColor(listColorOfProduct);
		subProduct.setListSize(listSizeOfProduct);
		subProduct.setCategory(category);
		subProduct.setBrand(brand);
		return subProduct;
	}

	// Get product by detail product id
	public Product getProductByDetailProductId(int detailProductId) {
		Product product = new Product();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.product from DetailProduct p  WHERE p.detailProductId = :detailProductId ";
            query = getSession().createQuery(hql);
            query.setParameter("detailProductId", detailProductId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	product = (Product) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return product;
	}

	// Get product by discount id
	public Product getProductByDiscountId(int discountId) {
		Product product = new Product();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.product from Discount p  WHERE p.discountId = :discountId ";
            query = getSession().createQuery(hql);
            query.setParameter("discountId", discountId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	product = (Product) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return product;
	}

	public Product getProductByDiscountInfoId(int discountInfoId) {
		Product product = new Product();
		String hql = "";
		Query query = null; 
		try{                	
			hql = "select p.product from DiscountInfo p  WHERE p.discountInfoId = :discountInfoId ";
            query = getSession().createQuery(hql);
            query.setParameter("discountInfoId", discountInfoId);
            List<Object> ds = query.list();
            if (ds.size() == 1){
            	Object obj = ds.get(0);
            	product = (Product) obj;           	
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error(e);          
        } 
		
		return product;
	}
}
