package com.openclassroom.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.Utilisateur;

@Repository("utilisateurRepository")
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	/*
	 * Ces méthodes vont permettre de récupérer un utilisateur l'une grâce à son
	 * adresseMail et la 2ème avec le mot de passe en plus
	 */

	Utilisateur findByAdresseMail(String adresseMail);

	Utilisateur findByAdresseMailAndPassword(String email, String password);

}
