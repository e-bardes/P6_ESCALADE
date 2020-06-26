package com.openclassroom.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.Secteur;
import com.openclassroom.escalade.domain.Site;

@Repository("secteurRepository")
public interface SecteurRepository extends JpaRepository<Secteur, Long> {

	/* Cette méthode permet de compter le nombre de secteurs d'un site */
	long countBySite(Site site);

	/* Cette méthode permet de mettre à jour la description d'un secteur */
	@Modifying
	@Query("UPDATE Secteur s SET s.description = ?2 WHERE s.id = ?1")
	void updateDescription(Long id, String description);

	/* Cette méthode permet de mettre à jour le nom d'un secteur */
	@Modifying
	@Query("UPDATE Secteur s SET s.nom = ?2 WHERE s.id = ?1")
	void updateNom(Long id, String nom);
}
