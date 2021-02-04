package tn.edu.BookStoreSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.edu.BookStoreSpring.DOA.*;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
