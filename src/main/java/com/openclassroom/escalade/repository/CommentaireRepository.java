package com.openclassroom.escalade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.Commentaire;
import com.openclassroom.escalade.domain.Site;

@Repository("commentaireRepository")
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

	/*
	 * Cette méthode va permettre de récupérer tous les commentaires d'un site qui
	 * sont à la racine de tous les autres
	 */
	List<Commentaire> findByCommentaireParentAndSite(Commentaire commentaireParent, Site site);

	/*
	 * Cette méthode va permettre de récupérer toutes les réponses de tous les
	 * commentaires d'un site passé en paramètre
	 */
	@Query("SELECT c FROM Commentaire c WHERE c.commentaireParent IS NOT NULL AND c.site = :site")
	List<Commentaire> findAllResponsesOfASite(@Param("site") Site site);

	/* Cette méthode permet de modifier le contenu d'un commentaire */
	@Modifying
	@Query("UPDATE Commentaire c SET c.contenu = ?2 WHERE c.id = ?1")
	void updateContenu(Long id, String contenu);

	/*
	 * Cette méthode va permettre de trouver un commentaire grâce au Site auquel il
	 * est rattaché
	 */
	List<Commentaire> findBySite(Site site);

	/*
	 * Va permettre de supprimer un commentaire que ce soit un commentaire parent ou
	 * une de ses réponses
	 */
	@Override
	void deleteById(Long id);

}
