package tn.edu.BookStoreSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.edu.BookStoreSpring.DOA.Book;

import java.util.List;
import java.util.Set;

@Repository
public interface BookCrudRepositry extends JpaRepository<Book, Long>{
    List<Book> findByTitle(String title);

    Set<Book> findByTitleContaining(String keyword);

}
