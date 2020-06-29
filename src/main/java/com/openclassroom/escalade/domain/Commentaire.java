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
@Table(name = "testdb.commentaire")
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 1000)
	private String contenu;

	@ManyToOne
	@JoinColumn(name = "utilisateur_id", nullable = false)
	private Utilisateur utilisateur;

	@ManyToOne
	@JoinColumn(name = "site_id", nullable = false)
	private Site site;

	@ManyToOne
	@JoinColumn(name = "commentaire_parent_id")
	private Commentaire commentaireParent;

	@OneToMany(targetEntity = Commentaire.class, mappedBy = "commentaireParent", cascade = {
			CascadeType.REMOVE }, fetch = FetchType.EAGER)
	private List<Commentaire> listeReponses = new ArrayList<Commentaire>();

	public Commentaire() {

	}

	public Commentaire(Utilisateur utilisateur, Site site, String contenu) {
		this.utilisateur = utilisateur;
		this.site = site;
		this.contenu = contenu;
	}

	public Commentaire(Utilisateur utilisateur, Site site, String contenu, Commentaire commentaireParent) {
		this.utilisateur = utilisateur;
		this.site = site;
		this.contenu = contenu;
		this.commentaireParent = commentaireParent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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

	public Commentaire getCommentaireParent() {
		return commentaireParent;
	}

	public void setCommentaireParent(Commentaire commentaireParent) {
		this.commentaireParent = commentaireParent;
	}

	public List<Commentaire> getListeReponses() {
		return listeReponses;
	}

	public void setListeReponses(List<Commentaire> listeReponses) {
		this.listeReponses = listeReponses;
	}
}
