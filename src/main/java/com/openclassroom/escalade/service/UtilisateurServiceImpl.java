package com.openclassroom.escalade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.repository.UtilisateurRepository;

@Service("utilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService {

	private UtilisateurRepository repository;

	public UtilisateurServiceImpl() {

	}

	public UtilisateurRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(UtilisateurRepository repository) {
		this.repository = repository;
	}

	// vérification de la validité du mot de passe lors de l'inscription
	@Override
	public void isRegisterPasswordValid(String motDePasse, String confirmation) throws Exception {

		if (!motDePasse.contentEquals(confirmation)) {
			throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
		} else if (motDePasse.trim().length() < 8) {
			throw new Exception("Les mots de passe doivent contenir au moins 8 caractères.");
		}
	}

	// vérification de la validité de l'email lors de l'inscription
	@Override
	public void isRegisterEmailValid(String email) throws Exception {
		if (!(repository.findByAdresseMail(email) == null)) {
			throw new Exception("Cette adresse mail est déjà utilisée");
		}
	}

	// renvoie un utilisateur qui va pouvoir être stockée en mémoire afficher de
	// nouveau le formulaire
	// d'inscription non valide
	@Override
	public Utilisateur saveUserInMemory(String password, String nom, String prenom, String adresseMail,
			String adressePostal, String membreAssociation) {

		boolean isMembreAssociation = false;
		if (membreAssociation != null)
			isMembreAssociation = true;

		return new Utilisateur(password, nom, prenom, adresseMail, adressePostal, isMembreAssociation);
	}

	// sauvegard l'utilisateur en base de donnée si la l'inscription réussi
	@Override
	public void saveUserInData(String password, String nom, String prenom, String adresseMail, String adressePostal,
			String membreAssociation) {

		boolean isMembreAssociation = false;
		if (membreAssociation != null)
			isMembreAssociation = true;

		repository.save(new Utilisateur(password, nom, prenom, adresseMail, adressePostal, isMembreAssociation));
	}

	// vérifie que les identifiants soient corrects lors de la connexion
	@Override
	public Utilisateur isConnectionValid(String email, String password) throws Exception {

		if (repository.findByAdresseMailAndPassword(email, password) == null) {
			throw new Exception("Identifiants incorrects");
		}

		return repository.findByAdresseMailAndPassword(email, password);
	}

	@Override
	public Utilisateur searchUser(String email) {
		return repository.findByAdresseMail(email);
	}

//	@Override
//	public Utilisateur searchUserById(Long id) {
//		return repository.findById(id).orElse(null);
//	}
}
