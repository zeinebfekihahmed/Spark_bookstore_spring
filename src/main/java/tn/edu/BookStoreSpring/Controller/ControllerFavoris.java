package tn.edu.BookStoreSpring.Controller;

import tn.edu.BookStoreSpring.Service.FavorisService;
import tn.edu.BookStoreSpring.Service.BookService;
import tn.edu.BookStoreSpring.DOA.Book;
import tn.edu.BookStoreSpring.DOA.BookFavoris;
import tn.edu.BookStoreSpring.DOA.Categorie;
import tn.edu.BookStoreSpring.DOA.bookFilterByCategory;
import tn.edu.BookStoreSpring.Exceptions.BookDuplicateExceptions;
import tn.edu.BookStoreSpring.Exceptions.BookNotFoundExceptions;
import tn.edu.BookStoreSpring.Repository.FavorisCrudRepositry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/favorisbook")
public class ControllerFavoris {
	
	@Autowired
	FavorisService fr;
	@Autowired
	FavorisCrudRepositry fcr;
	
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public void deleteBookFavoris(@RequestBody BookFavoris idFavoris) {
        fr.deleteBookFavoris(idFavoris);
    }
    @RequestMapping(value = "/NewBook", method = RequestMethod.POST)
    public void newBook(@RequestBody BookFavoris bookDto)throws BookDuplicateExceptions{
        //Check if bookDto is previously present{
        fr.addNewBook(bookDto);
    }  
    
    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public int updateFavoris(@RequestBody BookFavoris idFavoris)throws BookNotFoundExceptions{
    	return fr.updateBookFavoris(idFavoris);
    	
    }
    @RequestMapping(value = "/ajout", method = RequestMethod.POST)
    public void ajoutBookFavoris(@RequestBody BookFavoris bookDto) {
    	fcr.save(bookDto);
    }
    @RequestMapping("/book-list")
    public List<BookFavoris> getAllBook() {
        return fcr.findAll();
    }
    @RequestMapping(value ="/bookCatlist" , method = RequestMethod.GET)
    public List<bookFilterByCategory> getAllCatBook() {
    	return fr.getCategoryFilter();
        }
    @RequestMapping(value = "/search/{NameBook}/{GenreLivre}", method = RequestMethod.GET)
	List<BookFavoris> findBookFavorisByGenreLivreAndIdFavoris(@PathVariable("NameBook") String NameBook,@PathVariable("GenreLivre") String GenreLivre){
    	System.out.println(GenreLivre);

    	int b=Integer.parseInt(GenreLivre);
    	return this.fcr.findBookFavorisByGenreLivreAndIdFavoris(NameBook, b);
    }


}
