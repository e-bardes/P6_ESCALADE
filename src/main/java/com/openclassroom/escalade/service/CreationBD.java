package com.openclassroom.escalade.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.domain.CotationBloc;
import com.openclassroom.escalade.domain.CotationFalaise;
import com.openclassroom.escalade.domain.Departement;
import com.openclassroom.escalade.domain.Longueur;
import com.openclassroom.escalade.domain.Secteur;
import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.domain.Topo;
import com.openclassroom.escalade.domain.Voie;
import com.openclassroom.escalade.repository.LongueurRepository;
import com.openclassroom.escalade.repository.SecteurRepository;
import com.openclassroom.escalade.repository.SiteRepository;
import com.openclassroom.escalade.repository.TopoRepository;
import com.openclassroom.escalade.repository.VoieRepository;

@Service("creationBD")
public class CreationBD {

	private TopoRepository topoRepository;

	@Autowired
	public void setTopoRepository(TopoRepository topoRepository) {
		this.topoRepository = topoRepository;
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

	public CreationBD() {
	}

	@PostConstruct
	public void initialize() {
		Topo topo1 = new Topo("region1");
		Topo topo2 = new Topo("region2");
		List<Topo> listeTopos = Arrays.asList(topo1, topo2);
		topoRepository.saveAll(listeTopos);

		Site site1 = new Site("nom1", Departement.alpes_de_haute_provence, true);
		Site site2 = new Site("nom2", Departement.gard, false);
		Site site3 = new Site("nom3", Departement.hautes_pyrenees, false);
		Site site4 = new Site("nom4", Departement.lozere, false);
		Site site5 = new Site("nom5", Departement.seine_et_marne, true);
		Site site6 = new Site("nom6", Departement.vaucluse, true);
		site1.setTopo(topoRepository.findById(1l).orElse(null));
		site2.setTopo(topoRepository.findById(2l).orElse(null));
		site3.setTopo(topoRepository.findById(1l).orElse(null));
		site4.setTopo(topoRepository.findById(2l).orElse(null));
		site5.setTopo(topoRepository.findById(1l).orElse(null));
		site6.setTopo(topoRepository.findById(1l).orElse(null));
		List<Site> listeSites = Arrays.asList(site1, site2, site3, site4, site5, site6);
		siteRepository.saveAll(listeSites);

		Secteur secteur1 = new Secteur("nom1");
		Secteur secteur2 = new Secteur("nom2");
		Secteur secteur3 = new Secteur("nom3");
		Secteur secteur4 = new Secteur("nom4");
		Secteur secteur5 = new Secteur("nom5");
		Secteur secteur6 = new Secteur("nom6");
		Secteur secteur7 = new Secteur("nom7");
		Secteur secteur8 = new Secteur("nom8");
		secteur1.setSite(siteRepository.findById(1l).orElse(null));
		secteur2.setSite(siteRepository.findById(1l).orElse(null));
		secteur3.setSite(siteRepository.findById(2l).orElse(null));
		secteur4.setSite(siteRepository.findById(3l).orElse(null));
		secteur5.setSite(siteRepository.findById(4l).orElse(null));
		secteur6.setSite(siteRepository.findById(5l).orElse(null));
		secteur7.setSite(siteRepository.findById(5l).orElse(null));
		secteur8.setSite(siteRepository.findById(6l).orElse(null));
		List<Secteur> listeSecteurs = Arrays.asList(secteur1, secteur2, secteur3, secteur4, secteur5, secteur6,
				secteur7, secteur8);
		secteurRepository.saveAll(listeSecteurs);

		Voie voie1 = new Voie(false, CotationBloc._4);
		Voie voie2 = new Voie(false, CotationBloc._5);
		Voie voie3 = new Voie(true, CotationBloc._6Cplus);
		Voie voie4 = new Voie(true, CotationBloc._5plus);
		Voie voie5 = new Voie(false, CotationFalaise._3);
		Voie voie6 = new Voie(false, CotationFalaise._4a);
		Voie voie7 = new Voie(true, CotationFalaise._6a);
		Voie voie8 = new Voie(true, CotationFalaise._7cPlus);
		Voie voie9 = new Voie(true, CotationFalaise._3Plus);
		voie1.setSecteur(secteurRepository.findById(1l).orElse(null));
		voie3.setSecteur(secteurRepository.findById(1l).orElse(null));
		voie5.setSecteur(secteurRepository.findById(2l).orElse(null));
		voie7.setSecteur(secteurRepository.findById(3l).orElse(null));
		voie9.setSecteur(secteurRepository.findById(4l).orElse(null));
		voie2.setSite(siteRepository.findById(5l).orElse(null));
		voie4.setSite(siteRepository.findById(5l).orElse(null));
		voie6.setSite(siteRepository.findById(6l).orElse(null));
		voie8.setSite(siteRepository.findById(6l).orElse(null));

		List<Voie> listeVoies = Arrays.asList(voie1, voie2, voie3, voie4, voie5, voie6, voie7, voie8, voie9);
		voieRepository.saveAll(listeVoies);

		Longueur longueur1 = new Longueur(CotationBloc._4);
		Longueur longueur2 = new Longueur(CotationBloc._5);
		Longueur longueur3 = new Longueur(CotationBloc._6Cplus);
		Longueur longueur4 = new Longueur(CotationBloc._5plus);
		Longueur longueur5 = new Longueur(CotationFalaise._3);
		Longueur longueur6 = new Longueur(CotationFalaise._4a);
		Longueur longueur7 = new Longueur(CotationFalaise._6a);
		Longueur longueur8 = new Longueur(CotationFalaise._7cPlus);
		Longueur longueur9 = new Longueur(CotationFalaise._3Plus);
		Longueur longueur10 = new Longueur(CotationBloc._6A);
		Longueur longueur11 = new Longueur(CotationFalaise._8a);
		longueur1.setVoie(voieRepository.findById(1l).orElse(null));
		longueur2.setVoie(voieRepository.findById(2l).orElse(null));
		longueur3.setVoie(voieRepository.findById(3l).orElse(null));
		longueur4.setVoie(voieRepository.findById(4l).orElse(null));
		longueur5.setVoie(voieRepository.findById(4l).orElse(null));
		longueur6.setVoie(voieRepository.findById(5l).orElse(null));
		longueur7.setVoie(voieRepository.findById(5l).orElse(null));
		longueur8.setVoie(voieRepository.findById(6l).orElse(null));
		longueur9.setVoie(voieRepository.findById(7l).orElse(null));
		longueur10.setVoie(voieRepository.findById(8l).orElse(null));
		longueur11.setVoie(voieRepository.findById(9l).orElse(null));
		List<Longueur> listeLongueurs = Arrays.asList(longueur1, longueur2, longueur3, longueur4, longueur5, longueur6,
				longueur7, longueur8, longueur9, longueur10, longueur11);
		longueurRepository.saveAll(listeLongueurs);
	}
}
