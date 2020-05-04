package com.openclassroom.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.domain.UtilisateurConnecte;
import com.openclassroom.escalade.repository.UtilisateurConnecteRepository;

@Service("utilisateurConnecteService")
public class UtilisateurConnecteServiceImpl implements UtilisateurConnecteService{

	private UtilisateurConnecteRepository repository;
	
	public UtilisateurConnecteServiceImpl() {
		
	}
	
	@Override
	public <S extends UtilisateurConnecte> S save(S entity) {
		return repository.save(entity);
	}

	
	public UtilisateurConnecteRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(UtilisateurConnecteRepository repository) {
		System.out.println("validation1");
		this.repository = repository;
	}

	@Override
	public List<UtilisateurConnecte> findAll() {
		return repository.findAll();
	}
}
