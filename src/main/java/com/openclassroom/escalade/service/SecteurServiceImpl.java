// pas encore utilisé

package com.openclassroom.escalade.service;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.domain.Secteur;
import com.openclassroom.escalade.repository.SecteurRepository;

@Service("secteurService")
public class SecteurServiceImpl implements SecteurService {
	 
	private SecteurRepository repository;
	
	private SiteService siteService;
	
	public SecteurServiceImpl() {
		System.out.println("SecteurServiceImpl no args contructor");
	}

	@PostConstruct
	public void initialize() {
		System.out.println("Secteur initialize");
		Secteur secteur1 = new Secteur("nom1");
		Secteur secteur2 = new Secteur("nom2");
		Secteur secteur3 = new Secteur("nom3");
		Secteur secteur4 = new Secteur("nom4");
		Secteur secteur5 = new Secteur("nom5");
		Secteur secteur6 = new Secteur("nom6");
		Secteur secteur7 = new Secteur("nom7");
//		secteur1.setSite(siteService.findById(1l).orElse(null));
//		secteur2.setSite(siteService.findById(1l).orElse(null));
//		secteur3.setSite(siteService.findById(2l).orElse(null));
//		secteur4.setSite(siteService.findById(3l).orElse(null));
//		secteur5.setSite(siteService.findById(4l).orElse(null));
//		secteur6.setSite(siteService.findById(5l).orElse(null));
//		secteur7.setSite(siteService.findById(5l).orElse(null));
//		List<Secteur> listeSecteurs = Arrays.asList(secteur1, secteur2, secteur3, secteur4, secteur5, secteur6, secteur7);
//		repository.saveAll(listeSecteurs);
	}
	
	public SecteurRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(SecteurRepository repository) {
		System.out.println("SecteurRepository setter");
		this.repository = repository;
	}
	
	public SiteService getSiteService() {
		return siteService;
	}
	
	@Autowired
	public void setSiteService(SiteService siteService) {
		System.out.println("SiteService Setter dans Secteur");
		this.siteService = siteService;
	}

	@Override
	public Optional<Secteur> findById(Long id) {
		return repository.findById(id);
	}
}
