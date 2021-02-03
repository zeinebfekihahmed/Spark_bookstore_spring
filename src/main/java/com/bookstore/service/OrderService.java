package com.bookstore.service;

import com.bookstore.domain.*;

public interface OrderService {
    Order createOrder(   ShoppingCart sc,
                      Long userId);

    Order findOne(Long id);
}
