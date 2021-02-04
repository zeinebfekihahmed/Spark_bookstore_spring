package tn.edu.BookStoreSpring.DOA;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 import java.util.HashMap;
 import java.util.Map;


public enum Categorie {
	
	
 LITERATURE(0),
 NONFICTION(1),
 ACTION(2),
 THRILLER(3),
 TECHNOLOGY(4),
 DRAMA(5),
 POETRY(6),
 MEDIA(7),
 OTHERS(8);

 private int value;
 private static Map map = new HashMap<>();

 private Categorie(int value) {
     this.value = value;
 }

 static {
     for (Categorie category : Categorie.values()) {
         map.put(category.value, category);
     }
 }

 public static Categorie valueOf(int category) {
     return (Categorie) map.get(category);
 }

 public int getValue() {
     return value;
 }
		
	}


