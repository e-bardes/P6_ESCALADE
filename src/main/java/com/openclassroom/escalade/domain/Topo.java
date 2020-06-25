// pas encore utilisé

package com.openclassroom.escalade.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "testdb.topo")
public class Topo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;
	@Column(length = 1000)
	private String description;
	private String lieu;
	@Column(name = "date_de_parution")
	private LocalDate dateDeParution;

	@Column(name = "is_disponible") // pas utile ça faudra juste vérifier que le topo n'est lié à aucun utilisateur
									// je pense
									// même si l'état est indiqué dans l'énoncé
	private boolean isDisponible;

	@OneToMany(mappedBy = "topo", fetch = FetchType.EAGER)
	private List<EmpruntTopo> listeEmpruntsTopo = new ArrayList<EmpruntTopo>();

	public Topo() {
	}

	public Topo(String nom, String lieu, LocalDate dateDeParution, boolean isDisponible, String description) {
		this.nom = nom;
		this.lieu = lieu;
		this.dateDeParution = dateDeParution;
		this.isDisponible = isDisponible;
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

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public boolean isDisponible() {
		return isDisponible;
	}

	public boolean getIsDisponible() {
		return isDisponible;
	}

	public void setDisponible(boolean isDisponible) {
		this.isDisponible = isDisponible;
	}

	public List<EmpruntTopo> getListeEmpruntsTopo() {
		return listeEmpruntsTopo;
	}

	public void setListeEmpruntsTopo(List<EmpruntTopo> listeEmpruntsTopo) {
		this.listeEmpruntsTopo = listeEmpruntsTopo;
	}

	public LocalDate getDateDeParution() {
		return dateDeParution;
	}

	public void setDateDeParution(LocalDate dateDeParution) {
		this.dateDeParution = dateDeParution;
	}

}
