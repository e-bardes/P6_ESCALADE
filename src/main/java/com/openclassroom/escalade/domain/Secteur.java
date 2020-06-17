// pas encore utilisé

package com.openclassroom.escalade.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "testdb.secteur")
public class Secteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String nom;
	@Column(length = 1000)
	private String description;

	@ManyToOne
	@JoinColumn(name = "site_id", nullable = false)
	private Site site;

	@OneToMany(targetEntity = Voie.class, mappedBy = "secteur", fetch = FetchType.EAGER, cascade = {
			CascadeType.REMOVE })
	public List<Voie> listeVoies = new ArrayList<Voie>();

	public Secteur() {

	}

	public Secteur(String nom) {
		this.nom = nom;
	}

	public Secteur(String nom, String description) {
		this.nom = nom;
		this.description = description;
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

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public List<Voie> getListeVoies() {
		return listeVoies;
	}

	public void setListeVoies(List<Voie> listeVoies) {
		this.listeVoies = listeVoies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
