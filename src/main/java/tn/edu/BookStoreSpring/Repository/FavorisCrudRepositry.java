package tn.edu.BookStoreSpring.Repository;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.edu.BookStoreSpring.DOA.Book;
import tn.edu.BookStoreSpring.DOA.BookFavoris;
import tn.edu.BookStoreSpring.DOA.Categorie;

@Repository
public interface FavorisCrudRepositry extends JpaRepository<BookFavoris, Integer>{
	@Query("select count(GenreLivre) from BookFavoris")
	int retrieveGenreLivreCount();
	@Query("select GenreLivre from BookFavoris")
	List<String> retrieveBookFavorisGenreLivre();
	
	@Query(value="select * from t_book_favoris b where b.name_book= :NameBook and b.genre_livre= :GenreLivre",nativeQuery=true)
	List<BookFavoris> findBookFavorisByGenreLivreAndIdFavoris(@Param("NameBook") String NameBook,@Param("GenreLivre") int GenreLivre);
// List<BookFavoris> findBookFavorisByGenreLivreAndIdFavoris(String keyword, Categorie genreLivre);
    //List<BookFavoris>findByNameBook(String NameBook);

}
