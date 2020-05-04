package com.openclassroom.escalade.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReservationTopoKey implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "topo_id")
	Long topoId;
	 
	@Column(name = "utilisateur_connecte_id")
	Long utilisateurConnecteId;
	 
	public ReservationTopoKey() {
		
	}

	public Long getTopoId() {
		return topoId;
	}

	public void setTopoId(Long topoId) {
		this.topoId = topoId;
	}

	public Long getUtilisateurConnecteId() {
		return utilisateurConnecteId;
	}

	public void setUtilisateurConnecteId(Long utilisateurConnecteId) {
		this.utilisateurConnecteId = utilisateurConnecteId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((topoId == null) ? 0 : topoId.hashCode());
		result = prime * result + ((utilisateurConnecteId == null) ? 0 : utilisateurConnecteId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationTopoKey other = (ReservationTopoKey) obj;
		if (topoId == null) {
			if (other.topoId != null)
				return false;
		} else if (!topoId.equals(other.topoId))
			return false;
		if (utilisateurConnecteId == null) {
			if (other.utilisateurConnecteId != null)
				return false;
		} else if (!utilisateurConnecteId.equals(other.utilisateurConnecteId))
			return false;
		return true;
	}
	
	 
	

}
