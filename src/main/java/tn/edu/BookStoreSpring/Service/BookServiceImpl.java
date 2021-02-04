package tn.edu.BookStoreSpring.Service;
import tn.edu.BookStoreSpring.DOA.Book;
import tn.edu.BookStoreSpring.DOA.bookFilterByCategory;
import tn.edu.BookStoreSpring.Repository.BookCrudRepositry;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookCrudRepositry bookRepository;

    @Override
    public List<Book> findAll() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        List activeBook = new ArrayList();

        for (Book book : books) {
            if (book.isActive()) {
                activeBook.add(book);
            }
        }
        return books;
    }

    @Override
    public Optional<Book> findOne(Long id) {
        return (bookRepository.findById(id));
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> blurrysearch(String title) {
        List<Book> books = bookRepository.findByTitle(title);
        List activeBookbytitle = new ArrayList();

        for (Book book : books) {
            if (book.isActive()) {
                activeBookbytitle.add(book);
            }
        }
        return activeBookbytitle;
    }

    @Override
    public Void removeOne(Long id) {
        bookRepository.deleteById(id);
        return null;
    }

    @Override
    public Set<Book> blurrySearch(String keyword) {
        Set<Book> bookList = bookRepository.findByTitleContaining(keyword);

        Set<Book> activeBookList = new HashSet<>();

        for (Book book : bookList) {
            if (book.isActive()) {
                activeBookList.add(book);
            }
        }

        return activeBookList;

    }
    
    @Override
    public List<bookFilterByCategory> getCategoryFilter()
    {
    	
    	List<Book> books =bookRepository.findAll();
    	List<Book> testbooks  =  bookRepository.findAll();
    	List<bookFilterByCategory> filterCat = new ArrayList<>();
    	books.forEach(book->{
       int numberCategorie =0  ;
       boolean test = false ; 
       if(filterCat.size()>0){
       for(bookFilterByCategory bc:filterCat)
       {
    	   if(bc.getCategorieName().equals(book.getCategory().name())){test=true;}
    	   
       }   
       }
       for(Book testbook:testbooks){
      if((book.getCategory().name().equals(testbook.getCategory().name()))&&(test==false))	{
    	  numberCategorie=numberCategorie+1; 

      }  }
       if(test==false){
    	 bookFilterByCategory bookfilter = new bookFilterByCategory();
    	 bookfilter.setCategorieName(book.getCategory().name());
    	 bookfilter.setPourcentage((numberCategorie*100)/books.size() + "%");
    	 filterCat.add(bookfilter);}
    	});
    	
        return filterCat;

    }
    
}