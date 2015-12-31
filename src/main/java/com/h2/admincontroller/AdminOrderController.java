package com.h2.admincontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.h2.model.dao.interfaces.ColorDao;
import com.h2.model.dao.interfaces.DetailOrderDao;
import com.h2.model.dao.interfaces.DetailProductDao;
import com.h2.model.dao.interfaces.OrderDao;
import com.h2.model.dao.interfaces.OrderStatusDao;
import com.h2.model.dao.interfaces.ProductDao;
import com.h2.model.dao.interfaces.SizeDao;
import com.h2.model.pojo.AdDetailOrder;
import com.h2.model.pojo.AdOrder;
import com.h2.model.pojo.Color;
import com.h2.model.pojo.DetailOrder;
import com.h2.model.pojo.DetailProduct;
import com.h2.model.pojo.Order;
import com.h2.model.pojo.OrderStatus;
import com.h2.model.pojo.Product;
import com.h2.model.pojo.Size;

@Controller
@RequestMapping(value={"/order"})
public class AdminOrderController {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderStatusDao orderStatusDao;
	@Autowired
	private DetailOrderDao detailOrderDao;
	@Autowired
	private DetailProductDao detailProductDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ColorDao colorDao;
	@Autowired
	private SizeDao sizeDao;
	
	
	@RequestMapping(value={"/list.do"}, method = RequestMethod.GET)
	public String getListOrderByAdmin(Model model, @RequestParam("id") Integer id, @RequestParam("page") Integer page, @RequestParam("numPerPage") Integer numPerPage){
		List<Order> listOrder = new ArrayList<Order>();
		listOrder = orderDao.getListOrderByStatusIdPaging(id, page, numPerPage);
		List<OrderStatus> listOrderStatus = new ArrayList<OrderStatus>();
		listOrderStatus = orderStatusDao.getAll(OrderStatus.class.getName());
		List<AdOrder> listAdOrder = new ArrayList<AdOrder>();
		if (listOrder != null){
			for (int i = 0; i < listOrder.size(); i++){
				AdOrder ao = convertOrder(listOrder.get(i));
				listAdOrder.add(ao);
			}
		}
		model.addAttribute("listAdOrder", listAdOrder);
		model.addAttribute("orderStatusId", id);
		model.addAttribute("page", page);		
		model.addAttribute("numPerPage", numPerPage);
		model.addAttribute("listOrderStatus", listOrderStatus);
		
		// list order
		List<Order> list = new ArrayList<Order>();
		listOrder = orderDao.getListOrderByStatusId(id);
		int numPage = 0;
		if (listOrder != null){
			numPage = Math.round(listOrder.size()/numPerPage);
		}
		model.addAttribute("numPage", numPage);
		return "IndexOrder";
	}
	
	@RequestMapping(value={"/update.do"}, method = RequestMethod.GET)
	public String updateStatusOfOrder(Model model, @RequestParam("id") Integer id, @RequestParam("page") Integer page, 
			@RequestParam("numPerPage") Integer numPerPage, @RequestParam("orderId") Integer orderId, @RequestParam("status") Integer status){
		orderDao.updateStatusOfOrder(orderId, status);
		return getListOrderByAdmin(model, id, page, numPerPage);
	}
	
	@RequestMapping(value={"/detail.do"}, method = RequestMethod.GET)
	public String doPage7(@RequestParam("id") Integer id, Model model){
		// Get order
		Order order = new Order();
		order = orderDao.getOrderById(id);
		AdOrder adOrder = convertOrder(order);
		model.addAttribute("adOrder", adOrder);
		
		// Get list product and info of order
		List<DetailOrder> listDetailOrder = new ArrayList<DetailOrder>();
		listDetailOrder = detailOrderDao.getListDetailOrderByOrderId(id);
		List<AdDetailOrder> listAdDetailOrder = new ArrayList<AdDetailOrder>();
		if (listDetailOrder != null){
			for (int i = 0; i < listDetailOrder.size(); i++){
				AdDetailOrder ao = convertDetailOrder(listDetailOrder.get(i));
				listAdDetailOrder.add(ao);
			}
		}
		model.addAttribute("listAdDetailOrder", listAdDetailOrder);
		return "DetailOrder";
	}
	
	private AdOrder convertOrder(Order order){
		AdOrder adOrder = new AdOrder();
		adOrder.setOrder(order);		
		OrderStatus statusOfOrder = orderStatusDao.getOrderStatusByOrderId(order.getOrderId());
		adOrder.setOrderStatusId(statusOfOrder.getOrderStatusId());
		adOrder.setOrderStatusName(statusOfOrder.getOrderStatusName());
		return adOrder;
	}
	
	private AdDetailOrder convertDetailOrder(DetailOrder detailOrder){
		AdDetailOrder adDetailOrder = new AdDetailOrder();
		adDetailOrder.setDetailOrderId(detailOrder.getDetailOrderId());
		adDetailOrder.setDetailOrderPrice(detailOrder.getDetailOrderPrice());
		adDetailOrder.setDetailOrderQuantity(detailOrder.getDetailOrderQuantity());
		
		// Get detail product in detail order
		DetailProduct dp = new DetailProduct();
		dp = detailProductDao.getDetailProductByDetailOrderId(detailOrder.getDetailOrderId());
		// Get color name
		Color color = new Color();
		color = colorDao.getColorByDetailProductId(dp.getDetailProductId());
		adDetailOrder.setColorName(color.getColorName());
		// Get size name
		Size size = new Size();
		size = sizeDao.getSizeByDetailProductId(dp.getDetailProductId());
		adDetailOrder.setSizeName(size.getSizeName());
		// Get  product in detail product
		Product product = new Product();
		product = productDao.getProductByDetailProductId(dp.getDetailProductId());
		adDetailOrder.setProductName(product.getProductName());
		// Get tax of product
		float tax = 0;
		if (detailOrder.getDetailOrderPrice() != 0){
			float lastPrice = productDao.countPriceOfProductByProductId(product.getProductId());
			tax = (lastPrice - product.getProductPrice()) *detailOrder.getDetailOrderQuantity();
		}
		
		adDetailOrder.setTax(tax);
		// Counting sum
		float sum = 0;
		sum = detailOrder.getDetailOrderPrice()*detailOrder.getDetailOrderQuantity() + tax;
		adDetailOrder.setSum(sum);
		return adDetailOrder;
	}
	
	
}
