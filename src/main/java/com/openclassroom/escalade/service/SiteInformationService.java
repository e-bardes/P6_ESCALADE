package com.openclassroom.escalade.service;

import java.util.List;
import java.util.Optional;

import com.openclassroom.escalade.domain.Secteur;
import com.openclassroom.escalade.domain.Site;

public interface SiteInformationService {

	// méthodes liés uniquement au repository Site

	List<Site> getAllSites();

	Optional<Site> getSiteDetails(String siteId);

	Secteur getSecteurDetails(String secteurId);

	Long getSiteIdWithSecteurId(String secteurId);

	List<Integer> getNbSecteursOfSelectedSites(List<Site> listeSites);

	List<Integer> getNbVoiesOfSelectedSites(List<Site> listeSites);

	List<List<Object>> getMinAndMaxCotationOfSelectedSites(List<Site> listeSites);

}
