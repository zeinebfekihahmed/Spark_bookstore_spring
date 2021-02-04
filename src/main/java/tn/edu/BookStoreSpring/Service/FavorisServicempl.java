package tn.edu.BookStoreSpring.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.edu.BookStoreSpring.Exceptions.*;
import tn.edu.BookStoreSpring.DOA.Book;
import tn.edu.BookStoreSpring.DOA.Categorie;

import tn.edu.BookStoreSpring.DOA.BookFavoris;
import tn.edu.BookStoreSpring.DOA.User;
import tn.edu.BookStoreSpring.DOA.bookFilterByCategory;
import tn.edu.BookStoreSpring.Repository.BookCrudRepositry;
import tn.edu.BookStoreSpring.Repository.FavorisCrudRepositry;
import tn.edu.BookStoreSpring.Repository.UserCrudRepositry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class FavorisServicempl implements FavorisService{
	
	
    private static final Logger LOGGER = LoggerFactory.getLogger(FavorisServicempl.class);

	
	@Autowired
	FavorisCrudRepositry fr;
	@Override
	@Transactional
	public void addNewBook(BookFavoris bookDto) throws BookDuplicateExceptions{
        //Check if bookDto is previously present
        Optional<BookFavoris> bookById = fr.findById(bookDto.getIdFavoris());
        bookById.ifPresent(book -> {
            throw new BookDuplicateExceptions("Book with same id present. " +
                    "Either use update methods to update the book counts or use addBook(Long id, int quantityToAdd) methods");
        });	
  
	}

	@Override
	public void deleteBookFavoris(BookFavoris idFavoris) {
		fr.delete(idFavoris);
	}
	@Autowired
    UserCrudRepositry us;


	@Autowired
	BookCrudRepositry br;


	@Override
	public List<String> getAllBookFavorisGenreLivre() {
		// TODO Auto-generated method stub
		return fr.retrieveBookFavorisGenreLivre();
	}
	@Override
	public int updateBookFavoris(BookFavoris idFavoris) throws BookNotFoundExceptions{
		return fr.save(idFavoris).getIdFavoris();
	}

	@Override
	public int ajoutBookFavoris(BookFavoris idfavoris) {
		return fr.save(idfavoris).getIdFavoris();
	}
	

	public BookFavoris getBookFavorisById(Integer idFavoris) throws BookNotFoundExceptions {
		BookFavoris Book= fr.findById(idFavoris).orElseThrow(()->
                new BookNotFoundExceptions(idFavoris.toString()));
		return Book;
	}
	
    @Override
    public List<BookFavoris> findAll() {
        List<BookFavoris> books = (List<BookFavoris>) fr.findAll();
        List activeBook = new ArrayList();

        for (BookFavoris BookFavoris : books) {
            if (BookFavoris.isActive()){
                activeBook.add(BookFavoris);
            }
        }
        return books;
    }
	@Override
    public List<bookFilterByCategory> getCategoryFilter()
    {
    	
    	List<BookFavoris> books =fr.findAll();
    	List<BookFavoris> testbooks  =  fr.findAll();
    	List<bookFilterByCategory> filterCat = new ArrayList<>();
    	books.forEach(book->{
       int numberCategorie =0  ;
       boolean test = false ; 
       if(filterCat.size()>0){
       for(bookFilterByCategory bc:filterCat)
       {
    	   if(bc.getCategorieName().equals(book.getGenreLivre().name())){test=true;}   	   
       }   
       }
       for(BookFavoris testbook:testbooks){
      if((book.getGenreLivre().name().equals(testbook.getGenreLivre().name()))&&(test==false))	{
    	  numberCategorie=numberCategorie+1; 

      }  }
       if(test==false){
    	 bookFilterByCategory bookfilter = new bookFilterByCategory();
    	 bookfilter.setCategorieName(book.getGenreLivre().name());
    	 bookfilter.setPourcentage((numberCategorie*100)/books.size() + "%");
    	 filterCat.add(bookfilter);}
    	});
    	
        return filterCat;

    }
/*
	@Override
	public List<BookFavoris> getBookByCategoryKeyWord(String keyword, Categorie category) {
        LOGGER.info("Fetch all the books by category and keyword.");
        List<BookFavoris> book = fr.findBookFavorisByCategoryAndKey(keyword.toLowerCase(), category.getValue());
        return mapBookListToBooDtoList(book);
	}

*/
/*
	@Override
	public List<BookFavoris> blurrysearch(String NameBook) {
        List<BookFavoris> books = fr.findByNameBook(NameBook);
        List activeBookbyNameBooke = new ArrayList();

        for (BookFavoris book :books){
        	if (book.isActive()) {
        		activeBookbyNameBooke.add(book);
            }
        }
        return activeBookbyNameBooke;

        }*/



	

}
