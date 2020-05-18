package com.openclassroom.escalade.service;

import java.util.List;

import com.openclassroom.escalade.domain.Commentaire;
import com.openclassroom.escalade.domain.Site;

public interface CommentaireService {
	
	List<Commentaire> findAll();
	
	<S extends Commentaire> S save(S entity);
	
	List<Commentaire> findBySite(Site site);
}
