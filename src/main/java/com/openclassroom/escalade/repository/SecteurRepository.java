// pas encore utilisé

package com.openclassroom.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.Secteur;
import com.openclassroom.escalade.domain.Site;

@Repository("secteurRepository")
public interface SecteurRepository extends JpaRepository<Secteur, Long> {

	long countBySite(Site site);

	@Modifying
	@Query("UPDATE Secteur s SET s.description = ?2 WHERE s.id = ?1")
	void updateDescription(Long id, String description);
}
