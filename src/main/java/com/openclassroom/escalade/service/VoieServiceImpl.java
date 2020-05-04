package com.openclassroom.escalade.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.domain.VoieBloc;
import com.openclassroom.escalade.repository.VoieBlocRepository;

@Service("voieService")
public class VoieServiceImpl implements VoieService {
	
	VoieBlocRepository repository;
	
	SecteurService secteurService;
		
	public VoieServiceImpl() {
		System.out.println("VoieServiceImpl no args contructor");
	}
	
	@PostConstruct
	public void initialize() {
		System.out.println("Voie initialize");
		VoieBloc voie1 = new VoieBloc();
		VoieBloc voie2 = new VoieBloc();
		VoieBloc voie3 = new VoieBloc();
		VoieBloc voie4 = new VoieBloc();
		VoieBloc voie5 = new VoieBloc();
		VoieBloc voie6 = new VoieBloc();
		VoieBloc voie7 = new VoieBloc();
		VoieBloc voie8 = new VoieBloc();
		VoieBloc voie9 = new VoieBloc();
		voie1.setSecteur(secteurService.findById(1l).orElse(null));
		voie2.setSecteur(secteurService.findById(2l).orElse(null));
		voie3.setSecteur(secteurService.findById(3l).orElse(null));
		voie4.setSecteur(secteurService.findById(4l).orElse(null));
		voie5.setSecteur(secteurService.findById(4l).orElse(null));
		voie6.setSecteur(secteurService.findById(5l).orElse(null));
		voie7.setSecteur(secteurService.findById(5l).orElse(null));
		voie8.setSecteur(secteurService.findById(6l).orElse(null));
		voie9.setSecteur(secteurService.findById(7l).orElse(null));
		List<VoieBloc> listeVoies = Arrays.asList(voie1, voie2, voie3, voie4, voie5, voie6, voie7, voie8, voie9);
		repository.saveAll(listeVoies);
	}
	
	
	public VoieBlocRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(VoieBlocRepository repository) {
		System.out.println("VoieRepository setter");
		this.repository = repository;
	}
	
	public SecteurService getSiteService() {
		return secteurService;
	}
	
	@Autowired
	public void setSecteurService(SecteurService secteurService) {
		System.out.println("SecteurService Setter dans Voie");
		this.secteurService = secteurService;
	}

	@Override
	public Optional<VoieBloc> findById(Long id) {
		return repository.findById(id);
	}

}
