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
@Table(name = "testdb.utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String password;
	private String nom;
	private String prenom;
	@Column(name = "adresse_mail", unique = true)
	private String adresseMail;
	@Column(name = "adresse_postal")
	private String adressePostal;
	@Column(name = "is_membre_association")
	private boolean isMembreAssociation;

	@OneToMany(targetEntity = Commentaire.class, mappedBy = "utilisateur")
	public List<Commentaire> listeCommentaires = new ArrayList<Commentaire>();

//	@OneToMany(mappedBy = "utilisateur")
//	private List<EmpruntTopo> listeEmpruntsTopo = new ArrayList<EmpruntTopo>();

//	@ManyToMany
//	@JoinTable(name = "testdb.topo_booking", joinColumns = @JoinColumn(name = "utilisateur_id"), inverseJoinColumns = @JoinColumn(name = "topo_id"))
//	private List<Topo> listeToposDemandes = new ArrayList<>();

//	@LazyCollection(LazyCollectionOption.FALSE)
//	@OneToMany
//	@JoinColumn(name = "owner_id")
//	private List<Topo> ownedTopoList = new ArrayList<>();
//
//	@OneToMany
//	@JoinColumn(name = "possesor_id")
//	private List<Topo> possessedTopoList = new ArrayList<>();

	public Utilisateur() {

	}

	public Utilisateur(String adresseMail, String password) {
		this.adresseMail = adresseMail;
		this.password = password;
	}

	public Utilisateur(String password, String nom, String prenom, String adresseMail, String adressePostal,
			boolean isMembreAssociation) {
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.adressePostal = adressePostal;
		this.isMembreAssociation = isMembreAssociation;
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

	public List<Commentaire> getListeCommentaires() {
		return listeCommentaires;
	}

	public void setListeCommentaires(List<Commentaire> listeCommentaires) {
		this.listeCommentaires = listeCommentaires;
	}

	public boolean getIsMembreAssociation() {
		return isMembreAssociation;
	}

	public void setMembreAssociation(boolean isMembreAssociation) {
		this.isMembreAssociation = isMembreAssociation;
	}

//	public List<EmpruntTopo> getListeEmpruntsTopo() {
//		return listeEmpruntsTopo;
//	}
//
//	public void setListeEmpruntsTopo(List<EmpruntTopo> listeEmpruntsTopo) {
//		this.listeEmpruntsTopo = listeEmpruntsTopo;
//	}

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
