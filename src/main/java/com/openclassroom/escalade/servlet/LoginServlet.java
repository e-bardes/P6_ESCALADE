package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.service.UtilisateurService;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String USER = "utilisateur";
	public static final String ERR = "erreurConnexion";
	public static final String RESULT = "resultat";
	public static final String SESSION_USER = "sessionUtilisateur";
	public static final String VUE_FORM = "/WEB-INF/login.jsp";
	public static final String VUE_SUCCESS = "/";
	
	public static final String CHAMP_MAIL = "adressemail";
	public static final String CHAMP_PASS = "password";
	public static final String CHAMP_MEMOIRE = "memoire";
	
	private UtilisateurService utilisateurService;
	
	@Autowired
	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		String resultat;
		String erreurConnexion = null;
		Utilisateur utilisateur = null;
		
		String adresseMail = request.getParameter(CHAMP_MAIL);
		String password = request.getParameter(CHAMP_PASS);
		String memoire = request.getParameter(CHAMP_MEMOIRE);
		
		// si les identifiants sont invalides on stocke un message dans "erreurConnexion"
		try {
			utilisateur = utilisateurService.isConnectionValid(adresseMail, password);
			resultat = "Succès de la connexion.";
		} catch (Exception e) {
			resultat = "Echec de la connexion.";
			erreurConnexion = e.getMessage();
		}
		
		HttpSession session = request.getSession();
		
		// si on tout est valide on peut stocker un l'utilisateur en session
		if (erreurConnexion == null) {
			session.setAttribute(SESSION_USER, utilisateur);
			// si la case "se souvenir de moi" a été coché alors on va créer un cookie qui va être en vie pendant
			// un mois et qui permettra de trouver un utilisateur par son email
			if (memoire != null) {
	        	Cookie cookie = new Cookie("email", adresseMail);
	            cookie.setMaxAge(60 * 60 * 24 * 30);
	            response.addCookie(cookie);
	        }
			response.sendRedirect(request.getContextPath() +  VUE_SUCCESS);
		} else {
			session.setAttribute(SESSION_USER, null);
			
			request.setAttribute(RESULT, resultat);
			request.setAttribute(ERR, erreurConnexion);
			request.setAttribute(USER, utilisateur);
			
			request.getRequestDispatcher(VUE_FORM).forward(request, response);
		}
        
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher(VUE_FORM).forward(request, response);
	}
}
