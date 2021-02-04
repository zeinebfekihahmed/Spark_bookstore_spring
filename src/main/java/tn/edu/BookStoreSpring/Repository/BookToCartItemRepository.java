package tn.edu.BookStoreSpring.Repository;
import tn.edu.BookStoreSpring.DOA.CartItem;
import tn.edu.BookStoreSpring.DOA.BookToCartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {
	
    
}