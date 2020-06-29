package com.openclassroom.escalade.service;

public interface SiteEditionService {

	void deleteSecteur(String secteurId);

	void editerNomSecteur(String id, String nom);

	void deleteVoie(String voieId);

	void addVoieInSite(String valeurCotation, String isEquipe, String siteId);

	void addVoieInSecteur(String valeurCotation, String isEquipe, String secteurId);

	void deleteLongueur(String longueurId);

	void addLongueur(String valeurCotation, String voieId);

	void editerDescriptionSecteur(String id, String description);

	void modifierOfficialisation(String siteId);

	void editerDescriptionSite(String id, String description);

	void createSecteur(String siteId, String nom);

}
