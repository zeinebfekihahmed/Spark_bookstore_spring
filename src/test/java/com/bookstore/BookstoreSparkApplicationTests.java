package com.bookstore;



import java.net.URI;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookstore.dev.SendMail;
import com.bookstore.domain.CartItem;
import com.bookstore.domain.Order;

import com.bookstore.domain.User;

import com.bookstore.repository.CartItemRepository;
import com.bookstore.repository.OrderRepository;

import com.bookstore.repository.UserRepository;
import com.bookstore.service.CartItemService;
import com.bookstore.service.OrderService;
import com.bookstore.service.PaymentService;
import com.bookstore.service.ShoppingCartService;

import com.bookstore.service.UserService;
import com.stripe.exception.StripeException;
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
	@Autowired
    PaymentService paymentService;
	@Autowired 
	SendMail sm;
	
	@Test
	public void testMail()
	{
		sm.sendEmail("elyes.jarroudi@esprit.tn","Book Order","order.id       +order.date   +order.total order.boughtbooks are bla bla bla");
	}
		
		  
}
