package com.bookstore.service;

import com.bookstore.domain.*;

public interface OrderService {
    Order createOrder( ShoppingCart shoppingcart,
                      
                      UserPayment payment,
                      String shippingMehod,
                      Long userId);

    Order findOne(Long id);
}
