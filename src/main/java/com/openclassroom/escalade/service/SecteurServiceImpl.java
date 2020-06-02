// pas encore utilisé

package com.openclassroom.escalade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.repository.SecteurRepository;
import com.openclassroom.escalade.repository.SiteRepository;

@Service("secteurService")
public class SecteurServiceImpl implements SecteurService {
	 
	private SecteurRepository repository;
	
	private SiteRepository siteRepository;
	
	public SecteurServiceImpl() {
	}
	
	public SecteurRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(SecteurRepository repository) {
		this.repository = repository;
	}
	
	public SiteRepository getSiteRepository() {
		return siteRepository;
	}

	@Autowired
	public void setSiteRepository(SiteRepository siteRepository) {
		this.siteRepository = siteRepository;
	}
}
