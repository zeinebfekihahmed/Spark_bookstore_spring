package tn.edu.BookStoreSpring.Service;
import tn.edu.BookStoreSpring.DOA.*;
import java.util.Set;


public interface CartItemService {
    CartItem addBookToCartItem(Book book, User user, int qty);

    Set<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

    //Set<CartItem> findByorder(Order order);
    CartItem updateCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    CartItem findById(Long id);

    CartItem save(CartItem cartItem);

}
