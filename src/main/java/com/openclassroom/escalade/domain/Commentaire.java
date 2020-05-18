package com.openclassroom.escalade.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="testdb.commentaire")
public class Commentaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(length=1000)
	private String contenu;
	
	@ManyToOne
	@JoinColumn(name="utilisateur_connecte_id", nullable = false)
	private UtilisateurConnecte utilisateurConnecte;
	
	@ManyToOne
	@JoinColumn(name="site_id", nullable = false)
	private Site site;
	
	public Commentaire() {
		
	}
	
	public Commentaire(UtilisateurConnecte utilisateurConnecte, Site site, String contenu) {
		this.utilisateurConnecte = utilisateurConnecte;
		this.site = site;
		this.contenu = contenu;
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

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}
