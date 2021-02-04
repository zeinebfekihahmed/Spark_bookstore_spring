package tn.edu.BookStoreSpring.DOA;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "T_BookFavoris")
public class BookFavoris implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFavoris")
    private int idFavoris;
    @Column(name = "idUser")
    private int idUser;
    @Column(name = "idLivre")
    private int idLivre;
    
    @Column(name = "GenreLivre")
    @Enumerated(EnumType.ORDINAL)
    private Categorie GenreLivre;
    @Column(name = "genreUser")
    private String genreUser;
    @Column(name = "NameBook")
    private String NameBook;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Payment> payments;
    
    @OneToMany(mappedBy = "BookFavoris")
    private Set<Book> book ;
    
    @OneToMany(cascade = CascadeType.ALL)
    private Set<User>users;
   
 
    private boolean active;

    public boolean isctive() {
        return active;
    }

	public BookFavoris() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public BookFavoris(int idFavoris, int idUser, int idLivre, Categorie genreLivre, String genreUser, String nameBook,
			Set<Payment> payments, Set<User> users, Cart cart, Set<Categorie> categories) {
		super();
		this.idFavoris = idFavoris;
		this.idUser = idUser;
		this.idLivre = idLivre;
		GenreLivre = genreLivre;
		this.genreUser = genreUser;
		NameBook = nameBook;
		this.payments = payments;
		this.users = users;
	}
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

	public String getNameBook() {
		return NameBook;
	}


	public void setNameBook(String nameBook) {
		NameBook = nameBook;
	}


	public BookFavoris(int idFavoris, int idUser, int idLivre, Categorie genreLivre, String genreUser,
			Set<Payment> payments, Set<User> users, Cart cart) {
		super();
		this.idFavoris = idFavoris;
		this.idUser = idUser;
		this.idLivre = idLivre;
		GenreLivre = genreLivre;
		this.genreUser = genreUser;
		this.payments = payments;
		this.users = users;
	}


	public int getIdFavoris() {
		return idFavoris;
	}

	public void setIdFavoris(int idFavoris) {
		this.idFavoris = idFavoris;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}

	public Categorie getGenreLivre() {
		return GenreLivre;
	}

	public void setGenreLivre(Categorie genreLivre) {
		GenreLivre = genreLivre;
	}

	public String getGenreUser() {
		return genreUser;
	}

	public void setGenreUser(String genreUser) {
		this.genreUser = genreUser;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((GenreLivre == null) ? 0 : GenreLivre.hashCode());
		result = prime * result + ((NameBook == null) ? 0 : NameBook.hashCode());
		result = prime * result + ((genreUser == null) ? 0 : genreUser.hashCode());
		result = prime * result + idFavoris;
		result = prime * result + idLivre;
		result = prime * result + idUser;
		result = prime * result + ((payments == null) ? 0 : payments.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookFavoris other = (BookFavoris) obj;
		if (GenreLivre != other.GenreLivre)
			return false;
		if (NameBook == null) {
			if (other.NameBook != null)
				return false;
		} else if (!NameBook.equals(other.NameBook))
			return false;
		
		if (genreUser == null) {
			if (other.genreUser != null)
				return false;
		} else if (!genreUser.equals(other.genreUser))
			return false;
		if (idFavoris != other.idFavoris)
			return false;
		if (idLivre != other.idLivre)
			return false;
		if (idUser != other.idUser)
			return false;
		if (payments == null) {
			if (other.payments != null)
				return false;
		} else if (!payments.equals(other.payments))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}


	public BookFavoris(int idFavoris, int idUser, int idLivre, Categorie genreLivre, String genreUser,
			Set<Payment> payments, Set<User> users, Cart cart, Set<Categorie> categories) {
		super();
		this.idFavoris = idFavoris;
		this.idUser = idUser;
		this.idLivre = idLivre;
		GenreLivre = genreLivre;
		this.genreUser = genreUser;
		this.payments = payments;
		this.users = users;
	}
}

    
    

  

	
