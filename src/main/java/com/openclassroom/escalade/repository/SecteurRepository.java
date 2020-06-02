// pas encore utilisé

package com.openclassroom.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.Secteur;
import com.openclassroom.escalade.domain.Site;

@Repository("secteurRepository")
public interface SecteurRepository extends JpaRepository<Secteur, Long> {
	
	long countBySite(Site site);
}
