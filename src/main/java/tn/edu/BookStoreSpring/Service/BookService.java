package tn.edu.BookStoreSpring.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import tn.edu.BookStoreSpring.DOA.Book;
import tn.edu.BookStoreSpring.DOA.bookFilterByCategory;
import tn.edu.BookStoreSpring.DOA.*;



public interface BookService {
    List<Book> findAll();

    Optional<Book> findOne(Long id);

    Book save(Book book);

    List<Book> blurrysearch(String title);

    Void removeOne(Long id);

    Set<Book> blurrySearch(String title);
    List<bookFilterByCategory> getCategoryFilter();

}
