package com.bookstore.service.impl;

import com.bookstore.dev.SendMail;
import com.bookstore.domain.*;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.BookToCartItemRepository;
import com.bookstore.repository.CartItemRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    CartItemService cartitemservice;
    @Autowired
    private BookToCartItemRepository bookToCartItemRepository;
    @Autowired
    private BookRepository br;
    @Autowired
    private UserRepository ur;
    @Autowired
    SendMail sm;
    
  public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
        return cartItemRepository.findByShoppingCart(shoppingCart);
   }
   

    public CartItem updateCartItem(CartItem cartItem) {
        BigDecimal bigDecimal = new BigDecimal(cartItem.getBook().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));

        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        cartItem.setSubtotal(bigDecimal);

        cartItemRepository.save(cartItem);

        return cartItem;
    }

    public CartItem addBookToCartItem(Long BookId, Long userId, int qty) {
      

        CartItem cartItem = new CartItem();
       
        cartItem.setBook(br.findById(BookId).get());
        cartItem.setUser(ur.findById(userId).get());
        cartItem.setQty(qty);
        cartItem.setSubtotal(new BigDecimal(br.findById(BookId).get().getOurPrice()).multiply(new BigDecimal(qty)));
        cartItem = cartItemRepository.save(cartItem);

        BookToCartItem bookToCartItem = new BookToCartItem();
        bookToCartItem.setBook(br.findById(BookId).get());
        bookToCartItem.setCartItem(cartItem);
        bookToCartItemRepository.save(bookToCartItem);

        return cartItem;
    }

    public CartItem findById(Long id) {
        return cartItemRepository.findById(id).get();
    }

    public void removeCartItem(long cartitemId) {
    	CartItem cartItem = cartitemservice.findById(cartitemId);
        bookToCartItemRepository.deleteByCartItem(cartItem);
        cartItemRepository.delete(cartItem);
    }

    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> findByOrder(Order order) {
        return cartItemRepository.findByOrder(order);
    }

	@Override
	public List<CartItem> findByUser(User user) {
		return cartItemRepository.findByUser(user);
	}
	@Override
	public String algoBook(long userId){		
	User u = ur.findById(userId).get();
	u.getId().toString();
		List<CartItem> algo=u.getCartItems();
		algo.toString();
		List<Book>books=algo.stream().map(CartItem::getBook).collect(Collectors.toList());
		Map<String,Long> result =books.stream()
			.collect(Collectors.groupingBy(Book::getCategory,Collectors.counting()));
		Map<String, Long> finalMap = new LinkedHashMap<>();
		result.entrySet().stream()
		.sorted(Map.Entry.<String, Long>comparingByValue()
             .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
		String toCategorie=finalMap.entrySet().iterator().next().getKey();
		String suggBook=br.findBookBySuggCategory(toCategorie).getTitle();
		sm.sendEmail("ahmedzeineb.benfekih@esprit.tn","Book Recommendation By Spark BookStore" , "Hello we saw that you are interested in books "
				+toCategorie+" so we thought you might like this book aswell "+suggBook);
	
		return	suggBook;
		
	 

}
	
}

