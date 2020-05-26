package com.openclassroom.escalade.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="testdb.utilisateur_connecte")
public class UtilisateurConnecte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String password;
	private String nom;
	private String prenom;
	@Column(name = "adresse_mail", unique = true)
	private String adresseMail;
	@Column(name = "adresse_postal", unique = true)
	private String adressePostal;
	@Column(name = "is_membre_association")
	private boolean isMembreAssociation;
	
//	@ManyToMany
//	@JoinTable(name="testdb.topo_utilisateur",
//				joinColumns = @JoinColumn(name="id_utilisateur_connecte"),
//				inverseJoinColumns = @JoinColumn(name="id_topo"))
//	private List<Topo> listeTopos = new ArrayList<Topo>();
	
	@OneToMany(targetEntity=Commentaire.class, mappedBy="utilisateurConnecte")
	public List<Commentaire> listeCommentaires = new ArrayList<Commentaire>();
	
	@OneToMany(mappedBy = "utilisateurConnecte")
	private List<ReservationTopo> listeReservationTopos = new ArrayList<ReservationTopo>();

//	@OneToOne(mappedBy="utilisateurConnecte")
//	private Reservation reservation;
	
	public UtilisateurConnecte() {
		
	}
	
	public UtilisateurConnecte(String adresseMail, String password) {
		this.adresseMail = adresseMail;
		this.password = password;
	}
	
	public UtilisateurConnecte(String password, String nom, String prenom, String adresseMail, String adressePostal) {
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.adressePostal = adressePostal;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getIdUtilisateurConnecte() {
		return id;
	}
	public void setIdUtilisateurConnecte(Long idUtilisateurConnecte) {
		this.id = idUtilisateurConnecte;
	}
	
//	public List<Topo> getListeTopos() {
//		return listeTopos;
//	}
//	public void setListeTopos(List<Topo> listeTopos) {
//		this.listeTopos = listeTopos;
//	}
	
	public List<Commentaire> getListeCommentaires() {
		return listeCommentaires;
	}

	public void setListeCommentaires(List<Commentaire> listeCommentaires) {
		this.listeCommentaires = listeCommentaires;
	}

//	public Reservation getReservation() {
//		return reservation;
//	}
//
//	public void setReservation(Reservation reservation) {
//		this.reservation = reservation;
//	}

	public boolean isMembreAssociation() {
		return isMembreAssociation;
	}

	public void setMembreAssociation(boolean isMembreAssociation) {
		this.isMembreAssociation = isMembreAssociation;
	}

	public List<ReservationTopo> getListeReservationTopos() {
		return listeReservationTopos;
	}

	public void setListeReservationTopos(List<ReservationTopo> listeReservationTopos) {
		this.listeReservationTopos = listeReservationTopos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getAdressePostal() {
		return adressePostal;
	}

	public void setAdressePostal(String adressePostal) {
		this.adressePostal = adressePostal;
	}
}
