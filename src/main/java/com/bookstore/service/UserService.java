package com.bookstore.service;

import com.bookstore.domain.User;





import java.util.Set;

public interface UserService {


    

    User findByUsername(String username);

    User findByEmail(String email);

    User findById(Long id);



    User save(User user);

    

  



   
}
