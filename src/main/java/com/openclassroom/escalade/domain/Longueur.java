// pas encore utilisé
// on peut aussi rendre la classe concrète et supprimer les deux classes qui héritnet de celle-ci
// il y aurait donc les 2 énumérations liés à cette classe

package com.openclassroom.escalade.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "testdb.longueur")
public class Longueur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "cotation_bloc")
	private CotationBloc cotationBloc;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "cotation_falaise")
	private CotationFalaise cotationFalaise;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "voie_id")
	private Voie voie;

	public Longueur() {

	}

	public Longueur(CotationBloc cotationBloc) {
		this.cotationBloc = cotationBloc;
	}

	public Longueur(CotationBloc cotationBloc, Voie voie) {
		this.cotationBloc = cotationBloc;
		this.voie = voie;
	}

	public Longueur(CotationFalaise cotationFalaise) {
		this.cotationFalaise = cotationFalaise;
	}

	public Longueur(CotationFalaise cotationFalaise, Voie voie) {
		this.cotationFalaise = cotationFalaise;
		this.voie = voie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Voie getVoie() {
		return voie;
	}

	public void setVoie(Voie voie) {
		this.voie = voie;
	}

	public CotationBloc getCotationBloc() {
		return cotationBloc;
	}

	public void setCotationBloc(CotationBloc cotationbloc) {
		this.cotationBloc = cotationbloc;
	}

	public CotationFalaise getCotationFalaise() {
		return cotationFalaise;
	}

	public void setCotationFalaise(CotationFalaise cotationFalaise) {
		this.cotationFalaise = cotationFalaise;
	}
}
