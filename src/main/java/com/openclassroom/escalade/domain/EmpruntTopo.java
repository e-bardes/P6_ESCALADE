// pas encore utilisé

package com.openclassroom.escalade.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "testdb.emprunt_topo")
public class EmpruntTopo {

	@EmbeddedId
	EmpruntTopoKey id;

	@ManyToOne
	@MapsId("topo_id")
	@JoinColumn(name = "topo_id")
	Topo topo;

	@ManyToOne
	@MapsId("utilisateur_id")
	@JoinColumn(name = "utilisateur_id")
	Utilisateur utilisateur;

	public EmpruntTopo() {

	}

	public EmpruntTopo(Topo topo, Utilisateur utilisateur) {
		this.topo = topo;
		this.utilisateur = utilisateur;
	}

	public EmpruntTopoKey getId() {
		return id;
	}

	public void setId(EmpruntTopoKey id) {
		this.id = id;
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

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
