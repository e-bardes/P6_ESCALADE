// pas encore utilisé
// on peut aussi rendre la classe concrète et supprimer les deux classes qui héritnet de celle-ci
// il y aurait donc les 2 énumérations liés à cette classe


package com.openclassroom.escalade.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="testdb.voie")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Voie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name ="is_equipe")
	private boolean isEquipe;
	
	@ManyToOne
	@JoinColumn(name="secteur_id", nullable = true)
	private Secteur secteur;
	
	@ManyToOne
	@JoinColumn(name="site_id", nullable = true)
	private Site site;
	
	@OneToMany(targetEntity=Longueur.class, mappedBy="voie")
	public List<Longueur> listeLongueurs = new ArrayList<Longueur>();
	
	public Voie () {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEquipe() {
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
}
