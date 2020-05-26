package com.openclassroom.escalade.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.openclassroom.escalade.domain.UtilisateurConnecte;

public interface UtilisateurConnecteService {
	
	<S extends UtilisateurConnecte> S save(S entity);
	
	// List<UtilisateurConnecte> findAll();
	
	UtilisateurConnecte findByAdresseMail(String adresseMail);
//	List<UtilisateurConnecte> findByAdressePostal(String adressePostal);
//	
//	@Transactional
//	List<UtilisateurConnecte> verificationInscription(String adresseMail, String adressePostal);
	
	List<UtilisateurConnecte> findByAdresseMailOrAdressePostal(String adresseMail, String adressePostal);
	
	Optional<UtilisateurConnecte> findById(Long id);
	
	UtilisateurConnecte inscriptionUtilisateur(HttpServletRequest request);
	
	UtilisateurConnecte findByAdresseMailAndPassword(String email, String password);
	
	UtilisateurConnecte connexionUtilisateur(HttpServletRequest request);
	
	String getErreurConnexion();
}
