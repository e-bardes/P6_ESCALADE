package com.openclassroom.escalade.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "testdb.site")
public class Site {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(value = EnumType.STRING)
	private Departement departement;
	@Column(unique = true)
	private String nom;
	@Column(length = 1000)
	private String description;
	@Column(name = "is_officiel_les_amis_de_lescalade")
	private boolean isOfficielLesAmisDeLescalade;
//	@Column(name = "image_data")
//	private byte[] imageData;
//	@Column(name = "image_file_name")
//	String imageFileName;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(targetEntity = Secteur.class, mappedBy = "site")
	public List<Secteur> listeSecteurs = new ArrayList<Secteur>();

	@OneToMany(targetEntity = Commentaire.class, mappedBy = "site")
	public List<Commentaire> listeCommentaires = new ArrayList<Commentaire>();

	@OneToMany(targetEntity = Voie.class, mappedBy = "site", fetch = FetchType.EAGER)
	public List<Voie> listeVoies = new ArrayList<Voie>();

	public Site() {
	}

	public Site(String nom, Departement departement, Boolean isOfficielLesAmisDeLescalade, String description) {
		this.setNom(nom);
		this.setDepartement(departement);
		this.setOfficielLesAmisDeLescalade(isOfficielLesAmisDeLescalade);
		this.setDescription(description);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean getIsOfficielLesAmisDeLescalade() {
		return isOfficielLesAmisDeLescalade;
	}

	// n'est pas détecté comme un get par les JSP EL ->
	// javax.el.PropertyNotFoundException
	public boolean isOfficielLesAmisDeLescalade() {
		return isOfficielLesAmisDeLescalade;
	}

	public void setOfficielLesAmisDeLescalade(boolean isOfficielLesAmisDeLescalade) {
		this.isOfficielLesAmisDeLescalade = isOfficielLesAmisDeLescalade;
	}

	public List<Secteur> getListeSecteurs() {
		return listeSecteurs;
	}

	public void setListeSecteurs(List<Secteur> listeSecteurs) {
		this.listeSecteurs = listeSecteurs;
	}

	public List<Commentaire> getListeCommentaires() {
		return listeCommentaires;
	}

	public void setListeCommentaires(List<Commentaire> listeCommentaires) {
		this.listeCommentaires = listeCommentaires;
	}

	public List<Voie> getListeVoies() {
		return listeVoies;
	}

	public void setListeVoies(List<Voie> listeVoies) {
		this.listeVoies = listeVoies;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

//	public byte[] getImageData() {
//		return imageData;
//	}
//
//	public void setImageData(byte[] imageData) {
//		this.imageData = imageData;
//	}
//
//	public String getImageFileName() {
//		return imageFileName;
//	}
//
//	public void setImageFileName(String imageFileName) {
//		this.imageFileName = imageFileName;
//	}

}
