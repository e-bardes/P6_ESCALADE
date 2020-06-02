package com.openclassroom.escalade.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.Utilisateur;

@Repository("utilisateurRepository")
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	<S extends Utilisateur> S save(S entity);
	
	Utilisateur findByAdresseMail(String adresseMail);
	
	@Override 
	Optional<Utilisateur> findById(Long id);
	
	Utilisateur findByAdresseMailAndPassword(String email, String password);
	
}

