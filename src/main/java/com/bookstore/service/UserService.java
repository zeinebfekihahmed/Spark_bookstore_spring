package com.bookstore.service;

import com.bookstore.domain.User;
import com.bookstore.domain.UserBilling;
import com.bookstore.domain.UserPayment;



import java.util.Set;

public interface UserService {


    

    User findByUsername(String username);

    User findByEmail(String email);

    User findById(Long id);



    User save(User user);

    

  

    void setUserDefaultPayment(Long userPaymentId, User user);

   
}
