package com.example.demo.repository;

import com.example.demo.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    @Query("select u from Utilisateur u where u.login like %?1 ")
    Utilisateur FindByLogin(String login);

    @Transactional
    @Modifying
    @Query("delete from Utilisateur u where u.login like %?1")
    Integer deleteUser(String login);
}
