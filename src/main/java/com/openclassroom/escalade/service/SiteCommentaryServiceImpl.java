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

@Service("siteCommentaryService")
public class SiteCommentaryServiceImpl implements SiteCommentaryService {

	public SiteCommentaryServiceImpl() {

	}

	CommentaireRepository commentaireRepository;

	@Autowired
	public void setCommentaireRepository(CommentaireRepository commentaireRepository) {
		this.commentaireRepository = commentaireRepository;
	}

	SiteRepository siteRepository;

	@Autowired
	public void setSiteRepository(SiteRepository siteRepository) {
		this.siteRepository = siteRepository;
	}

	// si commentaireParent == null, on récupère tous les commentaires principaux
	// d'un site sinon on récupère toutes les réponses d'un commentaire spécifique
	@Override
	@Transactional
	public List<Commentaire> getCommentaries(Commentaire commentaireParent, String siteId) {
		return commentaireRepository.findByCommentaireParentAndSite(commentaireParent,
				siteRepository.findById(Long.parseLong(siteId)).orElse(null));
	}

	// on récupère toutes les réponses de tous les commentaires d'un site spécifique
	@Override
	@Transactional
	public List<Commentaire> getAllResponsesOfASite(String siteId) {
		return commentaireRepository
				.findAllResponsesOfASite(siteRepository.findById(Long.parseLong(siteId)).orElse(null));
	}

	// on créer en commentaire en définissant si c'est un nouveau ou une réponse
	// d'un autre puis on le sauvegard en base de données
	@Override
	@Transactional
	public void addCommentary(Utilisateur utilisateur, String siteId, String contenu, String commentaireId) {

		Commentaire commentaire = new Commentaire(utilisateur,
				siteRepository.findById(Long.parseLong(siteId)).orElse(null), contenu);

		if (!(commentaireId.contentEquals("null"))) {
			commentaire
					.setCommentaireParent(commentaireRepository.findById(Long.parseLong(commentaireId)).orElse(null));
		}
		commentaireRepository.save(commentaire);
	}

	@Override
	public Optional<Commentaire> getCommentary(Long id) {
		return commentaireRepository.findById(id);
	}

	@Override
	@Transactional
	public void editCommentary(String id, String contenu) {
		commentaireRepository.updateContenu(Long.parseLong(id), contenu);
	}

	// si c'est un commentaire parent alors il va entraîner la suppression de ses
	// réponses
	@Override
	@Transactional
	public void deleteCommentary(String commentaireId) {
		commentaireRepository.deleteById(Long.parseLong(commentaireId));
	}

}
