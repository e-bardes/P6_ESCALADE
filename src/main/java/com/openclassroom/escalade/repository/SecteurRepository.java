package com.openclassroom.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.Secteur;

@Transactional(readOnly = true)
@Repository("secteurRepository")
public interface SecteurRepository extends JpaRepository<Secteur, Long> {

	// public Optional<Secteur> findById(Long id);
}
