package com.openclassroom.escalade.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="testdb.secteur")
public class Secteur {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="site_id", nullable = false)
	private Site site;
	
	@OneToMany(targetEntity=Voie.class, mappedBy="secteur")
	public List<Voie> listeVoies = new ArrayList<Voie>();

	public Secteur() {
		
	}
	
	public Secteur(String nom) {
		this.nom = nom;
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
	
	
}
