package com.bookstore.service;

import com.stripe.exception.StripeException;
import com.stripe.model.Customer;

public interface PaymentService {

  

    String chargeCustomer(long customer_id) throws StripeException;

    
}
