package com.openclassroom.escalade.service;

import java.util.List;
import java.util.Optional;

import com.openclassroom.escalade.domain.Commentaire;
import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.domain.Utilisateur;

public interface GestionSitesService {
	
	// méthodes liés aux repositories Commentaire et Site
	
	void addCommentary(Utilisateur utilisateur, String siteId, 
   			String contenu, String commentaireId);
	
	List<Commentaire> getCommentaries(Commentaire commentaireParent, String siteId);
	
	List<Commentaire> getAllResponsesOfASite(String siteId);
	
	
	// méthodes liés uniquement au repository Commentaire
	
	Optional<Commentaire> getCommentary(Long id);
	
	void editerCommentaire(String id, String contenu);
	
	void supprimerCommentaire(String commentaireId);
	
	
	// méthodes liés uniquement au repository Site
	
	List<Site> getAllSites();

	Optional<Site> getSiteDetails(String siteId);
	
	void modifierOfficialisation(String siteId);
	
	List<Site> searchSites(List<String> criteriaList);
}


