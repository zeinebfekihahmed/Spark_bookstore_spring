package com.bookstore.service;

import com.bookstore.domain.*;

import java.util.List;

public interface CartItemService {
   
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
    CartItem updateCartItem(CartItem cartItem);
    
    CartItem addBookToCartItem(Long BookId, Long userId, int qty);

    CartItem findById(Long id);

    void removeCartItem(long cartItemId);

    CartItem save(CartItem cartItem);
    List<CartItem> findByUser(User user);
    List<CartItem> findByOrder(Order order);
    public String algoBook(long userId);
}
