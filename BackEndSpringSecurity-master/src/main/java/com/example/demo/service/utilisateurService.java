package com.example.demo.service;

import com.example.demo.entities.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface utilisateurService {
    boolean adduser(Utilisateur u);
    boolean updateuser(int id);
    List<Utilisateur> findAllusers();
    boolean findById(int id);
    boolean deleteuser(String login);
    Utilisateur findbyLogin(String login);
}
