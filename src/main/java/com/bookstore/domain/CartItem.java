package com.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int qty;
	private BigDecimal subtotal;	
	@OneToOne
	private Book book;
	@OneToMany(mappedBy = "cartItem",cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<BookToCartItem> bookToCartItemList;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="shopping_cart_id")
	private ShoppingCart shoppingCart;
	public ShoppingCart getShoppingcart() {
		return shoppingCart;
	}

	public void setShoppingcart(ShoppingCart shoppingcart) {
		this.shoppingCart = shoppingcart;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="order_id")
	private Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<BookToCartItem> getBookToCartItemList() {
		return bookToCartItemList;
	}

	public void setBookToCartItemList(List<BookToCartItem> bookToCartItemList) {
		this.bookToCartItemList = bookToCartItemList;
	}


	public Order getOrder() {
		return order;
	}

	
	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", qty=" + qty + ", subtotal=" + subtotal + ", book=" + book
				+ ", bookToCartItemList=" + bookToCartItemList + ", user=" + user + ", order=" + order + "]";
	}
	
	
}
