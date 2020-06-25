package com.openclassroom.escalade.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.domain.CotationBloc;
import com.openclassroom.escalade.domain.CotationFalaise;
import com.openclassroom.escalade.domain.Departement;
import com.openclassroom.escalade.domain.EmpruntTopo;
import com.openclassroom.escalade.domain.EmpruntTopoKey;
import com.openclassroom.escalade.domain.Longueur;
import com.openclassroom.escalade.domain.Secteur;
import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.domain.Topo;
import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.domain.Voie;
import com.openclassroom.escalade.repository.EmpruntTopoRepository;
import com.openclassroom.escalade.repository.LongueurRepository;
import com.openclassroom.escalade.repository.SecteurRepository;
import com.openclassroom.escalade.repository.SiteRepository;
import com.openclassroom.escalade.repository.TopoRepository;
import com.openclassroom.escalade.repository.UtilisateurRepository;
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

	private UtilisateurRepository repository;

	@Autowired
	public void setRepository(UtilisateurRepository repository) {
		this.repository = repository;
	}

	private EmpruntTopoRepository empruntTopoRepository;

	@Autowired
	public void setEmpruntTopoRepository(EmpruntTopoRepository empruntTopoRepository) {
		this.empruntTopoRepository = empruntTopoRepository;
	}

	public CreationBD() {
	}

	@PostConstruct
	public void initialize() {
		Topo topo1 = new Topo("nom1", "lieu1", LocalDate.of(1983, Month.MARCH, 28), true,
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nullam feugiat, turpis at pulvinar"
						+ " vulputate, erat libero tristique tellus, nec bibendum odio risus sit amet ante. Aliquam"
						+ " erat volutpat. Nunc auctor. Mauris pretium quam et urna. Fusce nibh. Duis risus. Curabitur"
						+ " sagittis hendrerit");
		Topo topo2 = new Topo("nom2", "lieu2", LocalDate.of(1983, Month.MARCH, 29), false,
				"Etiam posuere quam ac quam. Maecenas aliquet accumsan leo. Nullam dapibus fermentum ipsum. Etiam quis"
						+ " quam. Integer lacinia. Nulla est. Nulla turpis magna, cursus sit amet, suscipit a, interdum"
						+ " id, felis. Integer vulputate sem a nibh rutrum consequat. Maecenas lorem. Pellentesque"
						+ " pretium");
		Topo topo3 = new Topo("nom3", "lieu3", LocalDate.of(1983, Month.MARCH, 30), true,
				"Nam quis nulla. Integer malesuada. In in enim a arcu imperdiet malesuada. Sed vel lectus. Donec odio"
						+ " urna, tempus molestie, porttitor ut, iaculis quis, sem. Phasellus rhoncus. Aenean id metus"
						+ " id velit ullamcorper pulvinar. Vestibulum fermentum tortor id mi. Pellentesque ipsum."
						+ " Nulla");
		Topo topo4 = new Topo("nom4", "lieu4", LocalDate.of(1983, Month.MARCH, 31), true,
				"In sem justo, commodo ut, suscipit at, pharetra vitae, orci. Duis sapien nunc, commodo et, interdum"
						+ " suscipit, sollicitudin et, dolor. Pellentesque habitant morbi tristique senectus et netus"
						+ " et malesuada fames ac turpis egestas. Aliquam id dolor. Class aptent taciti sociosqu ad"
						+ " litora");
		Topo topo5 = new Topo("nom5", "lieu5", LocalDate.of(1983, Month.APRIL, 1), false,
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nullam feugiat, turpis at pulvinar "
						+ "vulputate, erat libero tristique tellus, nec bibendum odio risus sit amet ante. Aliquam erat"
						+ " volutpat. Nunc auctor. Mauris pretium quam et urna. Fusce nibh. Duis risus. Curabitur"
						+ " sagittis hendrerit");

		Utilisateur membreAssociation = new Utilisateur("a", "b", "a", "a@b", "a", true);
		Utilisateur utilisateurConnecte = new Utilisateur("b", "a", "b", "b@a", "b", false);

		repository.save(membreAssociation);
		repository.save(utilisateurConnecte);

		EmpruntTopo empruntTopo1 = new EmpruntTopo(topo1, membreAssociation);

		// topo1.getListeEmpruntsTopo().add(empruntTopo1);

		List<Topo> listeTopos = Arrays.asList(topo1, topo2, topo3, topo4, topo5);
		topoRepository.saveAll(listeTopos);

		// si on le met avant de saugegarder les topos en bd on ne pourra pas récupérer
		// l'id.
		EmpruntTopoKey id1 = new EmpruntTopoKey(true, false, topo1.getId(), membreAssociation.getId());
		empruntTopo1.setId(id1);

		empruntTopoRepository.save(empruntTopo1);

		Site site1 = new Site("nom1", Departement.alpes_de_haute_provence, true,
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nullam feugiat, turpis at pulvinar "
						+ "vulputate, erat libero tristique tellus, nec bibendum odio risus sit amet ante. Aliquam erat"
						+ " volutpat. Nunc auctor. Mauris pretium quam et urna. Fusce nibh. Duis risus. Curabitur"
						+ " sagittis hendrerit");
		Site site2 = new Site("nom2", Departement.finistere, false,
				"Nam quis nulla. Integer malesuada. In in enim a arcu imperdiet malesuada. Sed vel lectus. Donec odio"
						+ " urna, tempus molestie, porttitor ut, iaculis quis, sem. Phasellus rhoncus. Aenean id metus"
						+ " id velit ullamcorper pulvinar. Vestibulum fermentum tortor id mi. Pellentesque ipsum."
						+ " Nulla");
		Site site3 = new Site("nom3", Departement.hautes_pyrenees, false,
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nullam feugiat, turpis at pulvinar"
						+ " vulputate, erat libero tristique tellus, nec bibendum odio risus sit amet ante. Aliquam"
						+ " erat volutpat. Nunc auctor. Mauris pretium quam et urna. Fusce nibh. Duis risus. Curabitur"
						+ " sagittis hendrerit");
		Site site4 = new Site("nom4", Departement.lozere, false,
				"Maecenas ipsum velit, consectetuer eu, lobortis ut, dictum at, dui. In rutrum. Sed ac dolor sit amet"
						+ " purus malesuada congue. In laoreet, magna id viverra tincidunt, sem odio bibendum justo,"
						+ " vel imperdiet sapien wisi sed libero. Suspendisse sagittis ultrices augue. Mauris metus.");
		Site site5 = new Site("nom5", Departement.seine_et_marne, true,
				"In sem justo, commodo ut, suscipit at, pharetra vitae, orci. Duis sapien nunc, commodo et, interdum"
						+ " suscipit, sollicitudin et, dolor. Pellentesque habitant morbi tristique senectus et netus"
						+ " et malesuada fames ac turpis egestas. Aliquam id dolor. Class aptent taciti sociosqu ad"
						+ " litora");
		Site site6 = new Site("nom6", Departement.vaucluse, true,
				"Etiam posuere quam ac quam. Maecenas aliquet accumsan leo. Nullam dapibus fermentum ipsum. Etiam quis"
						+ " quam. Integer lacinia. Nulla est. Nulla turpis magna, cursus sit amet, suscipit a, interdum"
						+ " id, felis. Integer vulputate sem a nibh rutrum consequat. Maecenas lorem. Pellentesque"
						+ " pretium");
		List<Site> listeSites = Arrays.asList(site1, site2, site3, site4, site5, site6);
		siteRepository.saveAll(listeSites);

		Secteur secteur1 = new Secteur("nom1",
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nullam feugiat, turpis at pulvinar "
						+ "vulputate, erat libero tristique tellus, nec bibendum odio risus sit amet ante. Aliquam erat"
						+ " volutpat. Nunc auctor. Mauris pretium quam et urna. Fusce nibh. Duis risus. Curabitur"
						+ " sagittis hendrerit");
		Secteur secteur2 = new Secteur("nom2",
				"Nam quis nulla. Integer malesuada. In in enim a arcu imperdiet malesuada. Sed vel lectus. Donec odio"
						+ " urna, tempus molestie, porttitor ut, iaculis quis, sem. Phasellus rhoncus. Aenean id metus"
						+ " id velit ullamcorper pulvinar. Vestibulum fermentum tortor id mi. Pellentesque ipsum."
						+ " Nulla");
		Secteur secteur3 = new Secteur("nom3",
				"In sem justo, commodo ut, suscipit at, pharetra vitae, orci. Duis sapien nunc, commodo et, interdum"
						+ " suscipit, sollicitudin et, dolor. Pellentesque habitant morbi tristique senectus et netus"
						+ " et malesuada fames ac turpis egestas. Aliquam id dolor. Class aptent taciti sociosqu ad"
						+ " litora");
		Secteur secteur4 = new Secteur("nom4",
				"Etiam posuere quam ac quam. Maecenas aliquet accumsan leo. Nullam dapibus fermentum ipsum. Etiam quis"
						+ " quam. Integer lacinia. Nulla est. Nulla turpis magna, cursus sit amet, suscipit a, interdum"
						+ " id, felis. Integer vulputate sem a nibh rutrum consequat. Maecenas lorem. Pellentesque"
						+ " pretium");
		// Secteur secteur5 = new Secteur("nom5");
		Secteur secteur6 = new Secteur("nom6",
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nullam feugiat, turpis at pulvinar"
						+ " vulputate, erat libero tristique tellus, nec bibendum odio risus sit amet ante. Aliquam"
						+ " erat volutpat. Nunc auctor. Mauris pretium quam et urna. Fusce nibh. Duis risus. Curabitur"
						+ " sagittis hendrerit");
		Secteur secteur7 = new Secteur("nom7",
				"Maecenas ipsum velit, consectetuer eu, lobortis ut, dictum at, dui. In rutrum. Sed ac dolor sit amet"
						+ " purus malesuada congue. In laoreet, magna id viverra tincidunt, sem odio bibendum justo,"
						+ " vel imperdiet sapien wisi sed libero. Suspendisse sagittis ultrices augue. Mauris metus.");
		Secteur secteur8 = new Secteur("nom8",
				"Etiam posuere quam ac quam. Maecenas aliquet accumsan leo. Nullam dapibus fermentum ipsum. Etiam quis"
						+ " quam. Integer lacinia. Nulla est. Nulla turpis magna, cursus sit amet, suscipit a, interdum"
						+ " id, felis. Integer vulputate sem a nibh rutrum consequat. Maecenas lorem. Pellentesque"
						+ " pretium");
		secteur1.setSite(siteRepository.findById(1l).orElse(null));
		secteur2.setSite(siteRepository.findById(2l).orElse(null));
		secteur3.setSite(siteRepository.findById(2l).orElse(null));
		secteur4.setSite(siteRepository.findById(3l).orElse(null));
		// secteur5.setSite(siteRepository.findById(4l).orElse(null));
		secteur6.setSite(siteRepository.findById(5l).orElse(null));
		secteur7.setSite(siteRepository.findById(5l).orElse(null));
		secteur8.setSite(siteRepository.findById(6l).orElse(null));
		List<Secteur> listeSecteurs = Arrays.asList(secteur1, secteur2, secteur3, secteur4, secteur6, secteur7,
				secteur8);
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
		Voie voie10 = new Voie(true, CotationFalaise._7a);
		Voie voie11 = new Voie(false, CotationFalaise._9aPlus);
		voie1.setSecteur(secteurRepository.findById(1l).orElse(null));
		voie3.setSecteur(secteurRepository.findById(1l).orElse(null));
		voie5.setSecteur(secteurRepository.findById(2l).orElse(null));
		voie7.setSecteur(secteurRepository.findById(3l).orElse(null));
		voie9.setSecteur(secteurRepository.findById(4l).orElse(null));
		voie2.setSite(siteRepository.findById(5l).orElse(null));
		voie4.setSite(siteRepository.findById(5l).orElse(null));
		voie6.setSite(siteRepository.findById(6l).orElse(null));
		voie8.setSite(siteRepository.findById(6l).orElse(null));
		voie10.setSite(siteRepository.findById(4l).orElse(null));
		voie11.setSite(siteRepository.findById(4l).orElse(null));

		List<Voie> listeVoies = Arrays.asList(voie1, voie2, voie3, voie4, voie5, voie6, voie7, voie8, voie9, voie10,
				voie11);
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
		Longueur longueur12 = new Longueur(CotationFalaise._7bPlus);
		Longueur longueur13 = new Longueur(CotationFalaise._5a);
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

		longueur12.setVoie(voieRepository.findById(10l).orElse(null));
		longueur13.setVoie(voieRepository.findById(11l).orElse(null));
		List<Longueur> listeLongueurs = Arrays.asList(longueur1, longueur2, longueur3, longueur4, longueur5, longueur6,
				longueur7, longueur8, longueur9, longueur10, longueur11, longueur12, longueur13);
		longueurRepository.saveAll(listeLongueurs);
	}
}
