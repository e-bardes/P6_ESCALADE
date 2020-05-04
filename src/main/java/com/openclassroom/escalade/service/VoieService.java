package com.openclassroom.escalade.service;

import java.util.Optional;

import com.openclassroom.escalade.domain.VoieBloc;

public interface VoieService {
	
	Optional<VoieBloc> findById(Long id);

}
