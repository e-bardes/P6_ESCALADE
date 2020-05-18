package com.openclassroom.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.domain.Commentaire;
import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.repository.CommentaireRepository;

@Service("CommentaireService")
public class CommentaireServiceImpl implements CommentaireService{

	CommentaireRepository repository;
	
	public CommentaireServiceImpl() {
		
	}
	
	@Override
	public List<Commentaire> findAll() {
		return repository.findAll();
	}

	public CommentaireRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(CommentaireRepository repository) {
		this.repository = repository;
	}

	@Override
	public <S extends Commentaire> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public List<Commentaire> findBySite(Site site) {
		return repository.findBySite(site);
	}

	
	
}
