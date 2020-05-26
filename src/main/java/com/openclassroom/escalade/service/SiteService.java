package com.openclassroom.escalade.service;

import java.util.List;
import java.util.Optional;

import com.openclassroom.escalade.domain.Site;

public interface SiteService {

	void initialize();
	
	List<Site> getAllSites();
	
	List<Site> findAll();

	Optional<Site> getSiteDetails(String siteId);
}
