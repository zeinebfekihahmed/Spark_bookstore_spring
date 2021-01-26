package com.bookstore.service;

import com.bookstore.domain.ShoppingCart;

public interface ShoppingCartService {
    void updateShoppingCart(Long UserId);

    void clearShoppingCart(ShoppingCart shoppingCart);
}
