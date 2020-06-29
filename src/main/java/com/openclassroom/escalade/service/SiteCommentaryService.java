package com.openclassroom.escalade.service;

import java.util.List;
import java.util.Optional;

import com.openclassroom.escalade.domain.Commentaire;
import com.openclassroom.escalade.domain.Utilisateur;

public interface SiteCommentaryService {

	void addCommentary(Utilisateur utilisateur, String siteId, String contenu, String commentaireId);

	List<Commentaire> getCommentaries(Commentaire commentaireParent, String siteId);

	List<Commentaire> getAllResponsesOfASite(String siteId);

	Optional<Commentaire> getCommentary(Long id);

	void editCommentary(String id, String contenu);

	void deleteCommentary(String commentaireId);
}
