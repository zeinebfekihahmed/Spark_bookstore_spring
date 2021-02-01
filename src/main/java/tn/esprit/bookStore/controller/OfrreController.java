package tn.esprit.bookStore.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.bookStore.entities.Offre;
import tn.esprit.bookStore.service.OffreService;

@RestController
public class OfrreController {
	@Autowired
	private OffreService service;
	
	@PostMapping("/saveOffre")
public Offre saveOffre(@RequestBody Offre f) {
		return service.saveOffre(f) ;
	}
	
@PutMapping("/update")	
public Offre updateOffre(@RequestBody Offre f) {
	return service.updateOffre(f);
}



@DeleteMapping ("/delete/{id}")
public String deleteOffreById(@PathVariable Long id) {
	return service.deleteOffreById(id);
	 
	
}

@GetMapping("/offre/{id}")
public Offre getOffre(@PathVariable Long id) {
	
	return service.getOffre(id);
}
@GetMapping("/offres")
public List<Offre> getAllOffres() {
	
	return service.getAllOffres();
}

//@DeleteMapping ("/deletes")
//public void deleteOffre(@RequestBody Offre f) {
//	service.deleteOffre(f);
	
	
//}
}
