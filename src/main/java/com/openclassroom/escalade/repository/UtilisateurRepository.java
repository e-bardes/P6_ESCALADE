package com.openclassroom.escalade.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.UtilisateurConnecte;

//@Transactional(readOnly = true)
@Repository("utilisateurConnecteRepository")
public interface UtilisateurConnecteRepository extends JpaRepository<UtilisateurConnecte, Long>{

	<S extends UtilisateurConnecte> S save(S entity);
	
	// List<UtilisateurConnecte> findAll();
	
	UtilisateurConnecte findByAdresseMail(String adresseMail);
//	List<UtilisateurConnecte> findByAdressePostal(String adressePostal);
	
	List<UtilisateurConnecte> findByAdresseMailOrAdressePostal(String adresseMail, String adressePostal);
	
	@Override 
	Optional<UtilisateurConnecte> findById(Long id);
	
	UtilisateurConnecte findByAdresseMailAndPassword(String email, String password);
	
}

