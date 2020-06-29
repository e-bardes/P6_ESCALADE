//package com.openclassroom.escalade.service;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.Arrays;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.openclassroom.escalade.domain.Commentaire;
//import com.openclassroom.escalade.domain.CotationBloc;
//import com.openclassroom.escalade.domain.CotationFalaise;
//import com.openclassroom.escalade.domain.Departement;
//import com.openclassroom.escalade.domain.Longueur;
//import com.openclassroom.escalade.domain.Secteur;
//import com.openclassroom.escalade.domain.Site;
//import com.openclassroom.escalade.domain.Topo;
//import com.openclassroom.escalade.domain.Utilisateur;
//import com.openclassroom.escalade.domain.Voie;
//import com.openclassroom.escalade.repository.CommentaireRepository;
//import com.openclassroom.escalade.repository.LongueurRepository;
//import com.openclassroom.escalade.repository.SecteurRepository;
//import com.openclassroom.escalade.repository.SiteRepository;
//import com.openclassroom.escalade.repository.TopoRepository;
//import com.openclassroom.escalade.repository.UtilisateurRepository;
//import com.openclassroom.escalade.repository.VoieRepository;
//
//@Service("creationBD")
//public class CreationBD {
//
//	private TopoRepository topoRepository;
//
//	@Autowired
//	public void setTopoRepository(TopoRepository topoRepository) {
//		this.topoRepository = topoRepository;
//	}
//
//	SiteRepository siteRepository;
//
//	@Autowired
//	public void setSiteRepository(SiteRepository siteRepository) {
//		this.siteRepository = siteRepository;
//	}
//
//	SecteurRepository secteurRepository;
//
//	@Autowired
//	public void setSecteurRepository(SecteurRepository secteurRepository) {
//		this.secteurRepository = secteurRepository;
//	}
//
//	VoieRepository voieRepository;
//
//	@Autowired
//	public void setVoieRepository(VoieRepository voieRepository) {
//		this.voieRepository = voieRepository;
//	}
//
//	LongueurRepository longueurRepository;
//
//	@Autowired
//	public void setLongueurRepository(LongueurRepository longueurRepository) {
//		this.longueurRepository = longueurRepository;
//	}
//
//	private UtilisateurRepository repository;
//
//	@Autowired
//	public void setRepository(UtilisateurRepository repository) {
//		this.repository = repository;
//	}
//
//	private CommentaireRepository commentaireRepository;
//
//	@Autowired
//	public void setCommentaireRepository(CommentaireRepository commentaireRepository) {
//		this.commentaireRepository = commentaireRepository;
//	}
//
//	public CreationBD() {
//	}
//
//	@PostConstruct
//	public void initialize() {
//		Topo topo1 = new Topo("ESCALADE EN MAURIENNE", Departement.savoie, LocalDate.of(2018, Month.JANUARY, 4),
//				"erat neque non quam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac "
//						+ "turpis egestas. Aliquam fringilla cursus purus. Nullam scelerisque neque sed sem egestas "
//						+ "blandit. "
//						+ "Nam nulla magna, malesuada vel, convallis in, cursus et, eros. Proin ultrices. Duis volutpat"
//						+ " nunc");
//		Topo topo2 = new Topo("TOPO DU JURA", Departement.jura, LocalDate.of(2017, Month.APRIL, 29),
//				"odio tristique pharetra. Quisque ac libero nec ligula consectetuer rhoncus. Nullam velit dui, semper et, lacinia vitae, sodales at, velit. Pellentesque ultricies dignissim lacus. Aliquam rutrum lorem ac risus. Morbi metus. Vivamus euismod urna.");
//		Topo topo3 = new Topo("SOMMET DU MONT BLANC", Departement.savoie, LocalDate.of(2020, Month.FEBRUARY, 7),
//				"Mauris magna. Duis dignissim tempor arcu. Vestibulum ut eros non enim commodo hendrerit. Donec porttitor tellus non magna. Nam ligula elit, pretium et, rutrum non, hendrerit id, ante. Nunc mauris sapien, cursus in, hendrerit consectetuer, cursus et, magna. Praesent interdum ligula eu enim. Etiam imperdiet dictum magna. Ut tincidunt orci quis lectus. Nullam suscipit, est ac facilisis facilisis, magna tellus faucibus leo, in lobortis tellus justo sit amet nulla. Donec non justo. Proin non massa non ante bibendum ullamcorper. Duis cursus, diam at pretium aliquet, metus urna convallis erat, eget");
//		Topo topo4 = new Topo("49 FALAISES AUTOUR ANNECY", Departement.haute_savoie, LocalDate.of(2019, Month.JULY, 10),
//				"urna. Ut tincidunt vehicula risus. Nulla eget metus eu erat semper rutrum. Fusce dolor quam, elementum at, egestas a, scelerisque sed, sapien. Nunc pulvinar arcu et pede. Nunc sed orci lobortis augue scelerisque mollis. Phasellus libero mauris, aliquam eu, accumsan sed, facilisis vitae, orci. Phasellus dapibus quam quis diam. Pellentesque habitant morbi tristique senectus");
//		Topo topo5 = new Topo("VALLEE DE CHAMONIX ESCALADE", Departement.haute_savoie,
//				LocalDate.of(2019, Month.APRIL, 1),
//				"et ultrices posuere cubilia Curae; Phasellus ornare. Fusce mollis. Duis sit amet diam eu dolor egestas rhoncus. Proin nisl sem, consequat nec, mollis vitae, posuere at, velit. Cras lorem lorem, luctus ut, pellentesque eget, dictum placerat, augue. Sed molestie. Sed id risus quis diam luctus lobortis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos hymenaeos. Mauris ut quam vel sapien");
//		Topo topo6 = new Topo("VILLES SUR AUZON", Departement.vaucluse, LocalDate.of(2020, Month.MAY, 24),
//				"fringilla mi lacinia mattis. Integer eu lacus. Quisque imperdiet, erat nonummy ultricies ornare, elit elit fermentum risus, at fringilla purus mauris a nunc. In at pede. Cras vulputate velit eu sem. Pellentesque ut ipsum ac mi eleifend egestas. Sed pharetra, felis eget varius ultrices, mauris ipsum porta elit, a feugiat tellus lorem eu metus. In lorem. Donec elementum, lorem ut aliquam iaculis, lacus pede sagittis augue, eu tempor erat neque non quam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aliquam fringilla cursus purus. Nullam scelerisque neque sed sem egestas blandit. Nam nulla magna, malesuada");
//		Topo topo7 = new Topo("ESCALADE EN VALLEE DE L HERAULT", Departement.herault, LocalDate.of(2017, Month.JUNE, 4),
//				"psum dolor sit amet, consectetuer adipiscing elit. Etiam laoreet, libero et tristique pellentesque, tellus sem mollis dui, in sodales elit erat vitae risus. Duis a mi fringilla mi lacinia mattis. Integer eu lacus. Quisque imperdiet, erat nonummy ultricies ornare, elit elit fermentum risus, at fringilla purus mauris a nunc. In at pede. Cras vulputate velit eu sem. Pellentesque ut ipsum ac mi eleifend egestas. Sed pharetra, felis eget varius ultrices, mauris ipsum porta elit, a feugiat");
//		Topo topo8 = new Topo("LA VALLEE D OSSAU", Departement.pyrenees_atlantique, LocalDate.of(2018, Month.AUGUST, 9),
//				"tristique senectus et netus et malesuada fames ac turpis egestas. Fusce aliquet magna a neque. Nullam ut nisi a odio semper cursus. Integer mollis. Integer tincidunt aliquam arcu. Aliquam ultrices iaculis odio. Nam interdum enim non nisi. Aenean eget metus. In nec orci. Donec nibh. Quisque");
//		Topo topo9 = new Topo("7+8 FONTAINEBLEAU", Departement.seine_et_marne, LocalDate.of(2016, Month.JANUARY, 23),
//				"lorem. Donec elementum, lorem ut aliquam iaculis, lacus pede sagittis augue, eu tempor erat neque non quam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aliquam fringilla cursus purus. Nullam scelerisque neque sed sem egestas blandit. Nam nulla magna, malesuada vel, convallis in, cursus et, eros. Proin ultrices. Duis volutpat nunc sit amet metus. Aliquam erat volutpat. Nulla facilisis. Suspendisse commodo tincidunt nibh. Phasellus nulla. Integer\"),(\"dis parturient montes, nascetur ridiculus mus. Proin vel nisl. Quisque fringilla euismod enim. Etiam gravida molestie arcu. Sed eu nibh vulputate mauris sagittis placerat. Cras dictum ultricies ligula. Nullam enim. Sed nulla ante, iaculis nec, eleifend non, dapibus rutrum, justo. Praesent luctus. Curabitur egestas nunc sed libero. Proin sed turpis nec mauris blandit mattis. Cras");
//		Topo topo10 = new Topo("CHATEAUDOUBLE", Departement.var, LocalDate.of(2019, Month.DECEMBER, 21),
//				"gravida sagittis. Duis gravida. Praesent eu nulla at sem molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est, congue a, aliquet vel, vulputate eu, odio. Phasellus at augue id ante dictum cursus.");
//		Topo topo11 = new Topo("ESCALADE DANS LE DIOIS", Departement.drome, LocalDate.of(2018, Month.JANUARY, 5),
//				"iaculis, lacus pede sagittis augue, eu tempor erat neque non quam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aliquam fringilla cursus purus. Nullam scelerisque neque sed sem egestas blandit. Nam nulla magna, malesuada vel, convallis in, cursus et, eros. Proin ultrices. Duis volutpat nunc sit amet metus. Aliquam erat volutpat. Nulla facilisis. Suspendisse commodo tincidunt nibh. Phasellus nulla. Integer vulputate, risus a ultricies adipiscing, enim mi tempor");
//		Topo topo12 = new Topo("FONTAINEBLEAU FUN BLOC", Departement.seine_et_marne, LocalDate.of(2019, Month.MARCH, 8),
//				"dui. Cras pellentesque. Sed dictum. Proin eget odio. Aliquam vulputate ullamcorper magna. Sed eu eros. Nam consequat dolor vitae dolor. Donec fringilla. Donec feugiat metus sit amet ante. Vivamus non lorem vitae odio sagittis semper. Nam tempor diam dictum sapien. Aenean massa. Integer vitae nibh. Donec est mauris, rhoncus id, mollis nec, cursus a, enim. Suspendisse aliquet, sem ut cursus luctus, ipsum leo elementum sem, vitae aliquam eros turpis non enim. Mauris quis turpis vitae purus gravida sagittis. Duis gravida. Praesent eu nulla at sem molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est, congue");
//		Topo topo13 = new Topo("LES GRANDES JORASSES", Departement.haute_savoie, LocalDate.of(2015, Month.SEPTEMBER, 4),
//				"Nullam vitae diam. Proin dolor. Nulla semper tellus id nunc interdum feugiat. Sed nec metus facilisis lorem tristique aliquet. Phasellus fermentum convallis ligula. Donec luctus aliquet odio. Etiam ligula tortor, dictum eu, placerat");
//		Topo topo14 = new Topo("GUIDE OLLIVIER PYRENEES OCCIDENTALES I ASPE", Departement.pyrenees_atlantique,
//				LocalDate.of(2017, Month.JULY, 7),
//				"a nunc. In at pede. Cras vulputate velit eu sem. Pellentesque ut ipsum ac mi eleifend egestas. Sed pharetra, felis eget varius ultrices, mauris ipsum porta elit, a feugiat tellus lorem eu metus. In");
//		Topo topo15 = new Topo("GUIDE OLLIVIER PYRENEES OCCIDENTALES II ASPE", Departement.pyrenees_atlantique,
//				LocalDate.of(2020, Month.APRIL, 5),
//				"mollis. Duis sit amet diam eu dolor egestas rhoncus. Proin nisl sem, consequat nec, mollis vitae, posuere at, velit. Cras lorem lorem, luctus ut, pellentesque eget, dictum placerat, augue. Sed molestie. Sed id risus quis diam luctus lobortis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos hymenaeos. Mauris ut quam vel sapien imperdiet ornare. In faucibus. Morbi vehicula. Pellentesque tincidunt tempus risus. Donec egestas. Duis ac arcu. Nunc mauris. Morbi non sapien molestie orci tincidunt adipiscing. Mauris molestie pharetra nibh. Aliquam ornare, libero at auctor ullamcorper, nisl arcu iaculis enim,");
//		Topo topo16 = new Topo("CASCADES MT BLANC B.ARAVIS V.MONTJOIE T.1", Departement.savoie,
//				LocalDate.of(2018, Month.OCTOBER, 30),
//				"magna a neque. Nullam ut nisi a odio semper cursus. Integer mollis. Integer tincidunt aliquam arcu. Aliquam ultrices iaculis odio. Nam interdum enim non nisi. Aenean eget metus. In nec orci. Donec nibh. Quisque nonummy ipsum non arcu. Vivamus sit amet risus. Donec egestas. Aliquam nec");
//		Topo topo17 = new Topo("CASCADES MT BLANC B.ARAVIS V.MONTJOIE T.2", Departement.savoie,
//				LocalDate.of(2017, Month.MARCH, 4),
//				"tincidunt. Donec vitae erat vel pede blandit congue. In scelerisque scelerisque dui. Suspendisse ac metus vitae velit egestas lacinia. Sed congue, elit sed consequat auctor, nunc nulla vulputate dui, nec tempus mauris erat eget ipsum. Suspendisse sagittis. Nullam vitae diam.");
//		Topo topo18 = new Topo("ESCALADE EN ARDECHE", Departement.ardeche, LocalDate.of(2019, Month.APRIL, 3),
//				"elementum, lorem ut aliquam iaculis, lacus pede sagittis augue, eu tempor erat neque non quam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aliquam fringilla cursus purus. Nullam scelerisque neque sed sem egestas blandit. Nam nulla magna, malesuada vel, convallis in, cursus et, eros. Proin ultrices. Duis volutpat nunc sit amet metus. Aliquam erat volutpat. Nulla facilisis. Suspendisse commodo tincidunt nibh. Phasellus nulla. Integer vulputate, risus a");
//		Topo topo19 = new Topo("LEZARDONS DANS LE COUSERANS", Departement.ariege,
//				LocalDate.of(2018, Month.FEBRUARY, 13),
//				"sem molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est, congue a, aliquet vel, vulputate eu, odio. Phasellus at augue id ante dictum cursus. Nunc mauris elit, dictum eu, eleifend nec, malesuada ut, sem. Nulla interdum. Curabitur dictum. Phasellus in felis. Nulla tempor augue ac ipsum. Phasellus vitae mauris sit amet lorem");
//		Topo topo20 = new Topo("5 + 6 FONTAINEBLEAU TOME 2", Departement.seine_et_marne,
//				LocalDate.of(2019, Month.JUNE, 24),
//				"Nulla interdum. Curabitur dictum. Phasellus in felis. Nulla tempor augue ac ipsum. Phasellus vitae mauris sit amet lorem semper auctor. Mauris vel turpis. Aliquam adipiscing lobortis risus. In mi pede, nonummy ut, molestie in, tempus eu, ligula. Aenean euismod mauris eu elit. Nulla facilisi. Sed neque. Sed eget lacus. Mauris non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus ornare. Fusce mollis. Duis sit amet diam eu dolor egestas rhoncus. Proin nisl sem, consequat nec, mollis vitae, posuere at, velit. Cras lorem lorem, luctus ut,");
//
//		Utilisateur membreAssociation1 = new Utilisateur("9Q9Je8Kax", "Stein", "Lewis",
//				"Lorem.ipsum.dolor@dolorsitamet.net", "CP 838, 8782 Sed Av.", true);
//		Utilisateur membreAssociation2 = new Utilisateur("3HfBs57sV", "Malone", "Rebekah", "nibh@et.com",
//				"593-9665 Vehicula Route", true);
//		Utilisateur utilisateurConnecte1 = new Utilisateur("3f3DmRr8U", "Perry", "Zephania",
//				"vitae.sodales@antebibendumullamcorper.net", "5946 Pellentesque Rue", false);
//		Utilisateur utilisateurConnecte2 = new Utilisateur("y3mbJA86B", "Noble", "Alma", "sem@non.net",
//				"Appartement 526-8288 Interdum Impasse", false);
//
//		repository.save(membreAssociation1);
//		repository.save(membreAssociation2);
//		repository.save(utilisateurConnecte1);
//		repository.save(utilisateurConnecte2);
//
//		topo1.setOwner(membreAssociation1);
//		topo2.setOwner(membreAssociation1);
//		topo3.setOwner(membreAssociation1);
//		topo4.setOwner(membreAssociation1);
//		topo5.setOwner(membreAssociation1);
//
//		topo6.setOwner(membreAssociation2);
//		topo7.setOwner(membreAssociation2);
//		topo8.setOwner(membreAssociation2);
//		topo9.setOwner(membreAssociation2);
//		topo10.setOwner(membreAssociation2);
//
//		topo11.setOwner(utilisateurConnecte1);
//		topo12.setOwner(utilisateurConnecte1);
//		topo13.setOwner(utilisateurConnecte1);
//		topo14.setOwner(utilisateurConnecte1);
//		topo15.setOwner(utilisateurConnecte1);
//
//		topo16.setOwner(utilisateurConnecte2);
//		topo17.setOwner(utilisateurConnecte2);
//		topo18.setOwner(utilisateurConnecte2);
//		topo19.setOwner(utilisateurConnecte2);
//		topo20.setOwner(utilisateurConnecte2);
//
//		topo1.setPossessor(membreAssociation1);
//		topo2.setPossessor(membreAssociation1);
//
//		topo6.setPossessor(membreAssociation2);
//		topo7.setPossessor(membreAssociation2);
//
//		topo11.setPossessor(utilisateurConnecte1);
//		topo12.setPossessor(utilisateurConnecte1);
//
//		topo16.setPossessor(utilisateurConnecte2);
//		topo17.setPossessor(utilisateurConnecte2);
//
//		topo3.getApplicantList().add(membreAssociation2);
//		topo3.getApplicantList().add(utilisateurConnecte1);
//		topo3.getApplicantList().add(utilisateurConnecte2);
//		topo4.getApplicantList().add(membreAssociation2);
//		topo5.getApplicantList().add(utilisateurConnecte1);
//		topo5.getApplicantList().add(utilisateurConnecte2);
//
//		topo8.getApplicantList().add(membreAssociation1);
//		topo8.getApplicantList().add(utilisateurConnecte1);
//		topo9.getApplicantList().add(membreAssociation1);
//		topo10.getApplicantList().add(utilisateurConnecte2);
//
//		topo13.getApplicantList().add(utilisateurConnecte2);
//		topo13.getApplicantList().add(membreAssociation1);
//		topo14.getApplicantList().add(utilisateurConnecte2);
//		topo15.getApplicantList().add(membreAssociation2);
//
//		topo18.getApplicantList().add(membreAssociation2);
//		topo18.getApplicantList().add(membreAssociation1);
//		topo18.getApplicantList().add(utilisateurConnecte1);
//		topo19.getApplicantList().add(utilisateurConnecte1);
//
//		List<Topo> listeTopos = Arrays.asList(topo1, topo2, topo3, topo4, topo5, topo6, topo7, topo8, topo9, topo10,
//				topo11, topo12, topo13, topo14, topo15, topo16, topo17, topo18, topo19, topo20);
//		topoRepository.saveAll(listeTopos);
//
//		Site site1 = new Site("Ablon", Departement.haute_savoie, true,
//				"sem semper erat, in consectetuer ipsum nunc id enim. Curabitur massa. Vestibulum accumsan neque et nunc. Quisque ornare tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam tincidunt, nunc ac mattis ornare, lectus ante dictum mi, ac mattis velit justo nec ante. Maecenas mi felis, adipiscing fringilla, porttitor vulputate, posuere vulputate, lacus. Cras interdum. Nunc sollicitudin commodo ipsum. Suspendisse non leo. Vivamus nibh dolor, nonummy ac, feugiat non, lobortis quis, pede. Suspendisse dui. Fusce diam nunc, ullamcorper");
//		Site site2 = new Site("Ailefroide", Departement.hautes_alpes, false,
//				"sem elit, pharetra ut, pharetra sed, hendrerit a, arcu. Sed et libero. Proin mi. Aliquam gravida mauris ut mi. Duis risus odio, auctor vitae, aliquet nec, imperdiet nec, leo. Morbi neque tellus, imperdiet non, vestibulum nec, euismod in, dolor. Fusce feugiat. Lorem ipsum dolor sit amet, consectetuer adipiscing");
//		Site site3 = new Site("Annot", Departement.alpes_de_haute_provence, false,
//				"pede et risus. Quisque libero lacus, varius et, euismod et, commodo at, libero. Morbi accumsan laoreet ipsum. Curabitur consequat, lectus sit amet luctus vulputate, nisi sem semper erat, in consectetuer ipsum nunc id enim. Curabitur massa. Vestibulum accumsan neque et nunc. Quisque ornare tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam tincidunt, nunc ac mattis ornare, lectus ante dictum mi, ac mattis velit justo nec ante. Maecenas mi felis, adipiscing fringilla, porttitor vulputate, posuere vulputate, lacus. Cras interdum. Nunc sollicitudin commodo ipsum. Suspendisse non leo. Vivamus nibh");
//		Site site4 = new Site("Arudy", Departement.pyrenees_atlantique, false,
//				"ac turpis egestas. Fusce aliquet magna a neque. Nullam ut nisi a odio semper cursus. Integer mollis. Integer tincidunt aliquam arcu. Aliquam ultrices iaculis odio. Nam interdum enim non nisi. Aenean eget metus. In nec orci. Donec nibh. Quisque nonummy ipsum non arcu. Vivamus sit amet risus. Donec egestas. Aliquam nec enim. Nunc ut erat. Sed nunc est, mollis non, cursus non, egestas a, dui. Cras pellentesque. Sed dictum.");
//		Site site5 = new Site("Autoire", Departement.lot, true,
//				"augue scelerisque mollis. Phasellus libero mauris, aliquam eu, accumsan sed, facilisis vitae, orci. Phasellus dapibus quam quis diam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce aliquet magna a neque. Nullam ut nisi a odio semper cursus. Integer mollis. Integer tincidunt aliquam arcu. Aliquam ultrices iaculis odio. Nam interdum enim non nisi. Aenean eget metus. In nec orci. Donec nibh. Quisque");
//		Site site6 = new Site("Bavella", Departement.corse_du_sud, true,
//				"Curae; Phasellus ornare. Fusce mollis. Duis sit amet diam eu dolor egestas rhoncus. Proin nisl sem, consequat nec, mollis vitae, posuere at, velit. Cras lorem lorem, luctus ut, pellentesque eget, dictum placerat, augue. Sed molestie. Sed id risus quis diam luctus lobortis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos hymenaeos. Mauris ut quam vel sapien imperdiet ornare. In faucibus. Morbi vehicula. Pellentesque tincidunt tempus risus. Donec egestas. Duis acs");
//		Site site7 = new Site("Bergholtz", Departement.haut_rhin, false,
//				"morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aliquam fringilla cursus purus. Nullam scelerisque neque sed sem egestas blandit. Nam nulla magna, malesuada vel, convallis in, cursus et, eros. Proin ultrices. Duis volutpat nunc sit amet metus. Aliquam erat volutpat. Nulla facilisis. Suspendisse commodo tincidunt nibh. Phasellus nulla. Integer vulputate, risus a ultricies adipiscing, enim mi tempor lorem, eget mollis");
//		Site site8 = new Site("Bionnasay", Departement.haute_savoie, false,
//				"adipiscing. Mauris molestie pharetra nibh. Aliquam ornare, libero at auctor ullamcorper, nisl arcu iaculis enim, sit amet ornare lectus justo eu arcu. Morbi sit amet massa. Quisque porttitor eros nec tellus. Nunc lectus pede,");
//		Site site9 = new Site("Buoux", Departement.vaucluse, true,
//				"Suspendisse non leo. Vivamus nibh dolor, nonummy ac, feugiat non, lobortis quis, pede. Suspendisse dui. Fusce diam nunc, ullamcorper eu, euismod ac, fermentum vel, mauris. Integer sem elit, pharetra ut, pharetra sed, hendrerit a, arcu. Sed et libero. Proin mi. Aliquam gravida mauris ut mi. Duis risus odio, auctor vitae, aliquet nec, imperdiet nec, leo. Morbi neque tellus, imperdiet non, vestibulum nec, euismod in, dolor. Fusce feugiat. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aliquam auctor, velit eget laoreet posuere, enim nisl elementum purus, accumsan interdum libero dui nec");
//		Site site10 = new Site("Cantobre", Departement.aveyron, true,
//				"tempor arcu. Vestibulum ut eros non enim commodo hendrerit. Donec porttitor tellus non magna. Nam ligula elit, pretium et, rutrum non, hendrerit id, ante. Nunc mauris sapien, cursus in, hendrerit consectetuer, cursus et, magna. Praesent interdum ligula eu enim. Etiam imperdiet dictum magna. Ut tincidunt orci quis lectus. Nullam suscipit, est ac facilisis facilisis, magna tellus faucibus leo, in lobortis tellus justo sit amet nulla. Donec non justo. Proin non massa non ante bibendum ullamcorper. Duis cursus, diam at pretium aliquet, metus");
//		Site site11 = new Site("Cap Dramont", Departement.var, false,
//				"eu dolor egestas rhoncus. Proin nisl sem, consequat nec, mollis vitae, posuere at, velit. Cras lorem lorem, luctus ut, pellentesque eget, dictum placerat, augue. Sed molestie. Sed id risus quis diam luctus lobortis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos hymenaeos. Mauris ut quam vel sapien imperdiet ornare. In faucibus. Morbi vehicula. Pellentesque tincidunt tempus risus. Donec egestas. Duis ac arcu. Nunc mauris. Morbi non sapien molestie orci tincidunt adipiscing. Mauris molestie pharetra nibh. Aliquam ornare, libero at auctor ullamcorper, nisl arcu iaculis enim, sit amet ornare lectus justo eu");
//		Site site12 = new Site("Castillon", Departement.alpes_maritimes, true,
//				"nec tempus scelerisque, lorem ipsum sodales purus, in molestie tortor nibh sit amet orci. Ut sagittis lobortis mauris. Suspendisse aliquet molestie tellus. Aenean egestas hendrerit neque. In ornare sagittis felis. Donec tempor, est ac mattis semper, dui lectus rutrum urna, nec luctus felis purus ac tellus. Suspendisse sed dolor. Fusce mi lorem, vehicula et, rutrum eu, ultrices sit amet, risus. Donec nibh enim, gravida sit amet, dapibus id, blandit at, nisi.");
//		Site site13 = new Site("Chamiers", Departement.ardeche, false,
//				"ligula eu enim. Etiam imperdiet dictum magna. Ut tincidunt orci quis lectus. Nullam suscipit, est ac facilisis facilisis, magna tellus faucibus leo, in lobortis tellus justo sit amet nulla. Donec non justo. Proin non massa non ante bibendum ullamcorper. Duis cursus, diam at pretium aliquet, metus urna convallis");
//		Site site14 = new Site("Claret", Departement.herault, true,
//				"lectus convallis est, vitae sodales nisi magna sed dui. Fusce aliquam, enim nec tempus scelerisque, lorem ipsum sodales purus, in molestie tortor nibh sit amet orci. Ut sagittis lobortis mauris. Suspendisse aliquet molestie tellus. Aenean egestas hendrerit neque. In ornare sagittis felis. Donec tempor, est ac mattis semper, dui lectus rutrum urna, nec luctus felis purus ac tellus. Suspendisse sed dolor. Fusce mi lorem, vehicula et, rutrum eu, ultrices sit amet, risus. Donec nibh enim, gravida sit amet, dapibus id, blandit at, nisi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.");
//		Site site15 = new Site("Clemont", Departement.doubs, false,
//				"nisl. Nulla eu neque pellentesque massa lobortis ultrices. Vivamus rhoncus. Donec est. Nunc ullamcorper, velit in aliquet lobortis, nisi nibh lacinia orci, consectetuer euismod est arcu ac orci. Ut semper pretium neque. Morbi quis urna. Nunc quis arcu vel quam dignissim pharetra. Nam ac nulla. In tincidunt congue turpis. In condimentum. Donec at arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec tincidunt. Donec vitae erat vel pede blandit congue. In scelerisque scelerisque dui. Suspendisse ac metus vitae velit");
//		Site site16 = new Site("Cirque d'Archiane", Departement.drome, true,
//				"parturient montes, nascetur ridiculus mus. Donec dignissim magna a tortor. Nunc commodo auctor velit. Aliquam nisl. Nulla eu neque pellentesque massa lobortis ultrices. Vivamus rhoncus. Donec est. Nunc ullamcorper, velit in aliquet lobortis, nisi nibh lacinia orci, consectetuer euismod est arcu ac orci. Ut sempers");
//		Site site17 = new Site("Collias", Departement.gard, true,
//				"Aliquam erat volutpat. Nulla dignissim. Maecenas ornare egestas ligula. Nullam feugiat placerat velit. Quisque varius. Nam porttitor scelerisque neque. Nullam nisl. Maecenas malesuada fringilla est. Mauris eu turpis. Nulla aliquet. Proin velit. Sed malesuada augue ut lacus. Nulla tincidunt, neque vitae semper egestas, urna justo faucibus lectus, a sollicitudin orci sem eget massa. Suspendisse eleifend. Cras sed leo. Cras vehicula");
//		Site site18 = new Site("Cormont", Departement.bourgogne, false,
//				"quis urna. Nunc quis arcu vel quam dignissim pharetra. Nam ac nulla. In tincidunt congue turpis. In condimentum. Donec at arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec tincidunt. Donec vitae erat vel pede blandit congue. In scelerisque scelerisque dui. Suspendisse ac metus vitae velit egestas");
//		Site site19 = new Site("Côté court", Departement.drome, false,
//				"massa. Quisque porttitor eros nec tellus. Nunc lectus pede, ultrices a, auctor non, feugiat nec, diam. Duis mi enim, condimentum eget, volutpat ornare, facilisis eget, ipsum. Donec sollicitudin adipiscing ligula. Aenean gravida nunc sed pede. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel arcu eu odio tristique pharetra. Quisque ac libero nec ligula consectetuer rhoncus. Nullam velit dui, semper et, lacinia vitae, sodales at, velit. Pellentesque ultricies dignissim lacus. Aliquam rutrum lorem ac risus. Morbi metus. Vivamus euismod urna. Nullam lobortis quam a felis ullamcorper viverra. Maecenas iaculis");
//		Site site20 = new Site("Crenans", Departement.jura, true,
//				"sit amet ultricies sem magna nec quam. Curabitur vel lectus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec dignissim magna a tortor. Nunc commodo auctor velit. Aliquam nisl. Nulla eu neque pellentesque massa lobortis ultrices. Vivamus rhoncus.");
//		List<Site> listeSites = Arrays.asList(site1, site2, site3, site4, site5, site6, site7, site8, site9, site10,
//				site11, site12, site13, site14, site15, site16, site17, site18, site19, site20);
//		siteRepository.saveAll(listeSites);
//
//		Commentaire commentaire1 = new Commentaire(membreAssociation1, site1,
//				"aliquam eu, accumsan sed, facilisis vitae, orci. Phasellus dapibus quam quis diam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce aliquet magna");
//		Commentaire commentaire2 = new Commentaire(membreAssociation1, site1,
//				"lobortis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos hymenaeos. Mauris ut quam vel sapien imperdiet ornare. In faucibus. Morbi vehicula. Pellentesque tincidunt tempus risus. Donec egestas. Duis ac arcu. Nunc mauris. Morbi non sapien molestie orci tincidunt adipiscing. Mauris molestie pharetra nibh. Aliquam",
//				commentaire1);
//		Commentaire commentaire3 = new Commentaire(membreAssociation1, site1,
//				"purus. Maecenas libero est, congue a, aliquet vel, vulputate eu, odio. Phasellus at augue id ante dictum cursus. Nunc mauris elit, dictum eu, eleifend nec, malesuada ut, sem. Nulla interdum. Curabitur dictum. Phasellus in felis. Nulla tempor augue ac ipsum. Phasellus vitae mauris sit amet",
//				commentaire1);
//		Commentaire commentaire4 = new Commentaire(membreAssociation2, site1,
//				"fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus ornare. Fusce mollis. Duis sit amet diam eu dolor egestas rhoncus. Proin nisl sem, consequat nec, mollis vitae, posuere at, velit.",
//				commentaire1);
//		Commentaire commentaire5 = new Commentaire(membreAssociation2, site1,
//				"ac risus. Morbi metus. Vivamus euismod urna. Nullam lobortis quam a felis ullamcorper viverra. Maecenas iaculis aliquet diam. Sed diam lorem, auctor quis, tristique ac, eleifend vitae, erat. Vivamus nisi. Mauris nulla. Integer urna. Vivamus molestie",
//				commentaire1);
//
//		Commentaire commentaire8 = new Commentaire(utilisateurConnecte1, site2,
//				"amet risus. Donec egestas. Aliquam nec enim. Nunc ut erat. Sed nunc est, mollis non, cursus non, egestas a, dui. Cras pellentesque. Sed dictum. Proin eget odio. Aliquam vulputate ullamcorper magna. Sed eu eros. Nam consequat dolor vitae dolor. Donec fringilla. Donec feugiat");
//		Commentaire commentaire6 = new Commentaire(membreAssociation1, site2,
//				"Mauris ut quam vel sapien imperdiet ornare. In faucibus. Morbi vehicula. Pellentesque tincidunt tempus risus. Donec egestas. Duis ac arcu. Nunc mauris. Morbi non sapien molestie orci tincidunt adipiscing. Mauris molestie pharetra nibh. Aliquam ornare, libero at auctor ullamcorper, nisl arcu",
//				commentaire8);
//		Commentaire commentaire7 = new Commentaire(membreAssociation2, site2,
//				"metus facilisis lorem tristique aliquet. Phasellus fermentum convallis ligula. Donec luctus aliquet odio. Etiam ligula tortor, dictum eu, placerat eget, venenatis a, magna. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Etiam laoreet, libero et tristique pellentesque, tellus sem mollis dui,",
//				commentaire8);
//		Commentaire commentaire9 = new Commentaire(utilisateurConnecte1, site2,
//				"hymenaeos. Mauris ut quam vel sapien imperdiet ornare. In faucibus. Morbi vehicula. Pellentesque tincidunt tempus risus. Donec egestas. Duis ac arcu. Nunc mauris. Morbi non sapien molestie orci tincidunt adipiscing. Mauris molestie pharetra nibh. Aliquam ornare, libero at auctor ullamcorper, nisl arcu iaculis enim,",
//				commentaire8);
//
//		Commentaire commentaire10 = new Commentaire(utilisateurConnecte1, site3,
//				"Sed eget lacus. Mauris non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in");
//		Commentaire commentaire11 = new Commentaire(utilisateurConnecte1, site3,
//				"Cras dolor dolor, tempus non, lacinia at, iaculis quis, pede. Praesent eu dui. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aenean eget magna. Suspendisse tristique neque venenatis lacus. Etiam bibendum fermentum metus. Aenean sed pede nec ante blandit",
//				commentaire10);
//		Commentaire commentaire12 = new Commentaire(utilisateurConnecte2, site3,
//				"et ipsum cursus vestibulum. Mauris magna. Duis dignissim tempor arcu. Vestibulum ut eros non enim commodo hendrerit. Donec porttitor tellus non magna. Nam ligula elit, pretium et, rutrum non, hendrerit",
//				commentaire10);
//		Commentaire commentaire13 = new Commentaire(utilisateurConnecte1, site3,
//				"in lobortis tellus justo sit amet nulla. Donec non justo. Proin non massa non ante bibendum ullamcorper. Duis cursus, diam at pretium aliquet, metus urna convallis erat, eget tincidunt dui augue eu",
//				commentaire10);
//		Commentaire commentaire14 = new Commentaire(membreAssociation2, site3,
//				"massa. Vestibulum accumsan neque et nunc. Quisque ornare tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam tincidunt, nunc ac mattis ornare, lectus ante dictum mi, ac mattis velit justo nec ante. Maecenas mi felis, adipiscing fringilla, porttitor vulputate,",
//				commentaire10);
//
//		Commentaire commentaire16 = new Commentaire(utilisateurConnecte1, site4,
//				"lacinia mattis. Integer eu lacus. Quisque imperdiet, erat nonummy ultricies ornare, elit elit fermentum risus, at fringilla purus mauris a nunc. In at pede. Cras vulputate velit");
//		Commentaire commentaire15 = new Commentaire(membreAssociation1, site4,
//				"non ante bibendum ullamcorper. Duis cursus, diam at pretium aliquet, metus urna convallis erat, eget tincidunt dui augue eu tellus.",
//				commentaire16);
//		Commentaire commentaire18 = new Commentaire(utilisateurConnecte2, site4,
//				"est, mollis non, cursus non, egestas a, dui. Cras pellentesque. Sed dictum. Proin eget odio. Aliquam vulputate ullamcorper magna. Sed eu eros. Nam consequat dolor vitae dolor. Donec fringilla. Donec feugiat metus sit amet ante. Vivamus");
//		Commentaire commentaire17 = new Commentaire(utilisateurConnecte1, site4,
//				"amet ornare lectus justo eu arcu. Morbi sit amet massa. Quisque porttitor eros nec tellus. Nunc lectus pede, ultrices a, auctor non,",
//				commentaire18);
//		Commentaire commentaire19 = new Commentaire(utilisateurConnecte2, site4,
//				"\"massa. Integer vitae nibh. Donec est mauris, rhoncus id, mollis nec, cursus a, enim. Suspendisse aliquet, sem ut cursus luctus, ipsum leo elementum sem,",
//				commentaire18);
//		Commentaire commentaire20 = new Commentaire(utilisateurConnecte2, site4,
//				"dis parturient montes, nascetur ridiculus mus. Proin vel arcu eu odio tristique pharetra. Quisque ac libero nec ligula consectetuer rhoncus. Nullam velit dui, semper et, lacinia vitae, sodales at, velit. Pellentesque ultricies dignissim lacus. Aliquam rutrum lorem ac risus. Morbi metus. Vivamus euismod urna. Nullam lobortis quam",
//				commentaire16);
//
//		Commentaire commentaire25 = new Commentaire(utilisateurConnecte2, site5,
//				"amet risus. Donec egestas. Aliquam nec enim. Nunc ut erat. Sed nunc est, mollis non, cursus non, egestas a, dui. Cras pellentesque. Sed dictum. Proin eget odio. Aliquam");
//		Commentaire commentaire21 = new Commentaire(membreAssociation1, site5,
//				"ut odio vel est tempor bibendum. Donec felis orci, adipiscing non, luctus sit amet, faucibus ut, nulla. Cras eu tellus eu augue porttitor interdum.");
//		Commentaire commentaire22 = new Commentaire(membreAssociation2, site5,
//				"interdum. Sed auctor odio a purus. Duis elementum, dui quis accumsan convallis, ante lectus convallis est, vitae sodales nisi magna sed dui. Fusce aliquam, enim nec tempus scelerisque, lorem ipsum sodales purus, in molestie tortor nibh sit amet orci. Ut sagittis lobortis mauris. Suspendisse aliquet",
//				commentaire25);
//		Commentaire commentaire23 = new Commentaire(utilisateurConnecte1, site5,
//				"malesuada. Integer id magna et ipsum cursus vestibulum. Mauris magna. Duis dignissim tempor arcu. Vestibulum",
//				commentaire21);
//		Commentaire commentaire24 = new Commentaire(utilisateurConnecte2, site5,
//				"diam luctus lobortis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos hymenaeos. Mauris ut",
//				commentaire21);
//		Commentaire commentaire26 = new Commentaire(utilisateurConnecte2, site5,
//				"facilisis lorem tristique aliquet. Phasellus fermentum convallis ligula. Donec luctus aliquet odio. Etiam ligula tortor, dictum eu, placerat eget, venenatis a, magna. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Etiam laoreet, libero",
//				commentaire25);
//
//		Commentaire commentaire27 = new Commentaire(membreAssociation1, site6,
//				"urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras");
//		Commentaire commentaire29 = new Commentaire(utilisateurConnecte2, site6,
//				"\"mi eleifend egestas. Sed pharetra, felis eget varius ultrices, mauris ipsum porta elit, a feugiat tellus lorem eu metus. In lorem. Donec elementum, lorem ut aliquam iaculis, lacus pede sagittis augue, eu tempor erat neque non quam. Pellentesque habitant morbi tristique senectus et netus et malesuada",
//				commentaire27);
//		Commentaire commentaire30 = new Commentaire(membreAssociation2, site6,
//				"pellentesque, tellus sem mollis dui, in sodales elit erat vitae risus. Duis a mi fringilla mi lacinia mattis. Integer eu lacus. Quisque imperdiet, erat nonummy ultricies ornare, elit elit fermentum risus, at fringilla purus mauris a nunc. In at pede. Cras vulputate",
//				commentaire27);
//		Commentaire commentaire28 = new Commentaire(membreAssociation1, site6,
//				"est tempor bibendum. Donec felis orci, adipiscing non, luctus sit amet, faucibus ut, nulla. Cras eu tellus",
//				commentaire27);
//
//		Commentaire commentaire31 = new Commentaire(membreAssociation1, site7,
//				"Nam porttitor scelerisque neque. Nullam nisl. Maecenas malesuada fringilla est. Mauris eu turpis. Nulla aliquet. Proin velit. Sed malesuada augue");
//		Commentaire commentaire33 = new Commentaire(utilisateurConnecte1, site7,
//				"enim, condimentum eget, volutpat ornare, facilisis eget, ipsum. Donec sollicitudin adipiscing ligula. Aenean gravida nunc sed pede. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel arcu eu odio tristique pharetra. Quisque ac libero nec ligula consectetuer rhoncus. Nullam",
//				commentaire31);
//		Commentaire commentaire34 = new Commentaire(utilisateurConnecte1, site7,
//				"diam. Proin dolor. Nulla semper tellus id nunc interdum feugiat. Sed nec metus facilisis lorem tristique aliquet. Phasellus fermentum convallis ligula. Donec luctus aliquet odio. Etiam ligula tortor, dictum eu, placerat eget, venenatis a, magna. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Etiam laoreet, libero e");
//		Commentaire commentaire36 = new Commentaire(utilisateurConnecte2, site7,
//				"amet, faucibus ut, nulla. Cras eu tellus eu augue porttitor interdum. Sed auctor odio a purus. Duis elementum, dui quis accumsan convallis, ante lectus convallis est, vitae sodales nisi magna sed dui. Fusce aliquam, enim nec tempus scelerisque, lorem ipsum sodales purus, in molestie tortor nibh",
//				commentaire34);
//		Commentaire commentaire35 = new Commentaire(utilisateurConnecte1, site7,
//				"arcu vel quam dignissim pharetra. Nam ac nulla. In tincidunt congue turpis. In condimentum. Donec at arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices",
//				commentaire34);
//		Commentaire commentaire37 = new Commentaire(utilisateurConnecte2, site7,
//				"mauris eu elit. Nulla facilisi. Sed neque. Sed eget lacus. Mauris non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus orci",
//				commentaire34);
//		Commentaire commentaire32 = new Commentaire(membreAssociation1, site7,
//				"sapien. Aenean massa. Integer vitae nibh. Donec est mauris, rhoncus id, mollis nec, cursus a, enim. Suspendisse aliquet, sem ut cursus luctus, ipsum leo elementum sem, vitae aliquam eros turpis non enim. Mauris quis",
//				commentaire31);
//
//		Commentaire commentaire38 = new Commentaire(membreAssociation1, site8,
//				"Sed neque. Sed eget lacus. Mauris non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus ornare. Fusce mollis. Duis sit amet diam eu dolor egestas rhoncus. Proin nisl sem, consequat nec, mollis vitae, posuere at,");
//		Commentaire commentaire40 = new Commentaire(membreAssociation2, site8,
//				"Mauris molestie pharetra nibh. Aliquam ornare, libero at auctor ullamcorper, nisl arcu iaculis enim, sit amet ornare lectus justo");
//		Commentaire commentaire39 = new Commentaire(membreAssociation1, site8,
//				"posuere cubilia Curae; Donec tincidunt. Donec vitae erat vel pede blandit congue. In scelerisque scelerisque dui. Suspendisse ac metus vitae velit egestas lacinia. Sed congue, elit sed consequat auctor, nunc nulla",
//				commentaire40);
//
//		Commentaire commentaire42 = new Commentaire(utilisateurConnecte2, site9,
//				"eu, accumsan sed, facilisis vitae, orci. Phasellus dapibus quam quis diam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce aliquet magna a neque. Nullam ut nisi a odio semper cursus. Integer mollis. Integer tincidunt aliquam arcu. Aliquam ultrices iaculis odio.");
//		Commentaire commentaire41 = new Commentaire(utilisateurConnecte1, site9,
//				"non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus",
//				commentaire42);
//		Commentaire commentaire43 = new Commentaire(utilisateurConnecte2, site9,
//				"augue eu tellus. Phasellus elit pede, malesuada vel, venenatis vel, faucibus id, libero. Donec consectetuer mauris id sapien. Cras dolor dolor, tempus non, lacinia at, iaculis quis,",
//				commentaire42);
//
//		Commentaire commentaire44 = new Commentaire(membreAssociation1, site10,
//				"dis parturient montes, nascetur ridiculus mus. Aenean eget magna. Suspendisse tristique neque venenatis lacus. Etiam bibendum fermentum metus. Aenean sed pede nec ante blandit viverra. Donec tempus, lorem fringilla ornare placerat, orci lacus vestibulum lorem, sit amet ultricies sem magna nec quam. Curabitur vel lectus. Cum");
//		Commentaire commentaire47 = new Commentaire(membreAssociation2, site10,
//				"Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec dignissim magna",
//				commentaire44);
//		Commentaire commentaire48 = new Commentaire(membreAssociation2, site10,
//				"euismod est arcu ac orci. Ut semper pretium neque. Morbi quis urna. Nunc quis arcu vel quam dignissim pharetra. Nam ac nulla. In tincidunt congue turpis. In");
//		Commentaire commentaire45 = new Commentaire(membreAssociation1, site10,
//				"purus gravida sagittis. Duis gravida. Praesent eu nulla at sem molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est,",
//				commentaire48);
//		Commentaire commentaire46 = new Commentaire(membreAssociation1, site10,
//				"parturient montes, nascetur ridiculus mus. Aenean eget magna. Suspendisse tristique neque venenatis lacus. Etiam bibendum fermentum metus. Aenean sed pede nec ante blandit viverra.",
//				commentaire44);
//		Commentaire commentaire49 = new Commentaire(utilisateurConnecte1, site10,
//				"molestie in, tempus eu, ligula. Aenean euismod mauris eu elit. Nulla facilisi. Sed neque. Sed eget lacus. Mauris non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere",
//				commentaire48);
//		Commentaire commentaire50 = new Commentaire(utilisateurConnecte2, site10,
//				"pretium et, rutrum non, hendrerit id, ante. Nunc mauris sapien, cursus in, hendrerit consectetuer, cursus et, magna. Praesent interdum ligula eu enim. Etiam imperdiet dictum",
//				commentaire44);
//
//		Commentaire commentaire51 = new Commentaire(membreAssociation1, site11,
//				"pede. Cras vulputate velit eu sem. Pellentesque ut ipsum ac mi eleifend egestas. Sed pharetra, felis eget varius ultrices, mauris ipsum porta elit, a feugiat tellus lorem eu metus. In");
//		Commentaire commentaire54 = new Commentaire(membreAssociation2, site11,
//				"vel, venenatis vel, faucibus id, libero. Donec consectetuer mauris id sapien. Cras dolor dolor, tempus non, lacinia at, iaculis quis, pede. Praesent eu dui. Cum sociis natoque penatibus et magnis dis parturient montes,",
//				commentaire51);
//		Commentaire commentaire55 = new Commentaire(membreAssociation2, site11,
//				"lorem, eget mollis lectus pede et risus. Quisque libero lacus, varius et, euismod et, commodo at, libero. Morbi accumsan laoreet ipsum. Curabitur consequat, lectus sit amet luctus vulputate, nisi sem semper erat,");
//		Commentaire commentaire56 = new Commentaire(utilisateurConnecte1, site11,
//				"non, dapibus rutrum, justo. Praesent luctus. Curabitur egestas nunc sed libero. Proin sed turpis nec mauris blandit mattis.",
//				commentaire51);
//		Commentaire commentaire57 = new Commentaire(utilisateurConnecte1, site11,
//				"purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor. Quisque tincidunt",
//				commentaire55);
//		Commentaire commentaire58 = new Commentaire(utilisateurConnecte1, site11,
//				"Mauris non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices");
//		Commentaire commentaire52 = new Commentaire(membreAssociation1, site11,
//				"eu dolor egestas rhoncus. Proin nisl sem, consequat nec, mollis vitae, posuere at, velit. Cras lorem lorem, luctus ut,",
//				commentaire58);
//		Commentaire commentaire53 = new Commentaire(membreAssociation1, site11,
//				"gravida. Praesent eu nulla at sem molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est, congue a, aliquet vel, vulputate eu, odio. Phasellus at augue id ante dictum cursus. Nunc mauris elit, dictum eu, eleifend nec, malesuada ut,",
//				commentaire51);
//
//		Commentaire commentaire59 = new Commentaire(utilisateurConnecte1, site12,
//				"ligula consectetuer rhoncus. Nullam velit dui, semper et, lacinia vitae, sodales at, velit. Pellentesque ultricies dignissim lacus. Aliquam rutrum lorem ac risus. Morbi metus. Vivamus euismod urna. Nullam lobortis quam a felis ullamcorper viverra. Maecenas iaculis aliquet diam. Sed diam lorem, auctor quis, tristique ac, eleifend vitae,");
//		Commentaire commentaire60 = new Commentaire(membreAssociation2, site12,
//				"adipiscing. Mauris molestie pharetra nibh. Aliquam ornare, libero at auctor ullamcorper, nisl arcu iaculis enim, sit amet ornare lectus justo eu arcu. Morbi sit amet");
//
//		Commentaire commentaire61 = new Commentaire(membreAssociation2, site13,
//				"Donec egestas. Aliquam nec enim. Nunc ut erat. Sed nunc est, mollis non, cursus non, egestas a, dui. Cras pellentesque. Sed dictum. Proin eget odio. Aliquam vulputate ullamcorper magna. Sed eu eros. Nam consequat dolor vitae");
//		Commentaire commentaire63 = new Commentaire(utilisateurConnecte2, site13,
//				"vitae erat vel pede blandit congue. In scelerisque scelerisque dui. Suspendisse ac metus vitae velit egestas lacinia. Sed congue, elit sed consequat auctor, nunc nulla vulputate dui, nec tempus mauris erat eget ipsum. Suspendisse sagittis. Nullam vitae diam. Proin dolor. Nulla semper tellus id nunc",
//				commentaire61);
//		Commentaire commentaire62 = new Commentaire(membreAssociation2, site13,
//				"mus. Proin vel nisl. Quisque fringilla euismod enim. Etiam gravida molestie arcu. Sed eu nibh vulputate mauris sagittis placerat. Cras dictum ultricies ligula. Nullam enim. Sed nulla ante, iaculis nec, eleifend non, dapibus rutrum, justo. Praesent luctus. Curabitur egestas nunc sed libero.",
//				commentaire61);
//		Commentaire commentaire64 = new Commentaire(utilisateurConnecte2, site13,
//				"lobortis augue scelerisque mollis. Phasellus libero mauris, aliquam eu, accumsan sed, facilisis vitae, orci. Phasellus dapibus quam quis diam. Pellentesque habitant",
//				commentaire61);
//		Commentaire commentaire65 = new Commentaire(utilisateurConnecte2, site13,
//				"Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec tincidunt. Donec vitae erat vel pede blandit congue. In scelerisque scelerisque dui. Suspendisse ac metus vitae velit egestas");
//
//		Commentaire commentaire66 = new Commentaire(utilisateurConnecte2, site14,
//				"dictum mi, ac mattis velit justo nec ante. Maecenas mi felis, adipiscing fringilla, porttitor vulputate, posuere vulputate, lacus. Cras interdum. Nunc sollicitudin commodo ipsum. Suspendisse non leo. Vivamus nibh dolor, nonummy");
//		Commentaire commentaire68 = new Commentaire(utilisateurConnecte1, site14,
//				"ut, pharetra sed, hendrerit a, arcu. Sed et libero. Proin mi. Aliquam gravida mauris ut mi. Duis risus odio, auctor vitae, aliquet nec, imperdiet nec, leo. Morbi neque tellus, imperdiet non,");
//		Commentaire commentaire67 = new Commentaire(utilisateurConnecte2, site14,
//				"amet, faucibus ut, nulla. Cras eu tellus eu augue porttitor interdum. Sed auctor odio a purus. Duis elementum, dui quis accumsan convallis, ante lectus convallis est, vitae sodales nisi magna sed dui. Fusce aliquam, enim nec tempus scelerisque, lorem ipsum",
//				commentaire68);
//		Commentaire commentaire69 = new Commentaire(utilisateurConnecte1, site14,
//				"Aliquam ultrices iaculis odio. Nam interdum enim non nisi. Aenean eget metus. In nec orci. Donec nibh. Quisque nonummy ipsum non",
//				commentaire66);
//		Commentaire commentaire70 = new Commentaire(utilisateurConnecte1, site14,
//				"ut ipsum ac mi eleifend egestas. Sed pharetra, felis eget varius ultrices, mauris ipsum porta elit, a feugiat tellus lorem eu metus. In lorem. Donec elementum, lorem ut aliquam iaculis, lacus pede sagittis augue, eu tempor erat neque non quam. Pellentesque habitant morbi tristique senectus et netus et");
//
//		Commentaire commentaire71 = new Commentaire(membreAssociation1, site15,
//				"magnis dis parturient montes, nascetur ridiculus mus. Proin vel nisl. Quisque fringilla euismod enim. Etiam gravida molestie arcu. Sed eu nibh vulputate mauris sagittis placerat. Cras dictum ultricies ligula. Nullam enim. Sed nulla ante, iaculis nec, eleifend non, dapibus");
//		Commentaire commentaire73 = new Commentaire(utilisateurConnecte1, site15,
//				"tincidunt tempus risus. Donec egestas. Duis ac arcu. Nunc mauris. Morbi non sapien molestie orci tincidunt adipiscing. Mauris",
//				commentaire71);
//		Commentaire commentaire72 = new Commentaire(membreAssociation1, site15,
//				"erat, in consectetuer ipsum nunc id enim. Curabitur massa. Vestibulum accumsan neque et nunc. Quisque ornare tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam tincidunt,");
//		Commentaire commentaire74 = new Commentaire(utilisateurConnecte1, site15,
//				"placerat. Cras dictum ultricies ligula. Nullam enim. Sed nulla ante, iaculis nec, eleifend non, dapibus rutrum, justo. Praesent luctus. Curabitur egestas nunc sed libero. Proin sed turpis nec mauris blandit",
//				commentaire72);
//
//		Commentaire commentaire75 = new Commentaire(membreAssociation2, site16,
//				"gravida nunc sed pede. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel");
//		Commentaire commentaire78 = new Commentaire(utilisateurConnecte2, site16,
//				"lacus vestibulum lorem, sit amet ultricies sem magna nec quam. Curabitur vel lectus. Cum sociis natoque");
//		Commentaire commentaire76 = new Commentaire(membreAssociation2, site16,
//				"varius et, euismod et, commodo at, libero. Morbi accumsan laoreet ipsum. Curabitur consequat, lectus sit amet luctus vulputate, nisi sem semper erat, in consectetuer ipsum nunc id enim. Curabitur massa. Vestibulum accumsan neque et nunc. Quisque ornare tortor at risus. Nunc ac sem ut dolor dapibus",
//				commentaire75);
//		Commentaire commentaire77 = new Commentaire(membreAssociation2, site16,
//				"arcu. Vivamus sit amet risus. Donec egestas. Aliquam nec enim. Nunc ut erat. Sed nunc est, mollis non, cursus non, egestas a, dui. Cras pellentesque. Sed",
//				commentaire75);
//		Commentaire commentaire79 = new Commentaire(utilisateurConnecte2, site16,
//				"aliquam eu, accumsan sed, facilisis vitae, orci. Phasellus dapibus quam quis diam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce aliquet magna a neque. Nullam ut nisi a",
//				commentaire75);
//		Commentaire commentaire80 = new Commentaire(membreAssociation1, site16,
//				"erat neque non quam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis",
//				commentaire78);
//
//		Commentaire commentaire81 = new Commentaire(utilisateurConnecte2, site17,
//				"Phasellus ornare. Fusce mollis. Duis sit amet diam eu dolor egestas rhoncus. Proin nisl sem, consequat nec,");
//		Commentaire commentaire83 = new Commentaire(membreAssociation1, site17,
//				"vestibulum. Mauris magna. Duis dignissim tempor arcu. Vestibulum ut eros non enim commodo hendrerit. Donec porttitor");
//		Commentaire commentaire82 = new Commentaire(utilisateurConnecte2, site17,
//				"pede. Suspendisse dui. Fusce diam nunc, ullamcorper eu, euismod ac, fermentum vel, mauris. Integer sem elit, pharetra ut, pharetra sed, hendrerit a, arcu. Sed et libero. Proin mi. Aliquam gravida mauris ut mi. Duis risus",
//				commentaire83);
//		Commentaire commentaire84 = new Commentaire(membreAssociation1, site17,
//				"montes, nascetur ridiculus mus. Proin vel nisl. Quisque fringilla euismod enim. Etiam gravida molestie arcu. Sed eu nibh vulputate mauris sagittis placerat. Cras dictum ultricies ligula. Nullam enim. Sed nulla ante, iaculis nec, eleifend non, dapibus rutrum, justo. Praesent luctus. Curabitur egestas nunc sed libero. Proin sed",
//				commentaire81);
//		Commentaire commentaire85 = new Commentaire(membreAssociation1, site17,
//				"mauris sit amet lorem semper auctor. Mauris vel turpis. Aliquam adipiscing lobortis risus. In mi pede, nonummy ut,",
//				commentaire83);
//
//		Commentaire commentaire86 = new Commentaire(utilisateurConnecte2, site18,
//				"in magna. Phasellus dolor elit, pellentesque a, facilisis non, bibendum sed, est. Nunc laoreet lectus quis massa. Mauris vestibulum, neque sed dictum eleifend, nunc risus varius orci, in consequat enim");
//		Commentaire commentaire89 = new Commentaire(membreAssociation1, site18,
//				"et magnis dis parturient montes, nascetur ridiculus mus. Aenean eget magna. Suspendisse tristique neque venenatis lacus. Etiam bibendum fermentum metus. Aenean sed pede nec ante blandit viverra. Donec tempus, lorem");
//		Commentaire commentaire87 = new Commentaire(utilisateurConnecte2, site18,
//				"nascetur ridiculus mus. Proin vel nisl. Quisque fringilla euismod enim. Etiam gravida molestie arcu. Sed eu nibh vulputate mauris sagittis placerat. Cras dictum ultricies ligula. Nullam enim. Sed nulla",
//				commentaire89);
//		Commentaire commentaire88 = new Commentaire(utilisateurConnecte2, site18,
//				"odio. Aliquam vulputate ullamcorper magna. Sed eu eros. Nam consequat dolor vitae dolor. Donec fringilla. Donec feugiat metus sit amet ante. Vivamus non lorem vitae odio sagittis semper. Nam tempor diam dictum sapien. Aenean massa. Integer vitae nibh. Donec est mauris, rhoncus id,");
//		Commentaire commentaire90 = new Commentaire(membreAssociation1, site18,
//				"Vivamus non lorem vitae odio sagittis semper. Nam tempor diam dictum sapien. Aenean massa. Integer vitae nibh. Donec",
//				commentaire88);
//
//		Commentaire commentaire91 = new Commentaire(utilisateurConnecte1, site19,
//				"lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat.");
//		Commentaire commentaire93 = new Commentaire(utilisateurConnecte2, site19,
//				"erat. Vivamus nisi. Mauris nulla. Integer urna. Vivamus molestie dapibus ligula. Aliquam erat volutpat. Nulla dignissim. Maecenas ornare egestas ligula. Nullam feugiat placerat velit. Quisque varius. Nam porttitor scelerisque neque. Nullam nisl. Maecenas malesuada fringilla est. Mauris eu turpis. Nulla");
//		Commentaire commentaire92 = new Commentaire(utilisateurConnecte1, site19,
//				"Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a,",
//				commentaire93);
//		Commentaire commentaire95 = new Commentaire(membreAssociation2, site19,
//				"risus varius orci, in consequat enim diam vel arcu. Curabitur ut odio vel est tempor bibendum. Donec felis orci, adipiscing non, luctus sit amet, faucibus ut, nulla. Cras eu tellus eu augue porttitor interdum. Sed auctor odio a purus. Duis elementum, dui quis accumsan convallis, ante lectus",
//				commentaire93);
//		Commentaire commentaire94 = new Commentaire(utilisateurConnecte2, site19,
//				"Cras convallis convallis dolor. Quisque tincidunt pede ac urna. Ut tincidunt vehicula risus. Nulla eget metus eu erat semper rutrum. Fusce dolor",
//				commentaire93);
//		Commentaire commentaire96 = new Commentaire(membreAssociation2, site19,
//				"Sed neque. Sed eget lacus. Mauris non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus ornare. Fusce mollis. Duis sit amet",
//				commentaire93);
//		Commentaire commentaire97 = new Commentaire(membreAssociation2, site19,
//				"malesuada vel, venenatis vel, faucibus id, libero. Donec consectetuer mauris id sapien. Cras dolor dolor, tempus non, lacinia at, iaculis quis, pede. Praesent eu dui. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aenean eget");
//
//		Commentaire commentaire98 = new Commentaire(membreAssociation2, site20,
//				"non enim. Mauris quis turpis vitae purus gravida sagittis. Duis gravida. Praesent eu nulla at sem molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est, congue");
//		Commentaire commentaire99 = new Commentaire(utilisateurConnecte1, site20,
//				"congue, elit sed consequat auctor, nunc nulla vulputate dui, nec tempus mauris erat eget ipsum. Suspendisse sagittis. Nullam vitae diam. Proin dolor. Nulla semper tellus id nunc interdum feugiat. Sed nec metus facilisis lorem tristique aliquet. Phasellus fermentum convallis ligula. Donec luctus aliquet odio. Etiam ligula tortor, dictum eu,",
//				commentaire98);
//		Commentaire commentaire100 = new Commentaire(membreAssociation1, site20,
//				"nulla. Cras eu tellus eu augue porttitor interdum. Sed auctor odio a purus. Duis elementum, dui quis accumsan convallis, ante lectus convallis est, vitae sodales nisi magna sed dui. Fusce aliquam, enim nec tempus scelerisque, lorem ipsum sodales purus, in molestie tortor nibh sit amet orci. Ut sagittis lobortis mauris.",
//				commentaire98);
//
//		List<Commentaire> listeCommentaires = Arrays.asList(commentaire1, commentaire2, commentaire3, commentaire4,
//				commentaire5, commentaire6, commentaire7, commentaire8, commentaire9, commentaire10, commentaire11,
//				commentaire12, commentaire13, commentaire14, commentaire15, commentaire16, commentaire17, commentaire18,
//				commentaire19, commentaire20, commentaire21, commentaire22, commentaire23, commentaire24, commentaire25,
//				commentaire26, commentaire27, commentaire28, commentaire29, commentaire30, commentaire31, commentaire32,
//				commentaire33, commentaire34, commentaire35, commentaire36, commentaire37, commentaire38, commentaire39,
//				commentaire40, commentaire41, commentaire42, commentaire43, commentaire44, commentaire45, commentaire46,
//				commentaire47, commentaire48, commentaire49, commentaire50, commentaire51, commentaire52, commentaire53,
//				commentaire54, commentaire55, commentaire56, commentaire57, commentaire58, commentaire59, commentaire60,
//				commentaire61, commentaire62, commentaire63, commentaire64, commentaire65, commentaire66, commentaire67,
//				commentaire68, commentaire69, commentaire70, commentaire71, commentaire72, commentaire73, commentaire74,
//				commentaire75, commentaire76, commentaire77, commentaire78, commentaire79, commentaire80, commentaire81,
//				commentaire82, commentaire83, commentaire84, commentaire85, commentaire86, commentaire87, commentaire88,
//				commentaire89, commentaire90, commentaire91, commentaire92, commentaire93, commentaire94, commentaire95,
//				commentaire96, commentaire97, commentaire98, commentaire99, commentaire100);
//
//		commentaireRepository.saveAll(listeCommentaires);
//
//		Secteur secteur1 = new Secteur("nomSecteur1",
//				"dictum augue malesuada malesuada. Integer id magna et ipsum cursus vestibulum. Mauris magna. Duis dignissim tempor arcu. Vestibulum ut");
//		Secteur secteur2 = new Secteur("nomSecteur2",
//				"Aliquam erat volutpat. Nulla dignissim. Maecenas ornare egestas ligula. Nullam feugiat placerat velit. Quisque varius. Nam porttitor scelerisque neque. Nullam nisl. Maecenas malesuada fringilla est. Mauris eu turpis. Nulla aliquet. Proin velit. Sed malesuada augue ut lacus. Nulla tincidunt, neque");
//		Secteur secteur3 = new Secteur("nomSecteur3",
//				"et ipsum cursus vestibulum. Mauris magna. Duis dignissim tempor arcu. Vestibulum ut eros non enim commodo hendrerit. Donec porttitor tellus non magna. Nam ligula elit, pretium et, rutrum non, hendrerit id, ante.");
//		Secteur secteur4 = new Secteur("nomSecteur4",
//				"lobortis ultrices. Vivamus rhoncus. Donec est. Nunc ullamcorper, velit in aliquet lobortis, nisi nibh lacinia orci, consectetuer euismod est arcu ac orci. Ut semper pretium neque. Morbi quis");
//		Secteur secteur5 = new Secteur("nomSecteur5",
//				"ac risus. Morbi metus. Vivamus euismod urna. Nullam lobortis quam a felis ullamcorper viverra. Maecenas iaculis aliquet");
//		Secteur secteur6 = new Secteur("nomSecteur6",
//				"aoreet lectus quis massa. Mauris vestibulum, neque sed dictum eleifend, nunc risus varius orci, in consequat enim diam vel arcu. Curabitur ut odio vel est tempor bibendum. Donec felis orci, adipiscing non, luctus sit amet, faucibus ut");
//		Secteur secteur7 = new Secteur("nomSecteur7",
//				"sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel arcu eu odio tristique pharetra. Quisque ac libero nec ligula consectetuer rhoncus. Nullam velit dui, semper");
//		Secteur secteur8 = new Secteur("nomSecteur8",
//				"justo nec ante. Maecenas mi felis, adipiscing fringilla, porttitor vulputate, posuere vulputate, lacus. Cras interdum. Nunc sollicitudin commodo ipsum. Suspendisse non leo. Vivamus nibh dolor, nonummy ac, feugiat non, lobortis quis, pede. Suspendisse dui. Fusce diam nunc, ullamcorper eu, euismod");
//		Secteur secteur9 = new Secteur("nomSecteur9",
//				"rhoncus. Nullam velit dui, semper et, lacinia vitae, sodales at, velit. Pellentesque ultricies dignissim lacus.");
//		Secteur secteur10 = new Secteur("nomSecteur10",
//				"nunc risus varius orci, in consequat enim diam vel arcu. Curabitur ut odio vel est");
//		Secteur secteur11 = new Secteur("nomSecteur11",
//				"velit egestas lacinia. Sed congue, elit sed consequat auctor, nunc nulla vulputate dui, nec tempus mauris erat eget ipsum. Suspendisse sagittis. Nullam vitae diam. Proin dolor. Nulla semper tellus id nunc interdum feugiat. Sed nec metus facilisis lorem tristique aliquet. Phasellus fermentum convallis ligula. Donec luctus aliquet odio.");
//		Secteur secteur12 = new Secteur("nomSecteur12",
//				"hendrerit a, arcu. Sed et libero. Proin mi. Aliquam gravida mauris ut mi. Duis risus odio, auctor vitae, aliquet nec, imperdiet nec, leo. Morbi neque tellus, imperdiet non, vestibulum nec, euismod in, dolor. Fusce feugiat. Lorem ipsum dolor");
//		Secteur secteur13 = new Secteur("nomSecteur13",
//				"purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis");
//		Secteur secteur14 = new Secteur("nomSecteur14",
//				"semper pretium neque. Morbi quis urna. Nunc quis arcu vel quam dignissim pharetra. Nam ac nulla. In tincidunt congue turpis. In condimentum. Donec at arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec tincidunt. Donec vitae erat");
//		Secteur secteur15 = new Secteur("nomSecteur15",
//				"adipiscing elit. Etiam laoreet, libero et tristique pellentesque, tellus sem mollis dui, in sodales elit erat vitae risus. Duis");
//		Secteur secteur16 = new Secteur("nomSecteur16",
//				"non magna. Nam ligula elit, pretium et, rutrum non, hendrerit id, ante. Nunc mauris sapien, cursus in, hendrerit consectetuer, cursus et, magna. Praesent interdum ligula eu enim. Etiam");
//		Secteur secteur17 = new Secteur("nomSecteur17",
//				"Nam ligula elit, pretium et, rutrum non, hendrerit id, ante. Nunc mauris sapien, cursus in, hendrerit consectetuer, cursus et, magna. Praesent interdum ligula eu enim. Etiam imperdiet dictum magna. Ut tincidunt orci quis lectus. Nullam suscipit, est ac facilisis facilisis, magna tellus faucibus leo, in lobortis tellus justo");
//		Secteur secteur18 = new Secteur("nomSecteur18",
//				"quis arcu vel quam dignissim pharetra. Nam ac nulla. In tincidunt congue turpis. In condimentum. Donec at arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec tincidunt. Donec vitae erat vel pede blandit congue. In scelerisque scelerisque dui. Suspendisse ac metus vitae velit egestas");
//		Secteur secteur19 = new Secteur("nomSecteur19",
//				"metus. In nec orci. Donec nibh. Quisque nonummy ipsum non arcu. Vivamus sit amet risus. Donec egestas. Aliquam nec enim. Nunc ut erat. Sed nunc est, mollis non, cursus non, egestas a, dui. Cras pellentesque. Sed dictum. Proin eget odio. Aliquam vulputate");
//		Secteur secteur20 = new Secteur("nomSecteur20",
//				"Suspendisse sed dolor. Fusce mi lorem, vehicula et, rutrum eu, ultrices sit amet, risus. Donec nibh enim, gravida sit amet, dapibus id, blandit at, nisi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel nisl. Quisque fringilla euismod enim.");
//		Secteur secteur21 = new Secteur("nomSecteur21",
//				"tristique neque venenatis lacus. Etiam bibendum fermentum metus. Aenean sed pede nec ante blandit viverra. Donec tempus,");
//		Secteur secteur22 = new Secteur("nomSecteur22",
//				"sem ut dolor dapibus gravida. Aliquam tincidunt, nunc ac mattis ornare, lectus ante dictum mi, ac mattis velit justo nec ante. Maecenas mi felis, adipiscing fringilla, porttitor vulputate, posuere vulputate, lacus. Cras interdum. Nunc sollicitudin commodo ipsum. Suspendisse");
//		Secteur secteur23 = new Secteur("nomSecteur23",
//				"magnis dis parturient montes, nascetur ridiculus mus. Donec dignissim magna a tortor. Nunc commodo auctor velit. Aliquam nisl. Nulla eu neque pellentesque massa lobortis ultrices. Vivamus rhoncus. Donec est. Nunc ullamcorper, velit in aliquet lobortis, nisi nibh lacinia orci, consectetuer euismod est arcu ac orci. Ut semper pretium neque. Morbi");
//		Secteur secteur24 = new Secteur("nomSecteur24",
//				"tincidunt. Donec vitae erat vel pede blandit congue. In scelerisque scelerisque dui. Suspendisse ac metus vitae velit");
//		Secteur secteur25 = new Secteur("nomSecteur25",
//				"eu nibh vulputate mauris sagittis placerat. Cras dictum ultricies ligula. Nullam enim. Sed nulla ante, iaculis nec, eleifend non, dapibus rutrum, justo. Praesent luctus. Curabitur egestas nunc sed libero. Proin sed turpis nec mauris blandit mattis. Cras eget nisi dictum");
//		Secteur secteur26 = new Secteur("nomSecteur26",
//				"et netus et malesuada fames ac turpis egestas. Aliquam fringilla cursus purus. Nullam scelerisque neque");
//		Secteur secteur27 = new Secteur("nomSecteur27",
//				"adipiscing, enim mi tempor lorem, eget mollis lectus pede et risus. Quisque libero lacus, varius et, euismod et, commodo at, libero. Morbi accumsan laoreet ipsum. Curabitur consequat, lectus sit amet luctus vulputate,");
//		Secteur secteur28 = new Secteur("nomSecteur28",
//				"mauris eu elit. Nulla facilisi. Sed neque. Sed eget lacus. Mauris non dui nec urna suscipit nonummy. Fusce fermentum fermentum");
//		Secteur secteur29 = new Secteur("nomSecteur29",
//				"odio. Phasellus at augue id ante dictum cursus. Nunc mauris elit, dictum eu, eleifend nec,");
//		Secteur secteur30 = new Secteur("nomSecteur30",
//				"Nullam vitae diam. Proin dolor. Nulla semper tellus id nunc interdum feugiat. Sed nec metus facilisis lorem tristique aliquet. Phasellus fermentum convallis ligula. Donec luctus aliquet odio. Etiam ligula tortor, dictum eu, placerat eget, venenatis a, magna. Lorem ipsum dolor sit amet, consectetuer");
//		Secteur secteur31 = new Secteur("nomSecteur31",
//				"Etiam bibendum fermentum metus. Aenean sed pede nec ante blandit viverra. Donec tempus, lorem fringilla ornare placerat, orci lacus vestibulum lorem, sit amet ultricies sem magna nec quam. Curabitur vel lectus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec dignissim magna a");
//		Secteur secteur32 = new Secteur("nomSecteur32",
//				"Curabitur dictum. Phasellus in felis. Nulla tempor augue ac ipsum. Phasellus vitae mauris sit amet lorem semper auctor. Mauris vel turpis. Aliquam adipiscing lobortis risus. In mi pede, nonummy ut, molestie in, tempus");
//		Secteur secteur33 = new Secteur("nomSecteur33",
//				"at pede. Cras vulputate velit eu sem. Pellentesque ut ipsum ac mi eleifend egestas. Sed pharetra, felis eget varius ultrices, mauris ipsum porta elit, a feugiat tellus lorem eu metus. In lorem. Donec elementum, lorem");
//		Secteur secteur34 = new Secteur("nomSecteur34",
//				"elit fermentum risus, at fringilla purus mauris a nunc. In at pede. Cras vulputate velit eu sem. Pellentesque ut ipsum ac mi eleifend egestas. Sed pharetra, felis eget varius ultrices, mauris ipsum porta elit, a feugiat tellus lorem eu metus. In lorem. Donec elementum, lorem ut aliquam iaculis, lacus");
//		Secteur secteur35 = new Secteur("nomSecteur35",
//				"tempor lorem, eget mollis lectus pede et risus. Quisque libero lacus, varius et, euismod et, commodo at, libero. Morbi accumsan laoreet ipsum. Curabitur consequat, lectus sit amet luctus");
//		Secteur secteur36 = new Secteur("nomSecteur36",
//				"Suspendisse sed dolor. Fusce mi lorem, vehicula et, rutrum eu, ultrices sit amet, risus. Donec nibh enim, gravida sit amet, dapibus id, blandit at, nisi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel nisl. Quisque fringilla euismod enim. Etiam gravida molestie arcu. Sed");
//		Secteur secteur37 = new Secteur("nomSecteur37",
//				"lobortis ultrices. Vivamus rhoncus. Donec est. Nunc ullamcorper, velit in aliquet lobortis, nisi nibh lacinia orci, consectetuer euismod est arcu ac orci. Ut semper pretium neque. Morbi quis urna. Nunc quis arcu vel quam dignissim pharetra. Nam ac nulla. In tincidunt congue turpis.");
//		Secteur secteur38 = new Secteur("nomSecteur38",
//				"elit, pharetra ut, pharetra sed, hendrerit a, arcu. Sed et libero. Proin mi. Aliquam gravida mauris ut mi. Duis risus odio, auctor vitae, aliquet nec, imperdiet nec, leo. Morbi neque tellus, imperdiet non, vestibulum nec, euismod in, dolor. Fusce feugiat. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.");
//		Secteur secteur39 = new Secteur("nomSecteur39",
//				"aliquet, metus urna convallis erat, eget tincidunt dui augue eu tellus. Phasellus elit pede, malesuada vel, venenatis vel, faucibus id, libero. Donec consectetuer mauris id sapien. Cras");
//		Secteur secteur40 = new Secteur("nomSecteur40",
//				"\"id, blandit at, nisi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel nisl. Quisque fringilla euismod enim. Etiam gravida molestie arcu. Sed eu nibh vulputate mauris sagittis placerat. Cras dictum ultricies ligula. Nullam enim. Sed nulla ante, iaculis nec, eleifend non,");
//		Secteur secteur41 = new Secteur("nomSecteur41",
//				"mollis. Phasellus libero mauris, aliquam eu, accumsan sed, facilisis vitae, orci. Phasellus dapibus quam quis diam. Pellentesque habitant morbi tristique");
//		Secteur secteur42 = new Secteur("nomSecteur42",
//				"felis. Nulla tempor augue ac ipsum. Phasellus vitae mauris sit amet lorem semper auctor. Mauris vel turpis");
//		Secteur secteur43 = new Secteur("nomSecteur43",
//				"sollicitudin adipiscing ligula. Aenean gravida nunc sed pede. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel arcu");
//		Secteur secteur44 = new Secteur("nomSecteur44",
//				"dui quis accumsan convallis, ante lectus convallis est, vitae sodales nisi magna sed dui. Fusce aliquam, enim nec tempus scelerisque, lorem ipsum");
//		Secteur secteur45 = new Secteur("nomSecteur45",
//				"Praesent interdum ligula eu enim. Etiam imperdiet dictum magna. Ut tincidunt orci quis lectus. Nullam suscipit, est ac");
//		Secteur secteur46 = new Secteur("nomSecteur46",
//				"sodales nisi magna sed dui. Fusce aliquam, enim nec tempus scelerisque, lorem ipsum sodales purus, in molestie tortor nibh sit amet orci. Ut sagittis lobortis mauris. Suspendisse aliquet molestie tellus. Aenean egestas hendrerit neque. In ornare sagittis felis. Donec");
//		Secteur secteur47 = new Secteur("nomSecteur47",
//				"tempus eu, ligula. Aenean euismod mauris eu elit. Nulla facilisi. Sed neque. Sed eget lacus. Mauris non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus ornare. Fusce mollis. Duis sit amet diam eu dolor egestas");
//		Secteur secteur48 = new Secteur("nomSecteur48",
//				"vel lectus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec dignissim magna a tortor. Nunc commodo auctor velit. Aliquam nisl. Nulla eu neque pellentesque massa lobortis ultrices. Vivamus rhoncus. Donec est. Nunc ullamcorper, velit in aliquet");
//		Secteur secteur49 = new Secteur("nomSecteur49",
//				"non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus");
//		Secteur secteur50 = new Secteur("nomSecteur50",
//				"a, scelerisque sed, sapien. Nunc pulvinar arcu et pede. Nunc sed orci lobortis augue scelerisque mollis. Phasellus libero mauris, aliquam eu, accumsan");
//		Secteur secteur51 = new Secteur("nomSecteur51",
//				"consequat nec, mollis vitae, posuere at, velit. Cras lorem lorem, luctus ut, pellentesque eget, dictum placerat, augue. Sed molestie. Sed id risus quis diam luctus lobortis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos");
//		Secteur secteur52 = new Secteur("nomSecteur52",
//				"ornare. In faucibus. Morbi vehicula. Pellentesque tincidunt tempus risus. Donec egestas. Duis ac arcu. Nunc mauris. Morbi non sapien molestie orci tincidunt adipiscing. Mauris molestie pharetra nibh. Aliquam ornare, libero at auctor ullamcorper, nisl arcu iaculis enim, sit amet ornare lectus justo eu arcu. Morbi");
//		Secteur secteur53 = new Secteur("nomSecteur53",
//				"id, blandit at, nisi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel nisl.");
//		Secteur secteur54 = new Secteur("nomSecteur54",
//				"Etiam imperdiet dictum magna. Ut tincidunt orci quis lectus. Nullam suscipit, est ac facilisis facilisis, magna");
//		Secteur secteur55 = new Secteur("nomSecteur55",
//				"nonummy ultricies ornare, elit elit fermentum risus, at fringilla purus mauris a nunc. In at pede. Cras vulputate velit eu sem. Pellentesque ut ipsum ac mi eleifend egestas.");
//		Secteur secteur56 = new Secteur("nomSecteur56",
//				"ultrices sit amet, risus. Donec nibh enim, gravida sit amet, dapibus id, blandit at, nisi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel nisl. Quisque fringilla euismod enim. Etiam gravida molestie arcu. Sed eu nibh vulputate mauris sagittis placerat. Cras dictum ultricies");
//		Secteur secteur57 = new Secteur("nomSecteur57",
//				"feugiat non, lobortis quis, pede. Suspendisse dui. Fusce diam nunc, ullamcorper eu, euismod ac, fermentum vel, mauris. Integer sem elit, pharetra ut, pharetra sed, hendrerit a, arcu. Sed et libero. Proin mi. Aliquam gravida mauris ut");
//		Secteur secteur58 = new Secteur("nomSecteur58",
//				"magna, malesuada vel, convallis in, cursus et, eros. Proin ultrices. Duis volutpat nunc sit amet");
//		Secteur secteur59 = new Secteur("nomSecteur59",
//				"Proin non massa non ante bibendum ullamcorper. Duis cursus, diam at pretium aliquet, metus urna convallis erat, eget tincidunt dui augue eu tellus. Phasellus elit pede, malesuada vel, venenatis vel, faucibus id, libero. Donec consectetuer mauris id sapien. Cras dolor");
//		Secteur secteur60 = new Secteur("nomSecteur60",
//				"Donec vitae erat vel pede blandit congue. In scelerisque scelerisque dui. Suspendisse ac metus vitae velit egestas lacinia. Sed congue, elit sed consequat auctor, nunc nulla vulputate dui, nec tempus mauris erat eget ipsum. Suspendisse sagittis. Nullam vitae diam.");
//		secteur1.setSite(siteRepository.findById(1l).orElse(null));
//		secteur2.setSite(siteRepository.findById(1l).orElse(null));
//		secteur3.setSite(siteRepository.findById(1l).orElse(null));
//		secteur4.setSite(siteRepository.findById(1l).orElse(null));
//		secteur5.setSite(siteRepository.findById(1l).orElse(null));
//		secteur51.setSite(siteRepository.findById(1l).orElse(null));
//		secteur52.setSite(siteRepository.findById(1l).orElse(null));
//
//		secteur6.setSite(siteRepository.findById(2l).orElse(null));
//		secteur7.setSite(siteRepository.findById(2l).orElse(null));
//		secteur8.setSite(siteRepository.findById(2l).orElse(null));
//		secteur9.setSite(siteRepository.findById(2l).orElse(null));
//
//		secteur10.setSite(siteRepository.findById(3l).orElse(null));
//		secteur11.setSite(siteRepository.findById(3l).orElse(null));
//		secteur12.setSite(siteRepository.findById(3l).orElse(null));
//		secteur54.setSite(siteRepository.findById(3l).orElse(null));
//		secteur55.setSite(siteRepository.findById(3l).orElse(null));
//
//		secteur13.setSite(siteRepository.findById(4l).orElse(null));
//		secteur14.setSite(siteRepository.findById(4l).orElse(null));
//		secteur56.setSite(siteRepository.findById(4l).orElse(null));
//		secteur57.setSite(siteRepository.findById(4l).orElse(null));
//
//		secteur15.setSite(siteRepository.findById(5l).orElse(null));
//		secteur43.setSite(siteRepository.findById(5l).orElse(null));
//		secteur44.setSite(siteRepository.findById(5l).orElse(null));
//
//		secteur16.setSite(siteRepository.findById(6l).orElse(null));
//		secteur17.setSite(siteRepository.findById(6l).orElse(null));
//		secteur18.setSite(siteRepository.findById(6l).orElse(null));
//		secteur19.setSite(siteRepository.findById(6l).orElse(null));
//
//		secteur20.setSite(siteRepository.findById(7l).orElse(null));
//		secteur21.setSite(siteRepository.findById(7l).orElse(null));
//		secteur22.setSite(siteRepository.findById(7l).orElse(null));
//		secteur58.setSite(siteRepository.findById(7l).orElse(null));
//
//		secteur23.setSite(siteRepository.findById(8l).orElse(null));
//		secteur24.setSite(siteRepository.findById(8l).orElse(null));
//		secteur53.setSite(siteRepository.findById(8l).orElse(null));
//
//		secteur25.setSite(siteRepository.findById(9l).orElse(null));
//		secteur45.setSite(siteRepository.findById(9l).orElse(null));
//		secteur46.setSite(siteRepository.findById(9l).orElse(null));
//		secteur59.setSite(siteRepository.findById(9l).orElse(null));
//		secteur60.setSite(siteRepository.findById(9l).orElse(null));
//
//		secteur26.setSite(siteRepository.findById(11l).orElse(null));
//		secteur27.setSite(siteRepository.findById(11l).orElse(null));
//		secteur28.setSite(siteRepository.findById(11l).orElse(null));
//
//		secteur29.setSite(siteRepository.findById(12l).orElse(null));
//		secteur30.setSite(siteRepository.findById(12l).orElse(null));
//		secteur31.setSite(siteRepository.findById(12l).orElse(null));
//		secteur32.setSite(siteRepository.findById(12l).orElse(null));
//
//		secteur33.setSite(siteRepository.findById(14l).orElse(null));
//		secteur34.setSite(siteRepository.findById(14l).orElse(null));
//
//		secteur35.setSite(siteRepository.findById(16l).orElse(null));
//		secteur36.setSite(siteRepository.findById(16l).orElse(null));
//		secteur37.setSite(siteRepository.findById(16l).orElse(null));
//
//		secteur49.setSite(siteRepository.findById(17l).orElse(null));
//		secteur50.setSite(siteRepository.findById(17l).orElse(null));
//
//		secteur38.setSite(siteRepository.findById(18l).orElse(null));
//		secteur39.setSite(siteRepository.findById(18l).orElse(null));
//
//		secteur40.setSite(siteRepository.findById(20l).orElse(null));
//		secteur41.setSite(siteRepository.findById(20l).orElse(null));
//		secteur42.setSite(siteRepository.findById(20l).orElse(null));
//		secteur47.setSite(siteRepository.findById(20l).orElse(null));
//		secteur48.setSite(siteRepository.findById(20l).orElse(null));
//
//		List<Secteur> listeSecteurs = Arrays.asList(secteur1, secteur2, secteur3, secteur4, secteur6, secteur7,
//				secteur8, secteur9, secteur10, secteur11, secteur12, secteur13, secteur14, secteur15, secteur16,
//				secteur17, secteur18, secteur19, secteur20, secteur20, secteur21, secteur22, secteur23, secteur24,
//				secteur25, secteur26, secteur27, secteur28, secteur29, secteur30, secteur31, secteur32, secteur33,
//				secteur34, secteur35, secteur36, secteur37, secteur38, secteur39, secteur40, secteur41, secteur42,
//				secteur43, secteur44, secteur45, secteur46, secteur47, secteur48, secteur49, secteur50, secteur51,
//				secteur52, secteur53, secteur54, secteur55, secteur56, secteur57, secteur58, secteur59, secteur60);
//		secteurRepository.saveAll(listeSecteurs);
//
//		secteurRepository.saveAll(listeSecteurs);
//
//		Voie voie21 = new Voie(true, CotationBloc._4);
//		Voie voie22 = new Voie(true, CotationBloc._4);
//		Voie voie23 = new Voie(true, CotationBloc._4);
//		Voie voie24 = new Voie(false, CotationBloc._4);
//		Voie voie25 = new Voie(false, CotationBloc._4);
//		Voie voie26 = new Voie(false, CotationBloc._4);
//		Voie voie27 = new Voie(false, CotationBloc._4);
//		Voie voie28 = new Voie(false, CotationBloc._4);
//		Voie voie29 = new Voie(true, CotationBloc._4);
//
//		Voie voie31 = new Voie(false, CotationBloc._4plus);
//		Voie voie32 = new Voie(false, CotationBloc._4plus);
//		Voie voie33 = new Voie(false, CotationBloc._4plus);
//		Voie voie34 = new Voie(false, CotationBloc._4plus);
//		Voie voie35 = new Voie(false, CotationBloc._4plus);
//		Voie voie36 = new Voie(true, CotationBloc._4plus);
//		Voie voie37 = new Voie(true, CotationBloc._4plus);
//		Voie voie38 = new Voie(true, CotationBloc._4plus);
//		Voie voie39 = new Voie(true, CotationBloc._4plus);
//
//		Voie voie41 = new Voie(true, CotationBloc._5);
//		Voie voie42 = new Voie(true, CotationBloc._5);
//		Voie voie43 = new Voie(true, CotationBloc._5);
//		Voie voie44 = new Voie(true, CotationBloc._5);
//		Voie voie45 = new Voie(false, CotationBloc._5);
//		Voie voie46 = new Voie(false, CotationBloc._5);
//		Voie voie47 = new Voie(false, CotationBloc._5);
//		Voie voie48 = new Voie(false, CotationBloc._5);
//		Voie voie49 = new Voie(false, CotationBloc._5);
//
//		Voie voie51 = new Voie(false, CotationBloc._5plus);
//		Voie voie52 = new Voie(false, CotationBloc._5plus);
//		Voie voie53 = new Voie(false, CotationBloc._5plus);
//		Voie voie54 = new Voie(false, CotationBloc._5plus);
//		Voie voie55 = new Voie(false, CotationBloc._5plus);
//		Voie voie56 = new Voie(true, CotationBloc._5plus);
//		Voie voie57 = new Voie(true, CotationBloc._5plus);
//		Voie voie58 = new Voie(true, CotationBloc._5plus);
//		Voie voie59 = new Voie(true, CotationBloc._5plus);
//
//		Voie voie61 = new Voie(true, CotationBloc._6A);
//		Voie voie62 = new Voie(true, CotationBloc._6A);
//		Voie voie63 = new Voie(true, CotationBloc._6A);
//		Voie voie64 = new Voie(true, CotationBloc._6A);
//		Voie voie65 = new Voie(false, CotationBloc._6A);
//		Voie voie66 = new Voie(false, CotationBloc._6A);
//		Voie voie67 = new Voie(false, CotationBloc._6A);
//		Voie voie68 = new Voie(false, CotationBloc._6A);
//		Voie voie69 = new Voie(false, CotationBloc._6A);
//
//		Voie voie71 = new Voie(false, CotationBloc._6Aplus);
//		Voie voie72 = new Voie(false, CotationBloc._6Aplus);
//		Voie voie73 = new Voie(false, CotationBloc._6Aplus);
//		Voie voie74 = new Voie(false, CotationBloc._6Aplus);
//		Voie voie75 = new Voie(false, CotationBloc._6Aplus);
//		Voie voie76 = new Voie(true, CotationBloc._6Aplus);
//		Voie voie77 = new Voie(true, CotationBloc._6Aplus);
//		Voie voie78 = new Voie(true, CotationBloc._6Aplus);
//		Voie voie79 = new Voie(true, CotationBloc._6Aplus);
//
//		Voie voie81 = new Voie(true, CotationBloc._6B);
//		Voie voie82 = new Voie(true, CotationBloc._6B);
//		Voie voie83 = new Voie(true, CotationBloc._6B);
//		Voie voie84 = new Voie(true, CotationBloc._6B);
//		Voie voie85 = new Voie(false, CotationBloc._6B);
//		Voie voie86 = new Voie(false, CotationBloc._6B);
//		Voie voie87 = new Voie(false, CotationBloc._6B);
//		Voie voie88 = new Voie(false, CotationBloc._6B);
//		Voie voie89 = new Voie(false, CotationBloc._6B);
//
//		Voie voie101 = new Voie(false, CotationBloc._6Bplus);
//		Voie voie102 = new Voie(false, CotationBloc._6Bplus);
//		Voie voie103 = new Voie(false, CotationBloc._6Bplus);
//		Voie voie104 = new Voie(false, CotationBloc._6Bplus);
//		Voie voie105 = new Voie(false, CotationBloc._6Bplus);
//		Voie voie106 = new Voie(true, CotationBloc._6Bplus);
//		Voie voie107 = new Voie(true, CotationBloc._6Bplus);
//		Voie voie108 = new Voie(true, CotationBloc._6Bplus);
//		Voie voie109 = new Voie(true, CotationBloc._6Bplus);
//
//		Voie voie111 = new Voie(true, CotationBloc._6C);
//		Voie voie112 = new Voie(true, CotationBloc._6C);
//		Voie voie113 = new Voie(true, CotationBloc._6C);
//		Voie voie114 = new Voie(true, CotationBloc._6C);
//		Voie voie115 = new Voie(false, CotationBloc._6C);
//		Voie voie116 = new Voie(false, CotationBloc._6C);
//		Voie voie117 = new Voie(false, CotationBloc._6C);
//		Voie voie118 = new Voie(false, CotationBloc._6C);
//		Voie voie119 = new Voie(false, CotationBloc._6C);
//
//		Voie voie121 = new Voie(false, CotationBloc._6Cplus);
//		Voie voie122 = new Voie(false, CotationBloc._6Cplus);
//		Voie voie123 = new Voie(false, CotationBloc._6Cplus);
//		Voie voie124 = new Voie(false, CotationBloc._6Cplus);
//		Voie voie125 = new Voie(false, CotationBloc._6Cplus);
//		Voie voie126 = new Voie(true, CotationBloc._6Cplus);
//		Voie voie127 = new Voie(true, CotationBloc._6Cplus);
//		Voie voie128 = new Voie(true, CotationBloc._6Cplus);
//		Voie voie129 = new Voie(true, CotationBloc._6Cplus);
//
//		Voie voie131 = new Voie(true, CotationBloc._7A);
//		Voie voie132 = new Voie(true, CotationBloc._7A);
//		Voie voie133 = new Voie(true, CotationBloc._7A);
//		Voie voie134 = new Voie(true, CotationBloc._7A);
//		Voie voie135 = new Voie(false, CotationBloc._7A);
//		Voie voie136 = new Voie(false, CotationBloc._7A);
//		Voie voie137 = new Voie(false, CotationBloc._7A);
//		Voie voie138 = new Voie(false, CotationBloc._7A);
//		Voie voie139 = new Voie(false, CotationBloc._7A);
//
//		Voie voie141 = new Voie(false, CotationBloc._7Aplus);
//		Voie voie142 = new Voie(false, CotationBloc._7Aplus);
//		Voie voie143 = new Voie(false, CotationBloc._7Aplus);
//		Voie voie144 = new Voie(false, CotationBloc._7Aplus);
//		Voie voie145 = new Voie(false, CotationBloc._7Aplus);
//		Voie voie146 = new Voie(false, CotationBloc._7Aplus);
//		Voie voie147 = new Voie(false, CotationBloc._7Aplus);
//		Voie voie148 = new Voie(false, CotationBloc._7Aplus);
//		Voie voie149 = new Voie(false, CotationBloc._7Aplus);
//
//		Voie voie151 = new Voie(false, CotationBloc._7B);
//		Voie voie152 = new Voie(false, CotationBloc._7B);
//		Voie voie153 = new Voie(false, CotationBloc._7B);
//		Voie voie154 = new Voie(false, CotationBloc._7B);
//		Voie voie155 = new Voie(false, CotationBloc._7B);
//		Voie voie156 = new Voie(true, CotationBloc._7B);
//		Voie voie157 = new Voie(true, CotationBloc._7B);
//		Voie voie158 = new Voie(true, CotationBloc._7B);
//		Voie voie159 = new Voie(true, CotationBloc._7B);
//
//		Voie voie161 = new Voie(true, CotationBloc._7Bplus);
//		Voie voie162 = new Voie(true, CotationBloc._7Bplus);
//		Voie voie163 = new Voie(true, CotationBloc._7Bplus);
//		Voie voie164 = new Voie(true, CotationBloc._7Bplus);
//		Voie voie165 = new Voie(false, CotationBloc._7Bplus);
//		Voie voie166 = new Voie(false, CotationBloc._7Bplus);
//		Voie voie167 = new Voie(false, CotationBloc._7Bplus);
//		Voie voie168 = new Voie(false, CotationBloc._7Bplus);
//		Voie voie169 = new Voie(false, CotationBloc._7Bplus);
//
//		Voie voie171 = new Voie(false, CotationBloc._7C);
//		Voie voie172 = new Voie(false, CotationBloc._7C);
//		Voie voie173 = new Voie(false, CotationBloc._7C);
//		Voie voie174 = new Voie(false, CotationBloc._7C);
//		Voie voie175 = new Voie(false, CotationBloc._7C);
//		Voie voie176 = new Voie(true, CotationBloc._7C);
//		Voie voie177 = new Voie(true, CotationBloc._7C);
//		Voie voie178 = new Voie(true, CotationBloc._7C);
//		Voie voie179 = new Voie(true, CotationBloc._7C);
//
//		Voie voie181 = new Voie(true, CotationBloc._7Cplus);
//		Voie voie182 = new Voie(true, CotationBloc._7Cplus);
//		Voie voie183 = new Voie(true, CotationBloc._7Cplus);
//		Voie voie184 = new Voie(true, CotationBloc._7Cplus);
//		Voie voie185 = new Voie(false, CotationBloc._7Cplus);
//		Voie voie186 = new Voie(false, CotationBloc._7Cplus);
//		Voie voie187 = new Voie(false, CotationBloc._7Cplus);
//		Voie voie188 = new Voie(false, CotationBloc._7Cplus);
//		Voie voie189 = new Voie(false, CotationBloc._7Cplus);
//
//		Voie voie191 = new Voie(false, CotationBloc._8A);
//		Voie voie192 = new Voie(false, CotationBloc._8A);
//		Voie voie193 = new Voie(false, CotationBloc._8A);
//		Voie voie194 = new Voie(false, CotationBloc._8A);
//		Voie voie195 = new Voie(false, CotationBloc._8A);
//		Voie voie196 = new Voie(true, CotationBloc._8A);
//		Voie voie197 = new Voie(true, CotationBloc._8A);
//		Voie voie198 = new Voie(true, CotationBloc._8A);
//		Voie voie199 = new Voie(true, CotationBloc._8A);
//
//		Voie voie201 = new Voie(true, CotationBloc._8Aplus);
//		Voie voie202 = new Voie(true, CotationBloc._8Aplus);
//		Voie voie203 = new Voie(true, CotationBloc._8Aplus);
//		Voie voie204 = new Voie(true, CotationBloc._8Aplus);
//		Voie voie205 = new Voie(false, CotationBloc._8Aplus);
//		Voie voie206 = new Voie(false, CotationBloc._8Aplus);
//		Voie voie207 = new Voie(false, CotationBloc._8Aplus);
//		Voie voie208 = new Voie(false, CotationBloc._8Aplus);
//		Voie voie209 = new Voie(false, CotationBloc._8Aplus);
//
//		Voie voie211 = new Voie(false, CotationBloc._8B);
//		Voie voie212 = new Voie(false, CotationBloc._8B);
//		Voie voie213 = new Voie(false, CotationBloc._8B);
//		Voie voie214 = new Voie(false, CotationBloc._8B);
//		Voie voie215 = new Voie(false, CotationBloc._8B);
//		Voie voie216 = new Voie(true, CotationBloc._8B);
//		Voie voie217 = new Voie(true, CotationBloc._8B);
//		Voie voie218 = new Voie(true, CotationBloc._8B);
//		Voie voie219 = new Voie(true, CotationBloc._8B);
//
//		Voie voie221 = new Voie(true, CotationBloc._8Bplus);
//		Voie voie222 = new Voie(true, CotationBloc._8Bplus);
//		Voie voie223 = new Voie(true, CotationBloc._8Bplus);
//		Voie voie224 = new Voie(true, CotationBloc._8Bplus);
//		Voie voie225 = new Voie(false, CotationBloc._8Bplus);
//		Voie voie226 = new Voie(false, CotationBloc._8Bplus);
//		Voie voie227 = new Voie(false, CotationBloc._8Bplus);
//		Voie voie228 = new Voie(false, CotationBloc._8Bplus);
//		Voie voie229 = new Voie(false, CotationBloc._8Bplus);
//
//		Voie voie231 = new Voie(false, CotationBloc._8C);
//		Voie voie232 = new Voie(false, CotationBloc._8C);
//		Voie voie233 = new Voie(false, CotationBloc._8C);
//		Voie voie234 = new Voie(false, CotationBloc._8C);
//		Voie voie235 = new Voie(false, CotationBloc._8C);
//		Voie voie236 = new Voie(true, CotationBloc._8C);
//		Voie voie237 = new Voie(true, CotationBloc._8C);
//		Voie voie238 = new Voie(true, CotationBloc._8C);
//		Voie voie239 = new Voie(true, CotationBloc._8C);
//
//		Voie voie241 = new Voie(true, CotationBloc._8Clus);
//		Voie voie242 = new Voie(true, CotationBloc._8Clus);
//		Voie voie243 = new Voie(true, CotationBloc._8Clus);
//		Voie voie244 = new Voie(true, CotationBloc._8Clus);
//		Voie voie245 = new Voie(false, CotationBloc._8Clus);
//		Voie voie246 = new Voie(false, CotationBloc._8Clus);
//		Voie voie247 = new Voie(false, CotationBloc._8Clus);
//		Voie voie248 = new Voie(false, CotationBloc._8Clus);
//		Voie voie249 = new Voie(false, CotationBloc._8Clus);
//
//		Voie voie251 = new Voie(true, CotationFalaise._3);
//		Voie voie252 = new Voie(true, CotationFalaise._3);
//		Voie voie253 = new Voie(true, CotationFalaise._3);
//		Voie voie254 = new Voie(true, CotationFalaise._3);
//		Voie voie255 = new Voie(false, CotationFalaise._3);
//		Voie voie256 = new Voie(false, CotationFalaise._3);
//		Voie voie257 = new Voie(false, CotationFalaise._3);
//		Voie voie258 = new Voie(false, CotationFalaise._3);
//		Voie voie259 = new Voie(false, CotationFalaise._3);
//
//		Voie voie261 = new Voie(false, CotationFalaise._3Plus);
//		Voie voie262 = new Voie(false, CotationFalaise._3Plus);
//		Voie voie263 = new Voie(false, CotationFalaise._3Plus);
//		Voie voie264 = new Voie(false, CotationFalaise._3Plus);
//		Voie voie265 = new Voie(false, CotationFalaise._3Plus);
//		Voie voie266 = new Voie(true, CotationFalaise._3Plus);
//		Voie voie267 = new Voie(true, CotationFalaise._3Plus);
//		Voie voie268 = new Voie(true, CotationFalaise._3Plus);
//		Voie voie269 = new Voie(true, CotationFalaise._3Plus);
//
//		Voie voie271 = new Voie(true, CotationFalaise._4a);
//		Voie voie272 = new Voie(true, CotationFalaise._4a);
//		Voie voie273 = new Voie(true, CotationFalaise._4a);
//		Voie voie274 = new Voie(true, CotationFalaise._4a);
//		Voie voie275 = new Voie(false, CotationFalaise._4a);
//		Voie voie276 = new Voie(false, CotationFalaise._4a);
//		Voie voie277 = new Voie(false, CotationFalaise._4a);
//		Voie voie278 = new Voie(false, CotationFalaise._4a);
//		Voie voie279 = new Voie(false, CotationFalaise._4a);
//
//		Voie voie281 = new Voie(false, CotationFalaise._4b);
//		Voie voie282 = new Voie(false, CotationFalaise._4b);
//		Voie voie283 = new Voie(false, CotationFalaise._4b);
//		Voie voie284 = new Voie(false, CotationFalaise._4b);
//		Voie voie285 = new Voie(false, CotationFalaise._4b);
//		Voie voie286 = new Voie(true, CotationFalaise._4b);
//		Voie voie287 = new Voie(true, CotationFalaise._4b);
//		Voie voie288 = new Voie(true, CotationFalaise._4b);
//		Voie voie289 = new Voie(true, CotationFalaise._4b);
//
//		Voie voie291 = new Voie(true, CotationFalaise._4c);
//		Voie voie292 = new Voie(true, CotationFalaise._4c);
//		Voie voie293 = new Voie(true, CotationFalaise._4c);
//		Voie voie294 = new Voie(true, CotationFalaise._4c);
//		Voie voie295 = new Voie(false, CotationFalaise._4c);
//		Voie voie296 = new Voie(false, CotationFalaise._4c);
//		Voie voie297 = new Voie(false, CotationFalaise._4c);
//		Voie voie298 = new Voie(false, CotationFalaise._4c);
//		Voie voie299 = new Voie(false, CotationFalaise._4c);
//
//		Voie voie301 = new Voie(false, CotationFalaise._5a);
//		Voie voie302 = new Voie(false, CotationFalaise._5a);
//		Voie voie303 = new Voie(false, CotationFalaise._5a);
//		Voie voie304 = new Voie(false, CotationFalaise._5a);
//		Voie voie305 = new Voie(false, CotationFalaise._5a);
//		Voie voie306 = new Voie(true, CotationFalaise._5a);
//		Voie voie307 = new Voie(true, CotationFalaise._5a);
//		Voie voie308 = new Voie(true, CotationFalaise._5a);
//		Voie voie309 = new Voie(true, CotationFalaise._5a);
//
//		Voie voie311 = new Voie(true, CotationFalaise._5b);
//		Voie voie312 = new Voie(true, CotationFalaise._5b);
//		Voie voie313 = new Voie(true, CotationFalaise._5b);
//		Voie voie314 = new Voie(true, CotationFalaise._5b);
//		Voie voie315 = new Voie(false, CotationFalaise._5b);
//		Voie voie316 = new Voie(false, CotationFalaise._5b);
//		Voie voie317 = new Voie(false, CotationFalaise._5b);
//		Voie voie318 = new Voie(false, CotationFalaise._5b);
//		Voie voie319 = new Voie(false, CotationFalaise._5b);
//
//		Voie voie321 = new Voie(false, CotationFalaise._5c);
//		Voie voie322 = new Voie(false, CotationFalaise._5c);
//		Voie voie323 = new Voie(false, CotationFalaise._5c);
//		Voie voie324 = new Voie(false, CotationFalaise._5c);
//		Voie voie325 = new Voie(false, CotationFalaise._5c);
//		Voie voie326 = new Voie(true, CotationFalaise._5c);
//		Voie voie327 = new Voie(true, CotationFalaise._5c);
//		Voie voie328 = new Voie(true, CotationFalaise._5c);
//		Voie voie329 = new Voie(true, CotationFalaise._5c);
//
//		Voie voie331 = new Voie(true, CotationFalaise._6a);
//		Voie voie332 = new Voie(true, CotationFalaise._6a);
//		Voie voie333 = new Voie(true, CotationFalaise._6a);
//		Voie voie334 = new Voie(true, CotationFalaise._6a);
//		Voie voie335 = new Voie(false, CotationFalaise._6a);
//		Voie voie336 = new Voie(false, CotationFalaise._6a);
//		Voie voie337 = new Voie(false, CotationFalaise._6a);
//		Voie voie338 = new Voie(false, CotationFalaise._6a);
//		Voie voie339 = new Voie(false, CotationFalaise._6a);
//
//		Voie voie341 = new Voie(false, CotationFalaise._6aPlus);
//		Voie voie342 = new Voie(false, CotationFalaise._6aPlus);
//		Voie voie343 = new Voie(false, CotationFalaise._6aPlus);
//		Voie voie344 = new Voie(false, CotationFalaise._6aPlus);
//		Voie voie345 = new Voie(false, CotationFalaise._6aPlus);
//		Voie voie346 = new Voie(true, CotationFalaise._6aPlus);
//		Voie voie347 = new Voie(true, CotationFalaise._6aPlus);
//		Voie voie348 = new Voie(true, CotationFalaise._6aPlus);
//		Voie voie349 = new Voie(true, CotationFalaise._6aPlus);
//
//		Voie voie351 = new Voie(true, CotationFalaise._6b);
//		Voie voie352 = new Voie(true, CotationFalaise._6b);
//		Voie voie353 = new Voie(true, CotationFalaise._6b);
//		Voie voie354 = new Voie(true, CotationFalaise._6b);
//		Voie voie355 = new Voie(false, CotationFalaise._6b);
//		Voie voie356 = new Voie(false, CotationFalaise._6b);
//		Voie voie357 = new Voie(false, CotationFalaise._6b);
//		Voie voie358 = new Voie(false, CotationFalaise._6b);
//		Voie voie359 = new Voie(false, CotationFalaise._6b);
//
//		Voie voie361 = new Voie(false, CotationFalaise._6bPlus);
//		Voie voie362 = new Voie(false, CotationFalaise._6bPlus);
//		Voie voie363 = new Voie(false, CotationFalaise._6bPlus);
//		Voie voie364 = new Voie(false, CotationFalaise._6bPlus);
//		Voie voie365 = new Voie(false, CotationFalaise._6bPlus);
//		Voie voie366 = new Voie(true, CotationFalaise._6bPlus);
//		Voie voie367 = new Voie(true, CotationFalaise._6bPlus);
//		Voie voie368 = new Voie(true, CotationFalaise._6bPlus);
//		Voie voie369 = new Voie(true, CotationFalaise._6bPlus);
//
//		Voie voie371 = new Voie(true, CotationFalaise._6c);
//		Voie voie372 = new Voie(true, CotationFalaise._6c);
//		Voie voie373 = new Voie(true, CotationFalaise._6c);
//		Voie voie374 = new Voie(true, CotationFalaise._6c);
//		Voie voie375 = new Voie(false, CotationFalaise._6c);
//		Voie voie376 = new Voie(false, CotationFalaise._6c);
//		Voie voie377 = new Voie(false, CotationFalaise._6c);
//		Voie voie378 = new Voie(false, CotationFalaise._6c);
//		Voie voie379 = new Voie(false, CotationFalaise._6c);
//
//		Voie voie381 = new Voie(false, CotationFalaise._6cPlus);
//		Voie voie382 = new Voie(false, CotationFalaise._6cPlus);
//		Voie voie383 = new Voie(false, CotationFalaise._6cPlus);
//		Voie voie384 = new Voie(false, CotationFalaise._6cPlus);
//		Voie voie385 = new Voie(false, CotationFalaise._6cPlus);
//		Voie voie386 = new Voie(true, CotationFalaise._6cPlus);
//		Voie voie387 = new Voie(true, CotationFalaise._6cPlus);
//		Voie voie388 = new Voie(true, CotationFalaise._6cPlus);
//		Voie voie389 = new Voie(true, CotationFalaise._6cPlus);
//
//		Voie voie391 = new Voie(true, CotationFalaise._7a);
//		Voie voie392 = new Voie(true, CotationFalaise._7a);
//		Voie voie393 = new Voie(true, CotationFalaise._7a);
//		Voie voie394 = new Voie(true, CotationFalaise._7a);
//		Voie voie395 = new Voie(false, CotationFalaise._7a);
//		Voie voie396 = new Voie(false, CotationFalaise._7a);
//		Voie voie397 = new Voie(false, CotationFalaise._7a);
//		Voie voie398 = new Voie(false, CotationFalaise._7a);
//		Voie voie399 = new Voie(false, CotationFalaise._7a);
//
//		Voie voie401 = new Voie(false, CotationFalaise._7aPlus);
//		Voie voie402 = new Voie(false, CotationFalaise._7aPlus);
//		Voie voie403 = new Voie(false, CotationFalaise._7aPlus);
//		Voie voie404 = new Voie(false, CotationFalaise._7aPlus);
//		Voie voie405 = new Voie(false, CotationFalaise._7aPlus);
//		Voie voie406 = new Voie(true, CotationFalaise._7aPlus);
//		Voie voie407 = new Voie(true, CotationFalaise._7aPlus);
//		Voie voie408 = new Voie(true, CotationFalaise._7aPlus);
//		Voie voie409 = new Voie(true, CotationFalaise._7aPlus);
//
//		Voie voie411 = new Voie(true, CotationFalaise._7b);
//		Voie voie412 = new Voie(true, CotationFalaise._7b);
//		Voie voie413 = new Voie(true, CotationFalaise._7b);
//		Voie voie414 = new Voie(true, CotationFalaise._7b);
//		Voie voie415 = new Voie(false, CotationFalaise._7b);
//		Voie voie416 = new Voie(false, CotationFalaise._7b);
//		Voie voie417 = new Voie(false, CotationFalaise._7b);
//		Voie voie418 = new Voie(false, CotationFalaise._7b);
//		Voie voie419 = new Voie(false, CotationFalaise._7b);
//
//		Voie voie421 = new Voie(false, CotationFalaise._7bPlus);
//		Voie voie422 = new Voie(false, CotationFalaise._7bPlus);
//		Voie voie423 = new Voie(false, CotationFalaise._7bPlus);
//		Voie voie424 = new Voie(false, CotationFalaise._7bPlus);
//		Voie voie425 = new Voie(false, CotationFalaise._7bPlus);
//		Voie voie426 = new Voie(true, CotationFalaise._7bPlus);
//		Voie voie427 = new Voie(true, CotationFalaise._7bPlus);
//		Voie voie428 = new Voie(true, CotationFalaise._7bPlus);
//		Voie voie429 = new Voie(true, CotationFalaise._7bPlus);
//
//		Voie voie431 = new Voie(true, CotationFalaise._7c);
//		Voie voie432 = new Voie(true, CotationFalaise._7c);
//		Voie voie433 = new Voie(true, CotationFalaise._7c);
//		Voie voie434 = new Voie(true, CotationFalaise._7c);
//		Voie voie435 = new Voie(false, CotationFalaise._7c);
//		Voie voie436 = new Voie(false, CotationFalaise._7c);
//		Voie voie437 = new Voie(false, CotationFalaise._7c);
//		Voie voie438 = new Voie(false, CotationFalaise._7c);
//		Voie voie439 = new Voie(false, CotationFalaise._7c);
//
//		Voie voie441 = new Voie(false, CotationFalaise._7cPlus);
//		Voie voie442 = new Voie(false, CotationFalaise._7cPlus);
//		Voie voie443 = new Voie(false, CotationFalaise._7cPlus);
//		Voie voie444 = new Voie(false, CotationFalaise._7cPlus);
//		Voie voie445 = new Voie(false, CotationFalaise._7cPlus);
//		Voie voie446 = new Voie(true, CotationFalaise._7cPlus);
//		Voie voie447 = new Voie(true, CotationFalaise._7cPlus);
//		Voie voie448 = new Voie(true, CotationFalaise._7cPlus);
//		Voie voie449 = new Voie(true, CotationFalaise._7cPlus);
//
//		Voie voie451 = new Voie(true, CotationFalaise._8a);
//		Voie voie452 = new Voie(true, CotationFalaise._8a);
//		Voie voie453 = new Voie(true, CotationFalaise._8a);
//		Voie voie454 = new Voie(true, CotationFalaise._8a);
//		Voie voie455 = new Voie(false, CotationFalaise._8a);
//		Voie voie456 = new Voie(false, CotationFalaise._8a);
//		Voie voie457 = new Voie(false, CotationFalaise._8a);
//		Voie voie458 = new Voie(false, CotationFalaise._8a);
//		Voie voie459 = new Voie(false, CotationFalaise._8a);
//
//		Voie voie461 = new Voie(false, CotationFalaise._8aPlus);
//		Voie voie462 = new Voie(false, CotationFalaise._8aPlus);
//		Voie voie463 = new Voie(false, CotationFalaise._8aPlus);
//		Voie voie464 = new Voie(false, CotationFalaise._8aPlus);
//		Voie voie465 = new Voie(false, CotationFalaise._8aPlus);
//		Voie voie466 = new Voie(true, CotationFalaise._8aPlus);
//		Voie voie467 = new Voie(true, CotationFalaise._8aPlus);
//		Voie voie468 = new Voie(true, CotationFalaise._8aPlus);
//		Voie voie469 = new Voie(true, CotationFalaise._8aPlus);
//
//		Voie voie471 = new Voie(true, CotationFalaise._8b);
//		Voie voie472 = new Voie(true, CotationFalaise._8b);
//		Voie voie473 = new Voie(true, CotationFalaise._8b);
//		Voie voie474 = new Voie(true, CotationFalaise._8b);
//		Voie voie475 = new Voie(false, CotationFalaise._8b);
//		Voie voie476 = new Voie(false, CotationFalaise._8b);
//		Voie voie477 = new Voie(false, CotationFalaise._8b);
//		Voie voie478 = new Voie(false, CotationFalaise._8b);
//		Voie voie479 = new Voie(false, CotationFalaise._8b);
//
//		Voie voie481 = new Voie(false, CotationFalaise._8bPlus);
//		Voie voie482 = new Voie(false, CotationFalaise._8bPlus);
//		Voie voie483 = new Voie(false, CotationFalaise._8bPlus);
//		Voie voie484 = new Voie(false, CotationFalaise._8bPlus);
//		Voie voie485 = new Voie(false, CotationFalaise._8bPlus);
//		Voie voie486 = new Voie(true, CotationFalaise._8bPlus);
//		Voie voie487 = new Voie(true, CotationFalaise._8bPlus);
//		Voie voie488 = new Voie(true, CotationFalaise._8bPlus);
//		Voie voie489 = new Voie(true, CotationFalaise._8bPlus);
//
//		Voie voie491 = new Voie(true, CotationFalaise._8c);
//		Voie voie492 = new Voie(true, CotationFalaise._8c);
//		Voie voie493 = new Voie(true, CotationFalaise._8c);
//		Voie voie494 = new Voie(true, CotationFalaise._8c);
//		Voie voie495 = new Voie(false, CotationFalaise._8c);
//		Voie voie496 = new Voie(false, CotationFalaise._8c);
//		Voie voie497 = new Voie(false, CotationFalaise._8c);
//		Voie voie498 = new Voie(false, CotationFalaise._8c);
//		Voie voie499 = new Voie(false, CotationFalaise._8c);
//
//		Voie voie501 = new Voie(false, CotationFalaise._8cPlus);
//		Voie voie502 = new Voie(false, CotationFalaise._8cPlus);
//		Voie voie503 = new Voie(false, CotationFalaise._8cPlus);
//		Voie voie504 = new Voie(false, CotationFalaise._8cPlus);
//		Voie voie505 = new Voie(false, CotationFalaise._8cPlus);
//		Voie voie506 = new Voie(true, CotationFalaise._8cPlus);
//		Voie voie507 = new Voie(true, CotationFalaise._8cPlus);
//		Voie voie508 = new Voie(true, CotationFalaise._8cPlus);
//		Voie voie509 = new Voie(true, CotationFalaise._8cPlus);
//
//		Voie voie511 = new Voie(true, CotationFalaise._9a);
//		Voie voie512 = new Voie(true, CotationFalaise._9a);
//		Voie voie513 = new Voie(true, CotationFalaise._9a);
//		Voie voie514 = new Voie(true, CotationFalaise._9a);
//		Voie voie515 = new Voie(false, CotationFalaise._9a);
//		Voie voie516 = new Voie(false, CotationFalaise._9a);
//		Voie voie517 = new Voie(false, CotationFalaise._9a);
//		Voie voie518 = new Voie(false, CotationFalaise._9a);
//		Voie voie519 = new Voie(false, CotationFalaise._9a);
//
//		Voie voie521 = new Voie(false, CotationFalaise._9aPlus);
//		Voie voie522 = new Voie(false, CotationFalaise._9aPlus);
//		Voie voie523 = new Voie(false, CotationFalaise._9aPlus);
//		Voie voie524 = new Voie(false, CotationFalaise._9aPlus);
//		Voie voie525 = new Voie(false, CotationFalaise._9aPlus);
//		Voie voie526 = new Voie(true, CotationFalaise._9aPlus);
//		Voie voie527 = new Voie(true, CotationFalaise._9aPlus);
//		Voie voie528 = new Voie(true, CotationFalaise._9aPlus);
//		Voie voie529 = new Voie(true, CotationFalaise._9aPlus);
//
//		// bloc 22*9 (198 voies) falaise: 28*9 (252 voies) total (450 voies)
//
//		// 60 secteurs + 3 sites sans secteurs (19, 15, 10)
//
//		// 1 2 3 4 5 51 52 -> site 1
//		voie21.setSecteur(secteurRepository.findById(1l).orElse(null));
//		voie31.setSecteur(secteurRepository.findById(1l).orElse(null));
//		voie41.setSecteur(secteurRepository.findById(1l).orElse(null));
//		voie51.setSecteur(secteurRepository.findById(1l).orElse(null));
//		voie61.setSecteur(secteurRepository.findById(1l).orElse(null));
//		voie71.setSecteur(secteurRepository.findById(1l).orElse(null));
//		voie81.setSecteur(secteurRepository.findById(1l).orElse(null));
//		// -------------
//		voie101.setSecteur(secteurRepository.findById(2l).orElse(null));
//		voie111.setSecteur(secteurRepository.findById(2l).orElse(null));
//		voie121.setSecteur(secteurRepository.findById(2l).orElse(null));
//		voie131.setSecteur(secteurRepository.findById(2l).orElse(null));
//		voie141.setSecteur(secteurRepository.findById(2l).orElse(null));
//		voie151.setSecteur(secteurRepository.findById(2l).orElse(null));
//		voie161.setSecteur(secteurRepository.findById(2l).orElse(null));
//		voie171.setSecteur(secteurRepository.findById(2l).orElse(null));
//		voie181.setSecteur(secteurRepository.findById(2l).orElse(null));
//		// -------------
//		voie191.setSecteur(secteurRepository.findById(3l).orElse(null));
//		voie201.setSecteur(secteurRepository.findById(3l).orElse(null));
//		voie211.setSecteur(secteurRepository.findById(3l).orElse(null));
//		voie221.setSecteur(secteurRepository.findById(3l).orElse(null));
//		voie231.setSecteur(secteurRepository.findById(3l).orElse(null));
//		voie241.setSecteur(secteurRepository.findById(3l).orElse(null));
//		voie22.setSecteur(secteurRepository.findById(3l).orElse(null));
//		voie32.setSecteur(secteurRepository.findById(3l).orElse(null));
//		voie42.setSecteur(secteurRepository.findById(3l).orElse(null));
//		voie52.setSecteur(secteurRepository.findById(3l).orElse(null));
//		// -------------
//		voie62.setSecteur(secteurRepository.findById(4l).orElse(null));
//		voie72.setSecteur(secteurRepository.findById(4l).orElse(null));
//		voie82.setSecteur(secteurRepository.findById(4l).orElse(null));
//		voie102.setSecteur(secteurRepository.findById(4l).orElse(null));
//		voie112.setSecteur(secteurRepository.findById(4l).orElse(null));
//		voie122.setSecteur(secteurRepository.findById(4l).orElse(null));
//		voie132.setSecteur(secteurRepository.findById(4l).orElse(null));
//		voie142.setSecteur(secteurRepository.findById(4l).orElse(null));
//		voie152.setSecteur(secteurRepository.findById(4l).orElse(null));
//		// -------------
//		voie162.setSecteur(secteurRepository.findById(5l).orElse(null));
//		voie172.setSecteur(secteurRepository.findById(5l).orElse(null));
//		voie182.setSecteur(secteurRepository.findById(5l).orElse(null));
//		voie192.setSecteur(secteurRepository.findById(5l).orElse(null));
//		voie202.setSecteur(secteurRepository.findById(5l).orElse(null));
//		voie212.setSecteur(secteurRepository.findById(5l).orElse(null));
//		// -------------
//		voie222.setSecteur(secteurRepository.findById(51l).orElse(null));
//		voie232.setSecteur(secteurRepository.findById(51l).orElse(null));
//		voie242.setSecteur(secteurRepository.findById(51l).orElse(null));
//		voie23.setSecteur(secteurRepository.findById(51l).orElse(null));
//		voie33.setSecteur(secteurRepository.findById(51l).orElse(null));
//		voie43.setSecteur(secteurRepository.findById(51l).orElse(null));
//		// -------------
//		voie53.setSecteur(secteurRepository.findById(52l).orElse(null));
//		voie63.setSecteur(secteurRepository.findById(52l).orElse(null));
//		voie73.setSecteur(secteurRepository.findById(52l).orElse(null));
//		voie83.setSecteur(secteurRepository.findById(52l).orElse(null));
//		voie103.setSecteur(secteurRepository.findById(52l).orElse(null));
//		voie113.setSecteur(secteurRepository.findById(52l).orElse(null));
//
//		// 6, 7, 8, 9 -> site 2
//		voie123.setSecteur(secteurRepository.findById(6l).orElse(null));
//		voie133.setSecteur(secteurRepository.findById(6l).orElse(null));
//		voie143.setSecteur(secteurRepository.findById(6l).orElse(null));
//		voie153.setSecteur(secteurRepository.findById(6l).orElse(null));
//		voie163.setSecteur(secteurRepository.findById(6l).orElse(null));
//		voie173.setSecteur(secteurRepository.findById(6l).orElse(null));
//
//		voie183.setSecteur(secteurRepository.findById(7l).orElse(null));
//		voie193.setSecteur(secteurRepository.findById(7l).orElse(null));
//		voie203.setSecteur(secteurRepository.findById(7l).orElse(null));
//		voie213.setSecteur(secteurRepository.findById(7l).orElse(null));
//		voie223.setSecteur(secteurRepository.findById(7l).orElse(null));
//		voie233.setSecteur(secteurRepository.findById(7l).orElse(null));
//
//		voie243.setSecteur(secteurRepository.findById(8l).orElse(null));
//		voie24.setSecteur(secteurRepository.findById(8l).orElse(null));
//		voie34.setSecteur(secteurRepository.findById(8l).orElse(null));
//		voie44.setSecteur(secteurRepository.findById(8l).orElse(null));
//		voie54.setSecteur(secteurRepository.findById(8l).orElse(null));
//		voie64.setSecteur(secteurRepository.findById(8l).orElse(null));
//
//		voie74.setSecteur(secteurRepository.findById(9l).orElse(null));
//		voie84.setSecteur(secteurRepository.findById(9l).orElse(null));
//		voie104.setSecteur(secteurRepository.findById(9l).orElse(null));
//		voie114.setSecteur(secteurRepository.findById(9l).orElse(null));
//		voie124.setSecteur(secteurRepository.findById(9l).orElse(null));
//		voie134.setSecteur(secteurRepository.findById(9l).orElse(null));
//
//		// 10, 11, 12, 54, 55 -> site 3
//
//		voie144.setSecteur(secteurRepository.findById(10l).orElse(null));
//		voie154.setSecteur(secteurRepository.findById(10l).orElse(null));
//		voie164.setSecteur(secteurRepository.findById(10l).orElse(null));
//		voie174.setSecteur(secteurRepository.findById(10l).orElse(null));
//		voie184.setSecteur(secteurRepository.findById(10l).orElse(null));
//		voie194.setSecteur(secteurRepository.findById(10l).orElse(null));
//		voie204.setSecteur(secteurRepository.findById(10l).orElse(null));
//		voie214.setSecteur(secteurRepository.findById(10l).orElse(null));
//
//		voie224.setSecteur(secteurRepository.findById(11l).orElse(null));
//		voie234.setSecteur(secteurRepository.findById(11l).orElse(null));
//		voie244.setSecteur(secteurRepository.findById(11l).orElse(null));
//		voie25.setSecteur(secteurRepository.findById(11l).orElse(null));
//		voie35.setSecteur(secteurRepository.findById(11l).orElse(null));
//		voie45.setSecteur(secteurRepository.findById(11l).orElse(null));
//		voie55.setSecteur(secteurRepository.findById(11l).orElse(null));
//		voie65.setSecteur(secteurRepository.findById(11l).orElse(null));
//
//		voie75.setSecteur(secteurRepository.findById(12l).orElse(null));
//		voie85.setSecteur(secteurRepository.findById(12l).orElse(null));
//		voie105.setSecteur(secteurRepository.findById(12l).orElse(null));
//		voie115.setSecteur(secteurRepository.findById(12l).orElse(null));
//		voie125.setSecteur(secteurRepository.findById(12l).orElse(null));
//		voie135.setSecteur(secteurRepository.findById(12l).orElse(null));
//		voie145.setSecteur(secteurRepository.findById(12l).orElse(null));
//		voie155.setSecteur(secteurRepository.findById(12l).orElse(null));
//
//		voie165.setSecteur(secteurRepository.findById(54l).orElse(null));
//		voie175.setSecteur(secteurRepository.findById(54l).orElse(null));
//		voie185.setSecteur(secteurRepository.findById(54l).orElse(null));
//		voie195.setSecteur(secteurRepository.findById(54l).orElse(null));
//		voie205.setSecteur(secteurRepository.findById(54l).orElse(null));
//		voie215.setSecteur(secteurRepository.findById(54l).orElse(null));
//		voie225.setSecteur(secteurRepository.findById(54l).orElse(null));
//		voie235.setSecteur(secteurRepository.findById(54l).orElse(null));
//
//		voie245.setSecteur(secteurRepository.findById(55l).orElse(null));
//		voie26.setSecteur(secteurRepository.findById(55l).orElse(null));
//		voie36.setSecteur(secteurRepository.findById(55l).orElse(null));
//		voie46.setSecteur(secteurRepository.findById(55l).orElse(null));
//		voie56.setSecteur(secteurRepository.findById(55l).orElse(null));
//		voie66.setSecteur(secteurRepository.findById(55l).orElse(null));
//		voie76.setSecteur(secteurRepository.findById(55l).orElse(null));
//		voie86.setSecteur(secteurRepository.findById(55l).orElse(null));
//
//		// 13, 14, 56, 57 -> site 4
//
//		voie106.setSecteur(secteurRepository.findById(13l).orElse(null));
//		voie116.setSecteur(secteurRepository.findById(13l).orElse(null));
//		voie126.setSecteur(secteurRepository.findById(13l).orElse(null));
//		voie136.setSecteur(secteurRepository.findById(13l).orElse(null));
//		voie146.setSecteur(secteurRepository.findById(13l).orElse(null));
//		voie156.setSecteur(secteurRepository.findById(13l).orElse(null));
//		voie166.setSecteur(secteurRepository.findById(13l).orElse(null));
//
//		voie176.setSecteur(secteurRepository.findById(14l).orElse(null));
//		voie186.setSecteur(secteurRepository.findById(14l).orElse(null));
//		voie196.setSecteur(secteurRepository.findById(14l).orElse(null));
//		voie206.setSecteur(secteurRepository.findById(14l).orElse(null));
//		voie216.setSecteur(secteurRepository.findById(14l).orElse(null));
//		voie226.setSecteur(secteurRepository.findById(14l).orElse(null));
//		voie236.setSecteur(secteurRepository.findById(14l).orElse(null));
//		voie246.setSecteur(secteurRepository.findById(14l).orElse(null));
//		voie27.setSecteur(secteurRepository.findById(14l).orElse(null));
//		voie37.setSecteur(secteurRepository.findById(14l).orElse(null));
//
//		voie47.setSecteur(secteurRepository.findById(56l).orElse(null));
//		voie57.setSecteur(secteurRepository.findById(56l).orElse(null));
//		voie67.setSecteur(secteurRepository.findById(56l).orElse(null));
//		voie77.setSecteur(secteurRepository.findById(56l).orElse(null));
//		voie87.setSecteur(secteurRepository.findById(56l).orElse(null));
//		voie107.setSecteur(secteurRepository.findById(56l).orElse(null));
//		voie117.setSecteur(secteurRepository.findById(56l).orElse(null));
//		voie127.setSecteur(secteurRepository.findById(56l).orElse(null));
//
//		voie137.setSecteur(secteurRepository.findById(57l).orElse(null));
//		voie147.setSecteur(secteurRepository.findById(57l).orElse(null));
//		voie157.setSecteur(secteurRepository.findById(57l).orElse(null));
//		voie167.setSecteur(secteurRepository.findById(57l).orElse(null));
//		voie177.setSecteur(secteurRepository.findById(57l).orElse(null));
//		voie187.setSecteur(secteurRepository.findById(57l).orElse(null));
//		voie197.setSecteur(secteurRepository.findById(57l).orElse(null));
//		voie207.setSecteur(secteurRepository.findById(57l).orElse(null));
//		voie217.setSecteur(secteurRepository.findById(57l).orElse(null));
//		voie227.setSecteur(secteurRepository.findById(57l).orElse(null));
//
//		// 15, 43, 44 -> site 5
//
//		voie237.setSecteur(secteurRepository.findById(15l).orElse(null));
//		voie247.setSecteur(secteurRepository.findById(15l).orElse(null));
//		voie28.setSecteur(secteurRepository.findById(15l).orElse(null));
//		voie38.setSecteur(secteurRepository.findById(15l).orElse(null));
//		voie48.setSecteur(secteurRepository.findById(15l).orElse(null));
//		voie58.setSecteur(secteurRepository.findById(15l).orElse(null));
//
//		voie68.setSecteur(secteurRepository.findById(43l).orElse(null));
//		voie78.setSecteur(secteurRepository.findById(43l).orElse(null));
//		voie88.setSecteur(secteurRepository.findById(43l).orElse(null));
//		voie108.setSecteur(secteurRepository.findById(43l).orElse(null));
//		voie118.setSecteur(secteurRepository.findById(43l).orElse(null));
//		voie128.setSecteur(secteurRepository.findById(43l).orElse(null));
//
//		voie138.setSecteur(secteurRepository.findById(44l).orElse(null));
//		voie148.setSecteur(secteurRepository.findById(44l).orElse(null));
//		voie158.setSecteur(secteurRepository.findById(44l).orElse(null));
//		voie168.setSecteur(secteurRepository.findById(44l).orElse(null));
//		voie178.setSecteur(secteurRepository.findById(44l).orElse(null));
//		voie188.setSecteur(secteurRepository.findById(44l).orElse(null));
//
//		// 16, 17, 18, 19 -> site 6
//		voie198.setSecteur(secteurRepository.findById(16l).orElse(null));
//		voie208.setSecteur(secteurRepository.findById(16l).orElse(null));
//		voie218.setSecteur(secteurRepository.findById(16l).orElse(null));
//		voie228.setSecteur(secteurRepository.findById(16l).orElse(null));
//		voie238.setSecteur(secteurRepository.findById(16l).orElse(null));
//		voie248.setSecteur(secteurRepository.findById(16l).orElse(null));
//
//		voie29.setSecteur(secteurRepository.findById(17l).orElse(null));
//		voie39.setSecteur(secteurRepository.findById(17l).orElse(null));
//		voie49.setSecteur(secteurRepository.findById(17l).orElse(null));
//		voie59.setSecteur(secteurRepository.findById(17l).orElse(null));
//		voie69.setSecteur(secteurRepository.findById(17l).orElse(null));
//		voie79.setSecteur(secteurRepository.findById(17l).orElse(null));
//
//		voie89.setSecteur(secteurRepository.findById(18l).orElse(null));
//		voie109.setSecteur(secteurRepository.findById(18l).orElse(null));
//		voie119.setSecteur(secteurRepository.findById(18l).orElse(null));
//		voie129.setSecteur(secteurRepository.findById(18l).orElse(null));
//		voie139.setSecteur(secteurRepository.findById(18l).orElse(null));
//		voie149.setSecteur(secteurRepository.findById(18l).orElse(null));
//
//		voie159.setSecteur(secteurRepository.findById(19l).orElse(null));
//		voie169.setSecteur(secteurRepository.findById(19l).orElse(null));
//		voie179.setSecteur(secteurRepository.findById(19l).orElse(null));
//		voie189.setSecteur(secteurRepository.findById(19l).orElse(null));
//		voie199.setSecteur(secteurRepository.findById(19l).orElse(null));
//		voie209.setSecteur(secteurRepository.findById(19l).orElse(null));
//		voie219.setSecteur(secteurRepository.findById(19l).orElse(null));
//		voie229.setSecteur(secteurRepository.findById(19l).orElse(null));
//		voie239.setSecteur(secteurRepository.findById(19l).orElse(null));
//		voie249.setSecteur(secteurRepository.findById(19l).orElse(null));
//
//		// FALAISE MAINTENANT
//
//		// 20,21, 22, 58 -> site 7
//
//		voie251.setSecteur(secteurRepository.findById(20l).orElse(null));
//		voie261.setSecteur(secteurRepository.findById(20l).orElse(null));
//		voie271.setSecteur(secteurRepository.findById(20l).orElse(null));
//		voie281.setSecteur(secteurRepository.findById(20l).orElse(null));
//		voie291.setSecteur(secteurRepository.findById(20l).orElse(null));
//		voie301.setSecteur(secteurRepository.findById(20l).orElse(null));
//		voie311.setSecteur(secteurRepository.findById(20l).orElse(null));
//		voie321.setSecteur(secteurRepository.findById(20l).orElse(null));
//		voie331.setSecteur(secteurRepository.findById(20l).orElse(null));
//
//		voie341.setSecteur(secteurRepository.findById(21l).orElse(null));
//		voie351.setSecteur(secteurRepository.findById(21l).orElse(null));
//		voie361.setSecteur(secteurRepository.findById(21l).orElse(null));
//		voie371.setSecteur(secteurRepository.findById(21l).orElse(null));
//		voie381.setSecteur(secteurRepository.findById(21l).orElse(null));
//		voie391.setSecteur(secteurRepository.findById(21l).orElse(null));
//		voie401.setSecteur(secteurRepository.findById(21l).orElse(null));
//		voie411.setSecteur(secteurRepository.findById(21l).orElse(null));
//		voie421.setSecteur(secteurRepository.findById(21l).orElse(null));
//
//		voie431.setSecteur(secteurRepository.findById(22l).orElse(null));
//		voie441.setSecteur(secteurRepository.findById(22l).orElse(null));
//		voie451.setSecteur(secteurRepository.findById(22l).orElse(null));
//		voie461.setSecteur(secteurRepository.findById(22l).orElse(null));
//		voie471.setSecteur(secteurRepository.findById(22l).orElse(null));
//		voie481.setSecteur(secteurRepository.findById(22l).orElse(null));
//		voie491.setSecteur(secteurRepository.findById(22l).orElse(null));
//		voie501.setSecteur(secteurRepository.findById(22l).orElse(null));
//		voie511.setSecteur(secteurRepository.findById(22l).orElse(null));
//
//		voie521.setSecteur(secteurRepository.findById(58l).orElse(null));
//		voie252.setSecteur(secteurRepository.findById(58l).orElse(null));
//		voie262.setSecteur(secteurRepository.findById(58l).orElse(null));
//		voie272.setSecteur(secteurRepository.findById(58l).orElse(null));
//		voie282.setSecteur(secteurRepository.findById(58l).orElse(null));
//		voie292.setSecteur(secteurRepository.findById(58l).orElse(null));
//		voie302.setSecteur(secteurRepository.findById(58l).orElse(null));
//		voie312.setSecteur(secteurRepository.findById(58l).orElse(null));
//		voie322.setSecteur(secteurRepository.findById(58l).orElse(null));
//
//		// 23, 24, 53 -> site 8
//		voie332.setSecteur(secteurRepository.findById(23l).orElse(null));
//		voie342.setSecteur(secteurRepository.findById(23l).orElse(null));
//		voie352.setSecteur(secteurRepository.findById(23l).orElse(null));
//		voie362.setSecteur(secteurRepository.findById(23l).orElse(null));
//		voie372.setSecteur(secteurRepository.findById(23l).orElse(null));
//		voie382.setSecteur(secteurRepository.findById(23l).orElse(null));
//		voie392.setSecteur(secteurRepository.findById(23l).orElse(null));
//
//		voie402.setSecteur(secteurRepository.findById(24l).orElse(null));
//		voie412.setSecteur(secteurRepository.findById(24l).orElse(null));
//		voie422.setSecteur(secteurRepository.findById(24l).orElse(null));
//		voie432.setSecteur(secteurRepository.findById(24l).orElse(null));
//		voie442.setSecteur(secteurRepository.findById(24l).orElse(null));
//		voie452.setSecteur(secteurRepository.findById(24l).orElse(null));
//		voie462.setSecteur(secteurRepository.findById(24l).orElse(null));
//
//		voie472.setSecteur(secteurRepository.findById(53l).orElse(null));
//		voie482.setSecteur(secteurRepository.findById(53l).orElse(null));
//		voie492.setSecteur(secteurRepository.findById(53l).orElse(null));
//		voie502.setSecteur(secteurRepository.findById(53l).orElse(null));
//		voie512.setSecteur(secteurRepository.findById(53l).orElse(null));
//
//		// 25,45,46,59,60 -> site 9
//		voie522.setSecteur(secteurRepository.findById(25l).orElse(null));
//		voie253.setSecteur(secteurRepository.findById(25l).orElse(null));
//		voie263.setSecteur(secteurRepository.findById(25l).orElse(null));
//		voie273.setSecteur(secteurRepository.findById(25l).orElse(null));
//		voie283.setSecteur(secteurRepository.findById(25l).orElse(null));
//		voie293.setSecteur(secteurRepository.findById(25l).orElse(null));
//		voie303.setSecteur(secteurRepository.findById(25l).orElse(null));
//		voie313.setSecteur(secteurRepository.findById(25l).orElse(null));
//		voie323.setSecteur(secteurRepository.findById(25l).orElse(null));
//
//		voie333.setSecteur(secteurRepository.findById(45l).orElse(null));
//		voie343.setSecteur(secteurRepository.findById(45l).orElse(null));
//		voie353.setSecteur(secteurRepository.findById(45l).orElse(null));
//		voie363.setSecteur(secteurRepository.findById(45l).orElse(null));
//		voie373.setSecteur(secteurRepository.findById(45l).orElse(null));
//		voie383.setSecteur(secteurRepository.findById(45l).orElse(null));
//		voie393.setSecteur(secteurRepository.findById(45l).orElse(null));
//
//		voie403.setSecteur(secteurRepository.findById(46l).orElse(null));
//		voie413.setSecteur(secteurRepository.findById(46l).orElse(null));
//		voie423.setSecteur(secteurRepository.findById(46l).orElse(null));
//		voie433.setSecteur(secteurRepository.findById(46l).orElse(null));
//		voie443.setSecteur(secteurRepository.findById(46l).orElse(null));
//		voie453.setSecteur(secteurRepository.findById(46l).orElse(null));
//		voie463.setSecteur(secteurRepository.findById(46l).orElse(null));
//		voie473.setSecteur(secteurRepository.findById(46l).orElse(null));
//
//		voie483.setSecteur(secteurRepository.findById(59l).orElse(null));
//		voie493.setSecteur(secteurRepository.findById(59l).orElse(null));
//		voie503.setSecteur(secteurRepository.findById(59l).orElse(null));
//		voie513.setSecteur(secteurRepository.findById(59l).orElse(null));
//		voie523.setSecteur(secteurRepository.findById(59l).orElse(null));
//		voie254.setSecteur(secteurRepository.findById(59l).orElse(null));
//		voie264.setSecteur(secteurRepository.findById(59l).orElse(null));
//		voie274.setSecteur(secteurRepository.findById(59l).orElse(null));
//
//		voie284.setSecteur(secteurRepository.findById(59l).orElse(null));
//		voie294.setSecteur(secteurRepository.findById(59l).orElse(null));
//		voie304.setSecteur(secteurRepository.findById(59l).orElse(null));
//		voie314.setSecteur(secteurRepository.findById(59l).orElse(null));
//		voie324.setSecteur(secteurRepository.findById(59l).orElse(null));
//		voie334.setSecteur(secteurRepository.findById(59l).orElse(null));
//		voie344.setSecteur(secteurRepository.findById(59l).orElse(null));
//		voie354.setSecteur(secteurRepository.findById(59l).orElse(null));
//
//		// 26,27,28 -> site 11
//		voie364.setSecteur(secteurRepository.findById(26l).orElse(null));
//		voie374.setSecteur(secteurRepository.findById(26l).orElse(null));
//		voie384.setSecteur(secteurRepository.findById(26l).orElse(null));
//		voie394.setSecteur(secteurRepository.findById(26l).orElse(null));
//
//		voie404.setSecteur(secteurRepository.findById(27l).orElse(null));
//		voie414.setSecteur(secteurRepository.findById(27l).orElse(null));
//		voie424.setSecteur(secteurRepository.findById(27l).orElse(null));
//		voie434.setSecteur(secteurRepository.findById(27l).orElse(null));
//		voie444.setSecteur(secteurRepository.findById(27l).orElse(null));
//		voie454.setSecteur(secteurRepository.findById(27l).orElse(null));
//		voie464.setSecteur(secteurRepository.findById(27l).orElse(null));
//		voie474.setSecteur(secteurRepository.findById(27l).orElse(null));
//		voie484.setSecteur(secteurRepository.findById(27l).orElse(null));
//		voie494.setSecteur(secteurRepository.findById(27l).orElse(null));
//		voie504.setSecteur(secteurRepository.findById(27l).orElse(null));
//		voie514.setSecteur(secteurRepository.findById(27l).orElse(null));
//
//		voie524.setSecteur(secteurRepository.findById(28l).orElse(null));
//		voie255.setSecteur(secteurRepository.findById(28l).orElse(null));
//		voie265.setSecteur(secteurRepository.findById(28l).orElse(null));
//		voie275.setSecteur(secteurRepository.findById(28l).orElse(null));
//		voie285.setSecteur(secteurRepository.findById(28l).orElse(null));
//		voie295.setSecteur(secteurRepository.findById(28l).orElse(null));
//		voie305.setSecteur(secteurRepository.findById(28l).orElse(null));
//		voie315.setSecteur(secteurRepository.findById(28l).orElse(null));
//		voie325.setSecteur(secteurRepository.findById(28l).orElse(null));
//		voie335.setSecteur(secteurRepository.findById(28l).orElse(null));
//		voie345.setSecteur(secteurRepository.findById(28l).orElse(null));
//
//		// 29,30,31,32 -> site 12
//		voie355.setSecteur(secteurRepository.findById(29l).orElse(null));
//		voie365.setSecteur(secteurRepository.findById(29l).orElse(null));
//		voie375.setSecteur(secteurRepository.findById(29l).orElse(null));
//		voie385.setSecteur(secteurRepository.findById(29l).orElse(null));
//		voie395.setSecteur(secteurRepository.findById(29l).orElse(null));
//		voie405.setSecteur(secteurRepository.findById(29l).orElse(null));
//		voie415.setSecteur(secteurRepository.findById(29l).orElse(null));
//		voie425.setSecteur(secteurRepository.findById(29l).orElse(null));
//		voie435.setSecteur(secteurRepository.findById(29l).orElse(null));
//		voie445.setSecteur(secteurRepository.findById(29l).orElse(null));
//		voie455.setSecteur(secteurRepository.findById(29l).orElse(null));
//		voie465.setSecteur(secteurRepository.findById(29l).orElse(null));
//
//		voie475.setSecteur(secteurRepository.findById(30l).orElse(null));
//		voie485.setSecteur(secteurRepository.findById(30l).orElse(null));
//		voie495.setSecteur(secteurRepository.findById(30l).orElse(null));
//		voie505.setSecteur(secteurRepository.findById(30l).orElse(null));
//		voie515.setSecteur(secteurRepository.findById(30l).orElse(null));
//		voie525.setSecteur(secteurRepository.findById(30l).orElse(null));
//
//		voie256.setSecteur(secteurRepository.findById(31l).orElse(null));
//		voie266.setSecteur(secteurRepository.findById(31l).orElse(null));
//		voie276.setSecteur(secteurRepository.findById(31l).orElse(null));
//		voie286.setSecteur(secteurRepository.findById(31l).orElse(null));
//		voie296.setSecteur(secteurRepository.findById(31l).orElse(null));
//		voie306.setSecteur(secteurRepository.findById(31l).orElse(null));
//		voie316.setSecteur(secteurRepository.findById(31l).orElse(null));
//		voie326.setSecteur(secteurRepository.findById(31l).orElse(null));
//
//		voie336.setSecteur(secteurRepository.findById(32l).orElse(null));
//		voie346.setSecteur(secteurRepository.findById(32l).orElse(null));
//		voie356.setSecteur(secteurRepository.findById(32l).orElse(null));
//		voie366.setSecteur(secteurRepository.findById(32l).orElse(null));
//		voie376.setSecteur(secteurRepository.findById(32l).orElse(null));
//		voie386.setSecteur(secteurRepository.findById(32l).orElse(null));
//		voie396.setSecteur(secteurRepository.findById(32l).orElse(null));
//
//		// 33,34 -> site 14
//		voie406.setSecteur(secteurRepository.findById(33l).orElse(null));
//		voie416.setSecteur(secteurRepository.findById(33l).orElse(null));
//		voie426.setSecteur(secteurRepository.findById(33l).orElse(null));
//		voie436.setSecteur(secteurRepository.findById(33l).orElse(null));
//		voie446.setSecteur(secteurRepository.findById(33l).orElse(null));
//		voie456.setSecteur(secteurRepository.findById(33l).orElse(null));
//		voie466.setSecteur(secteurRepository.findById(33l).orElse(null));
//		voie476.setSecteur(secteurRepository.findById(33l).orElse(null));
//		voie486.setSecteur(secteurRepository.findById(33l).orElse(null));
//
//		voie496.setSecteur(secteurRepository.findById(34l).orElse(null));
//		voie506.setSecteur(secteurRepository.findById(34l).orElse(null));
//		voie516.setSecteur(secteurRepository.findById(34l).orElse(null));
//		voie526.setSecteur(secteurRepository.findById(34l).orElse(null));
//		voie257.setSecteur(secteurRepository.findById(34l).orElse(null));
//
//		// 35,36,37 -> site 16
//		voie267.setSecteur(secteurRepository.findById(35l).orElse(null));
//		voie277.setSecteur(secteurRepository.findById(35l).orElse(null));
//		voie287.setSecteur(secteurRepository.findById(35l).orElse(null));
//		voie297.setSecteur(secteurRepository.findById(35l).orElse(null));
//
//		voie307.setSecteur(secteurRepository.findById(36l).orElse(null));
//		voie317.setSecteur(secteurRepository.findById(36l).orElse(null));
//		voie327.setSecteur(secteurRepository.findById(36l).orElse(null));
//		voie337.setSecteur(secteurRepository.findById(36l).orElse(null));
//
//		voie347.setSecteur(secteurRepository.findById(37l).orElse(null));
//		voie357.setSecteur(secteurRepository.findById(37l).orElse(null));
//		voie367.setSecteur(secteurRepository.findById(37l).orElse(null));
//		voie377.setSecteur(secteurRepository.findById(37l).orElse(null));
//		voie387.setSecteur(secteurRepository.findById(37l).orElse(null));
//		voie397.setSecteur(secteurRepository.findById(37l).orElse(null));
//		voie407.setSecteur(secteurRepository.findById(37l).orElse(null));
//
//		// 49,50 -> site 17
//		voie417.setSecteur(secteurRepository.findById(49l).orElse(null));
//		voie427.setSecteur(secteurRepository.findById(49l).orElse(null));
//		voie437.setSecteur(secteurRepository.findById(49l).orElse(null));
//		voie447.setSecteur(secteurRepository.findById(49l).orElse(null));
//		voie457.setSecteur(secteurRepository.findById(49l).orElse(null));
//
//		voie467.setSecteur(secteurRepository.findById(50l).orElse(null));
//		voie477.setSecteur(secteurRepository.findById(50l).orElse(null));
//		voie487.setSecteur(secteurRepository.findById(50l).orElse(null));
//
//		// 38,39 -> site 18
//		voie497.setSecteur(secteurRepository.findById(38l).orElse(null));
//		voie507.setSecteur(secteurRepository.findById(38l).orElse(null));
//		voie517.setSecteur(secteurRepository.findById(38l).orElse(null));
//		voie527.setSecteur(secteurRepository.findById(38l).orElse(null));
//		voie228.setSecteur(secteurRepository.findById(38l).orElse(null));
//		voie238.setSecteur(secteurRepository.findById(38l).orElse(null));
//		voie248.setSecteur(secteurRepository.findById(38l).orElse(null));
//
//		voie258.setSecteur(secteurRepository.findById(39l).orElse(null));
//		voie268.setSecteur(secteurRepository.findById(39l).orElse(null));
//		voie278.setSecteur(secteurRepository.findById(39l).orElse(null));
//
//		// 40, 41, 42, 47, 48 -> site 20
//		voie288.setSecteur(secteurRepository.findById(40l).orElse(null));
//		voie298.setSecteur(secteurRepository.findById(40l).orElse(null));
//		voie308.setSecteur(secteurRepository.findById(40l).orElse(null));
//
//		voie338.setSecteur(secteurRepository.findById(41l).orElse(null));
//		voie348.setSecteur(secteurRepository.findById(41l).orElse(null));
//		voie358.setSecteur(secteurRepository.findById(41l).orElse(null));
//
//		voie368.setSecteur(secteurRepository.findById(42l).orElse(null));
//		voie378.setSecteur(secteurRepository.findById(42l).orElse(null));
//		voie388.setSecteur(secteurRepository.findById(42l).orElse(null));
//		voie398.setSecteur(secteurRepository.findById(42l).orElse(null));
//
//		voie408.setSecteur(secteurRepository.findById(47l).orElse(null));
//		voie418.setSecteur(secteurRepository.findById(47l).orElse(null));
//		voie428.setSecteur(secteurRepository.findById(47l).orElse(null));
//
//		voie318.setSecteur(secteurRepository.findById(48l).orElse(null));
//		voie328.setSecteur(secteurRepository.findById(48l).orElse(null));
//
//		// site 10
//		voie438.setSite(siteRepository.findById(10l).orElse(null));
//		voie448.setSite(siteRepository.findById(10l).orElse(null));
//		voie458.setSite(siteRepository.findById(10l).orElse(null));
//		voie468.setSite(siteRepository.findById(10l).orElse(null));
//		voie478.setSite(siteRepository.findById(10l).orElse(null));
//		voie488.setSite(siteRepository.findById(10l).orElse(null));
//		voie498.setSite(siteRepository.findById(10l).orElse(null));
//		voie508.setSite(siteRepository.findById(10l).orElse(null));
//		voie518.setSite(siteRepository.findById(10l).orElse(null));
//		voie528.setSite(siteRepository.findById(10l).orElse(null));
//		voie259.setSite(siteRepository.findById(10l).orElse(null));
//		voie269.setSite(siteRepository.findById(10l).orElse(null));
//		voie279.setSite(siteRepository.findById(10l).orElse(null));
//		voie289.setSite(siteRepository.findById(10l).orElse(null));
//		voie309.setSite(siteRepository.findById(10l).orElse(null));
//
//		// site 15
//		voie319.setSite(siteRepository.findById(15l).orElse(null));
//		voie329.setSite(siteRepository.findById(15l).orElse(null));
//		voie339.setSite(siteRepository.findById(15l).orElse(null));
//		voie349.setSite(siteRepository.findById(15l).orElse(null));
//		voie359.setSite(siteRepository.findById(15l).orElse(null));
//		voie369.setSite(siteRepository.findById(15l).orElse(null));
//		voie379.setSite(siteRepository.findById(15l).orElse(null));
//		voie389.setSite(siteRepository.findById(15l).orElse(null));
//		voie399.setSite(siteRepository.findById(15l).orElse(null));
//		voie409.setSite(siteRepository.findById(15l).orElse(null));
//
//		// site 19
//		voie419.setSite(siteRepository.findById(19l).orElse(null));
//		voie429.setSite(siteRepository.findById(19l).orElse(null));
//		voie439.setSite(siteRepository.findById(19l).orElse(null));
//		voie449.setSite(siteRepository.findById(19l).orElse(null));
//		voie459.setSite(siteRepository.findById(19l).orElse(null));
//		voie469.setSite(siteRepository.findById(19l).orElse(null));
//		voie479.setSite(siteRepository.findById(19l).orElse(null));
//		voie489.setSite(siteRepository.findById(19l).orElse(null));
//		voie499.setSite(siteRepository.findById(19l).orElse(null));
//		voie509.setSite(siteRepository.findById(19l).orElse(null));
//		voie519.setSite(siteRepository.findById(19l).orElse(null));
//		voie529.setSite(siteRepository.findById(19l).orElse(null));
//
//		Longueur longueur1 = new Longueur(CotationBloc._4, voie21);
//		Longueur longueur2 = new Longueur(CotationBloc._4plus, voie21);
//		Longueur longueur3 = new Longueur(CotationBloc._4, voie22);
//		Longueur longueur4 = new Longueur(CotationBloc._4, voie22);
//		Longueur longueur5 = new Longueur(CotationBloc._4, voie23);
//		Longueur longueur6 = new Longueur(CotationBloc._4, voie23);
//		Longueur longueur7 = new Longueur(CotationBloc._4, voie24);
//		Longueur longueur8 = new Longueur(CotationBloc._4, voie24);
//		Longueur longueur9 = new Longueur(CotationBloc._4plus, voie25);
//		Longueur longueur10 = new Longueur(CotationBloc._4plus, voie25);
//		Longueur longueur11 = new Longueur(CotationBloc._4plus, voie26);
//		Longueur longueur12 = new Longueur(CotationBloc._4plus, voie26);
//		Longueur longueur13 = new Longueur(CotationBloc._4plus, voie27);
//		Longueur longueur14 = new Longueur(CotationBloc._4plus, voie27);
//		Longueur longueur15 = new Longueur(CotationBloc._4, voie27);
//		Longueur longueur16 = new Longueur(CotationBloc._4, voie28);
//		Longueur longueur17 = new Longueur(CotationBloc._4, voie29);
//		Longueur longueur18 = new Longueur(CotationBloc._4, voie29);
//
//		Longueur longueur19 = new Longueur(CotationBloc._4, voie31);
//		Longueur longueur20 = new Longueur(CotationBloc._4, voie31);
//		Longueur longueur21 = new Longueur(CotationBloc._4plus, voie31);
//		Longueur longueur22 = new Longueur(CotationBloc._4plus, voie31);
//		Longueur longueur23 = new Longueur(CotationBloc._5, voie32);
//		Longueur longueur24 = new Longueur(CotationBloc._4plus, voie32);
//		Longueur longueur25 = new Longueur(CotationBloc._5, voie33);
//		Longueur longueur26 = new Longueur(CotationBloc._4, voie33);
//		Longueur longueur27 = new Longueur(CotationBloc._4plus, voie34);
//		Longueur longueur28 = new Longueur(CotationBloc._4plus, voie34);
//		Longueur longueur29 = new Longueur(CotationBloc._4, voie35);
//		Longueur longueur30 = new Longueur(CotationBloc._4plus, voie35);
//		Longueur longueur31 = new Longueur(CotationBloc._5, voie36);
//		Longueur longueur32 = new Longueur(CotationBloc._4, voie36);
//		Longueur longueur33 = new Longueur(CotationBloc._4plus, voie37);
//		Longueur longueur34 = new Longueur(CotationBloc._4plus, voie37);
//		Longueur longueur35 = new Longueur(CotationBloc._4, voie38);
//		Longueur longueur36 = new Longueur(CotationBloc._5, voie38);
//
//		Longueur longueur37 = new Longueur(CotationBloc._5, voie41);
//		Longueur longueur38 = new Longueur(CotationBloc._4plus, voie41);
//		Longueur longueur39 = new Longueur(CotationBloc._5, voie41);
//		Longueur longueur40 = new Longueur(CotationBloc._5, voie42);
//		Longueur longueur41 = new Longueur(CotationBloc._5, voie42);
//		Longueur longueur42 = new Longueur(CotationBloc._4plus, voie42);
//		Longueur longueur43 = new Longueur(CotationBloc._5plus, voie43);
//		Longueur longueur44 = new Longueur(CotationBloc._5, voie43);
//		Longueur longueur45 = new Longueur(CotationBloc._5, voie43);
//		Longueur longueur46 = new Longueur(CotationBloc._5plus, voie44);
//		Longueur longueur47 = new Longueur(CotationBloc._5, voie44);
//		Longueur longueur48 = new Longueur(CotationBloc._4plus, voie45);
//		Longueur longueur49 = new Longueur(CotationBloc._5, voie45);
//		Longueur longueur50 = new Longueur(CotationBloc._4, voie46);
//		Longueur longueur51 = new Longueur(CotationBloc._6A, voie46);
//		Longueur longueur52 = new Longueur(CotationBloc._5, voie47);
//		Longueur longueur53 = new Longueur(CotationBloc._5, voie47);
//		Longueur longueur54 = new Longueur(CotationBloc._5, voie47);
//
//		Longueur longueur55 = new Longueur(CotationBloc._5plus, voie51);
//		Longueur longueur56 = new Longueur(CotationBloc._5plus, voie51);
//		Longueur longueur57 = new Longueur(CotationBloc._5, voie52);
//		Longueur longueur58 = new Longueur(CotationBloc._6A, voie52);
//		Longueur longueur59 = new Longueur(CotationBloc._5, voie53);
//		Longueur longueur60 = new Longueur(CotationBloc._6A, voie53);
//		Longueur longueur61 = new Longueur(CotationBloc._5plus, voie54);
//		Longueur longueur62 = new Longueur(CotationBloc._5plus, voie55);
//		Longueur longueur63 = new Longueur(CotationBloc._5plus, voie55);
//		Longueur longueur64 = new Longueur(CotationBloc._6A, voie55);
//		Longueur longueur65 = new Longueur(CotationBloc._6A, voie56);
//		Longueur longueur66 = new Longueur(CotationBloc._5, voie56);
//		Longueur longueur67 = new Longueur(CotationBloc._5plus, voie57);
//		Longueur longueur68 = new Longueur(CotationBloc._5plus, voie57);
//		Longueur longueur69 = new Longueur(CotationBloc._5, voie57);
//		Longueur longueur70 = new Longueur(CotationBloc._6A, voie57);
//		Longueur longueur71 = new Longueur(CotationBloc._5plus, voie57);
//		Longueur longueur72 = new Longueur(CotationBloc._5plus, voie59);
//
//		Longueur longueur73 = new Longueur(CotationBloc._6A, voie61);
//		Longueur longueur74 = new Longueur(CotationBloc._6A, voie62);
//		Longueur longueur75 = new Longueur(CotationBloc._6A, voie63);
//		Longueur longueur76 = new Longueur(CotationBloc._6Aplus, voie64);
//		Longueur longueur77 = new Longueur(CotationBloc._5plus, voie64);
//		Longueur longueur78 = new Longueur(CotationBloc._6A, voie64);
//		Longueur longueur79 = new Longueur(CotationBloc._5plus, voie65);
//		Longueur longueur80 = new Longueur(CotationBloc._5plus, voie65);
//		Longueur longueur81 = new Longueur(CotationBloc._6B, voie65);
//		Longueur longueur82 = new Longueur(CotationBloc._6A, voie66);
//		Longueur longueur83 = new Longueur(CotationBloc._6Aplus, voie66);
//		Longueur longueur84 = new Longueur(CotationBloc._6A, voie67);
//		Longueur longueur85 = new Longueur(CotationBloc._5plus, voie67);
//		Longueur longueur86 = new Longueur(CotationBloc._6A, voie68);
//		Longueur longueur87 = new Longueur(CotationBloc._6A, voie68);
//		Longueur longueur88 = new Longueur(CotationBloc._6Aplus, voie68);
//		Longueur longueur89 = new Longueur(CotationBloc._6B, voie69);
//		Longueur longueur90 = new Longueur(CotationBloc._5, voie69);
//
//		Longueur longueur91 = new Longueur(CotationBloc._6Aplus, voie72);
//		Longueur longueur92 = new Longueur(CotationBloc._6A, voie72);
//		Longueur longueur93 = new Longueur(CotationBloc._6B, voie72);
//		Longueur longueur94 = new Longueur(CotationBloc._6Aplus, voie72);
//		Longueur longueur95 = new Longueur(CotationBloc._6Aplus, voie73);
//		Longueur longueur96 = new Longueur(CotationBloc._6A, voie73);
//		Longueur longueur97 = new Longueur(CotationBloc._6B, voie73);
//		Longueur longueur98 = new Longueur(CotationBloc._6Aplus, voie73);
//		Longueur longueur99 = new Longueur(CotationBloc._6Bplus, voie74);
//		Longueur longueur100 = new Longueur(CotationBloc._5plus, voie74);
//		Longueur longueur101 = new Longueur(CotationBloc._6Aplus, voie74);
//		Longueur longueur102 = new Longueur(CotationBloc._6Aplus, voie74);
//		Longueur longueur103 = new Longueur(CotationBloc._6B, voie75);
//		Longueur longueur104 = new Longueur(CotationBloc._6Aplus, voie75);
//		Longueur longueur105 = new Longueur(CotationBloc._6Aplus, voie76);
//		Longueur longueur106 = new Longueur(CotationBloc._6Aplus, voie76);
//		Longueur longueur107 = new Longueur(CotationBloc._6A, voie77);
//		Longueur longueur108 = new Longueur(CotationBloc._6B, voie77);
//
//		Longueur longueur109 = new Longueur(CotationBloc._6B, voie81);
//		Longueur longueur110 = new Longueur(CotationBloc._6B, voie81);
//		Longueur longueur111 = new Longueur(CotationBloc._6Bplus, voie82);
//		Longueur longueur112 = new Longueur(CotationBloc._6Aplus, voie82);
//		Longueur longueur113 = new Longueur(CotationBloc._6Aplus, voie83);
//		Longueur longueur114 = new Longueur(CotationBloc._6Bplus, voie83);
//		Longueur longueur115 = new Longueur(CotationBloc._6B, voie84);
//		Longueur longueur116 = new Longueur(CotationBloc._6B, voie84);
//		Longueur longueur117 = new Longueur(CotationBloc._6C, voie85);
//		Longueur longueur118 = new Longueur(CotationBloc._6A, voie85);
//		Longueur longueur119 = new Longueur(CotationBloc._6B, voie86);
//		Longueur longueur121 = new Longueur(CotationBloc._6B, voie86);
//		Longueur longueur122 = new Longueur(CotationBloc._6B, voie87);
//		Longueur longueur123 = new Longueur(CotationBloc._6Aplus, voie87);
//		Longueur longueur124 = new Longueur(CotationBloc._6B, voie88);
//
//		Longueur longueur125 = new Longueur(CotationBloc._6Bplus, voie81);
//		Longueur longueur126 = new Longueur(CotationBloc._6Bplus, voie82);
//		Longueur longueur127 = new Longueur(CotationBloc._6Bplus, voie83);
//		Longueur longueur128 = new Longueur(CotationBloc._6Bplus, voie84);
//		Longueur longueur129 = new Longueur(CotationBloc._6B, voie85);
//		Longueur longueur120 = new Longueur(CotationBloc._6C, voie105);
//		Longueur longueur131 = new Longueur(CotationBloc._6Bplus, voie105);
//		Longueur longueur132 = new Longueur(CotationBloc._6Cplus, voie86);
//		Longueur longueur133 = new Longueur(CotationBloc._6Aplus, voie86);
//		Longueur longueur134 = new Longueur(CotationBloc._6Bplus, voie106);
//		Longueur longueur135 = new Longueur(CotationBloc._6C, voie107);
//		Longueur longueur136 = new Longueur(CotationBloc._6Bplus, voie87);
//		Longueur longueur137 = new Longueur(CotationBloc._6Bplus, voie107);
//		Longueur longueur138 = new Longueur(CotationBloc._6Bplus, voie108);
//		Longueur longueur139 = new Longueur(CotationBloc._6B, voie88);
//		Longueur longueur130 = new Longueur(CotationBloc._6C, voie88);
//		Longueur longueur140 = new Longueur(CotationBloc._6Bplus, voie89);
//		Longueur longueur141 = new Longueur(CotationBloc._6B, voie109);
//		Longueur longueur142 = new Longueur(CotationBloc._6Bplus, voie109);
//
//		Longueur longueur143 = new Longueur(CotationBloc._6C, voie101);
//		Longueur longueur144 = new Longueur(CotationBloc._6C, voie101);
//		Longueur longueur145 = new Longueur(CotationBloc._7A, voie102);
//		Longueur longueur146 = new Longueur(CotationBloc._6B, voie102);
//		Longueur longueur147 = new Longueur(CotationBloc._6C, voie103);
//		Longueur longueur148 = new Longueur(CotationBloc._6Bplus, voie103);
//		Longueur longueur149 = new Longueur(CotationBloc._6Cplus, voie103);
//		Longueur longueur150 = new Longueur(CotationBloc._6C, voie103);
//		Longueur longueur151 = new Longueur(CotationBloc._6C, voie103);
//		Longueur longueur152 = new Longueur(CotationBloc._6C, voie104);
//		Longueur longueur153 = new Longueur(CotationBloc._6C, voie105);
//		Longueur longueur154 = new Longueur(CotationBloc._6Bplus, voie106);
//		Longueur longueur155 = new Longueur(CotationBloc._6Cplus, voie106);
//		Longueur longueur156 = new Longueur(CotationBloc._6C, voie107);
//		Longueur longueur157 = new Longueur(CotationBloc._6C, voie107);
//		Longueur longueur158 = new Longueur(CotationBloc._6C, voie108);
//		Longueur longueur159 = new Longueur(CotationBloc._6Cplus, voie108);
//		Longueur longueur160 = new Longueur(CotationBloc._6C, voie109);
//
//		Longueur longueur161 = new Longueur(CotationBloc._6Cplus, voie111);
//		Longueur longueur162 = new Longueur(CotationBloc._6Cplus, voie111);
//		Longueur longueur163 = new Longueur(CotationBloc._7A, voie112);
//		Longueur longueur164 = new Longueur(CotationBloc._6C, voie112);
//		Longueur longueur165 = new Longueur(CotationBloc._6Cplus, voie113);
//		Longueur longueur166 = new Longueur(CotationBloc._7A, voie113);
//		Longueur longueur167 = new Longueur(CotationBloc._6C, voie113);
//		Longueur longueur168 = new Longueur(CotationBloc._6Cplus, voie113);
//		Longueur longueur169 = new Longueur(CotationBloc._6Cplus, voie114);
//		Longueur longueur170 = new Longueur(CotationBloc._6Cplus, voie114);
//		Longueur longueur171 = new Longueur(CotationBloc._6Cplus, voie114);
//		Longueur longueur172 = new Longueur(CotationBloc._7A, voie115);
//		Longueur longueur173 = new Longueur(CotationBloc._6C, voie115);
//		Longueur longueur174 = new Longueur(CotationBloc._6Cplus, voie115);
//		Longueur longueur175 = new Longueur(CotationBloc._6Cplus, voie116);
//		Longueur longueur176 = new Longueur(CotationBloc._6Cplus, voie116);
//		Longueur longueur177 = new Longueur(CotationBloc._6Bplus, voie117);
//		Longueur longueur178 = new Longueur(CotationBloc._7Aplus, voie117);
//
//		Longueur longueur179 = new Longueur(CotationBloc._7A, voie122);
//		Longueur longueur180 = new Longueur(CotationBloc._7A, voie122);
//		Longueur longueur181 = new Longueur(CotationBloc._7A, voie122);
//		Longueur longueur182 = new Longueur(CotationBloc._6Cplus, voie123);
//		Longueur longueur183 = new Longueur(CotationBloc._7Aplus, voie123);
//		Longueur longueur184 = new Longueur(CotationBloc._7A, voie124);
//		Longueur longueur185 = new Longueur(CotationBloc._7Aplus, voie124);
//		Longueur longueur186 = new Longueur(CotationBloc._7A, voie125);
//		Longueur longueur187 = new Longueur(CotationBloc._6Cplus, voie125);
//		Longueur longueur188 = new Longueur(CotationBloc._6Cplus, voie126);
//		Longueur longueur189 = new Longueur(CotationBloc._7A, voie126);
//		Longueur longueur190 = new Longueur(CotationBloc._7A, voie127);
//		Longueur longueur191 = new Longueur(CotationBloc._7Aplus, voie127);
//		Longueur longueur192 = new Longueur(CotationBloc._7B, voie128);
//		Longueur longueur193 = new Longueur(CotationBloc._6Cplus, voie128);
//		Longueur longueur194 = new Longueur(CotationBloc._7A, voie129);
//		Longueur longueur195 = new Longueur(CotationBloc._7A, voie129);
//		Longueur longueur196 = new Longueur(CotationBloc._7Aplus, voie129);
//
//		Longueur longueur197 = new Longueur(CotationBloc._7Aplus, voie133);
//		Longueur longueur198 = new Longueur(CotationBloc._7Aplus, voie133);
//		Longueur longueur199 = new Longueur(CotationBloc._7Aplus, voie133);
//		Longueur longueur200 = new Longueur(CotationBloc._7A, voie134);
//		Longueur longueur201 = new Longueur(CotationBloc._7Aplus, voie134);
//		Longueur longueur202 = new Longueur(CotationBloc._7B, voie134);
//		Longueur longueur203 = new Longueur(CotationBloc._7Aplus, voie135);
//		Longueur longueur204 = new Longueur(CotationBloc._7Bplus, voie135);
//		Longueur longueur205 = new Longueur(CotationBloc._6Cplus, voie135);
//		Longueur longueur206 = new Longueur(CotationBloc._7Aplus, voie137);
//		Longueur longueur207 = new Longueur(CotationBloc._7A, voie137);
//		Longueur longueur208 = new Longueur(CotationBloc._7Aplus, voie138);
//		Longueur longueur209 = new Longueur(CotationBloc._7B, voie138);
//		Longueur longueur210 = new Longueur(CotationBloc._7B, voie139);
//		Longueur longueur211 = new Longueur(CotationBloc._7B, voie139);
//		Longueur longueur212 = new Longueur(CotationBloc._7A, voie139);
//		Longueur longueur213 = new Longueur(CotationBloc._7Aplus, voie139);
//		Longueur longueur214 = new Longueur(CotationBloc._7Aplus, voie139);
//
//		Longueur longueur215 = new Longueur(CotationBloc._7B, voie141);
//		Longueur longueur216 = new Longueur(CotationBloc._7B, voie141);
//		Longueur longueur217 = new Longueur(CotationBloc._7Aplus, voie141);
//		Longueur longueur218 = new Longueur(CotationBloc._7B, voie142);
//		Longueur longueur219 = new Longueur(CotationBloc._7Bplus, voie142);
//		Longueur longueur220 = new Longueur(CotationBloc._7B, voie143);
//		Longueur longueur221 = new Longueur(CotationBloc._7Aplus, voie143);
//		Longueur longueur222 = new Longueur(CotationBloc._7C, voie144);
//		Longueur longueur223 = new Longueur(CotationBloc._7A, voie144);
//		Longueur longueur224 = new Longueur(CotationBloc._7B, voie145);
//		Longueur longueur225 = new Longueur(CotationBloc._7Bplus, voie145);
//		Longueur longueur226 = new Longueur(CotationBloc._7Aplus, voie145);
//		Longueur longueur227 = new Longueur(CotationBloc._7B, voie146);
//		Longueur longueur228 = new Longueur(CotationBloc._7B, voie146);
//		Longueur longueur229 = new Longueur(CotationBloc._7Cplus, voie147);
//		Longueur longueur230 = new Longueur(CotationBloc._6Cplus, voie147);
//		Longueur longueur231 = new Longueur(CotationBloc._7B, voie148);
//		Longueur longueur232 = new Longueur(CotationBloc._7B, voie148);
//
//		Longueur longueur233 = new Longueur(CotationBloc._7Bplus, voie151);
//		Longueur longueur234 = new Longueur(CotationBloc._7C, voie155);
//		Longueur longueur235 = new Longueur(CotationBloc._7B, voie155);
//		Longueur longueur236 = new Longueur(CotationBloc._7Bplus, voie155);
//		Longueur longueur237 = new Longueur(CotationBloc._7Bplus, voie155);
//		Longueur longueur238 = new Longueur(CotationBloc._7C, voie156);
//		Longueur longueur239 = new Longueur(CotationBloc._7Aplus, voie156);
//		Longueur longueur240 = new Longueur(CotationBloc._7Bplus, voie156);
//		Longueur longueur241 = new Longueur(CotationBloc._7C, voie157);
//		Longueur longueur242 = new Longueur(CotationBloc._7Bplus, voie157);
//		Longueur longueur243 = new Longueur(CotationBloc._7Bplus, voie157);
//		Longueur longueur244 = new Longueur(CotationBloc._7Bplus, voie158);
//		Longueur longueur245 = new Longueur(CotationBloc._7C, voie158);
//		Longueur longueur246 = new Longueur(CotationBloc._7B, voie158);
//		Longueur longueur247 = new Longueur(CotationBloc._7Bplus, voie159);
//		Longueur longueur248 = new Longueur(CotationBloc._7B, voie159);
//		Longueur longueur249 = new Longueur(CotationBloc._7C, voie159);
//		Longueur longueur250 = new Longueur(CotationBloc._7Bplus, voie159);
//
//		Longueur longueur251 = new Longueur(CotationBloc._7C, voie161);
//		Longueur longueur252 = new Longueur(CotationBloc._7C, voie161);
//		Longueur longueur253 = new Longueur(CotationBloc._7Bplus, voie162);
//		Longueur longueur254 = new Longueur(CotationBloc._7Cplus, voie162);
//		Longueur longueur255 = new Longueur(CotationBloc._7Bplus, voie163);
//		Longueur longueur256 = new Longueur(CotationBloc._7C, voie163);
//		Longueur longueur257 = new Longueur(CotationBloc._7C, voie164);
//		Longueur longueur258 = new Longueur(CotationBloc._7Cplus, voie164);
//		Longueur longueur259 = new Longueur(CotationBloc._7Cplus, voie165);
//		Longueur longueur260 = new Longueur(CotationBloc._7B, voie165);
//		Longueur longueur261 = new Longueur(CotationBloc._7Bplus, voie166);
//		Longueur longueur262 = new Longueur(CotationBloc._7C, voie166);
//		Longueur longueur263 = new Longueur(CotationBloc._7Bplus, voie167);
//		Longueur longueur264 = new Longueur(CotationBloc._7C, voie167);
//		Longueur longueur265 = new Longueur(CotationBloc._7C, voie168);
//		Longueur longueur266 = new Longueur(CotationBloc._7Bplus, voie168);
//		Longueur longueur267 = new Longueur(CotationBloc._7C, voie169);
//		Longueur longueur268 = new Longueur(CotationBloc._7B, voie169);
//
//		Longueur longueur269 = new Longueur(CotationBloc._7Cplus, voie171);
//		Longueur longueur270 = new Longueur(CotationBloc._7C, voie171);
//		Longueur longueur271 = new Longueur(CotationBloc._7Cplus, voie171);
//		Longueur longueur272 = new Longueur(CotationBloc._7Cplus, voie171);
//		Longueur longueur273 = new Longueur(CotationBloc._7C, voie172);
//		Longueur longueur274 = new Longueur(CotationBloc._8A, voie172);
//		Longueur longueur275 = new Longueur(CotationBloc._7Cplus, voie172);
//		Longueur longueur276 = new Longueur(CotationBloc._7Cplus, voie172);
//		Longueur longueur277 = new Longueur(CotationBloc._7C, voie174);
//		Longueur longueur278 = new Longueur(CotationBloc._7Cplus, voie174);
//		Longueur longueur279 = new Longueur(CotationBloc._8A, voie176);
//		Longueur longueur280 = new Longueur(CotationBloc._7C, voie176);
//		Longueur longueur281 = new Longueur(CotationBloc._7Cplus, voie177);
//		Longueur longueur282 = new Longueur(CotationBloc._7Cplus, voie177);
//		Longueur longueur283 = new Longueur(CotationBloc._7C, voie178);
//		Longueur longueur284 = new Longueur(CotationBloc._8A, voie178);
//		Longueur longueur285 = new Longueur(CotationBloc._7Cplus, voie178);
//		Longueur longueur286 = new Longueur(CotationBloc._7Cplus, voie179);
//
//		Longueur longueur287 = new Longueur(CotationBloc._8A, voie183);
//		Longueur longueur288 = new Longueur(CotationBloc._8A, voie183);
//		Longueur longueur289 = new Longueur(CotationBloc._7Cplus, voie184);
//		Longueur longueur290 = new Longueur(CotationBloc._8Aplus, voie184);
//		Longueur longueur291 = new Longueur(CotationBloc._7Cplus, voie185);
//		Longueur longueur292 = new Longueur(CotationBloc._8Aplus, voie185);
//		Longueur longueur293 = new Longueur(CotationBloc._8Aplus, voie186);
//		Longueur longueur294 = new Longueur(CotationBloc._8A, voie186);
//		Longueur longueur295 = new Longueur(CotationBloc._8A, voie186);
//		Longueur longueur296 = new Longueur(CotationBloc._8Aplus, voie187);
//		Longueur longueur297 = new Longueur(CotationBloc._8Aplus, voie187);
//		Longueur longueur298 = new Longueur(CotationBloc._8A, voie187);
//		Longueur longueur299 = new Longueur(CotationBloc._8A, voie188);
//		Longueur longueur300 = new Longueur(CotationBloc._8A, voie188);
//		Longueur longueur301 = new Longueur(CotationBloc._7Cplus, voie188);
//		Longueur longueur302 = new Longueur(CotationBloc._8A, voie189);
//		Longueur longueur303 = new Longueur(CotationBloc._7Cplus, voie189);
//		Longueur longueur304 = new Longueur(CotationBloc._8Aplus, voie189);
//
//		Longueur longueur305 = new Longueur(CotationBloc._8Aplus, voie191);
//		Longueur longueur306 = new Longueur(CotationBloc._8A, voie191);
//		Longueur longueur307 = new Longueur(CotationBloc._8B, voie191);
//		Longueur longueur308 = new Longueur(CotationBloc._8A, voie192);
//		Longueur longueur309 = new Longueur(CotationBloc._8Aplus, voie192);
//		Longueur longueur310 = new Longueur(CotationBloc._8Aplus, voie192);
//		Longueur longueur311 = new Longueur(CotationBloc._8B, voie193);
//		Longueur longueur312 = new Longueur(CotationBloc._8Aplus, voie193);
//		Longueur longueur313 = new Longueur(CotationBloc._8Aplus, voie193);
//		Longueur longueur314 = new Longueur(CotationBloc._8Aplus, voie194);
//		Longueur longueur315 = new Longueur(CotationBloc._8Bplus, voie194);
//		Longueur longueur316 = new Longueur(CotationBloc._7Cplus, voie194);
//		Longueur longueur317 = new Longueur(CotationBloc._8A, voie194);
//		Longueur longueur318 = new Longueur(CotationBloc._8A, voie194);
//		Longueur longueur319 = new Longueur(CotationBloc._8A, voie195);
//		Longueur longueur320 = new Longueur(CotationBloc._8A, voie196);
//		Longueur longueur321 = new Longueur(CotationBloc._8A, voie197);
//		Longueur longueur322 = new Longueur(CotationBloc._8A, voie198);
//
//		Longueur longueur323 = new Longueur(CotationBloc._8B, voie201);
//		Longueur longueur324 = new Longueur(CotationBloc._8B, voie202);
//		Longueur longueur325 = new Longueur(CotationBloc._8Bplus, voie203);
//		Longueur longueur326 = new Longueur(CotationBloc._8B, voie203);
//		Longueur longueur327 = new Longueur(CotationBloc._8A, voie203);
//		Longueur longueur328 = new Longueur(CotationBloc._8B, voie204);
//		Longueur longueur329 = new Longueur(CotationBloc._8B, voie204);
//		Longueur longueur330 = new Longueur(CotationBloc._8B, voie205);
//		Longueur longueur331 = new Longueur(CotationBloc._8Bplus, voie205);
//		Longueur longueur332 = new Longueur(CotationBloc._8B, voie206);
//		Longueur longueur333 = new Longueur(CotationBloc._8B, voie206);
//		Longueur longueur334 = new Longueur(CotationBloc._8Aplus, voie206);
//		Longueur longueur335 = new Longueur(CotationBloc._8B, voie207);
//		Longueur longueur336 = new Longueur(CotationBloc._8B, voie208);
//		Longueur longueur337 = new Longueur(CotationBloc._8Bplus, voie209);
//		Longueur longueur338 = new Longueur(CotationBloc._8C, voie209);
//		Longueur longueur339 = new Longueur(CotationBloc._8Aplus, voie209);
//		Longueur longueur340 = new Longueur(CotationBloc._8A, voie209);
//
//		Longueur longueur341 = new Longueur(CotationBloc._8Bplus, voie211);
//		Longueur longueur342 = new Longueur(CotationBloc._8Bplus, voie211);
//		Longueur longueur343 = new Longueur(CotationBloc._8Bplus, voie212);
//		Longueur longueur344 = new Longueur(CotationBloc._8B, voie212);
//		Longueur longueur345 = new Longueur(CotationBloc._8Bplus, voie213);
//		Longueur longueur346 = new Longueur(CotationBloc._8C, voie213);
//		Longueur longueur347 = new Longueur(CotationBloc._8Bplus, voie213);
//		Longueur longueur348 = new Longueur(CotationBloc._8Bplus, voie214);
//		Longueur longueur349 = new Longueur(CotationBloc._8C, voie214);
//		Longueur longueur350 = new Longueur(CotationBloc._8Aplus, voie214);
//		Longueur longueur351 = new Longueur(CotationBloc._8Bplus, voie215);
//		Longueur longueur352 = new Longueur(CotationBloc._8B, voie215);
//		Longueur longueur353 = new Longueur(CotationBloc._8Bplus, voie216);
//		Longueur longueur354 = new Longueur(CotationBloc._8C, voie218);
//		Longueur longueur355 = new Longueur(CotationBloc._8B, voie218);
//		Longueur longueur356 = new Longueur(CotationBloc._8Bplus, voie219);
//		Longueur longueur357 = new Longueur(CotationBloc._8Bplus, voie219);
//		Longueur longueur358 = new Longueur(CotationBloc._8C, voie219);
//
//		Longueur longueur359 = new Longueur(CotationBloc._8C, voie221);
//		Longueur longueur360 = new Longueur(CotationBloc._8C, voie222);
//		Longueur longueur361 = new Longueur(CotationBloc._8C, voie224);
//		Longueur longueur362 = new Longueur(CotationBloc._8Clus, voie224);
//		Longueur longueur363 = new Longueur(CotationBloc._8Bplus, voie224);
//		Longueur longueur364 = new Longueur(CotationBloc._8C, voie225);
//		Longueur longueur365 = new Longueur(CotationBloc._8Clus, voie225);
//		Longueur longueur366 = new Longueur(CotationBloc._8Bplus, voie226);
//		Longueur longueur367 = new Longueur(CotationBloc._8C, voie226);
//		Longueur longueur368 = new Longueur(CotationBloc._8Bplus, voie226);
//		Longueur longueur369 = new Longueur(CotationBloc._8C, voie226);
//		Longueur longueur370 = new Longueur(CotationBloc._8C, voie227);
//		Longueur longueur371 = new Longueur(CotationBloc._8C, voie227);
//		Longueur longueur372 = new Longueur(CotationBloc._8Clus, voie228);
//		Longueur longueur373 = new Longueur(CotationBloc._8C, voie228);
//		Longueur longueur374 = new Longueur(CotationBloc._8C, voie229);
//		Longueur longueur375 = new Longueur(CotationBloc._8Bplus, voie229);
//		Longueur longueur376 = new Longueur(CotationBloc._8C, voie229);
//
//		Longueur longueur377 = new Longueur(CotationBloc._8Clus, voie231);
//		Longueur longueur378 = new Longueur(CotationBloc._8C, voie231);
//		Longueur longueur379 = new Longueur(CotationBloc._8C, voie233);
//		Longueur longueur380 = new Longueur(CotationBloc._8C, voie233);
//		Longueur longueur381 = new Longueur(CotationBloc._8Clus, voie235);
//		Longueur longueur382 = new Longueur(CotationBloc._8Clus, voie235);
//		Longueur longueur383 = new Longueur(CotationBloc._8C, voie236);
//		Longueur longueur384 = new Longueur(CotationBloc._8Clus, voie236);
//		Longueur longueur385 = new Longueur(CotationBloc._8Clus, voie236);
//		Longueur longueur386 = new Longueur(CotationBloc._8C, voie237);
//		Longueur longueur387 = new Longueur(CotationBloc._8Clus, voie237);
//		Longueur longueur388 = new Longueur(CotationBloc._8Clus, voie237);
//		Longueur longueur389 = new Longueur(CotationBloc._8Clus, voie238);
//		Longueur longueur390 = new Longueur(CotationBloc._8Clus, voie238);
//		Longueur longueur391 = new Longueur(CotationBloc._8C, voie238);
//		Longueur longueur392 = new Longueur(CotationBloc._8Clus, voie239);
//		Longueur longueur393 = new Longueur(CotationBloc._8Clus, voie239);
//		Longueur longueur394 = new Longueur(CotationBloc._8Clus, voie239);
//
//		Longueur longueur395 = new Longueur(CotationBloc._8Clus, voie241);
//		Longueur longueur396 = new Longueur(CotationBloc._8Clus, voie241);
//		Longueur longueur397 = new Longueur(CotationBloc._8Clus, voie241);
//		Longueur longueur398 = new Longueur(CotationBloc._8Clus, voie241);
//		Longueur longueur399 = new Longueur(CotationBloc._8Clus, voie242);
//		Longueur longueur400 = new Longueur(CotationBloc._8Clus, voie242);
//		Longueur longueur401 = new Longueur(CotationBloc._8C, voie242);
//		Longueur longueur402 = new Longueur(CotationBloc._8C, voie242);
//		Longueur longueur403 = new Longueur(CotationBloc._8C, voie243);
//		Longueur longueur404 = new Longueur(CotationBloc._8Clus, voie243);
//		Longueur longueur405 = new Longueur(CotationBloc._8Clus, voie243);
//		Longueur longueur406 = new Longueur(CotationBloc._8C, voie244);
//		Longueur longueur407 = new Longueur(CotationBloc._8C, voie244);
//		Longueur longueur408 = new Longueur(CotationBloc._8Clus, voie244);
//		Longueur longueur409 = new Longueur(CotationBloc._8Clus, voie245);
//		Longueur longueur410 = new Longueur(CotationBloc._8Clus, voie245);
//		Longueur longueur411 = new Longueur(CotationBloc._8C, voie246);
//		Longueur longueur412 = new Longueur(CotationBloc._8Clus, voie246);
//
//		Longueur longueur413 = new Longueur(CotationFalaise._3, voie251);
//		Longueur longueur414 = new Longueur(CotationFalaise._3, voie251);
//		Longueur longueur415 = new Longueur(CotationFalaise._3Plus, voie251);
//		Longueur longueur416 = new Longueur(CotationFalaise._3, voie253);
//		Longueur longueur417 = new Longueur(CotationFalaise._3Plus, voie253);
//		Longueur longueur418 = new Longueur(CotationFalaise._3, voie253);
//		Longueur longueur419 = new Longueur(CotationFalaise._3Plus, voie255);
//		Longueur longueur420 = new Longueur(CotationFalaise._3, voie255);
//		Longueur longueur421 = new Longueur(CotationFalaise._3, voie255);
//		Longueur longueur422 = new Longueur(CotationFalaise._3Plus, voie256);
//		Longueur longueur423 = new Longueur(CotationFalaise._3, voie256);
//		Longueur longueur424 = new Longueur(CotationFalaise._4a, voie257);
//		Longueur longueur425 = new Longueur(CotationFalaise._3, voie257);
//		Longueur longueur426 = new Longueur(CotationFalaise._3Plus, voie258);
//		Longueur longueur427 = new Longueur(CotationFalaise._3, voie258);
//		Longueur longueur428 = new Longueur(CotationFalaise._3, voie258);
//		Longueur longueur429 = new Longueur(CotationFalaise._3Plus, voie259);
//		Longueur longueur430 = new Longueur(CotationFalaise._3, voie259);
//
//		Longueur longueur431 = new Longueur(CotationFalaise._3Plus, voie261);
//		Longueur longueur432 = new Longueur(CotationFalaise._3Plus, voie261);
//		Longueur longueur433 = new Longueur(CotationFalaise._3Plus, voie262);
//		Longueur longueur434 = new Longueur(CotationFalaise._3, voie262);
//		Longueur longueur435 = new Longueur(CotationFalaise._3Plus, voie263);
//		Longueur longueur436 = new Longueur(CotationFalaise._3Plus, voie263);
//		Longueur longueur437 = new Longueur(CotationFalaise._4a, voie264);
//		Longueur longueur438 = new Longueur(CotationFalaise._3, voie264);
//		Longueur longueur439 = new Longueur(CotationFalaise._3Plus, voie265);
//		Longueur longueur440 = new Longueur(CotationFalaise._3Plus, voie265);
//		Longueur longueur441 = new Longueur(CotationFalaise._3, voie266);
//		Longueur longueur442 = new Longueur(CotationFalaise._4a, voie266);
//		Longueur longueur443 = new Longueur(CotationFalaise._3Plus, voie267);
//		Longueur longueur444 = new Longueur(CotationFalaise._3Plus, voie267);
//		Longueur longueur445 = new Longueur(CotationFalaise._3Plus, voie268);
//		Longueur longueur446 = new Longueur(CotationFalaise._3Plus, voie268);
//		Longueur longueur447 = new Longueur(CotationFalaise._3Plus, voie268);
//		Longueur longueur448 = new Longueur(CotationFalaise._3Plus, voie269);
//
//		Longueur longueur449 = new Longueur(CotationFalaise._4a, voie272);
//		Longueur longueur450 = new Longueur(CotationFalaise._4a, voie272);
//		Longueur longueur451 = new Longueur(CotationFalaise._4a, voie274);
//		Longueur longueur452 = new Longueur(CotationFalaise._3, voie274);
//		Longueur longueur453 = new Longueur(CotationFalaise._4c, voie274);
//		Longueur longueur454 = new Longueur(CotationFalaise._4a, voie274);
//		Longueur longueur455 = new Longueur(CotationFalaise._4b, voie275);
//		Longueur longueur456 = new Longueur(CotationFalaise._4a, voie275);
//		Longueur longueur457 = new Longueur(CotationFalaise._4a, voie275);
//		Longueur longueur458 = new Longueur(CotationFalaise._4a, voie276);
//		Longueur longueur459 = new Longueur(CotationFalaise._3Plus, voie276);
//		Longueur longueur460 = new Longueur(CotationFalaise._4a, voie277);
//		Longueur longueur461 = new Longueur(CotationFalaise._4c, voie278);
//		Longueur longueur462 = new Longueur(CotationFalaise._4b, voie278);
//		Longueur longueur463 = new Longueur(CotationFalaise._3Plus, voie278);
//		Longueur longueur464 = new Longueur(CotationFalaise._4a, voie278);
//		Longueur longueur465 = new Longueur(CotationFalaise._4a, voie279);
//		Longueur longueur466 = new Longueur(CotationFalaise._4b, voie279);
//
//		Longueur longueur467 = new Longueur(CotationFalaise._4b, voie281);
//		Longueur longueur468 = new Longueur(CotationFalaise._4b, voie281);
//		Longueur longueur469 = new Longueur(CotationFalaise._4c, voie281);
//		Longueur longueur470 = new Longueur(CotationFalaise._4b, voie282);
//		Longueur longueur471 = new Longueur(CotationFalaise._4b, voie282);
//		Longueur longueur472 = new Longueur(CotationFalaise._4b, voie283);
//		Longueur longueur473 = new Longueur(CotationFalaise._3Plus, voie283);
//		Longueur longueur474 = new Longueur(CotationFalaise._4b, voie284);
//		Longueur longueur475 = new Longueur(CotationFalaise._3Plus, voie284);
//		Longueur longueur476 = new Longueur(CotationFalaise._5b, voie284);
//		Longueur longueur477 = new Longueur(CotationFalaise._4c, voie285);
//		Longueur longueur478 = new Longueur(CotationFalaise._4a, voie285);
//		Longueur longueur479 = new Longueur(CotationFalaise._4b, voie285);
//		Longueur longueur480 = new Longueur(CotationFalaise._4b, voie286);
//		Longueur longueur481 = new Longueur(CotationFalaise._4b, voie286);
//		Longueur longueur482 = new Longueur(CotationFalaise._4b, voie286);
//		Longueur longueur483 = new Longueur(CotationFalaise._4c, voie287);
//		Longueur longueur484 = new Longueur(CotationFalaise._4b, voie287);
//
//		Longueur longueur485 = new Longueur(CotationFalaise._4c, voie291);
//		Longueur longueur486 = new Longueur(CotationFalaise._4c, voie291);
//		Longueur longueur487 = new Longueur(CotationFalaise._4b, voie292);
//		Longueur longueur488 = new Longueur(CotationFalaise._5a, voie292);
//		Longueur longueur489 = new Longueur(CotationFalaise._4c, voie292);
//		Longueur longueur490 = new Longueur(CotationFalaise._5a, voie293);
//		Longueur longueur491 = new Longueur(CotationFalaise._4c, voie293);
//		Longueur longueur492 = new Longueur(CotationFalaise._4c, voie293);
//		Longueur longueur493 = new Longueur(CotationFalaise._4c, voie294);
//		Longueur longueur494 = new Longueur(CotationFalaise._4c, voie294);
//		Longueur longueur495 = new Longueur(CotationFalaise._5a, voie295);
//		Longueur longueur496 = new Longueur(CotationFalaise._4c, voie295);
//		Longueur longueur497 = new Longueur(CotationFalaise._5a, voie296);
//		Longueur longueur498 = new Longueur(CotationFalaise._4b, voie296);
//		Longueur longueur499 = new Longueur(CotationFalaise._4c, voie297);
//		Longueur longueur500 = new Longueur(CotationFalaise._4c, voie297);
//		Longueur longueur501 = new Longueur(CotationFalaise._4c, voie298);
//		Longueur longueur502 = new Longueur(CotationFalaise._4c, voie299);
//
//		Longueur longueur503 = new Longueur(CotationFalaise._5a, voie301);
//		Longueur longueur504 = new Longueur(CotationFalaise._5a, voie301);
//		Longueur longueur505 = new Longueur(CotationFalaise._5a, voie302);
//		Longueur longueur506 = new Longueur(CotationFalaise._5a, voie303);
//		Longueur longueur507 = new Longueur(CotationFalaise._4c, voie304);
//		Longueur longueur508 = new Longueur(CotationFalaise._5b, voie304);
//		Longueur longueur509 = new Longueur(CotationFalaise._5a, voie304);
//		Longueur longueur510 = new Longueur(CotationFalaise._5b, voie305);
//		Longueur longueur511 = new Longueur(CotationFalaise._5a, voie305);
//		Longueur longueur512 = new Longueur(CotationFalaise._5b, voie306);
//		Longueur longueur513 = new Longueur(CotationFalaise._4c, voie306);
//		Longueur longueur514 = new Longueur(CotationFalaise._4c, voie307);
//		Longueur longueur515 = new Longueur(CotationFalaise._4c, voie307);
//		Longueur longueur516 = new Longueur(CotationFalaise._5c, voie307);
//		Longueur longueur517 = new Longueur(CotationFalaise._5a, voie308);
//		Longueur longueur518 = new Longueur(CotationFalaise._5b, voie309);
//		Longueur longueur519 = new Longueur(CotationFalaise._5a, voie309);
//		Longueur longueur520 = new Longueur(CotationFalaise._4c, voie309);
//
//		Longueur longueur521 = new Longueur(CotationFalaise._5b, voie311);
//		Longueur longueur522 = new Longueur(CotationFalaise._5b, voie311);
//		Longueur longueur523 = new Longueur(CotationFalaise._5a, voie312);
//		Longueur longueur524 = new Longueur(CotationFalaise._5c, voie312);
//		Longueur longueur525 = new Longueur(CotationFalaise._5b, voie312);
//		Longueur longueur526 = new Longueur(CotationFalaise._5b, voie313);
//		Longueur longueur527 = new Longueur(CotationFalaise._5c, voie313);
//		Longueur longueur528 = new Longueur(CotationFalaise._5b, voie314);
//		Longueur longueur529 = new Longueur(CotationFalaise._4c, voie314);
//		Longueur longueur530 = new Longueur(CotationFalaise._5c, voie314);
//		Longueur longueur531 = new Longueur(CotationFalaise._5c, voie314);
//		Longueur longueur532 = new Longueur(CotationFalaise._5b, voie315);
//		Longueur longueur533 = new Longueur(CotationFalaise._5a, voie315);
//		Longueur longueur534 = new Longueur(CotationFalaise._5b, voie316);
//		Longueur longueur535 = new Longueur(CotationFalaise._5b, voie317);
//		Longueur longueur536 = new Longueur(CotationFalaise._5b, voie318);
//		Longueur longueur537 = new Longueur(CotationFalaise._5c, voie319);
//		Longueur longueur538 = new Longueur(CotationFalaise._5a, voie319);
//
//		Longueur longueur539 = new Longueur(CotationFalaise._5c, voie323);
//		Longueur longueur540 = new Longueur(CotationFalaise._5c, voie324);
//		Longueur longueur541 = new Longueur(CotationFalaise._6a, voie324);
//		Longueur longueur542 = new Longueur(CotationFalaise._6a, voie326);
//		Longueur longueur543 = new Longueur(CotationFalaise._5c, voie326);
//		Longueur longueur544 = new Longueur(CotationFalaise._5b, voie326);
//		Longueur longueur545 = new Longueur(CotationFalaise._5b, voie327);
//		Longueur longueur546 = new Longueur(CotationFalaise._6aPlus, voie327);
//		Longueur longueur547 = new Longueur(CotationFalaise._5b, voie327);
//		Longueur longueur548 = new Longueur(CotationFalaise._5c, voie328);
//		Longueur longueur549 = new Longueur(CotationFalaise._5c, voie328);
//		Longueur longueur550 = new Longueur(CotationFalaise._5b, voie328);
//		Longueur longueur551 = new Longueur(CotationFalaise._5a, voie329);
//		Longueur longueur552 = new Longueur(CotationFalaise._6aPlus, voie329);
//		Longueur longueur553 = new Longueur(CotationFalaise._5c, voie329);
//		Longueur longueur554 = new Longueur(CotationFalaise._5b, voie329);
//		Longueur longueur555 = new Longueur(CotationFalaise._6a, voie329);
//		Longueur longueur556 = new Longueur(CotationFalaise._5b, voie329);
//
//		Longueur longueur557 = new Longueur(CotationFalaise._6a, voie331);
//		Longueur longueur558 = new Longueur(CotationFalaise._6a, voie331);
//		Longueur longueur559 = new Longueur(CotationFalaise._6aPlus, voie331);
//		Longueur longueur560 = new Longueur(CotationFalaise._6a, voie332);
//		Longueur longueur561 = new Longueur(CotationFalaise._5c, voie333);
//		Longueur longueur562 = new Longueur(CotationFalaise._6aPlus, voie333);
//		Longueur longueur563 = new Longueur(CotationFalaise._5c, voie334);
//		Longueur longueur564 = new Longueur(CotationFalaise._6b, voie334);
//		Longueur longueur565 = new Longueur(CotationFalaise._6a, voie334);
//		Longueur longueur566 = new Longueur(CotationFalaise._6a, voie335);
//		Longueur longueur567 = new Longueur(CotationFalaise._5c, voie335);
//		Longueur longueur568 = new Longueur(CotationFalaise._6aPlus, voie336);
//		Longueur longueur569 = new Longueur(CotationFalaise._6a, voie336);
//		Longueur longueur570 = new Longueur(CotationFalaise._6a, voie336);
//		Longueur longueur571 = new Longueur(CotationFalaise._6a, voie337);
//		Longueur longueur572 = new Longueur(CotationFalaise._5c, voie338);
//		Longueur longueur573 = new Longueur(CotationFalaise._6aPlus, voie338);
//		Longueur longueur574 = new Longueur(CotationFalaise._6a, voie338);
//
//		Longueur longueur575 = new Longueur(CotationFalaise._6aPlus, voie341);
//		Longueur longueur576 = new Longueur(CotationFalaise._6aPlus, voie343);
//		Longueur longueur577 = new Longueur(CotationFalaise._6b, voie345);
//		Longueur longueur578 = new Longueur(CotationFalaise._6a, voie345);
//		Longueur longueur579 = new Longueur(CotationFalaise._6aPlus, voie345);
//		Longueur longueur580 = new Longueur(CotationFalaise._6bPlus, voie345);
//		Longueur longueur581 = new Longueur(CotationFalaise._6bPlus, voie346);
//		Longueur longueur582 = new Longueur(CotationFalaise._5c, voie346);
//		Longueur longueur583 = new Longueur(CotationFalaise._6aPlus, voie346);
//		Longueur longueur584 = new Longueur(CotationFalaise._6aPlus, voie347);
//		Longueur longueur585 = new Longueur(CotationFalaise._6aPlus, voie348);
//		Longueur longueur586 = new Longueur(CotationFalaise._6a, voie348);
//		Longueur longueur587 = new Longueur(CotationFalaise._6b, voie348);
//		Longueur longueur588 = new Longueur(CotationFalaise._6aPlus, voie349);
//		Longueur longueur589 = new Longueur(CotationFalaise._6a, voie349);
//		Longueur longueur590 = new Longueur(CotationFalaise._6bPlus, voie349);
//		Longueur longueur591 = new Longueur(CotationFalaise._6b, voie349);
//		Longueur longueur592 = new Longueur(CotationFalaise._6a, voie349);
//
//		Longueur longueur593 = new Longueur(CotationFalaise._6b, voie351);
//		Longueur longueur594 = new Longueur(CotationFalaise._6b, voie351);
//		Longueur longueur595 = new Longueur(CotationFalaise._6b, voie351);
//		Longueur longueur596 = new Longueur(CotationFalaise._6aPlus, voie352);
//		Longueur longueur597 = new Longueur(CotationFalaise._6bPlus, voie352);
//		Longueur longueur598 = new Longueur(CotationFalaise._6b, voie352);
//		Longueur longueur599 = new Longueur(CotationFalaise._6aPlus, voie353);
//		Longueur longueur600 = new Longueur(CotationFalaise._6bPlus, voie353);
//		Longueur longueur601 = new Longueur(CotationFalaise._6b, voie353);
//		Longueur longueur602 = new Longueur(CotationFalaise._6a, voie354);
//		Longueur longueur603 = new Longueur(CotationFalaise._6c, voie354);
//		Longueur longueur604 = new Longueur(CotationFalaise._6b, voie354);
//		Longueur longueur605 = new Longueur(CotationFalaise._6b, voie355);
//		Longueur longueur606 = new Longueur(CotationFalaise._6aPlus, voie355);
//		Longueur longueur607 = new Longueur(CotationFalaise._6bPlus, voie356);
//		Longueur longueur608 = new Longueur(CotationFalaise._6b, voie356);
//		Longueur longueur609 = new Longueur(CotationFalaise._6b, voie358);
//		Longueur longueur610 = new Longueur(CotationFalaise._6b, voie359);
//
//		Longueur longueur611 = new Longueur(CotationFalaise._6bPlus, voie362);
//		Longueur longueur612 = new Longueur(CotationFalaise._6bPlus, voie362);
//		Longueur longueur613 = new Longueur(CotationFalaise._6bPlus, voie363);
//		Longueur longueur614 = new Longueur(CotationFalaise._6c, voie363);
//		Longueur longueur615 = new Longueur(CotationFalaise._6b, voie364);
//		Longueur longueur616 = new Longueur(CotationFalaise._6bPlus, voie364);
//		Longueur longueur617 = new Longueur(CotationFalaise._6b, voie366);
//		Longueur longueur618 = new Longueur(CotationFalaise._6bPlus, voie366);
//		Longueur longueur619 = new Longueur(CotationFalaise._6aPlus, voie366);
//		Longueur longueur620 = new Longueur(CotationFalaise._6b, voie367);
//		Longueur longueur621 = new Longueur(CotationFalaise._6a, voie367);
//		Longueur longueur622 = new Longueur(CotationFalaise._6c, voie367);
//		Longueur longueur623 = new Longueur(CotationFalaise._6bPlus, voie368);
//		Longueur longueur624 = new Longueur(CotationFalaise._6aPlus, voie368);
//		Longueur longueur625 = new Longueur(CotationFalaise._6cPlus, voie368);
//		Longueur longueur626 = new Longueur(CotationFalaise._6aPlus, voie369);
//		Longueur longueur627 = new Longueur(CotationFalaise._6bPlus, voie369);
//		Longueur longueur628 = new Longueur(CotationFalaise._6b, voie369);
//
//		Longueur longueur629 = new Longueur(CotationFalaise._6bPlus, voie371);
//		Longueur longueur630 = new Longueur(CotationFalaise._6bPlus, voie371);
//		Longueur longueur631 = new Longueur(CotationFalaise._6bPlus, voie371);
//		Longueur longueur632 = new Longueur(CotationFalaise._6bPlus, voie372);
//		Longueur longueur633 = new Longueur(CotationFalaise._6bPlus, voie373);
//		Longueur longueur634 = new Longueur(CotationFalaise._6b, voie374);
//		Longueur longueur635 = new Longueur(CotationFalaise._6c, voie374);
//		Longueur longueur636 = new Longueur(CotationFalaise._6bPlus, voie375);
//		Longueur longueur637 = new Longueur(CotationFalaise._6b, voie375);
//		Longueur longueur638 = new Longueur(CotationFalaise._6bPlus, voie376);
//		Longueur longueur639 = new Longueur(CotationFalaise._6c, voie376);
//		Longueur longueur640 = new Longueur(CotationFalaise._6bPlus, voie377);
//		Longueur longueur641 = new Longueur(CotationFalaise._6aPlus, voie377);
//		Longueur longueur642 = new Longueur(CotationFalaise._6cPlus, voie377);
//		Longueur longueur643 = new Longueur(CotationFalaise._6bPlus, voie377);
//		Longueur longueur644 = new Longueur(CotationFalaise._6bPlus, voie378);
//		Longueur longueur645 = new Longueur(CotationFalaise._6b, voie378);
//		Longueur longueur646 = new Longueur(CotationFalaise._6bPlus, voie379);
//
//		Longueur longueur647 = new Longueur(CotationFalaise._6c, voie381);
//		Longueur longueur648 = new Longueur(CotationFalaise._6c, voie381);
//		Longueur longueur649 = new Longueur(CotationFalaise._6cPlus, voie382);
//		Longueur longueur650 = new Longueur(CotationFalaise._6c, voie382);
//		Longueur longueur651 = new Longueur(CotationFalaise._6c, voie383);
//		Longueur longueur652 = new Longueur(CotationFalaise._6bPlus, voie383);
//		Longueur longueur653 = new Longueur(CotationFalaise._6c, voie384);
//		Longueur longueur654 = new Longueur(CotationFalaise._6bPlus, voie384);
//		Longueur longueur655 = new Longueur(CotationFalaise._6bPlus, voie385);
//		Longueur longueur656 = new Longueur(CotationFalaise._6cPlus, voie385);
//		Longueur longueur657 = new Longueur(CotationFalaise._6c, voie386);
//		Longueur longueur658 = new Longueur(CotationFalaise._6c, voie386);
//		Longueur longueur659 = new Longueur(CotationFalaise._7a, voie387);
//		Longueur longueur660 = new Longueur(CotationFalaise._6b, voie387);
//		Longueur longueur661 = new Longueur(CotationFalaise._6c, voie388);
//		Longueur longueur662 = new Longueur(CotationFalaise._6cPlus, voie388);
//		Longueur longueur663 = new Longueur(CotationFalaise._6c, voie389);
//		Longueur longueur664 = new Longueur(CotationFalaise._6bPlus, voie389);
//
//		Longueur longueur665 = new Longueur(CotationFalaise._6cPlus, voie391);
//		Longueur longueur666 = new Longueur(CotationFalaise._6cPlus, voie391);
//		Longueur longueur667 = new Longueur(CotationFalaise._6c, voie391);
//		Longueur longueur668 = new Longueur(CotationFalaise._6c, voie392);
//		Longueur longueur669 = new Longueur(CotationFalaise._7a, voie392);
//		Longueur longueur670 = new Longueur(CotationFalaise._6cPlus, voie392);
//		Longueur longueur671 = new Longueur(CotationFalaise._7a, voie393);
//		Longueur longueur672 = new Longueur(CotationFalaise._6b, voie393);
//		Longueur longueur673 = new Longueur(CotationFalaise._7aPlus, voie393);
//		Longueur longueur674 = new Longueur(CotationFalaise._7a, voie394);
//		Longueur longueur675 = new Longueur(CotationFalaise._6c, voie394);
//		Longueur longueur676 = new Longueur(CotationFalaise._6cPlus, voie394);
//		Longueur longueur677 = new Longueur(CotationFalaise._7a, voie395);
//		Longueur longueur678 = new Longueur(CotationFalaise._7aPlus, voie395);
//		Longueur longueur679 = new Longueur(CotationFalaise._6bPlus, voie395);
//		Longueur longueur680 = new Longueur(CotationFalaise._7aPlus, voie396);
//		Longueur longueur681 = new Longueur(CotationFalaise._6cPlus, voie396);
//		Longueur longueur682 = new Longueur(CotationFalaise._6cPlus, voie396);
//
//		Longueur longueur683 = new Longueur(CotationFalaise._7a, voie401);
//		Longueur longueur684 = new Longueur(CotationFalaise._7aPlus, voie401);
//		Longueur longueur685 = new Longueur(CotationFalaise._7a, voie403);
//		Longueur longueur686 = new Longueur(CotationFalaise._6cPlus, voie403);
//		Longueur longueur687 = new Longueur(CotationFalaise._7a, voie405);
//		Longueur longueur688 = new Longueur(CotationFalaise._7a, voie405);
//		Longueur longueur689 = new Longueur(CotationFalaise._6cPlus, voie405);
//		Longueur longueur690 = new Longueur(CotationFalaise._7a, voie406);
//		Longueur longueur691 = new Longueur(CotationFalaise._7aPlus, voie406);
//		Longueur longueur692 = new Longueur(CotationFalaise._7a, voie407);
//		Longueur longueur693 = new Longueur(CotationFalaise._7a, voie407);
//		Longueur longueur694 = new Longueur(CotationFalaise._6c, voie407);
//		Longueur longueur695 = new Longueur(CotationFalaise._7b, voie407);
//		Longueur longueur696 = new Longueur(CotationFalaise._7a, voie408);
//		Longueur longueur697 = new Longueur(CotationFalaise._6cPlus, voie408);
//		Longueur longueur698 = new Longueur(CotationFalaise._7aPlus, voie408);
//		Longueur longueur699 = new Longueur(CotationFalaise._7a, voie409);
//		Longueur longueur700 = new Longueur(CotationFalaise._6cPlus, voie409);
//
//		Longueur longueur701 = new Longueur(CotationFalaise._7b, voie411);
//		Longueur longueur702 = new Longueur(CotationFalaise._7a, voie411);
//		Longueur longueur703 = new Longueur(CotationFalaise._7aPlus, voie411);
//		Longueur longueur704 = new Longueur(CotationFalaise._7aPlus, voie412);
//		Longueur longueur705 = new Longueur(CotationFalaise._7a, voie412);
//		Longueur longueur706 = new Longueur(CotationFalaise._7a, voie412);
//		Longueur longueur707 = new Longueur(CotationFalaise._7b, voie413);
//		Longueur longueur708 = new Longueur(CotationFalaise._7aPlus, voie413);
//		Longueur longueur709 = new Longueur(CotationFalaise._7a, voie414);
//		Longueur longueur710 = new Longueur(CotationFalaise._7b, voie414);
//		Longueur longueur711 = new Longueur(CotationFalaise._7aPlus, voie415);
//		Longueur longueur712 = new Longueur(CotationFalaise._7aPlus, voie415);
//		Longueur longueur713 = new Longueur(CotationFalaise._7aPlus, voie416);
//		Longueur longueur714 = new Longueur(CotationFalaise._7a, voie416);
//		Longueur longueur715 = new Longueur(CotationFalaise._7b, voie417);
//		Longueur longueur716 = new Longueur(CotationFalaise._7a, voie417);
//		Longueur longueur717 = new Longueur(CotationFalaise._7aPlus, voie418);
//		Longueur longueur718 = new Longueur(CotationFalaise._7b, voie418);
//
//		Longueur longueur719 = new Longueur(CotationFalaise._7b, voie421);
//		Longueur longueur720 = new Longueur(CotationFalaise._7b, voie421);
//		Longueur longueur721 = new Longueur(CotationFalaise._7aPlus, voie422);
//		Longueur longueur722 = new Longueur(CotationFalaise._7bPlus, voie422);
//		Longueur longueur723 = new Longueur(CotationFalaise._7aPlus, voie423);
//		Longueur longueur724 = new Longueur(CotationFalaise._7b, voie423);
//		Longueur longueur725 = new Longueur(CotationFalaise._7b, voie424);
//		Longueur longueur726 = new Longueur(CotationFalaise._7bPlus, voie424);
//		Longueur longueur727 = new Longueur(CotationFalaise._7aPlus, voie425);
//		Longueur longueur728 = new Longueur(CotationFalaise._7b, voie425);
//		Longueur longueur729 = new Longueur(CotationFalaise._7bPlus, voie425);
//		Longueur longueur730 = new Longueur(CotationFalaise._7b, voie425);
//		Longueur longueur731 = new Longueur(CotationFalaise._7bPlus, voie426);
//		Longueur longueur732 = new Longueur(CotationFalaise._7b, voie426);
//		Longueur longueur733 = new Longueur(CotationFalaise._7aPlus, voie427);
//		Longueur longueur734 = new Longueur(CotationFalaise._7b, voie427);
//		Longueur longueur735 = new Longueur(CotationFalaise._7b, voie428);
//		Longueur longueur736 = new Longueur(CotationFalaise._7b, voie429);
//
//		Longueur longueur737 = new Longueur(CotationFalaise._7bPlus, voie431);
//		Longueur longueur738 = new Longueur(CotationFalaise._7b, voie431);
//		Longueur longueur739 = new Longueur(CotationFalaise._7c, voie432);
//		Longueur longueur740 = new Longueur(CotationFalaise._7bPlus, voie432);
//		Longueur longueur741 = new Longueur(CotationFalaise._7bPlus, voie432);
//		Longueur longueur742 = new Longueur(CotationFalaise._7bPlus, voie433);
//		Longueur longueur743 = new Longueur(CotationFalaise._7b, voie433);
//		Longueur longueur744 = new Longueur(CotationFalaise._7c, voie433);
//		Longueur longueur745 = new Longueur(CotationFalaise._7cPlus, voie434);
//		Longueur longueur746 = new Longueur(CotationFalaise._7aPlus, voie434);
//		Longueur longueur747 = new Longueur(CotationFalaise._7bPlus, voie434);
//		Longueur longueur748 = new Longueur(CotationFalaise._7bPlus, voie435);
//		Longueur longueur749 = new Longueur(CotationFalaise._7aPlus, voie436);
//		Longueur longueur750 = new Longueur(CotationFalaise._7cPlus, voie436);
//		Longueur longueur751 = new Longueur(CotationFalaise._7b, voie437);
//		Longueur longueur752 = new Longueur(CotationFalaise._7c, voie437);
//		Longueur longueur753 = new Longueur(CotationFalaise._7bPlus, voie438);
//		Longueur longueur754 = new Longueur(CotationFalaise._7bPlus, voie439);
//
//		Longueur longueur755 = new Longueur(CotationFalaise._7c, voie442);
//		Longueur longueur756 = new Longueur(CotationFalaise._7c, voie442);
//		Longueur longueur757 = new Longueur(CotationFalaise._7bPlus, voie442);
//		Longueur longueur758 = new Longueur(CotationFalaise._7c, voie444);
//		Longueur longueur759 = new Longueur(CotationFalaise._7cPlus, voie444);
//		Longueur longueur760 = new Longueur(CotationFalaise._7bPlus, voie444);
//		Longueur longueur761 = new Longueur(CotationFalaise._7c, voie445);
//		Longueur longueur762 = new Longueur(CotationFalaise._7c, voie445);
//		Longueur longueur763 = new Longueur(CotationFalaise._7c, voie446);
//		Longueur longueur764 = new Longueur(CotationFalaise._7cPlus, voie447);
//		Longueur longueur765 = new Longueur(CotationFalaise._7bPlus, voie447);
//		Longueur longueur766 = new Longueur(CotationFalaise._7bPlus, voie447);
//		Longueur longueur767 = new Longueur(CotationFalaise._7c, voie448);
//		Longueur longueur768 = new Longueur(CotationFalaise._7c, voie448);
//		Longueur longueur769 = new Longueur(CotationFalaise._7cPlus, voie449);
//		Longueur longueur770 = new Longueur(CotationFalaise._7bPlus, voie449);
//		Longueur longueur771 = new Longueur(CotationFalaise._7bPlus, voie449);
//		Longueur longueur772 = new Longueur(CotationFalaise._7c, voie449);
//
//		Longueur longueur773 = new Longueur(CotationFalaise._7cPlus, voie451);
//		Longueur longueur774 = new Longueur(CotationFalaise._7cPlus, voie451);
//		Longueur longueur775 = new Longueur(CotationFalaise._7cPlus, voie451);
//		Longueur longueur776 = new Longueur(CotationFalaise._7bPlus, voie451);
//		Longueur longueur777 = new Longueur(CotationFalaise._7c, voie452);
//		Longueur longueur778 = new Longueur(CotationFalaise._7cPlus, voie454);
//		Longueur longueur779 = new Longueur(CotationFalaise._7bPlus, voie454);
//		Longueur longueur780 = new Longueur(CotationFalaise._7cPlus, voie454);
//		Longueur longueur781 = new Longueur(CotationFalaise._7bPlus, voie454);
//		Longueur longueur782 = new Longueur(CotationFalaise._7cPlus, voie455);
//		Longueur longueur783 = new Longueur(CotationFalaise._7c, voie456);
//		Longueur longueur784 = new Longueur(CotationFalaise._7cPlus, voie456);
//		Longueur longueur785 = new Longueur(CotationFalaise._8a, voie457);
//		Longueur longueur786 = new Longueur(CotationFalaise._7cPlus, voie457);
//		Longueur longueur787 = new Longueur(CotationFalaise._7cPlus, voie457);
//		Longueur longueur788 = new Longueur(CotationFalaise._7cPlus, voie458);
//		Longueur longueur789 = new Longueur(CotationFalaise._7cPlus, voie458);
//		Longueur longueur790 = new Longueur(CotationFalaise._7bPlus, voie458);
//
//		Longueur longueur791 = new Longueur(CotationFalaise._8a, voie461);
//		Longueur longueur792 = new Longueur(CotationFalaise._8a, voie462);
//		Longueur longueur793 = new Longueur(CotationFalaise._8a, voie463);
//		Longueur longueur794 = new Longueur(CotationFalaise._8a, voie464);
//		Longueur longueur795 = new Longueur(CotationFalaise._8a, voie465);
//		Longueur longueur796 = new Longueur(CotationFalaise._8a, voie466);
//		Longueur longueur797 = new Longueur(CotationFalaise._8a, voie467);
//		Longueur longueur798 = new Longueur(CotationFalaise._8a, voie468);
//		Longueur longueur799 = new Longueur(CotationFalaise._8a, voie468);
//		Longueur longueur800 = new Longueur(CotationFalaise._8aPlus, voie468);
//		Longueur longueur801 = new Longueur(CotationFalaise._8aPlus, voie468);
//		Longueur longueur802 = new Longueur(CotationFalaise._7c, voie468);
//		Longueur longueur803 = new Longueur(CotationFalaise._8a, voie469);
//		Longueur longueur804 = new Longueur(CotationFalaise._8a, voie469);
//		Longueur longueur805 = new Longueur(CotationFalaise._8aPlus, voie469);
//		Longueur longueur806 = new Longueur(CotationFalaise._7cPlus, voie469);
//		Longueur longueur807 = new Longueur(CotationFalaise._8a, voie469);
//		Longueur longueur808 = new Longueur(CotationFalaise._8a, voie469);
//
//		Longueur longueur809 = new Longueur(CotationFalaise._8aPlus, voie471);
//		Longueur longueur810 = new Longueur(CotationFalaise._8aPlus, voie473);
//		Longueur longueur811 = new Longueur(CotationFalaise._8b, voie473);
//		Longueur longueur812 = new Longueur(CotationFalaise._8a, voie473);
//		Longueur longueur813 = new Longueur(CotationFalaise._8aPlus, voie473);
//		Longueur longueur814 = new Longueur(CotationFalaise._8aPlus, voie473);
//		Longueur longueur815 = new Longueur(CotationFalaise._8aPlus, voie474);
//		Longueur longueur816 = new Longueur(CotationFalaise._8b, voie474);
//		Longueur longueur817 = new Longueur(CotationFalaise._8aPlus, voie475);
//		Longueur longueur818 = new Longueur(CotationFalaise._8aPlus, voie475);
//		Longueur longueur819 = new Longueur(CotationFalaise._8a, voie475);
//		Longueur longueur820 = new Longueur(CotationFalaise._8aPlus, voie476);
//		Longueur longueur821 = new Longueur(CotationFalaise._8b, voie476);
//		Longueur longueur822 = new Longueur(CotationFalaise._8aPlus, voie477);
//		Longueur longueur823 = new Longueur(CotationFalaise._8b, voie477);
//		Longueur longueur824 = new Longueur(CotationFalaise._8aPlus, voie478);
//		Longueur longueur825 = new Longueur(CotationFalaise._8b, voie478);
//		Longueur longueur826 = new Longueur(CotationFalaise._8aPlus, voie479);
//
//		Longueur longueur827 = new Longueur(CotationFalaise._8b, voie481);
//		Longueur longueur828 = new Longueur(CotationFalaise._8b, voie481);
//		Longueur longueur829 = new Longueur(CotationFalaise._8b, voie482);
//		Longueur longueur830 = new Longueur(CotationFalaise._8b, voie483);
//		Longueur longueur831 = new Longueur(CotationFalaise._8b, voie483);
//		Longueur longueur832 = new Longueur(CotationFalaise._8b, voie484);
//		Longueur longueur833 = new Longueur(CotationFalaise._8b, voie484);
//		Longueur longueur834 = new Longueur(CotationFalaise._8bPlus, voie484);
//		Longueur longueur835 = new Longueur(CotationFalaise._8b, voie485);
//		Longueur longueur836 = new Longueur(CotationFalaise._8bPlus, voie485);
//		Longueur longueur837 = new Longueur(CotationFalaise._8aPlus, voie485);
//		Longueur longueur838 = new Longueur(CotationFalaise._8b, voie486);
//		Longueur longueur839 = new Longueur(CotationFalaise._8aPlus, voie486);
//		Longueur longueur840 = new Longueur(CotationFalaise._8b, voie487);
//		Longueur longueur841 = new Longueur(CotationFalaise._8bPlus, voie487);
//		Longueur longueur842 = new Longueur(CotationFalaise._8b, voie488);
//		Longueur longueur843 = new Longueur(CotationFalaise._8b, voie489);
//		Longueur longueur844 = new Longueur(CotationFalaise._8b, voie489);
//
//		Longueur longueur845 = new Longueur(CotationFalaise._8bPlus, voie491);
//		Longueur longueur846 = new Longueur(CotationFalaise._8bPlus, voie492);
//		Longueur longueur847 = new Longueur(CotationFalaise._8bPlus, voie492);
//		Longueur longueur848 = new Longueur(CotationFalaise._8c, voie492);
//		Longueur longueur849 = new Longueur(CotationFalaise._8bPlus, voie494);
//		Longueur longueur851 = new Longueur(CotationFalaise._8c, voie494);
//		Longueur longueur852 = new Longueur(CotationFalaise._8bPlus, voie496);
//		Longueur longueur853 = new Longueur(CotationFalaise._8bPlus, voie496);
//		Longueur longueur854 = new Longueur(CotationFalaise._8cPlus, voie496);
//		Longueur longueur855 = new Longueur(CotationFalaise._8b, voie496);
//		Longueur longueur856 = new Longueur(CotationFalaise._8bPlus, voie498);
//		Longueur longueur857 = new Longueur(CotationFalaise._8c, voie498);
//		Longueur longueur858 = new Longueur(CotationFalaise._8bPlus, voie499);
//		Longueur longueur859 = new Longueur(CotationFalaise._8bPlus, voie499);
//		Longueur longueur850 = new Longueur(CotationFalaise._8c, voie499);
//		Longueur longueur860 = new Longueur(CotationFalaise._8bPlus, voie499);
//		Longueur longueur861 = new Longueur(CotationFalaise._8c, voie499);
//		Longueur longueur862 = new Longueur(CotationFalaise._8bPlus, voie499);
//
//		Longueur longueur863 = new Longueur(CotationFalaise._8c, voie501);
//		Longueur longueur864 = new Longueur(CotationFalaise._8c, voie501);
//		Longueur longueur865 = new Longueur(CotationFalaise._8c, voie501);
//		Longueur longueur866 = new Longueur(CotationFalaise._8c, voie502);
//		Longueur longueur867 = new Longueur(CotationFalaise._8c, voie502);
//		Longueur longueur868 = new Longueur(CotationFalaise._8cPlus, voie502);
//		Longueur longueur869 = new Longueur(CotationFalaise._8c, voie503);
//		Longueur longueur870 = new Longueur(CotationFalaise._8bPlus, voie503);
//		Longueur longueur871 = new Longueur(CotationFalaise._8c, voie504);
//		Longueur longueur872 = new Longueur(CotationFalaise._8cPlus, voie504);
//		Longueur longueur873 = new Longueur(CotationFalaise._8c, voie505);
//		Longueur longueur874 = new Longueur(CotationFalaise._8b, voie505);
//		Longueur longueur875 = new Longueur(CotationFalaise._9a, voie505);
//		Longueur longueur876 = new Longueur(CotationFalaise._8c, voie506);
//		Longueur longueur877 = new Longueur(CotationFalaise._8c, voie506);
//		Longueur longueur878 = new Longueur(CotationFalaise._8c, voie507);
//		Longueur longueur879 = new Longueur(CotationFalaise._8cPlus, voie507);
//		Longueur longueur880 = new Longueur(CotationFalaise._8bPlus, voie507);
//
//		Longueur longueur881 = new Longueur(CotationFalaise._9a, voie511);
//		Longueur longueur882 = new Longueur(CotationFalaise._9aPlus, voie511);
//		Longueur longueur883 = new Longueur(CotationFalaise._8cPlus, voie512);
//		Longueur longueur884 = new Longueur(CotationFalaise._9aPlus, voie512);
//		Longueur longueur885 = new Longueur(CotationFalaise._9aPlus, voie513);
//		Longueur longueur886 = new Longueur(CotationFalaise._9a, voie513);
//		Longueur longueur887 = new Longueur(CotationFalaise._8c, voie514);
//		Longueur longueur888 = new Longueur(CotationFalaise._8cPlus, voie514);
//		Longueur longueur889 = new Longueur(CotationFalaise._9a, voie515);
//		Longueur longueur890 = new Longueur(CotationFalaise._9aPlus, voie515);
//		Longueur longueur891 = new Longueur(CotationFalaise._9aPlus, voie516);
//		Longueur longueur892 = new Longueur(CotationFalaise._9a, voie516);
//		Longueur longueur893 = new Longueur(CotationFalaise._9aPlus, voie517);
//		Longueur longueur894 = new Longueur(CotationFalaise._8cPlus, voie517);
//		Longueur longueur895 = new Longueur(CotationFalaise._9a, voie518);
//		Longueur longueur896 = new Longueur(CotationFalaise._9aPlus, voie518);
//		Longueur longueur897 = new Longueur(CotationFalaise._9aPlus, voie519);
//		Longueur longueur898 = new Longueur(CotationFalaise._9a, voie519);
//		Longueur longueur899 = new Longueur(CotationFalaise._8cPlus, voie519);
//		Longueur longueur900 = new Longueur(CotationFalaise._9a, voie519);
//
////		List<Voie> listeVoies = Arrays.asList(voie21, voie22, voie23, voie24, voie25, voie26, voie27, voie28, voie29,
////				voie31, voie32, voie33, voie34, voie35, voie36, voie37, voie38, voie39, voie41, voie42, voie43, voie44,
////				voie45, voie46, voie47, voie48, voie49, voie51, voie52, voie53, voie54, voie55, voie56, voie57, voie58,
////				voie59, voie61, voie62, voie63, voie64, voie65, voie66, voie67, voie68, voie69, voie71, voie72, voie73,
////				voie74, voie75, voie76, voie77, voie78, voie79, voie81, voie82, voie83, voie84, voie85, voie86, voie87,
////				voie88, voie89, voie101, voie102, voie103, voie104, voie105, voie106, voie107, voie108, voie109,
////				voie111, voie112, voie113, voie114, voie115, voie116, voie117, voie118, voie119, voie121, voie122,
////				voie123, voie124, voie125, voie126, voie127, voie128, voie129, voie131, voie132, voie133, voie134,
////				voie135, voie136, voie137, voie138, voie139, voie141, voie142, voie143, voie144, voie145, voie146,
////				voie147, voie148, voie149, voie151, voie152, voie153, voie154, voie155, voie156, voie157, voie158,
////				voie159, voie161, voie162, voie163, voie164, voie165, voie166, voie167, voie168, voie169, voie171,
////				voie172, voie173, voie174, voie175, voie176, voie177, voie178, voie179, voie181, voie182, voie183,
////				voie184, voie185, voie186, voie187, voie188, voie189, voie191, voie192, voie193, voie194, voie195,
////				voie196, voie197, voie198, voie199, voie201, voie202, voie203, voie204, voie205, voie206, voie208,
////				voie209, voie211, voie212, voie213, voie214, voie215, voie216, voie217, voie218, voie219, voie221,
////				voie222, voie223, voie224, voie225, voie226, voie227, voie228, voie229, voie231, voie232, voie233,
////				voie234, voie235, voie236, voie237, voie238, voie239, voie241, voie242, voie243, voie244, voie245,
////				voie246, voie247, voie248, voie249, voie251, voie252, voie253, voie254, voie255, voie256, voie257,
////				voie258, voie259, voie261, voie262, voie263, voie264, voie265, voie266, voie267, voie268, voie269,
////				voie271, voie272, voie273, voie274, voie275, voie276, voie277, voie278, voie279, voie281, voie282,
////				voie283, voie284, voie285, voie286, voie287, voie288, voie289, voie291, voie292, voie293, voie294,
////				voie295, voie296, voie297, voie298, voie299, voie301, voie302, voie303, voie304, voie305, voie306,
////				voie307, voie308, voie309, voie311, voie312, voie313, voie314, voie315, voie316, voie317, voie318,
////				voie319, voie321, voie322, voie323, voie324, voie325, voie326, voie327, voie328, voie329, voie331,
////				voie332, voie333, voie334, voie335, voie336, voie337, voie338, voie339, voie341, voie342, voie343,
////				voie344, voie345, voie346, voie347, voie348, voie349, voie351, voie352, voie353, voie354, voie355,
////				voie356, voie357, voie358, voie359, voie361, voie362, voie363, voie364, voie365, voie366, voie367,
////				voie368, voie369, voie371, voie372, voie373, voie374, voie375, voie376, voie377, voie378, voie379,
////				voie381, voie382, voie383, voie384, voie385, voie386, voie387, voie388, voie389, voie391, voie392,
////				voie393, voie394, voie395, voie396, voie397, voie398, voie399, voie401, voie402, voie403, voie404,
////				voie405, voie406, voie407, voie408, voie409, voie411, voie412, voie413, voie414, voie415, voie416,
////				voie417, voie418, voie419, voie421, voie422, voie423, voie424, voie425, voie426, voie427, voie428,
////				voie429, voie431, voie432, voie433, voie434, voie435, voie436, voie437, voie438, voie439, voie441,
////				voie442, voie443, voie444, voie445, voie446, voie447, voie448, voie449, voie451, voie452, voie453,
////				voie454, voie455, voie456, voie457, voie458, voie459, voie461, voie462, voie463, voie464, voie465,
////				voie466, voie467, voie468, voie469, voie471, voie472, voie473, voie474, voie475, voie476, voie477,
////				voie478, voie479, voie481, voie482, voie483, voie484, voie485, voie486, voie487, voie488, voie489,
////				voie491, voie492, voie493, voie494, voie495, voie496, voie497, voie498, voie499, voie501, voie502,
////				voie503, voie504, voie505, voie506, voie507, voie508, voie509, voie511, voie512, voie513, voie514,
////				voie515, voie516, voie517, voie518, voie519, voie521, voie522, voie523, voie524, voie525, voie526,
////				voie527, voie528, voie529);
////		voieRepository.saveAll(listeVoies);
//
////		List<Longueur> listeLongueurs = Arrays.asList(longueur900);
//
//		List<Longueur> listeLongueurs = Arrays.asList(longueur1, longueur2, longueur3, longueur4, longueur5, longueur6,
//				longueur7, longueur8, longueur9, longueur10, longueur11, longueur12, longueur13, longueur14, longueur15,
//				longueur16, longueur17, longueur18, longueur19, longueur20, longueur21, longueur22, longueur23,
//				longueur24, longueur25, longueur26, longueur27, longueur28, longueur29, longueur30, longueur31,
//				longueur32, longueur33, longueur34, longueur35, longueur36, longueur37, longueur38, longueur39,
//				longueur40, longueur41, longueur42, longueur43, longueur44, longueur45, longueur46, longueur47,
//				longueur48, longueur49, longueur50, longueur51, longueur52, longueur53, longueur54, longueur55,
//				longueur56, longueur57, longueur58, longueur59, longueur60, longueur61, longueur62, longueur63,
//				longueur64, longueur65, longueur66, longueur67, longueur68, longueur69, longueur70, longueur71,
//				longueur72, longueur73, longueur74, longueur75, longueur76, longueur77, longueur78, longueur79,
//				longueur80, longueur81, longueur82, longueur83, longueur84, longueur85, longueur86, longueur87,
//				longueur88, longueur89, longueur90, longueur91, longueur92, longueur93, longueur94, longueur95,
//				longueur96, longueur97, longueur98, longueur99, longueur100, longueur101, longueur102, longueur103,
//				longueur104, longueur105, longueur106, longueur107, longueur108, longueur109, longueur110, longueur111,
//				longueur112, longueur113, longueur114, longueur115, longueur116, longueur117, longueur118, longueur119,
//				longueur120, longueur121, longueur122, longueur123, longueur124, longueur125, longueur126, longueur127,
//				longueur128, longueur129, longueur130, longueur131, longueur132, longueur133, longueur134, longueur135,
//				longueur136, longueur137, longueur138, longueur139, longueur140, longueur141, longueur142, longueur143,
//				longueur144, longueur145, longueur146, longueur147, longueur148, longueur149, longueur150, longueur151,
//				longueur152, longueur153, longueur154, longueur155, longueur156, longueur157, longueur158, longueur159,
//				longueur160, longueur161, longueur162, longueur163, longueur164, longueur165, longueur166, longueur167,
//				longueur168, longueur169, longueur170, longueur171, longueur172, longueur173, longueur174, longueur175,
//				longueur176, longueur177, longueur178, longueur179, longueur180, longueur181, longueur182, longueur183,
//				longueur184, longueur185, longueur186, longueur187, longueur188, longueur189, longueur190, longueur191,
//				longueur192, longueur193, longueur194, longueur195, longueur196, longueur197, longueur198, longueur199,
//				longueur200, longueur201, longueur202, longueur203, longueur204, longueur205, longueur206, longueur207,
//				longueur208, longueur209, longueur210, longueur211, longueur212, longueur213, longueur214, longueur215,
//				longueur216, longueur217, longueur218, longueur219, longueur220, longueur221, longueur222, longueur223,
//				longueur224, longueur225, longueur226, longueur227, longueur228, longueur229, longueur230, longueur231,
//				longueur232, longueur233, longueur234, longueur235, longueur236, longueur237, longueur238, longueur239,
//				longueur240, longueur241, longueur242, longueur243, longueur244, longueur245, longueur246, longueur247,
//				longueur248, longueur249, longueur250, longueur251, longueur252, longueur253, longueur254, longueur255,
//				longueur256, longueur257, longueur258, longueur259, longueur260, longueur261, longueur262, longueur263,
//				longueur264, longueur265, longueur266, longueur267, longueur268, longueur269, longueur270, longueur271,
//				longueur272, longueur273, longueur274, longueur275, longueur276, longueur277, longueur278, longueur279,
//				longueur280, longueur281, longueur282, longueur283, longueur284, longueur285, longueur286, longueur287,
//				longueur288, longueur289, longueur290, longueur291, longueur292, longueur293, longueur294, longueur295,
//				longueur296, longueur297, longueur298, longueur299, longueur300, longueur301, longueur302, longueur303,
//				longueur304, longueur305, longueur306, longueur307, longueur308, longueur309, longueur310, longueur311,
//				longueur312, longueur313, longueur314, longueur315, longueur316, longueur317, longueur318, longueur319,
//				longueur320, longueur321, longueur322, longueur323, longueur324, longueur325, longueur326, longueur327,
//				longueur328, longueur329, longueur330, longueur331, longueur332, longueur333, longueur334, longueur335,
//				longueur336, longueur337, longueur338, longueur339, longueur340, longueur341, longueur342, longueur343,
//				longueur344, longueur345, longueur346, longueur347, longueur348, longueur349, longueur350, longueur351,
//				longueur352, longueur353, longueur354, longueur355, longueur356, longueur357, longueur358, longueur359,
//				longueur360, longueur361, longueur362, longueur363, longueur364, longueur365, longueur366, longueur367,
//				longueur368, longueur369, longueur370, longueur371, longueur372, longueur373, longueur374, longueur375,
//				longueur376, longueur377, longueur378, longueur379, longueur380, longueur381, longueur382, longueur383,
//				longueur384, longueur385, longueur386, longueur387, longueur388, longueur389, longueur390, longueur391,
//				longueur392, longueur393, longueur394, longueur395, longueur396, longueur397, longueur398, longueur399,
//				longueur400, longueur401, longueur402, longueur403, longueur404, longueur405, longueur406, longueur407,
//				longueur408, longueur409, longueur410, longueur411, longueur412, longueur413, longueur414, longueur415,
//				longueur416, longueur417, longueur418, longueur419, longueur420, longueur421, longueur422, longueur423,
//				longueur424, longueur425, longueur426, longueur427, longueur428, longueur429, longueur430, longueur431,
//				longueur432, longueur433, longueur434, longueur435, longueur436, longueur437, longueur438, longueur439,
//				longueur440, longueur441, longueur442, longueur443, longueur444, longueur445, longueur446, longueur447,
//				longueur448, longueur449, longueur450, longueur451, longueur452, longueur453, longueur454, longueur455,
//				longueur456, longueur457, longueur458, longueur459, longueur460, longueur461, longueur462, longueur463,
//				longueur464, longueur465, longueur466, longueur467, longueur468, longueur469, longueur470, longueur471,
//				longueur472, longueur473, longueur474, longueur475, longueur476, longueur477, longueur478, longueur479,
//				longueur480, longueur481, longueur482, longueur483, longueur484, longueur485, longueur486, longueur487,
//				longueur488, longueur489, longueur490, longueur491, longueur492, longueur493, longueur494, longueur495,
//				longueur496, longueur497, longueur498, longueur499, longueur500, longueur501, longueur502, longueur503,
//				longueur504, longueur505, longueur506, longueur507, longueur508, longueur509, longueur510, longueur511,
//				longueur512, longueur513, longueur514, longueur515, longueur516, longueur517, longueur518, longueur519,
//				longueur520, longueur521, longueur522, longueur523, longueur524, longueur525, longueur526, longueur527,
//				longueur528, longueur529, longueur530, longueur531, longueur532, longueur533, longueur534, longueur535,
//				longueur536, longueur537, longueur538, longueur539, longueur540, longueur541, longueur542, longueur543,
//				longueur544, longueur545, longueur546, longueur547, longueur548, longueur549, longueur550, longueur551,
//				longueur552, longueur553, longueur554, longueur555, longueur556, longueur557, longueur558, longueur559,
//				longueur560, longueur561, longueur562, longueur563, longueur564, longueur565, longueur566, longueur567,
//				longueur568, longueur569, longueur570, longueur571, longueur572, longueur573, longueur574, longueur575,
//				longueur576, longueur577, longueur578, longueur579, longueur580, longueur581, longueur582, longueur583,
//				longueur584, longueur585, longueur586, longueur587, longueur588, longueur589, longueur590, longueur591,
//				longueur592, longueur593, longueur594, longueur595, longueur596, longueur597, longueur598, longueur599,
//				longueur600, longueur601, longueur602, longueur603, longueur604, longueur605, longueur606, longueur607,
//				longueur608, longueur609, longueur610, longueur611, longueur612, longueur613, longueur614, longueur615,
//				longueur616, longueur617, longueur618, longueur619, longueur620, longueur621, longueur622, longueur623,
//				longueur624, longueur625, longueur626, longueur627, longueur628, longueur629, longueur630, longueur631,
//				longueur632, longueur633, longueur634, longueur635, longueur636, longueur637, longueur638, longueur639,
//				longueur640, longueur641, longueur642, longueur643, longueur644, longueur645, longueur646, longueur647,
//				longueur648, longueur649, longueur650, longueur651, longueur652, longueur653, longueur654, longueur655,
//				longueur656, longueur657, longueur658, longueur659, longueur660, longueur661, longueur662, longueur663,
//				longueur664, longueur665, longueur666, longueur667, longueur668, longueur669, longueur670, longueur671,
//				longueur672, longueur673, longueur674, longueur675, longueur676, longueur677, longueur678, longueur679,
//				longueur680, longueur681, longueur682, longueur683, longueur684, longueur685, longueur686, longueur687,
//				longueur688, longueur689, longueur690, longueur691, longueur692, longueur693, longueur694, longueur695,
//				longueur696, longueur697, longueur698, longueur699, longueur700, longueur701, longueur702, longueur703,
//				longueur704, longueur705, longueur706, longueur707, longueur708, longueur709, longueur710, longueur711,
//				longueur712, longueur713, longueur714, longueur715, longueur716, longueur717, longueur718, longueur719,
//				longueur720, longueur721, longueur722, longueur722, longueur723, longueur724, longueur725, longueur726,
//				longueur727, longueur728, longueur729, longueur730, longueur731, longueur732, longueur733, longueur734,
//				longueur735, longueur736, longueur737, longueur738, longueur739, longueur740, longueur741, longueur742,
//				longueur743, longueur744, longueur745, longueur746, longueur747, longueur748, longueur749, longueur750,
//				longueur751, longueur752, longueur753, longueur754, longueur755, longueur756, longueur757, longueur758,
//				longueur759, longueur760, longueur761, longueur762, longueur763, longueur764, longueur765, longueur766,
//				longueur767, longueur768, longueur769, longueur770, longueur771, longueur772, longueur773, longueur774,
//				longueur775, longueur776, longueur777, longueur778, longueur779, longueur780, longueur781, longueur782,
//				longueur783, longueur784, longueur785, longueur786, longueur787, longueur788, longueur789, longueur790,
//				longueur791, longueur792, longueur793, longueur794, longueur795, longueur796, longueur797, longueur798,
//				longueur799, longueur800, longueur801, longueur802, longueur803, longueur804, longueur805, longueur806,
//				longueur807, longueur808, longueur809, longueur810, longueur811, longueur812, longueur813, longueur814,
//				longueur815, longueur816, longueur817, longueur818, longueur819, longueur820, longueur821, longueur822,
//				longueur823, longueur824, longueur825, longueur826, longueur827, longueur828, longueur829, longueur830,
//				longueur831, longueur832, longueur833, longueur834, longueur835, longueur836, longueur837, longueur838,
//				longueur839, longueur840, longueur841, longueur842, longueur843, longueur844, longueur845, longueur846,
//				longueur847, longueur848, longueur849, longueur850, longueur851, longueur852, longueur853, longueur854,
//				longueur855, longueur856, longueur857, longueur858, longueur859, longueur860, longueur861, longueur862,
//				longueur863, longueur864, longueur865, longueur866, longueur867, longueur868, longueur869, longueur87,
//				longueur870, longueur871, longueur872, longueur873, longueur874, longueur875, longueur876, longueur877,
//				longueur878, longueur879, longueur880, longueur881, longueur882, longueur883, longueur884, longueur885,
//				longueur886, longueur887, longueur888, longueur889, longueur890, longueur891, longueur892, longueur893,
//				longueur894, longueur895, longueur896, longueur897, longueur898, longueur899, longueur900);
//		longueurRepository.saveAll(listeLongueurs);
//
//	}
//}
