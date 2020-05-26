package com.openclassroom.escalade.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="testdb.site")
public class Site {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nom;
	@Column(name="is_officiel_les_amis_de_lescalade")
	private boolean isOfficielLesAmisDeLescalade;

	@ManyToOne
	@JoinColumn(name="topo_id", nullable = false)
	private Topo topo;
	
	@OneToMany(targetEntity=Secteur.class, mappedBy="site")
	public List<Secteur> listeSecteurs = new ArrayList<Secteur>();
	
	@OneToMany(targetEntity=Commentaire.class, mappedBy="site")
	public List<Commentaire> listeCommentaires = new ArrayList<Commentaire>();
	
	@OneToMany(targetEntity=Voie.class, mappedBy="site")
	public List<Voie> listeVoies = new ArrayList<Voie>();
	
	public Site() {
	}

	public Site(String nom) {
		this.setNom(nom);
	}
	
	public Site(String nom, Boolean isOfficielLesAmisDeLescalade) {
		this.setNom(nom);
		this.setOfficielLesAmisDeLescalade(isOfficielLesAmisDeLescalade);
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
	
	public boolean getIsOfficielLesAmisDeLescalade() {
		return isOfficielLesAmisDeLescalade;
	}

	// n'est pas détecté comme un get par les JSP EL -> javax.el.PropertyNotFoundException
	public boolean isOfficielLesAmisDeLescalade() {
		return isOfficielLesAmisDeLescalade;
	}

	public void setOfficielLesAmisDeLescalade(boolean isOfficielLesAmisDeLescalade) {
		this.isOfficielLesAmisDeLescalade = isOfficielLesAmisDeLescalade;
	}

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
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
}
