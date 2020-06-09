package com.openclassroom.escalade.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.Commentaire;
import com.openclassroom.escalade.domain.CotationBloc;
import com.openclassroom.escalade.domain.CotationFalaise;
import com.openclassroom.escalade.domain.Departement;
import com.openclassroom.escalade.domain.Longueur;
import com.openclassroom.escalade.domain.Secteur;
import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.domain.Voie;
import com.openclassroom.escalade.repository.CommentaireRepository;
import com.openclassroom.escalade.repository.LongueurRepository;
import com.openclassroom.escalade.repository.SecteurRepository;
import com.openclassroom.escalade.repository.SiteRepository;
import com.openclassroom.escalade.repository.TopoRepository;
import com.openclassroom.escalade.repository.VoieRepository;

@Service("gestionSitesService")
public class GestionSitesServiceImpl implements GestionSitesService {

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

	private LongueurRepository longueurRepository;

	public LongueurRepository getLongueurRepository() {
		return longueurRepository;
	}

	@Autowired
	public void setLongueurRepository(LongueurRepository longueurRepository) {
		this.longueurRepository = longueurRepository;
	}

	// méthodes liées au repository Site

	@Override
	public List<Integer> getNbSecteursOfSelectedSites(List<Site> listeSites) {
		List<Integer> listeNbSecteurs = new ArrayList<Integer>();
		for (Site si : listeSites) {
			listeNbSecteurs.add(si.getListeSecteurs().size());
		}
		return listeNbSecteurs;
	}

	// ou alors on créer juste une variable int et on add à la fin de la boucle
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

//	public Object lastIndex(List<Object> liste) {
//		return liste.get(liste.size() -1);
//	}

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

	@Override
	@Transactional
	public void editerDescriptionSite(String id, String description) {
		siteRepository.updateDescription(Long.parseLong(id), description);
	}

	// lié au secteur

//	@Override
//	@Transactional
//	public Secteur getSecteurOfASite(String siteId, String nom) {
//		return secteurRepository.findBySiteAndNom(siteRepository.findById(Long.parseLong(siteId)), nom);
//	}

	@Override
	@Transactional
	public void createSecteur(String siteId, String nom) {
		Secteur secteur = new Secteur(nom);
		secteur.setSite(siteRepository.findById(Long.parseLong(siteId)).orElse(null));
		secteurRepository.save(secteur);
	}

	@Override
	public Secteur getSecteurDetails(String secteurId) {
		return secteurRepository.findById(Long.parseLong(secteurId)).orElse(null);
	}

	@Override
	@Transactional
	public void editerDescriptionSecteur(String id, String description) {
		secteurRepository.updateDescription(Long.parseLong(id), description);
	}

	@Override
	public Long getSiteIdWithSecteurId(String secteurId) {
		return siteRepository.findBySecteurId(Long.parseLong(secteurId));
	}

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

	public List<Site> searchWithDepartement(String criteria) {
		return siteRepository.findByDepartement(Departement.from(criteria));
	}

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

	// méthodes liés aux repositories Commentaire et Site

	// si commentaireParent == null, on récupère tous les commentaires principaux
	// d'un site
	// sinon on récupère toutes les réponses d'un commentaire spécifique
	@Override
	@Transactional
	public List<Commentaire> getCommentaries(Commentaire commentaireParent, String siteId) {
		return commentaireRepository.findByCommentaireParentAndSite(commentaireParent,
				siteRepository.findById(Long.parseLong(siteId)).orElse(null));
	}

	// on récupère toutes les réponses de tous les commentaires d'un site spécifique
	@Override
	@Transactional
	public List<Commentaire> getAllResponsesOfASite(String siteId) {
		return commentaireRepository
				.findAllResponsesOfASite(siteRepository.findById(Long.parseLong(siteId)).orElse(null));
	}

	// on créer en commentaire en définissant si c'est un nouveau ou une réponse
	// d'un autre puis on le sauvegard en bd
	@Override
	@Transactional
	public void addCommentary(Utilisateur utilisateur, String siteId, String contenu, String commentaireId) {

		Commentaire commentaire = new Commentaire(utilisateur,
				siteRepository.findById(Long.parseLong(siteId)).orElse(null), contenu);

		if (!(commentaireId.contentEquals("null")))
			commentaire
					.setCommentaireParent(commentaireRepository.findById(Long.parseLong(commentaireId)).orElse(null));

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

	@Override
	@Transactional
	public void supprimerCommentaire(String commentaireId) {
		commentaireRepository.deleteById(Long.parseLong(commentaireId));
	}
}
