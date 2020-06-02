package com.openclassroom.escalade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.Commentaire;
import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.repository.CommentaireRepository;
import com.openclassroom.escalade.repository.SiteRepository;

@Service("CommentaireService")
public class CommentaireServiceImpl implements CommentaireService{

	CommentaireRepository commentaireRepository;
	
	public CommentaireServiceImpl() {
		
	}
	
	@Override
	public List<Commentaire> findAll() {
		return commentaireRepository.findAll();
	}

	public CommentaireRepository getCommentaireRepository() {
		return commentaireRepository;
	}

	@Autowired
	public void setCommentaireRepository(CommentaireRepository commentaireRepository) {
		this.commentaireRepository = commentaireRepository;
	}
	
	SiteRepository siteRepository;
	
	public SiteRepository getSiteRepository() {
		return siteRepository;
	}

	@Autowired
	public void setRepository(SiteRepository siteRepository) {
		this.siteRepository = siteRepository;
	}
	
	// si commentaireParent == null, on récupère tous les commentaires principaux d'un site
	// sinon on récupère toutes les réponses d'un commentaire spécifique
	@Transactional
	public List<Commentaire> getCommentaries(Commentaire commentaireParent, String siteId) {
		return commentaireRepository.findByCommentaireParentAndSite(
			commentaireParent, 
			siteRepository.findById(Long.parseLong(siteId)).orElse(null));
	}
	
	// on récupère toutes les réponses de tous les commentaires d'un site spécifique
	@Transactional
	public List<Commentaire> getAllResponsesOfASite(String siteId) {
		return commentaireRepository.findAllResponsesOfASite( 
			siteRepository.findById(Long.parseLong(siteId)).orElse(null));
	}
	
	// on créer en commentaire en définissant si c'est un nouveau ou une réponse d'un autre puis on le sauvegard en bd
	@Override
	@Transactional
   	public void addCommentary(Utilisateur utilisateur, String siteId, 
   			String contenu, String commentaireId) {
		
		Commentaire commentaire = new Commentaire(
				utilisateur, 
				siteRepository.findById(Long.parseLong(siteId)).orElse(null), 
				contenu);

		if (!(commentaireId.contentEquals("null")))
			commentaire.setCommentaireParent(commentaireRepository.findById(Long.parseLong(commentaireId)).orElse(null));

		commentaireRepository.save(commentaire);
   	}

	@Override
	public Optional<Commentaire> getCommentary(Long id) {
		return commentaireRepository.findById(id);
	}

	// annotation transactional obligatoire pour update ou delete
	// ces deux méthodes sont utilisés uniquement par un membre de l'association
	
	@Override
	@Transactional
	public void editerCommentaire(String id, String contenu) {
		commentaireRepository.updateContenu(Long.parseLong(id), contenu);
	}
	
	@Transactional
	public void supprimerCommentaire(String commentaireId) {
		commentaireRepository.deleteById(Long.parseLong(commentaireId));
	}
	
	
}
