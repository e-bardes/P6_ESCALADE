package com.openclassroom.escalade.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.Commentaire;
import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.repository.CommentaireRepository;
import com.openclassroom.escalade.repository.SecteurRepository;
import com.openclassroom.escalade.repository.SiteRepository;
import com.openclassroom.escalade.repository.TopoRepository;
import com.openclassroom.escalade.repository.VoieRepository;

@Service("gestionSitesService")
public class GestionSitesServiceImpl implements GestionSitesService{

	// private final static Logger logger = LogManager.getLogger();
	
	CommentaireRepository commentaireRepository;
	
	public CommentaireRepository getCommentaireRepository() {
		return commentaireRepository;
	}
	
	@Autowired
	public void setCommentaireRepository(CommentaireRepository commentaireRepository) {
		this.commentaireRepository = commentaireRepository;
	}
	
	SiteRepository siteRepository;
	
	public SiteRepository getSiteRepository() {
		return siteRepository;
	}

	@Autowired
	public void setSiteRepository(SiteRepository siteRepository) {
		this.siteRepository = siteRepository;
	}
	
	VoieRepository voieRepository;
	
	public VoieRepository getVoieRepository() {
		return voieRepository;
	}
	
	@Autowired
	public void setVoieRepository(VoieRepository voieRepository) {
		this.voieRepository = voieRepository;
	}
	
	SecteurRepository secteurRepository;
	
	public SecteurRepository getSecteurRepository() {
		return secteurRepository;
	}
	
	@Autowired
	public void setSecteurRepository(SecteurRepository secteurRepository) {
		this.secteurRepository = secteurRepository;
	}
	
	private TopoRepository topoRepository;
	
	public TopoRepository getTopoRepository() {
		return topoRepository;
	}
	
	@Autowired
	public void setTopoRepository(TopoRepository topoRepository) {
		this.topoRepository = topoRepository;
	}

	public GestionSitesServiceImpl() {
		
	}

	
	// méthodes liées au repository Site

	@Override
	public Optional<Site> getSiteDetails(String siteId) {
		return siteRepository.findById(Long.parseLong(siteId));
	}
	

	@Override
	public List<Site> getAllSites() {
		return siteRepository.findByOrderByIdAsc();
	}
	
	@Override
	@Transactional
	public void modifierOfficialisation(String siteId) {
		Long id = Long.parseLong(siteId);
		
		Site site = siteRepository.findById(id).orElse(null);
		
		if (site.isOfficielLesAmisDeLescalade())
			siteRepository.updateOfficialisation(id, false);
		else
			siteRepository.updateOfficialisation(id, true);
	}
	
	@Transactional
	public List<Site> searchSites(List<String> criteriaList) {
		
		List<Site> listeSites = new ArrayList<Site>();
		for (int i = 0; i < criteriaList.size(); i++) {
			if (criteriaList.get(i) != "") {
				if (i == 0) {
					listeSites.addAll(siteRepository.findByDepartement(criteriaList.get(0)));
				} else if (i == 1) {
					//CotationBloc cotation = CotationBloc.valueOf(criteriaList.get(1));

					//List<Voie> listeVoies = voieRepository.findByCotation(CotationBloc._5);
					//List<Voie> listeVoies = voieRepository.findByCotation(criteriaList.get(1));
					
					// listeSites.addAll(siteRepository.findByVoieIn(listeVoies));
				} else if (i == 2) {
					for(Site s : siteRepository.findByOrderByIdAsc()) {
						long nbSecteurs = secteurRepository.countBySite(s);
						if (nbSecteurs >= Long.parseLong(criteriaList.get(2))) {
							 listeSites.add(s);
						}
					}
				} else if (i == 3) {
					for (Site s : siteRepository.findByOrderByIdAsc()) {
						long nbVoies = voieRepository.countBySite(s);
						if (nbVoies >= Long.parseLong(criteriaList.get(3))) {
							listeSites.add(s);
						}
					}
				}
			}
		}
		
//		for (Secteur sec : ((Site) siteRepository.findByOrderByIdAsc()).getListeSecteurs()) {
//			
//		}
		
		return listeSites;	
	}
	
	// méthodes liés aux repositories Commentaire et Site
	
	// si commentaireParent == null, on récupère tous les commentaires principaux d'un site
	// sinon on récupère toutes les réponses d'un commentaire spécifique
	@Transactional
	public List<Commentaire> getCommentaries(Commentaire commentaireParent, String siteId) {
		return commentaireRepository.findByCommentaireParentAndSite(
			commentaireParent, 
			siteRepository.findById(Long.parseLong(siteId)).orElse(null));
	}
	
	// on récupère toutes les réponses de tous les commentaires d'un site spécifique
	@Transactional
	public List<Commentaire> getAllResponsesOfASite(String siteId) {
		return commentaireRepository.findAllResponsesOfASite( 
			siteRepository.findById(Long.parseLong(siteId)).orElse(null));
	}
	
	// on créer en commentaire en définissant si c'est un nouveau ou une réponse d'un autre puis on le sauvegard en bd
	@Override
	@Transactional
   	public void addCommentary(Utilisateur utilisateur, String siteId, 
   			String contenu, String commentaireId) {
		
		Commentaire commentaire = new Commentaire(
				utilisateur, 
				siteRepository.findById(Long.parseLong(siteId)).orElse(null), 
				contenu);

		if (!(commentaireId.contentEquals("null")))
			commentaire.setCommentaireParent(commentaireRepository.findById(Long.parseLong(commentaireId)).orElse(null));

		commentaireRepository.save(commentaire);
   	}
	
	// méthodes liés au repository Commentaire

	@Override
	public Optional<Commentaire> getCommentary(Long id) {
		return commentaireRepository.findById(id);
	}

	// annotation transactional obligatoire pour update ou delete
	// ces deux méthodes sont utilisés uniquement par un membre de l'association
	
	@Override
	@Transactional
	public void editerCommentaire(String id, String contenu) {
		commentaireRepository.updateContenu(Long.parseLong(id), contenu);
	}
	
	@Transactional
	public void supprimerCommentaire(String commentaireId) {
		commentaireRepository.deleteById(Long.parseLong(commentaireId));
	}
}
