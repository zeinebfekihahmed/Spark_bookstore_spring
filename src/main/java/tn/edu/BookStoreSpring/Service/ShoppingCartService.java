package tn.edu.BookStoreSpring.Service;
import tn.edu.BookStoreSpring.DOA.*;

public interface ShoppingCartService {
    ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);

    void clearShoppingCart(ShoppingCart shoppingCart);

}
