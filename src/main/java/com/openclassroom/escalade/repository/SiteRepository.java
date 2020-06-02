package com.openclassroom.escalade.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.domain.Voie;


@Repository("siteRepository")
public interface SiteRepository extends JpaRepository<Site, Long> { 

	@Override
	Optional<Site> findById(Long id);
	
//	@Override List<Site> findAll();
	
	@Modifying
	@Query("UPDATE Site s SET s.isOfficielLesAmisDeLescalade = ?2 WHERE s.id = ?1")
	void updateOfficialisation(Long id, boolean isOfficielLesAmisDeLescalade);
	
	
	// on choisi un ordre sinon ils seront affichés dans l'ordre de modification d'un de leur attribut
	List<Site> findByOrderByIdAsc();
	
	List<Site> findByDepartement(String departement);
	
	@Query("SELECT s FROM Site s WHERE s.listeSecteurs.getListeVoies() IN ?1 OR s.listeVoies IN ?1")
	List<Site> findByVoieIn(List<Voie> listeVoies);
	
	
	
	
	
}
