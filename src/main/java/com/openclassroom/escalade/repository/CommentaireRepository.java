package com.openclassroom.escalade.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.Commentaire;
import com.openclassroom.escalade.domain.Site;

@Repository("commentaireResitory")
public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{

	@Override
	List<Commentaire> findAll();
	
	@Override 
	<S extends Commentaire> S save(S entity);
	
	@Override
	Optional<Commentaire> findById(Long id);
	
	List<Commentaire> findBySite(Site site);
	
	List<Commentaire> findByCommentaireParentAndSite(Commentaire commentaireParent, Site site);
	
	@Query("SELECT c FROM Commentaire c WHERE c.commentaireParent IS NOT NULL AND c.site = :site")
	List<Commentaire> findAllResponsesOfASite(@Param("site") Site site);
	
	@Modifying
	@Query("UPDATE Commentaire c SET c.contenu = ?2 WHERE c.id = ?1")
	void updateContenu(Long id, String contenu);
	
	@Override 
	void deleteById(Long id);

}
