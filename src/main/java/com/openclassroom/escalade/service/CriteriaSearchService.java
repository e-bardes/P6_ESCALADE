package com.openclassroom.escalade.service;

import java.util.List;

import com.openclassroom.escalade.domain.Site;

public interface CriteriaSearchService {

	List<Site> searchSites(List<String> criteriaList);

	List<Site> searchWithDepartement(String criteria);

	List<Site> searchWithCotation(String criteria, List<Site> listeSites);

	List<Site> searchWithMinimumSecteurNb(String criteria, List<Site> listeSites);

	List<Site> searchWithMinimumVoieNb(String criteria, List<Site> listeSites);

}
