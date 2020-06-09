package com.openclassroom.escalade.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.Departement;
import com.openclassroom.escalade.domain.Longueur;
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

	// on choisi un ordre sinon ils seront affichés dans l'ordre de modification
	// d'un de leur attribut
	List<Site> findByOrderByIdAsc();

	List<Site> findByDepartement(Departement departement);

	@Query("SELECT s FROM Site s WHERE (s IN (SELECT v.site FROM Voie v WHERE v IN ?1) "
			+ "OR s IN (SELECT v.secteur.site FROM Voie v WHERE v IN ?1) "
			+ "OR s IN (SELECT l.voie.site FROM Longueur l WHERE l IN ?2) "
			+ "OR s IN (SELECT l.voie.secteur.site FROM Longueur l WHERE l IN ?2))" + "AND s IN ?3")
	List<Site> findByVoieOrLongueur(List<Voie> listeVoies, List<Longueur> listeLongueurs, List<Site> listeSites);

	@Modifying
	@Query("UPDATE Site s SET s.description = ?2 WHERE s.id = ?1")
	void updateDescription(Long id, String description);

	@Query("SELECT s.id FROM Site s WHERE s IN (SELECT se.site FROM Secteur se WHERE se.id = ?1)")
	long findBySecteurId(Long secteurId);

}
