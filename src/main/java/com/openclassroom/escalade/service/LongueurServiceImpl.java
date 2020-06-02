// pas encore utilisé

package com.openclassroom.escalade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.repository.LongueurRepository;
import com.openclassroom.escalade.repository.VoieRepository;

@Service("longueurService")
public class LongueurServiceImpl implements LongueurService {

	LongueurRepository repository;
	
	VoieRepository voieRepository;
	
	public LongueurServiceImpl() {
	}
	
	public LongueurRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(LongueurRepository repository) {
		this.repository = repository;
	}
	
	public VoieRepository getVoieRepository() {
		return voieRepository;
	}
	
	@Autowired
	public void setVoieRepository(VoieRepository voieRepository) {
		this.voieRepository = voieRepository;
	}
	
	
}
