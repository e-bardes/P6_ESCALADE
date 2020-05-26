package com.openclassroom.escalade.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.domain.UtilisateurConnecte;
import com.openclassroom.escalade.repository.UtilisateurConnecteRepository;

@Service("utilisateurConnecteService")
public class UtilisateurConnecteServiceImpl implements UtilisateurConnecteService{

	private UtilisateurConnecteRepository repository;
	
	public UtilisateurConnecteServiceImpl() {
		
	}
	
	@Override
	public <S extends UtilisateurConnecte> S save(S entity) {
		return repository.save(entity);
	}

	
	public UtilisateurConnecteRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(UtilisateurConnecteRepository repository) {
		System.out.println("validation1");
		this.repository = repository;
	}

	@Override
	public List<UtilisateurConnecte> findByAdresseMailOrAdressePostal(String adresseMail, String adressePostal) {
		return repository.findByAdresseMailOrAdressePostal(adresseMail, adressePostal);
	}

	@Override
	public UtilisateurConnecte findByAdresseMail(String adresseMail) {
		return repository.findByAdresseMail(adresseMail);
	}
	
	@Override
	public UtilisateurConnecte findByAdresseMailAndPassword(String email, String password) {
		return repository.findByAdresseMailAndPassword(email, password);
	}

	@Override
	public Optional<UtilisateurConnecte> findById(Long id) {
		return repository.findById(id);
	}
	
	public void verificationInscriptionMotsDePasse(String motDePasse, String confirmation) throws Exception{
		
		if(!motDePasse.contentEquals(confirmation)) {
			throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
		}
		else if (motDePasse.trim().length() < 8) {
			throw new Exception("Les mots de passe doivent contenir au moins 8 caractères.");
		}
	}
	
	public void verificationInscriptionAdresseMail(String email) throws Exception{
		if (!(findByAdresseMail(email) == null)){
			throw new Exception("Cette adresse mail est déjà utilisée");
		}
	}
	
	public static final String CHAMP_PASS = "password";
	public static final String CHAMP_CONF = "confirmation";
	public static final String CHAMP_NOM = "nom";
	public static final String CHAMP_PRENOM = "prenom";
	public static final String CHAMP_MAIL = "adressemail";
	public static final String CHAMP_POSTAL = "adressepostal";
	
	
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	private String erreurConnexion;
	
	public void setErreurConnexion(String erreurConnexion) {
		this.erreurConnexion = erreurConnexion;
	}
	
	public String getErreurConnexion() {
		return erreurConnexion;
	}
	
	public String getResultat() {
	    return resultat;
	}

	public Map<String, String> getErreurs() {
	    return erreurs;
	}
	
	private void setErreur( String champ, String message ) {
	    erreurs.put(champ, message);
	}
	
	public UtilisateurConnecte inscriptionUtilisateur(HttpServletRequest request) {
		String password = request.getParameter(CHAMP_PASS);
		String confirmation = request.getParameter(CHAMP_CONF);
		String nom = request.getParameter(CHAMP_NOM);
		String prenom = request.getParameter(CHAMP_PRENOM);
		String adresseMail = request.getParameter(CHAMP_MAIL);
		String adressePostal = request.getParameter(CHAMP_POSTAL);
		
		UtilisateurConnecte utilisateurConnecte = new UtilisateurConnecte(
				password, nom, prenom, adresseMail, adressePostal);
		
		try {
			verificationInscriptionMotsDePasse(password, confirmation);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
			setErreur(CHAMP_CONF, null);
		}
		
		try {
			verificationInscriptionAdresseMail(adresseMail);
		} catch (Exception e) {
			setErreur(CHAMP_MAIL, e.getMessage());
		}
		
		if (erreurs.isEmpty()) {
			save(utilisateurConnecte);
			resultat = "Succès de l'inscription.";
		} else {
			resultat = "Echec de l'inscription.";
		}
		
		return utilisateurConnecte;
	}
	
	
	public UtilisateurConnecte connexionUtilisateur(HttpServletRequest request) {
		
		String adresseMail = request.getParameter(CHAMP_MAIL);
		String password = request.getParameter(CHAMP_PASS);
		
		UtilisateurConnecte utilisateur = new UtilisateurConnecte(adresseMail, password);
		
		try {
			if(findByAdresseMailAndPassword(adresseMail, password) == null) {
				throw new Exception("Identifiants incorrects");
			}
		} catch(Exception e) {
			setErreurConnexion(e.getMessage());
		}
		
		if (erreurConnexion == null) {
			resultat = "Succès de la connexion.";
		} else {
			resultat = "Echec de la connexion.";
		}
		
		return utilisateur;	
	}
}
