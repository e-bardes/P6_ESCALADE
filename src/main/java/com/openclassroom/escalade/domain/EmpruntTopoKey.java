// pas encore utilisé

package com.openclassroom.escalade.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmpruntTopoKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "topo_id")
	Long topoId;

	@Column(name = "utilisateur_id")
	Long utilisateurId;

	@Column(name = "is_Possesseur")
	private boolean isPossesseur;

	@Column(name = "is_possede")
	private boolean isPossede;

	public EmpruntTopoKey() {

	}

	public EmpruntTopoKey(boolean isPossesseur, boolean isPossede, Long topoId, Long utilisateurId) {
		this.isPossesseur = isPossesseur;
		this.isPossede = isPossede;
		this.topoId = topoId;
		this.utilisateurId = utilisateurId;
	}

	public Long getTopoId() {
		return topoId;
	}

	public void setTopoId(Long topoId) {
		this.topoId = topoId;
	}

	public Long getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurConnecteId(Long utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public boolean getIsPossesseur() {
		return isPossesseur;
	}

	public void setPossesseur(boolean isPossesseur) {
		this.isPossesseur = isPossesseur;
	}

	public boolean getIsPossede() {
		return isPossede;
	}

	public void setPossede(boolean isPossede) {
		this.isPossede = isPossede;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((topoId == null) ? 0 : topoId.hashCode());
		result = prime * result + ((utilisateurId == null) ? 0 : utilisateurId.hashCode());
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
		EmpruntTopoKey other = (EmpruntTopoKey) obj;
		if (topoId == null) {
			if (other.topoId != null)
				return false;
		} else if (!topoId.equals(other.topoId))
			return false;
		if (utilisateurId == null) {
			if (other.utilisateurId != null)
				return false;
		} else if (!utilisateurId.equals(other.utilisateurId))
			return false;
		return true;
	}

}
