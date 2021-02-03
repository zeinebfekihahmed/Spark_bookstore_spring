package com.bookstore.service;

import com.bookstore.domain.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart updateShoppingCart(Long UserId);

    void clearShoppingCart(ShoppingCart shoppingCart);
   
}
