package com.bookstore.service.impl;

import com.bookstore.domain.CartItem;
import com.bookstore.domain.ShoppingCart;
import com.bookstore.domain.User;
import com.bookstore.repository.CartItemRepository;
import com.bookstore.repository.ShoppingCartRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.CartItemService;
import com.bookstore.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private UserRepository userRepository;
   @Autowired
   private CartItemRepository cartItemRepository;

    public ShoppingCart updateShoppingCart(Long UserId) {
        BigDecimal cartTotal = new BigDecimal(0);
        User user = userRepository.findById(UserId).get();
        List<CartItem> cartItemList = cartItemService.findByUser(user);
        ShoppingCart shoppingcart = new ShoppingCart();
        shoppingcart.setCartItemList(cartItemList);
        shoppingcart.setUser(user);
        for (CartItem cartItem : cartItemList) {
        	cartItem.setShoppingcart(shoppingcart);
              
                cartTotal = cartTotal.add(cartItem.getSubtotal());
                
           
            
        }

        shoppingcart.setGrandTotal(cartTotal);
        
        
        shoppingCartRepository.save(shoppingcart);
        return shoppingcart;
       
    }

    public void clearShoppingCart(ShoppingCart shoppingCart) {
       List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

       for(CartItem cartItem : cartItemList) {
          cartItem.setShoppingcart(null);
          
           //cartItemService.(cartItem);
          cartItemRepository.delete(cartItem);
          
       }
         // shoppingCart.setGrandTotal(new BigDecimal(0));
         // shoppingCart.setUser(null);
          
       User u=shoppingCart.getUser();
       u.setShoppingCart(null);
       userRepository.save(u);

       shoppingCartRepository.delete(shoppingCart);
           
       }
    }

