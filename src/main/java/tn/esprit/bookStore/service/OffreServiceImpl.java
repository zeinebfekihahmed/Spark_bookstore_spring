package tn.esprit.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.esprit.bookStore.entities.Offre;
import tn.esprit.bookStore.repos.OffreRepository;

@Service

public class OffreServiceImpl implements OffreService {
	
	@Autowired
	OffreRepository offreRepository;

	@Override
	public Offre saveOffre(Offre f) {
		
		return offreRepository.save(f) ;
	}

	@Override
	public Offre updateOffre(Offre f) {
		return offreRepository.save(f) ;
	}


	@Override
	public String  deleteOffreById(Long id) {
		try{
		 offreRepository.deleteById(id);
		 return "Offre Removed "+id;	
		 }
		catch (Exception e){return "invalid id";}
	}

	@Override
	public Offre getOffre(Long id) {
	
		return offreRepository.findById(id).orElse(null);
	}

	@Override
	public List<Offre> getAllOffres() {
		
		return offreRepository.findAll(Sort.by("dateDeb").ascending());
	}

}
