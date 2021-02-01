package tn.esprit.bookStore.service;

import java.util.List;

import tn.esprit.bookStore.entities.Offre;

public interface OffreService {
	Offre saveOffre(Offre f);
	Offre updateOffre(Offre f);
	//void  deleteOffre(Offre f);
	 String deleteOffreById(Long id);
	Offre getOffre(Long id);
	List<Offre> getAllOffres();



	
	

}
