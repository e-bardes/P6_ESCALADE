package com.openclassroom.escalade.servlet.authentification;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.UtilisateurService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "RegisterServlet", urlPatterns = { "/register" })
public class RegisterServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String USER = "utilisateur";
	public static final String ERR = "erreurs";
	public static final String RESULT = "resultat";
	public static final String VUE_SUCCESS = "/registersuccess";
	public static final String VUE_FORM = "/WEB-INF/register.jsp";
	
	public static final String CHAMP_PASS = "password";
	public static final String CHAMP_CONF = "confirmation";
	public static final String CHAMP_NOM = "nom";
	public static final String CHAMP_PRENOM = "prenom";
	public static final String CHAMP_MAIL = "adressemail";
	public static final String CHAMP_POSTAL = "adressepostal";
	
	private UtilisateurService utilisateurService;
	
	@Autowired
	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
	
	// à partir de register.jsp
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
	
		// pour stocker les différentes erreurs à afficher sous certains champs du formulaire
		Map<String, String> erreurs = new HashMap<String, String>();
		
		String password = request.getParameter(CHAMP_PASS);
		String confirmation = request.getParameter(CHAMP_CONF);
		String nom = request.getParameter(CHAMP_NOM);
		String prenom = request.getParameter(CHAMP_PRENOM);
		String adresseMail = request.getParameter(CHAMP_MAIL);
		String adressePostal = request.getParameter(CHAMP_POSTAL);
		// normalement il ne faudrait pas pouvoir renseigner ça dans le formulaire d'inscription
		String membreAssociation = request.getParameter("membreAssociation");
		
		// des erreurs peuvent être stockées au niveau du mot de passe et de l'email
		try {
			utilisateurService.isRegisterPasswordValid(password, confirmation);
		} catch (Exception e) {
			erreurs.put(CHAMP_PASS, e.getMessage());
			erreurs.put(CHAMP_CONF, null);
		}
		
		try {
			utilisateurService.isRegisterEmailValid(adresseMail);
		} catch (Exception e) {
			erreurs.put(CHAMP_MAIL, e.getMessage());
		}
		
		request.setAttribute(ERR, erreurs);
		
		// si c'est un succès on enregistre l'utilisateur en base de donnée et on redirige vers une page
		// qui va afficher un récapitulatif de l'inscription
		// en cas d'échec on stocke les informations remplis en mémoire pour pouvoir afficher les erreurs et
		// re-remplir les champs automatiquement au rechargement du formulaire
		if (erreurs.isEmpty()) {
			utilisateurService.saveUserInData(password, nom, prenom, adresseMail, 
								adressePostal, membreAssociation);
			response.sendRedirect(request.getContextPath() + VUE_SUCCESS + "?nom=" + nom + "&prenom="
					+ prenom + "&adressePostal=" + adressePostal + "&adresseMail=" + adresseMail);
		} else {
			request.setAttribute(RESULT, "Echec de l'inscription.");
			request.setAttribute(USER, 
					utilisateurService.saveUserInMemory(password, nom, prenom, adresseMail, 
							adressePostal, membreAssociation));
			request.getRequestDispatcher(VUE_FORM).forward(request, response);
		}
;
		
	}
	
	// à partir de n'importe quelle page du moment qu'on est pas connecté
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher(VUE_FORM).forward(request, response);
	}
	
}
