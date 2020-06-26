package com.openclassroom.escalade.repository;

import java.util.List;

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

	/* Cette méthode permet de modifier l'officialisation d'un site spécifique */
	@Modifying
	@Query("UPDATE Site s SET s.isOfficielLesAmisDeLescalade = ?2 WHERE s.id = ?1")
	void updateOfficialisation(Long id, boolean isOfficielLesAmisDeLescalade);

	/*
	 * On récupère tous les sites dans l'ordre ascendant de leur id; sinon ils
	 * apparaîtront dans l'ordre de modification, du plus ancien au plus récent
	 * (donc un ordre qui évolue souvent)
	 */
	List<Site> findByOrderByIdAsc();

	/*
	 * Cette méthode permet un ou plusieurs sites grâce à son département (critères
	 * de recherches)
	 */
	List<Site> findByDepartement(Departement departement);

	/*
	 * Cette méthode va permettre de récupérer des sites en fonction de voies et de
	 * longueurs. Il y a plusieurs cas à gérer car un site contient ou non des
	 * secteurs. Si c'est le cas les voies sont stockés dans les secteurs et sinon
	 * dans le site. De plus, les longueurs sont contenus dans les voies. Les
	 * longueurs et voies possèdent une cotation ce qui va permettre de faire un
	 * critère de recherche par cotation.
	 */
	@Query("SELECT s FROM Site s WHERE (s IN (SELECT v.site FROM Voie v WHERE v IN ?1) "
			+ "OR s IN (SELECT v.secteur.site FROM Voie v WHERE v IN ?1) "
			+ "OR s IN (SELECT l.voie.site FROM Longueur l WHERE l IN ?2) "
			+ "OR s IN (SELECT l.voie.secteur.site FROM Longueur l WHERE l IN ?2)) AND s IN ?3")
	List<Site> findByVoieOrLongueur(List<Voie> listeVoies, List<Longueur> listeLongueurs, List<Site> listeSites);

	/* Cette méthode va permettre de modifier la description d'un site */
	@Modifying
	@Query("UPDATE Site s SET s.description = ?2 WHERE s.id = ?1")
	void updateDescription(Long id, String description);

	/*
	 * Cette méthode va permettre de récupérer l'id d'un site grâce à l'id d'un de
	 * ses secteurs
	 */
	@Query("SELECT s.id FROM Site s WHERE s IN (SELECT se.site FROM Secteur se WHERE se.id = ?1)")
	long findBySecteurId(Long secteurId);

}
