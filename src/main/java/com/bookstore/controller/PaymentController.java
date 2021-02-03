package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.domain.Order;
import com.bookstore.domain.ShoppingCart;
import com.bookstore.domain.User;
import com.bookstore.service.OrderService;
import com.bookstore.service.PaymentService;
import com.bookstore.service.ShoppingCartService;
import com.bookstore.service.UserService;
import com.stripe.exception.StripeException;

@RestController
public class PaymentController {
	@Autowired
	PaymentService paymentservice;
	@Autowired
	OrderService orderservice;
	@Autowired
	ShoppingCartService shoppingcartservice;
	@Autowired
	UserService userservice;
	 @PostMapping("/ChargeUser/{customer_id}")	
	 @ResponseBody	
	 public void ChargeUser(@PathVariable("customer_id") Long customer_id) {
		 try {
			paymentservice.chargeCustomer(customer_id);
			
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	 }
	 
	 
	  @PostMapping("/createOrder/{userId}")	
		 @ResponseBody
		 public void createOrder(@PathVariable("userId") Long userId) {
		  User user=userservice.findById(userId);
		  ShoppingCart sc =  user.getShoppingCart();
		  orderservice.createOrder(sc, userId);
		
		 }
	  @GetMapping("/findOrder/{id}")
	  @ResponseBody
	  public Order findOne(@PathVariable("id")Long id)
	  {
		  return orderservice.findOne(id);
	  }
	  

}
