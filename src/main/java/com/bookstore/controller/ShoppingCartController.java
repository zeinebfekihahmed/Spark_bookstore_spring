package com.bookstore.controller;

import com.bookstore.domain.Book;
import com.bookstore.domain.CartItem;
import com.bookstore.domain.Order;
import com.bookstore.domain.ShoppingCart;
import com.bookstore.domain.User;
import com.bookstore.service.BookService;
import com.bookstore.service.CartItemService;
import com.bookstore.service.PaymentService;
import com.bookstore.service.ShoppingCartService;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private UserService userService;
    @Autowired
	UserService userservice;
    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private BookService bookService;

    @Autowired
    private ShoppingCartService shoppingCartService;


    @PutMapping("/cart/{userId}")
	 @ResponseBody
	 public String buildShoppingCart(@PathVariable("userId") Long userId) {
    	 
    	   shoppingCartService.updateShoppingCart(userId);
	return  "shoppingCart";
	 }

	 @PostMapping("/addcartItem/{userId}/{BookId}/{qty}")	
	 @ResponseBody	
	 public void addBookToCartItem(@PathVariable("BookId") Long BookId,@PathVariable("userId") Long userId,@PathVariable("qty") int qty) {
		   cartItemService.addBookToCartItem(BookId, userId,qty);
	
	 }
	 @PostMapping("/clearcart/{userId}")	
	 @ResponseBody	
	 public void clearCart(@PathVariable("userId") Long userId) {
		  User user=userservice.findById(userId);
		  ShoppingCart sc =  user.getShoppingCart();
		   shoppingCartService.clearShoppingCart(sc);
	
	 }
	 @PutMapping("/updateCartItem/{cartItemId}/{qty}")
	 @ResponseBody
	 public int modifyUser(@PathVariable("cartItemId") Long cartItemId,@PathVariable("qty") int qty) {
		  CartItem cartItem = cartItemService.findById(cartItemId);
	        cartItem.setQty(qty);
	
	return  cartItemService.updateCartItem(cartItem).getQty();
	 }
 

  
    @DeleteMapping("/remove-cartItem/{cartItemId}")
    @ResponseBody
   public void removeItem(@PathVariable("cartItemId") Long cartItemId) {
    	 cartItemService.removeCartItem(cartItemId);
   }
    
    @GetMapping("usercartitems/{userId}")
	 @ResponseBody
	 public  List<CartItem> getallBooks(@PathVariable("userId") Long userId) {
    User user=	userService.findById(userId);
	 List<CartItem> list = cartItemService.findByUser(user);
	 return list;
	 }
    
    @GetMapping("/algo/{userId}")	
	 @ResponseBody
	 public String algo(@PathVariable("userId") Long userId)
	 {
	  return cartItemService.algoBook(userId);
	 }
}
