package com.example.demo.controllers;

import com.example.demo.entities.Utilisateur;
import com.example.demo.service.Implementation.utilisateurServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    utilisateurServiceImplementation USI;

    @PostMapping("/adduser")
    public boolean adduser(@RequestBody Utilisateur U){
        return USI.adduser(U);
    }
    @GetMapping("/login")
    public Principal user(Principal principal){
        System.out.println("user Logged"+principal);
        return principal;
    }
    @PostMapping("/deleteuser")
    public boolean deleteuser(@RequestParam(name = "login") String login){
        return USI.deleteuser(login);
    }





}
