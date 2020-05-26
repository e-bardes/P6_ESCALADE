// pas encore utilisé

package com.openclassroom.escalade.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.domain.Longueur;
import com.openclassroom.escalade.domain.LongueurBloc;
import com.openclassroom.escalade.domain.LongueurFalaise;
import com.openclassroom.escalade.repository.LongueurRepository;

@Service("longueurService")
public class LongueurServiceImpl implements LongueurService {

	LongueurRepository repository;
	
	VoieService voieService;
	
	public LongueurServiceImpl() {
		System.out.println("LongueurServiceImpl no args contructor");
	}
	
	
	@PostConstruct
	public void initialize() {
		System.out.println("Longueur initialize");
		Longueur longueur1 = new LongueurBloc();
		Longueur longueur2 = new LongueurBloc();
		Longueur longueur3 = new LongueurBloc();
		Longueur longueur4 = new LongueurBloc();
		Longueur longueur5 = new LongueurBloc();
		Longueur longueur6 = new LongueurBloc();
		Longueur longueur7 = new LongueurFalaise();
		Longueur longueur8 = new LongueurFalaise();
		Longueur longueur9 = new LongueurFalaise();
		Longueur longueur10 = new LongueurFalaise();
		Longueur longueur11 = new LongueurFalaise();
//		longueur1.setVoie(voieService.findById(1l).orElse(null));
//		longueur2.setVoie(voieService.findById(2l).orElse(null));
//		longueur3.setVoie(voieService.findById(3l).orElse(null));
//		longueur4.setVoie(voieService.findById(4l).orElse(null));
//		longueur5.setVoie(voieService.findById(4l).orElse(null));
//		longueur6.setVoie(voieService.findById(5l).orElse(null));
//		longueur7.setVoie(voieService.findById(5l).orElse(null));
//		longueur8.setVoie(voieService.findById(6l).orElse(null));
//		longueur9.setVoie(voieService.findById(7l).orElse(null));
//		longueur10.setVoie(voieService.findById(8l).orElse(null));
//		longueur11.setVoie(voieService.findById(9l).orElse(null));
//		List<Longueur> listeLongueurs = Arrays.asList(longueur1, longueur2, longueur3, longueur4, longueur5, longueur6, 
//				longueur7, longueur8, longueur9, longueur10, longueur11);
//		repository.saveAll(listeLongueurs);
	}
	
	
	public LongueurRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(LongueurRepository repository) {
		System.out.println("LongueurRepository setter");
		this.repository = repository;
	}
	
	public VoieService getVoieService() {
		return voieService;
	}
	
	@Autowired
	public void setVoieService(VoieService voieService) {
		System.out.println("VoieService Setter dans Longueur");
		this.voieService = voieService;
	}
	
	
}
