package tn.esprit.bookStore.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.bookStore.entities.Offre;

public interface OffreRepository extends JpaRepository<Offre, Long> {
	

}
