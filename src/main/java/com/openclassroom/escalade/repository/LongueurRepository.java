// pas encore utilisé

package com.openclassroom.escalade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.CotationBloc;
import com.openclassroom.escalade.domain.CotationFalaise;
import com.openclassroom.escalade.domain.Longueur;

@Repository("longueurRepository")
public interface LongueurRepository extends JpaRepository<Longueur, Long> {

	/*
	 * Ces deux méthodes sont utilisés pour les critères de recherche après avoir
	 * sélectionné une cotation spécifique
	 */
	List<Longueur> findByCotationBloc(CotationBloc cotation);

	List<Longueur> findByCotationFalaise(CotationFalaise cotation);
}
