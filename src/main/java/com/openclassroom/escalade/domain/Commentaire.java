package com.openclassroom.escalade.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="testdb.commentaire")
public class Commentaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="utilisateur_connecte_id", nullable = false)
	private UtilisateurConnecte utilisateurConnecte;
	
	@ManyToOne
	@JoinColumn(name="site_id", nullable = false)
	private Site site;
	
	public Commentaire() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UtilisateurConnecte getUtilisateurConnecte() {
		return utilisateurConnecte;
	}

	public void setUtilisateurConnecte(UtilisateurConnecte utilisateurConnecte) {
		this.utilisateurConnecte = utilisateurConnecte;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
	

}
