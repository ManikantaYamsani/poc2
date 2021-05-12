package com.ojas.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ojas.model.Message;
import com.ojas.model.Order;
import com.ojas.model.Product;
import com.ojas.service.ProductAndOrderService;


@RestController
@RequestMapping("/rest")
public class ProductAndOrderController {

	@Autowired

	private ProductAndOrderService service;

	@PostMapping("/product/create")
	public Product creaeProduct(@RequestBody Product product) {
		return service.createProduct(product);

	}

	@GetMapping("/product/list")
	public Iterable<Product> getAllProduct() {
		return service.getAllProduct();

	}

	@PostMapping("/Order/create")
	public Order createOrder(@RequestBody Order order) {
		return service.createOrder(order);
	}

	@GetMapping("/Order/list")
	public Iterable<Order> getAllOrder() {
		return service.getAllOrder();
	}

	@GetMapping("/Product/get")
	public Optional<Product> getProduct(@RequestParam("id") Integer id) {
		return service.getProductById(id);
				
	}
	@GetMapping("/Order/get")
	public Optional<Order> getOrder(@RequestParam("id") Integer id) {
    return service.getOrderId(id);		
	}
	
	@GetMapping("/order/place")
	public Message placeOrder(@RequestParam("product_id") Integer id, @RequestParam("quantity") Integer quantity) {
		Message msg = getMsgObj();
		try {
			Order order = new Order();
			int code = service.placeOrder(id, quantity, order);
			if(code == 0) {
				msg.setCode(0);
				msg.setMessage("Success");
			}
			else if(code == 1) {
				msg.setCode(1);
				msg.setMessage("Invalid");
			}
			return msg;
		} catch (Exception e) {
			return msg;
		}
	}
	
	@GetMapping("/order/update")
	public Message updateOrder(@RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
		Message msg = getMsgObj();
		try {
			int code = service.updateOrder(id, quantity);
			if(code == 0) {
				msg.setCode(0);
				msg.setMessage("Success");
			}
			else if(code == 1) {
				msg.setCode(1);
				msg.setMessage("Invalid");
			}
			return msg;
		} catch (Exception e) {
			return msg;
		}
	}
	
	public static Message getMsgObj() {
		return new Message();
	}
	
}
    


	


