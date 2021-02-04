package tn.edu.BookStoreSpring.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.edu.BookStoreSpring.DOA.User;

public interface UserCrudRepositry extends CrudRepository<User, Integer> {

}
