package com.openclassroom.escalade.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "testdb.voie_bloc")
@PrimaryKeyJoinColumn( name = "voie_id" )
public class VoieBloc extends Voie {

	@Enumerated(value = EnumType.STRING)
	@Column(name="cotation_bloc")
	private CotationBloc cotationBloc;

	public CotationBloc getCotationBloc() {
		return cotationBloc;
	}

	public void setCotationBloc(CotationBloc cotationBloc) {
		this.cotationBloc = cotationBloc;
	}
	
	
	
}
