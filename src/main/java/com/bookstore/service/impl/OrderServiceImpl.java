package com.bookstore.service.impl;

import com.bookstore.dev.SendMail;
import com.bookstore.domain.*;
import com.bookstore.repository.OrderRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.CartItemService;
import com.bookstore.service.OrderService;
import com.bookstore.service.ShoppingCartService;
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
    @Autowired
       private ShoppingCartService scs;
    @Autowired
    SendMail sdm;
    public synchronized Order createOrder(
                      ShoppingCart sc,Long userId) {
        Order order = new Order();
       List<CartItem>  cartItemList = cartItemService.findByUser(ur.findById(userId).get());
         for(CartItem cartItem : cartItemList) {
          Book book = cartItem.getBook();
          cartItem.setOrder(order);
         }
          order.setCartItemList(cartItemList);
        order.setOrderDate(Calendar.getInstance().getTime());       
        User us = ur.findById(userId).get();
        order.setUser(us);
        order.setOrderTotal(sc.getGrandTotal());
        order = orderRepository.save(order);
        ///We can add a mail here with order information
        sdm.sendEmail("ahmedzeineb.benfekih@esprit.tn"," This is your order By Spark BookStore "," Thank you for your order "+order.getId()+
        		" in : "+order.getOrderDate()+" and this is your Total "+order.getOrderTotal()+"dt");
  
        return order;
    }

    public Order findOne(Long id) {
        return orderRepository.findById(id).get();
    }
    
    

}
