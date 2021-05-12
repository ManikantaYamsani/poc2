package com.ojas.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ojas.dao.orderdao;
import com.ojas.dao.productdao;
import com.ojas.model.Order;
import com.ojas.model.Product;

@Service
public class ProductAndOrderService {
	
	@Autowired
	private productdao productrepo;
	
	@Autowired
	private orderdao orderdao;
	
	public Product createProduct(Product product) {
		return productrepo.save(product);
	}

	
	public Order createOrder(Order order) {
		return orderdao.save(order);
		
	}
	public Iterable<Product> getAllProduct() {
		return productrepo.findAll();
	}
	
	public Iterable<Order> getAllOrder() {
		return orderdao.findAll();
		
	}
	
	public Optional<Product> getProductById(Integer productid){
		return productrepo.findById(productid);
	}
	public Optional<Order> getOrderId(Integer orderid) {
		return orderdao.findById(orderid);
	}
	
	public int placeOrder(int productId, int quantity, Order order) {
		int result = 1;
		Product product = productrepo.findById(productId).orElse(new Product());
		if(product == null)
			return result;
		order.setQuantity(quantity);
		
		order.setProducts(product);
		orderdao.save(order);
		result = 0;
		return result;
		
	}
	
	public int updateOrder(Integer id, Integer quantity) {
		int result = 1;
		Order order = orderdao.findById(id).orElse(new Order());
		if(order.getOrderId() == 0) {
			return result;
		}
		
		order.setQuantity(quantity);
		orderdao.save(order); 
		result = 0;
		
		return result;
	}
	}

