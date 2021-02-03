package com.bookstore.service.impl;


import com.bookstore.domain.Book;
import com.bookstore.domain.CartItem;
import com.bookstore.domain.ShoppingCart;
import com.bookstore.domain.User;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.OrderService;
import com.bookstore.service.PaymentService;
import com.bookstore.service.ShoppingCartService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.CustomerBalanceTransaction;
import com.stripe.model.PaymentIntent;
import com.stripe.net.RequestOptions;
import com.stripe.param.PaymentIntentCreateParams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class ImpPaymentService implements PaymentService {
	@Autowired
	ShoppingCartService sc;
	@Autowired
	UserRepository ur;
	@Autowired
	OrderService os;
	
	@Override
	public String chargeCustomer(long customer_id) throws StripeException {
		
		Stripe.apiKey = "sk_test_51IDwaJBXRG7IhBItzHZ5a05qfDS3BWGZxNFqUlKmycfsleIR9bsg7cJ0CN6mdPVJ3jTNSzjl5gu6Ww8hMxDs7i3Y00oCfy0Vlp";
		ShoppingCart ss =sc.updateShoppingCart(customer_id);
		//sc.clearShoppingCart(ss);
		RequestOptions requestOptions = RequestOptions.builder()
				  .setApiKey("sk_test_51IDwaJBXRG7IhBItzHZ5a05qfDS3BWGZxNFqUlKmycfsleIR9bsg7cJ0CN6mdPVJ3jTNSzjl5gu6Ww8hMxDs7i3Y00oCfy0Vlp")
				  .build();
		
		Map<String, Object> params = new HashMap<>();
		//params.put("amount", amount);
		
		params.put("amount", ss.getGrandTotal().intValue()*100);
		params.put("currency", "usd");
		params.put("source", "tok_visa");
		params.put(
		  "description",
		  "Order By CLIENT : "+customer_id
		);

		Charge charge = Charge.create(params);
		
		
		//os.createOrder(ss,customer_id);
		return null;
	}
	
	
}