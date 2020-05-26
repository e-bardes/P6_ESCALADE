package com.openclassroom.escalade.service;

import com.openclassroom.escalade.domain.Utilisateur;

public interface UtilisateurService {
	
	Utilisateur isConnectionValid(String email, String password) throws Exception;
	
	void isRegisterEmailValid(String email) throws Exception;
	
	void isRegisterPasswordValid(String motDePasse, String confirmation) throws Exception;
	
	Utilisateur addUser
	(String password, String nom, String prenom, String adresseMail, 
			String adressePostal, String membreAssociation, boolean isSaved);
	
	Utilisateur searchUser(String email);
}
