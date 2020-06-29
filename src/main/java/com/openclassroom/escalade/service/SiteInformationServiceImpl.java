package com.openclassroom.escalade.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.domain.CotationBloc;
import com.openclassroom.escalade.domain.CotationFalaise;
import com.openclassroom.escalade.domain.Secteur;
import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.domain.Voie;
import com.openclassroom.escalade.repository.SecteurRepository;
import com.openclassroom.escalade.repository.SiteRepository;
import com.openclassroom.escalade.repository.VoieRepository;

@Service("siteInformationService")
public class SiteInformationServiceImpl implements SiteInformationService {

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

	public SiteInformationServiceImpl() {

	}

	@Override
	public Optional<Site> getSiteDetails(String siteId) {
		return siteRepository.findById(Long.parseLong(siteId));
	}

	@Override
	public List<Site> getAllSites() {
		return siteRepository.findByOrderByIdAsc();
	}

	@Override
	public Secteur getSecteurDetails(String secteurId) {
		return secteurRepository.findById(Long.parseLong(secteurId)).orElse(null);
	}

	@Override
	public Long getSiteIdWithSecteurId(String secteurId) {
		return siteRepository.findBySecteurId(Long.parseLong(secteurId));
	}

	@Override
	public List<Integer> getNbSecteursOfSelectedSites(List<Site> listeSites) {
		List<Integer> listeNbSecteurs = new ArrayList<Integer>();
		for (Site si : listeSites) {
			listeNbSecteurs.add(si.getListeSecteurs().size());
		}
		return listeNbSecteurs;
	}

