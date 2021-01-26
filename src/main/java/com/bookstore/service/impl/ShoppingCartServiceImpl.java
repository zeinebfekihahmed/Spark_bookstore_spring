package com.bookstore.service.impl;

import com.bookstore.domain.CartItem;
import com.bookstore.domain.ShoppingCart;
import com.bookstore.domain.User;
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
   

    public void updateShoppingCart(Long UserId) {
        BigDecimal cartTotal = new BigDecimal(0);
        User user = userRepository.findById(UserId).get();
        List<CartItem> cartItemList = cartItemService.findByUser(user);
        ShoppingCart shoppingcart = new ShoppingCart();
        shoppingcart.setCartItemList(cartItemList);
        for (CartItem cartItem : cartItemList) {
            if(cartItem.getBook().getInStockNumber() > 0) {
                cartItemService.updateCartItem(cartItem);
                cartTotal = cartTotal.add(cartItem.getSubtotal());
            }
        }

        shoppingcart.setGrandTotal(cartTotal);
        shoppingcart.setUser(user);
        shoppingCartRepository.save(shoppingcart);

       
    }

    public void clearShoppingCart(ShoppingCart shoppingCart) {
       // List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

      //  for(CartItem cartItem : cartItemList) {
         //   cartItem.setShoppingCart(null);
         //   cartItemService.save(cartItem);

         //   shoppingCart.setGrandTotal(new BigDecimal(0));

         //   shoppingCartRepository.save(shoppingCart);
     //   }
    }
}
