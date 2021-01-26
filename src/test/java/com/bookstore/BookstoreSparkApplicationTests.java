package com.bookstore;



import java.net.URI;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookstore.domain.CartItem;
import com.bookstore.domain.Order;

import com.bookstore.domain.User;
import com.bookstore.domain.UserBilling;
import com.bookstore.domain.UserPayment;
import com.bookstore.repository.CartItemRepository;
import com.bookstore.repository.OrderRepository;

import com.bookstore.repository.UserRepository;
import com.bookstore.service.CartItemService;
import com.bookstore.service.OrderService;
import com.bookstore.service.ShoppingCartService;
import com.bookstore.service.UserPaymentService;
import com.bookstore.service.UserService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreSparkApplicationTests {
	@Autowired
	CartItemService cs;
	@Autowired
	UserService userService;
	
	@Autowired
	OrderService os;
	@Autowired
	CartItemRepository cr;
	@Autowired
	UserRepository ur;
	@Autowired
	ShoppingCartService shoppingcartservice;


	@Test
	public void contextLoads() {
	}
	@Test
	public void testmt()
	{
		shoppingcartservice.updateShoppingCart(1l);
		
	
	}
	
	@Test
	public void testupdate()
	{
	
	}
	@Test
	public void testremove()
	{
	}
	@Test
	public void testpayment()
	{	
		
		
		
		  
	}
}
