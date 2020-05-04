package com.openclassroom.escalade.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="testdb.topo")
 public class Topo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	@Lob
	private String description;
	private String lieu;
	@Column(name="date_de_parution")
	private Date dateDeParution;

	@Column(name="is_disponible") // pas utile ça faudra juste vérifier que le topo n'est lié à aucun utilisateur je pense
									// même si l'état est indiqué dans l'énoncé
	private boolean isDisponible; 

	@OneToMany(targetEntity=Site.class, mappedBy="topo")
	public List<Site> listeSites = new ArrayList<Site>();
	
//	@ManyToMany
//	@JoinTable(name="testdb.topo_utilisateur",
//				joinColumns = @JoinColumn(name="id_topo"),
//				inverseJoinColumns = @JoinColumn(name="id_utilisateur_connecte"))
//	private List<UtilisateurConnecte> listeUtilisateurConnectes = new ArrayList<UtilisateurConnecte>();
	
	@OneToMany(mappedBy = "topo")
	private List<ReservationTopo> listeReservationTopos = new ArrayList<ReservationTopo>();
	
//	@OneToOne(mappedBy="topo")
//	private Reservation reservation;
	
	public Topo() {
	}
	
	public Topo(String nom) {
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

	public Date getDateDeParution() {
		return dateDeParution;
	}

	public void setDateDeParution(Date dateDeParution) {
		this.dateDeParution = dateDeParution;
	}

	public boolean isDisponible() {
		return isDisponible;
	}

	public void setDisponible(boolean isDisponible) {
		this.isDisponible = isDisponible;
	}

	public List<Site> getListeSites() {
		return listeSites;
	}

	public void setListeSites(List<Site> listeSites) {
		this.listeSites = listeSites;
	}

	public List<ReservationTopo> getListeReservationTopos() {
		return listeReservationTopos;
	}

	public void setListeReservationTopos(List<ReservationTopo> listeReservationTopos) {
		this.listeReservationTopos = listeReservationTopos;
	}
}

