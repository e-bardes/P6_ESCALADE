package com.openclassroom.escalade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.Commentaire;
import com.openclassroom.escalade.domain.Site;

//@Transactional(readOnly = true)
@Repository("commentaireResitory")
public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{

	@Override
	List<Commentaire> findAll();
	
	@Override 
	<S extends Commentaire> S save(S entity);
	
	List<Commentaire> findBySite(Site site);
	
	
	
}
