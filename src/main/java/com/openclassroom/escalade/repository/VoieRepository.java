package com.openclassroom.escalade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.CotationBloc;
import com.openclassroom.escalade.domain.CotationFalaise;
import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.domain.Voie;

@Repository("voieRepository")
public interface VoieRepository extends JpaRepository<Voie, Long> {

	/*
	 * Ces deux méthodes sont utilisés pour les critères de recherche après avoir
	 * sélectionné une cotation spécifique
	 */

	List<Voie> findByCotationBloc(CotationBloc cotation);

	List<Voie> findByCotationFalaise(CotationFalaise cotation);

	/* Cette méthode va permettre de compter le nombre de voie d'un site */
	long countBySite(Site site);

	/* Cette méthode va permettre de supprimer une voie */
	@Override
	void deleteById(Long id);

}