	@Override
	public List<Integer> getNbVoiesOfSelectedSites(List<Site> listeSites) {
		List<Integer> listeNbVoies = new ArrayList<Integer>();
		for (Site si : listeSites) {
			listeNbVoies.add(si.getListeVoies().size());
			for (Secteur se : si.getListeSecteurs()) {
				listeNbVoies.set(listeNbVoies.size() - 1,
						listeNbVoies.get(listeNbVoies.size() - 1) + se.getListeVoies().size());
			}
		}
		return listeNbVoies;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<List<Object>> getMinAndMaxCotationOfSelectedSites(List<Site> listeSites) {

		// le but va être de remplir ces listes de façon à ce que l'index des cotations
		// corresponde à celui de la liste des sites. On aura donc pour chaque index
		// soit les cotations Bloc à null soit les cotation Falaise à null. Cela
		// permettra au final de traverser toutes les listes avec un seule boucle dans
		// une jsp. On stocke des Object car les deux types de cotations sont des
		// énumérations différentes.
		List<Object> listeCotationBlocMin = new ArrayList<Object>();
		List<Object> listeCotationBlocMax = new ArrayList<Object>();
		List<Object> listeCotationFalaiseMin = new ArrayList<Object>();
		List<Object> listeCotationFalaiseMax = new ArrayList<Object>();

		for (Site si : listeSites) {
			listeCotationBlocMin.add(null);
			listeCotationBlocMax.add(null);
			listeCotationFalaiseMin.add(null);
			listeCotationFalaiseMax.add(null);
			for (Voie v : si.getListeVoies()) {
				if (v.getCotationBloc() != null) {
					if (listeCotationBlocMin.get(listeCotationBlocMin.size() - 1) == null
							&& listeCotationBlocMax.get(listeCotationBlocMax.size() - 1) == null) {
						listeCotationBlocMin.set(listeCotationBlocMin.size() - 1, v.getCotationBloc());
						listeCotationBlocMax.set(listeCotationBlocMax.size() - 1, v.getCotationBloc());
					} else if (v.getCotationBloc().ordinal() < ((Enum<CotationBloc>) listeCotationBlocMin
							.get(listeCotationBlocMin.size() - 1)).ordinal()) {
						listeCotationBlocMin.set(listeCotationBlocMin.size() - 1, v.getCotationBloc());
					} else if (v.getCotationBloc().ordinal() > ((Enum<CotationBloc>) listeCotationBlocMax
							.get(listeCotationBlocMax.size() - 1)).ordinal()) {
						listeCotationBlocMax.set(listeCotationBlocMax.size() - 1, v.getCotationBloc());
					}
				} else {
					if (listeCotationFalaiseMin.get(listeCotationFalaiseMin.size() - 1) == null
							&& listeCotationFalaiseMax.get(listeCotationFalaiseMax.size() - 1) == null) {
						listeCotationFalaiseMin.set(listeCotationFalaiseMin.size() - 1, v.getCotationFalaise());
						listeCotationFalaiseMax.set(listeCotationFalaiseMax.size() - 1, v.getCotationFalaise());
					} else if (v.getCotationFalaise().ordinal() < ((Enum<CotationFalaise>) listeCotationFalaiseMin
							.get(listeCotationFalaiseMin.size() - 1)).ordinal()) {
						listeCotationFalaiseMin.set(listeCotationFalaiseMin.size() - 1, v.getCotationFalaise());
					} else if (v.getCotationFalaise().ordinal() > ((Enum<CotationFalaise>) listeCotationFalaiseMax
							.get(listeCotationFalaiseMax.size() - 1)).ordinal()) {
						listeCotationFalaiseMax.set(listeCotationFalaiseMax.size() - 1, v.getCotationFalaise());
					}
				}
			}
			for (Secteur se : si.getListeSecteurs()) {
				for (Voie v : se.getListeVoies()) {
					if (v.getCotationBloc() != null) {
						if (listeCotationBlocMin.get(listeCotationBlocMin.size() - 1) == null
								&& listeCotationBlocMax.get(listeCotationBlocMax.size() - 1) == null) {
							listeCotationBlocMin.set(listeCotationBlocMin.size() - 1, v.getCotationBloc());
							listeCotationBlocMax.set(listeCotationBlocMax.size() - 1, v.getCotationBloc());
						} else if (v.getCotationBloc().ordinal() < ((Enum<CotationBloc>) listeCotationBlocMin
								.get(listeCotationBlocMin.size() - 1)).ordinal()) {
							listeCotationBlocMin.set(listeCotationBlocMin.size() - 1, v.getCotationBloc());
						} else if (v.getCotationBloc().ordinal() > ((Enum<CotationBloc>) listeCotationBlocMax
								.get(listeCotationBlocMax.size() - 1)).ordinal()) {
							listeCotationBlocMax.set(listeCotationBlocMax.size() - 1, v.getCotationBloc());
						}
					} else {
						if (listeCotationFalaiseMin.get(listeCotationFalaiseMin.size() - 1) == null
								&& listeCotationFalaiseMax.get(listeCotationFalaiseMax.size() - 1) == null) {
							listeCotationFalaiseMin.set(listeCotationFalaiseMin.size() - 1, v.getCotationFalaise());
							listeCotationFalaiseMax.set(listeCotationFalaiseMax.size() - 1, v.getCotationFalaise());
						} else if (v.getCotationFalaise().ordinal() < ((Enum<CotationFalaise>) listeCotationFalaiseMin
								.get(listeCotationFalaiseMin.size() - 1)).ordinal()) {
							listeCotationFalaiseMin.set(listeCotationFalaiseMin.size() - 1, v.getCotationFalaise());
						} else if (v.getCotationFalaise().ordinal() > ((Enum<CotationFalaise>) listeCotationFalaiseMax
								.get(listeCotationFalaiseMax.size() - 1)).ordinal()) {
							listeCotationFalaiseMax.set(listeCotationFalaiseMax.size() - 1, v.getCotationFalaise());
						}
					}
				}
			}
		}

		List<List<Object>> cotationList = new ArrayList<List<Object>>();
		cotationList.add(listeCotationBlocMin);
		cotationList.add(listeCotationBlocMax);
		cotationList.add(listeCotationFalaiseMin);
		cotationList.add(listeCotationFalaiseMax);

		return cotationList;
	}
}
