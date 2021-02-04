package tn.edu.BookStoreSpring.Service;

import java.util.List;


import tn.edu.BookStoreSpring.DOA.Book;
import tn.edu.BookStoreSpring.DOA.BookFavoris;
import tn.edu.BookStoreSpring.DOA.Categorie;
import tn.edu.BookStoreSpring.DOA.User;
import tn.edu.BookStoreSpring.DOA.bookFilterByCategory;
import tn.edu.BookStoreSpring.Exceptions.BookDuplicateExceptions;
import tn.edu.BookStoreSpring.Exceptions.BookNotFoundExceptions;

public interface FavorisService {

	public int ajoutBookFavoris(BookFavoris idfavoris);
	public int updateBookFavoris(BookFavoris idFavoris) throws BookNotFoundExceptions;
	public void deleteBookFavoris(BookFavoris idFavoris);
	public List<String> getAllBookFavorisGenreLivre();
    public List<bookFilterByCategory> getCategoryFilter();
    void addNewBook(BookFavoris bookDto)throws BookDuplicateExceptions;
    public List<BookFavoris> findAll();
    
    
	
}
