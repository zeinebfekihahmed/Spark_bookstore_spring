package com.bookstore.repository;

import com.bookstore.domain.Book;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByCategory(String category);

    List<Book> findByTitleContaining(String title);
    @Query(nativeQuery = true, value = "SELECT * FROM Book TB   WHERE TB.category=:category ORDER BY RAND() LIMIT 1 ")
    Book findBookBySuggCategory(
    		  @Param("category") String category);
}
