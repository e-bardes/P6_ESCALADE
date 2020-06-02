// pas encore utilisé

package com.openclassroom.escalade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.repository.SecteurRepository;
import com.openclassroom.escalade.repository.VoieRepository;

@Service("voieService")
public class VoieServiceImpl implements VoieService {
	
	VoieRepository voieRepository;
	
	SecteurRepository secteurRepository;
	
	public VoieServiceImpl() {
	}
	
	public VoieRepository getVoieRepository() {
		return voieRepository;
	}

	@Autowired
	public void setVoieRepository(VoieRepository voieRepository) {
		this.voieRepository = voieRepository;
	}
	
	public SecteurRepository getSecteurRepository() {
		return secteurRepository;
	}

	@Autowired
	public void setSecteurRepository(SecteurRepository secteurRepository) {
		this.secteurRepository = secteurRepository;
	}
}
