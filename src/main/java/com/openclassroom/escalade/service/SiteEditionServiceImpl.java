package com.openclassroom.escalade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.CotationBloc;
import com.openclassroom.escalade.domain.CotationFalaise;
import com.openclassroom.escalade.domain.Longueur;
import com.openclassroom.escalade.domain.Secteur;
import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.domain.Voie;
import com.openclassroom.escalade.repository.LongueurRepository;
import com.openclassroom.escalade.repository.SecteurRepository;
import com.openclassroom.escalade.repository.SiteRepository;
import com.openclassroom.escalade.repository.VoieRepository;

@Service("siteEditionService")
public class SiteEditionServiceImpl implements SiteEditionService {

	public SiteEditionServiceImpl() {

	}

	SiteRepository siteRepository;

	@Autowired
	public void setSiteRepository(SiteRepository siteRepository) {
		this.siteRepository = siteRepository;
	}

	SecteurRepository secteurRepository;

	@Autowired
	public void setSecteurRepository(SecteurRepository secteurRepository) {
		this.secteurRepository = secteurRepository;
	}

	VoieRepository voieRepository;

	@Autowired
	public void setVoieRepository(VoieRepository voieRepository) {
		this.voieRepository = voieRepository;
	}

	LongueurRepository longueurRepository;

	@Autowired
	public void setLongueurRepository(LongueurRepository longueurRepository) {
		this.longueurRepository = longueurRepository;
	}

	@Override
	@Transactional
	public void deleteVoie(String voieId) {
		voieRepository.deleteById(Long.parseLong(voieId));
	}

	@Override
	@Transactional
	public void deleteSecteur(String secteurId) {
		secteurRepository.deleteById(Long.parseLong(secteurId));
	}

	@Override
	@Transactional
	public void deleteLongueur(String longueurId) {
		longueurRepository.deleteById(Long.parseLong(longueurId));
	}

	@Override
	public void addVoieInSecteur(String valeurCotation, String isEquipe, String secteurId) {

		if (CotationBloc.from(valeurCotation) != null) {
			Voie voie = new Voie(isEquipe != null, CotationBloc.from(valeurCotation));
			voie.setSecteur(secteurRepository.findById(Long.parseLong(secteurId)).orElse(null));
			voieRepository.save(voie);
		} else {
			Voie voie = new Voie(isEquipe != null, CotationFalaise.from(valeurCotation));
			voie.setSecteur(secteurRepository.findById(Long.parseLong(secteurId)).orElse(null));
			voieRepository.save(voie);
		}
	}

	@Override
	public void addVoieInSite(String valeurCotation, String isEquipe, String siteId) {

		if (CotationBloc.from(valeurCotation) != null) {
			Voie voie = new Voie(isEquipe != null, CotationBloc.from(valeurCotation));
			voie.setSite(siteRepository.findById(Long.parseLong(siteId)).orElse(null));
			voieRepository.save(voie);
		} else {
			Voie voie = new Voie(isEquipe != null, CotationFalaise.from(valeurCotation));
			voie.setSite(siteRepository.findById(Long.parseLong(siteId)).orElse(null));
			voieRepository.save(voie);
		}
	}

	@Override
	public void addLongueur(String valeurCotation, String voieId) {

		if (CotationBloc.from(valeurCotation) != null) {
			Longueur longueur = new Longueur(CotationBloc.from(valeurCotation));
			longueur.setVoie(voieRepository.findById(Long.parseLong(voieId)).orElse(null));
			longueurRepository.save(longueur);
		} else {
			Longueur longueur = new Longueur(CotationFalaise.from(valeurCotation));
			longueur.setVoie(voieRepository.findById(Long.parseLong(voieId)).orElse(null));
			longueurRepository.save(longueur);
		}
	}

	@Override
	@Transactional
	public void editerNomSecteur(String id, String nom) {
		secteurRepository.updateNom(Long.parseLong(id), nom);
	}

	@Override
	@Transactional
	public void editerDescriptionSite(String id, String description) {
		siteRepository.updateDescription(Long.parseLong(id), description);
	}

	@Override
	@Transactional
	public void createSecteur(String siteId, String nom) {
		Secteur secteur = new Secteur(nom);
		secteur.setSite(siteRepository.findById(Long.parseLong(siteId)).orElse(null));
		secteurRepository.save(secteur);
	}

	@Override
	@Transactional
	public void modifierOfficialisation(String siteId) {
		Long id = Long.parseLong(siteId);

		Site site = siteRepository.findById(id).orElse(null);

		// inverssement du booléen
		if (site.isOfficielLesAmisDeLescalade())
			siteRepository.updateOfficialisation(id, false);
		else
			siteRepository.updateOfficialisation(id, true);
	}

	@Override
	@Transactional
	public void editerDescriptionSecteur(String id, String description) {
		secteurRepository.updateDescription(Long.parseLong(id), description);
	}
}
