package com.openclassroom.escalade.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.CotationBloc;
import com.openclassroom.escalade.domain.CotationFalaise;
import com.openclassroom.escalade.domain.Departement;
import com.openclassroom.escalade.domain.Longueur;
import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.domain.Voie;
import com.openclassroom.escalade.repository.LongueurRepository;
import com.openclassroom.escalade.repository.SecteurRepository;
import com.openclassroom.escalade.repository.SiteRepository;
import com.openclassroom.escalade.repository.VoieRepository;

@Service("criteriaSearchService")
public class CriteriaSearchServiceImpl implements CriteriaSearchService {

	public CriteriaSearchServiceImpl() {

	}

	SiteRepository siteRepository;

	@Autowired
	public void setSiteRepository(SiteRepository siteRepository) {
		this.siteRepository = siteRepository;
	}

	VoieRepository voieRepository;

	@Autowired
	public void setVoieRepository(VoieRepository voieRepository) {
		this.voieRepository = voieRepository;
	}

	SecteurRepository secteurRepository;

	@Autowired
	public void setSecteurRepository(SecteurRepository secteurRepository) {
		this.secteurRepository = secteurRepository;
	}

	private LongueurRepository longueurRepository;

	@Autowired
	public void setLongueurRepository(LongueurRepository longueurRepository) {
		this.longueurRepository = longueurRepository;
	}

	// Cette méthode est la seule de ce service appelé par une servlet. Les autres
	// sont appelés par cette méthode elle même. Ils correspondent aux 4 critères de
	// recherche.
	@Override
	@Transactional
	public List<Site> searchSites(List<String> criteriaList) {

		int nbCritereVide = 0;
		for (String s : criteriaList) {
			if (s.isEmpty())
				nbCritereVide++;
		}
		if (nbCritereVide == criteriaList.size())
			return siteRepository.findByOrderByIdAsc();

		List<Site> listeSites = new ArrayList<Site>();

		String departement = criteriaList.get(0);
		String cotation = criteriaList.get(1);
		String minimumSecteurNb = criteriaList.get(2);
		String minimumVoieNb = criteriaList.get(3);

		// les critères sont parcourus de façon à ce que si plusieurs sont retenus alors
		// la recherche doit tenir compte des restrictions des deux
		if (!(departement.isEmpty())) {
			listeSites.addAll(searchWithDepartement(departement));
			if (!(cotation.isEmpty()))
				listeSites.retainAll(searchWithCotation(cotation, listeSites));
			if (!(minimumSecteurNb.isEmpty()))
				listeSites.retainAll(searchWithMinimumSecteurNb(minimumSecteurNb, listeSites));
			if (!(minimumVoieNb.isEmpty()))
				listeSites.retainAll(searchWithMinimumVoieNb(minimumVoieNb, listeSites));
		} else if (!(cotation.isEmpty())) {
			listeSites.addAll(searchWithCotation(cotation, siteRepository.findAll()));
			if (!(minimumSecteurNb.isEmpty()))
				listeSites.retainAll(searchWithMinimumSecteurNb(minimumSecteurNb, listeSites));
			if (!(minimumVoieNb.isEmpty()))
				listeSites.retainAll(searchWithMinimumVoieNb(minimumVoieNb, listeSites));
		} else if (!(minimumSecteurNb.isEmpty())) {
			listeSites.addAll(searchWithMinimumSecteurNb(minimumSecteurNb, siteRepository.findAll()));
			if (!(minimumVoieNb.isEmpty()))
				listeSites.retainAll(searchWithMinimumVoieNb(minimumVoieNb, listeSites));
		} else if (!(minimumVoieNb.isEmpty())) {
			listeSites.addAll(searchWithMinimumVoieNb(minimumVoieNb, siteRepository.findAll()));
		}
		return listeSites;
	}

	@Override
	public List<Site> searchWithDepartement(String criteria) {
		return siteRepository.findByDepartement(Departement.from(criteria));
	}

	@Override
	@Transactional
	public List<Site> searchWithCotation(String criteria, List<Site> listeSites) {
		List<Voie> listeVoies = new ArrayList<Voie>();
		List<Longueur> listeLongueurs = new ArrayList<Longueur>();

		CotationBloc cotationBloc = CotationBloc.from(criteria);
		CotationFalaise cotationFalaise = CotationFalaise.from(criteria);

		if (cotationBloc == null) {
			listeVoies.addAll(voieRepository.findByCotationFalaise(cotationFalaise));
			listeLongueurs.addAll(longueurRepository.findByCotationFalaise(cotationFalaise));
		} else {
			listeVoies.addAll(voieRepository.findByCotationBloc(cotationBloc));
			listeLongueurs.addAll(longueurRepository.findByCotationBloc(cotationBloc));
		}
		return siteRepository.findByVoieOrLongueur(listeVoies, listeLongueurs, listeSites);
	}

	@Override
	@Transactional
	public List<Site> searchWithMinimumSecteurNb(String criteria, List<Site> listeSites) {
		List<Site> listeSitesTemp = new ArrayList<Site>();
		for (Site s : listeSites) {
			long nbSecteurs = secteurRepository.countBySite(s);
			if (nbSecteurs >= Long.parseLong(criteria)) {
				listeSitesTemp.add(s);
			}
		}
		return listeSitesTemp;
	}

	@Override
	@Transactional
	public List<Site> searchWithMinimumVoieNb(String criteria, List<Site> listeSites) {
		List<Site> listeSitesTemp = new ArrayList<Site>();
		for (Site s : listeSites) {
			long nbVoies = voieRepository.countBySite(s);
			if (nbVoies >= Long.parseLong(criteria)) {
				listeSitesTemp.add(s);
			}
		}
		return listeSitesTemp;
	}

}
