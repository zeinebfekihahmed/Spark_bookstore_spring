package tn.esprit.bookStore.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name="offre")
public class Offre {
	//pour que l'idOffre soit le clé primaire
	@Id 
	//pour qu'il soit autoIncremante
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOffre;
	private String nomOffre;
	private Date dateDeb;
	private Date dateFin;
	private Double tauxRemise;
	
	
	
	
	
	
	
}
