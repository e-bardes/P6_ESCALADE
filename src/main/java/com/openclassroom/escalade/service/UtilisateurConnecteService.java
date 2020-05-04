package com.openclassroom.escalade.service;

import java.util.List;

import com.openclassroom.escalade.domain.UtilisateurConnecte;

public interface UtilisateurConnecteService {
	
	<S extends UtilisateurConnecte> S save(S entity);
	
	List<UtilisateurConnecte> findAll();
}
