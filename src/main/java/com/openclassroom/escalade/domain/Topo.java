package com.openclassroom.escalade.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "testdb.topo")
public class Topo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;
	@Column(length = 1000)
	private String description;
	private Departement lieu;
	@Column(name = "date_de_parution")
	private LocalDate dateDeParution;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Utilisateur owner;

	@ManyToOne
	@JoinColumn(name = "possessor_id")
	private Utilisateur possessor;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
	@JoinTable(name = "testdb.topo_booking", joinColumns = @JoinColumn(name = "topo_id"), inverseJoinColumns = @JoinColumn(name = "utilisateur_id"))
	private Set<Utilisateur> applicantList = new HashSet<>();

	public Topo() {
	}

	public Topo(String nom, Departement lieu, LocalDate dateDeParution, String description) {
		this.nom = nom;
		this.lieu = lieu;
		this.dateDeParution = dateDeParution;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Departement getLieu() {
		return lieu;
	}

	public void setLieu(Departement lieu) {
		this.lieu = lieu;
	}

//	public List<EmpruntTopo> getListeEmpruntsTopo() {
//		return listeEmpruntsTopo;
//	}
//
//	public void setListeEmpruntsTopo(List<EmpruntTopo> listeEmpruntsTopo) {
//		this.listeEmpruntsTopo = listeEmpruntsTopo;
//	}

	public LocalDate getDateDeParution() {
		return dateDeParution;
	}

	public void setDateDeParution(LocalDate dateDeParution) {
		this.dateDeParution = dateDeParution;
	}

	public Utilisateur getOwner() {
		return owner;
	}

	public void setOwner(Utilisateur owner) {
		this.owner = owner;
	}

	public Utilisateur getPossessor() {
		return possessor;
	}

	public void setPossessor(Utilisateur possessor) {
		this.possessor = possessor;
	}

	public Set<Utilisateur> getApplicantList() {
		return applicantList;
	}

	public void setApplicantList(Set<Utilisateur> applicantList) {
		this.applicantList = applicantList;
	}

}
