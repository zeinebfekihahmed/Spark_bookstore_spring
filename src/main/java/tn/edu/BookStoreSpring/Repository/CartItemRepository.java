package tn.edu.BookStoreSpring.Repository;
import tn.edu.BookStoreSpring.DOA.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    Set<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

}
