package com.example.demo.service.Implementation;

import com.example.demo.entities.Utilisateur;
import com.example.demo.repository.UtilisateurRepository;
import com.example.demo.service.utilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class utilisateurServiceImplementation implements utilisateurService {

    @Autowired
    UtilisateurRepository UR ;
    @Autowired
    public PasswordEncoder bCryptPassowordEncoder ;
    @Override
    public boolean adduser(Utilisateur u) {
        //Encrypt Password here
        String CryptedPassword = bCryptPassowordEncoder.encode(u.getMdp());
        u.setMdp(CryptedPassword);
        try{
            UR.save(u);
            System.out.println("Saved");
            return true ;
        }catch (Exception E){
            System.out.println(E.getMessage());
            return false ;
        }
    }

    @Override
    public boolean updateuser(int id) {
        return true ;
    }

    @Override
    public List<Utilisateur> findAllusers() {
        return UR.findAll();
    }

    @Override
    public boolean findById(int id) {
        return false;
    }

    @Override
    public boolean deleteuser(String  login) {

          int i= UR.deleteUser(login);
          if(i>0) {
              return true;
          }else {
              return false;
          }

    }

    @Override
    public Utilisateur findbyLogin(String login) {
        if(null == UR.FindByLogin(login)){
            System.out.println("*****************User NOT found ****************");

        }
        System.out.println("*************** DAO success " + UR.FindByLogin(login).getNom()+" "+ UR.FindByLogin(login).getPrenom());
       return  UR.FindByLogin(login);
    }
}
