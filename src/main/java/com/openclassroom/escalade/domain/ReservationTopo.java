// pas encore utilisé

package com.openclassroom.escalade.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "testdb.reservation_topo")
public class ReservationTopo {

	@EmbeddedId
	ReservationTopoKey id;
	
	@Column(name = "is_possede")
	private boolean isPossede;
	
	@ManyToOne
	@MapsId("topo_id")
	@JoinColumn(name = "topo_id")
	Topo topo;
	
	@ManyToOne
	@MapsId("utilisateur_id")
	@JoinColumn(name = "utilisateur_id")
	Utilisateur utilisateur;
	
	public ReservationTopo() {
		
	}

	public ReservationTopoKey getId() {
		return id;
	}

	public void setId(ReservationTopoKey id) {
		this.id = id;
	}

	public boolean isPossede() {
		return isPossede;
	}

	public void setPossede(boolean isPossede) {
		this.isPossede = isPossede;
	}

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateurConnecte(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
