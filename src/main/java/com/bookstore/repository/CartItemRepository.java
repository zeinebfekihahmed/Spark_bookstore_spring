package com.bookstore.repository;

import com.bookstore.domain.CartItem;
import com.bookstore.domain.Order;
import com.bookstore.domain.ShoppingCart;
import com.bookstore.domain.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
 List<CartItem> findByShoppingCart(ShoppingCart shoppingcart);
    List<CartItem> findByUser(User user);
    List<CartItem> findByOrder(Order order);
   
}
