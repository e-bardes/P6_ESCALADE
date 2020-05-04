package com.openclassroom.escalade.service;

import java.util.Optional;

import com.openclassroom.escalade.domain.Secteur;

public interface SecteurService {

	Optional<Secteur> findById(Long id);
}

