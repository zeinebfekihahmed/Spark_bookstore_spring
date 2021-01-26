package com.bookstore.service.impl;

import com.bookstore.domain.*;
import com.bookstore.repository.OrderRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.CartItemService;
import com.bookstore.service.OrderService;
import com.bookstore.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private UserRepository ur;

    public synchronized Order createOrder( ShoppingCart shoppingcart,
                      
                      UserPayment payment,
                      String shippingMehod,
                     Long userId) {
        Order order = new Order();
       
        order.setOrderStatus("created");
        order.setPayment(payment);
       
        order.setShippingMethod(shippingMehod);

       List<CartItem>  cartItemList = cartItemService.findByShoppingCart(shoppingcart);

         for(CartItem cartItem : cartItemList) {
          Book book = cartItem.getBook();
          cartItem.setOrder(order);
          
         }

          order.setCartItemList(cartItemList);
        order.setOrderDate(Calendar.getInstance().getTime());
      
        payment.setOrder(order);
        User us = ur.findById(userId).get();
        order.setUser(us);
        order = orderRepository.save(order);

        return order;
    }

    public Order findOne(Long id) {
        return orderRepository.findById(id).get();
    }
}
