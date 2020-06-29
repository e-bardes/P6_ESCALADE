package com.openclassroom.escalade.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "testdb.voie")
public class Voie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "is_equipe")
	private boolean isEquipe;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "cotation_bloc")
	private CotationBloc cotationBloc;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "cotation_falaise")
	private CotationFalaise cotationFalaise;

	@ManyToOne
	@JoinColumn(name = "secteur_id", nullable = true)
	private Secteur secteur;

	@ManyToOne
	@JoinColumn(name = "site_id", nullable = true)
	private Site site;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(targetEntity = Longueur.class, mappedBy = "voie", cascade = { CascadeType.REMOVE })
	public List<Longueur> listeLongueurs = new ArrayList<Longueur>();

	public Voie() {

	}

	public Voie(boolean isEquipe, CotationBloc cotationBloc) {
		this.isEquipe = isEquipe;
		this.cotationBloc = cotationBloc;
	}

	public Voie(boolean isEquipe, CotationFalaise cotationFalaise) {
		this.isEquipe = isEquipe;
		this.cotationFalaise = cotationFalaise;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean getIsEquipe() {
		return isEquipe;
	}

	public void setEquipe(boolean isEquipe) {
		this.isEquipe = isEquipe;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public List<Longueur> getListeLongueurs() {
		return listeLongueurs;
	}

	public void setListeLongueurs(List<Longueur> listeLongueurs) {
		this.listeLongueurs = listeLongueurs;
	}

	public CotationFalaise getCotationFalaise() {
		return cotationFalaise;
	}

	public void setCotationFalaise(CotationFalaise cotationFalaise) {
		this.cotationFalaise = cotationFalaise;
	}

	public CotationBloc getCotationBloc() {
		return cotationBloc;
	}

	public void setCotationBloc(CotationBloc cotationBloc) {
		this.cotationBloc = cotationBloc;
	}
}
