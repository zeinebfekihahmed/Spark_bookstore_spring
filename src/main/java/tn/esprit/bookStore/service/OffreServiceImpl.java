package tn.esprit.bookStore.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

//	@Override
//	public void deleteOffre(Offre f) {
//		offreRepository.delete(f);
//		
//	}

	@Override
	public String  deleteOffreById(Long id) {
		 offreRepository.deleteById(id);
		 return "Offre Removed "+id;
	}

	@Override
	public Offre getOffre(Long id) {
	
		return offreRepository.findById(id).get();
	}

	@Override
	public List<Offre> getAllOffres() {
		
		return offreRepository.findAll(Sort.by("dateDeb").ascending());
	}

}
