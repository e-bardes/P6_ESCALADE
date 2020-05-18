package com.openclassroom.escalade.service;

import java.util.List;
import java.util.Optional;

import com.openclassroom.escalade.domain.Site;

public interface SiteService {

	public void initialize();
	
	Optional<Site> findById(Long id);
	
	public List<Site> getAllSites();
	
	List<Site> findAll();
}
