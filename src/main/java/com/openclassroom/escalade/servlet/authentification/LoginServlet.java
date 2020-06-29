package com.openclassroom.escalade.servlet.authentification;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.service.UtilisateurService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	public static final String USER = "utilisateur";
	public static final String ERR = "erreurConnexion";
	public static final String RESULT = "resultat";
	public static final String SESSION_USER = "sessionUtilisateur";
	public static final String VUE_FORM = "/WEB-INF/login.jsp";
	public static final String VUE_SUCCESS = "/accueil";

	public static final String CHAMP_MAIL = "adressemail";
	public static final String CHAMP_PASS = "password";

	private UtilisateurService utilisateurService;

	@Autowired
	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String resultat;
		String erreurConnexion = null;
		Utilisateur utilisateur = null;

		String adresseMail = request.getParameter(CHAMP_MAIL);
		String password = request.getParameter(CHAMP_PASS);

		// si les identifiants sont invalides on stocke un message dans
		// "erreurConnexion"
		try {
			utilisateur = utilisateurService.isConnectionValid(adresseMail, password);
			resultat = "Succès de la connexion.";
		} catch (Exception e) {
			resultat = "Echec de la connexion.";
			erreurConnexion = e.getMessage();
		}

		HttpSession session = request.getSession();

		// si tout est valide on peut stocker un l'utilisateur en session
		if (erreurConnexion == null) {
			session.setAttribute(SESSION_USER, utilisateur);

			response.sendRedirect(request.getContextPath() + VUE_SUCCESS);
		} else {
			session.setAttribute(SESSION_USER, null);

			request.setAttribute(RESULT, resultat);
			request.setAttribute(ERR, erreurConnexion);
			request.setAttribute(USER, utilisateur);

			request.getRequestDispatcher(VUE_FORM).forward(request, response);
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(VUE_FORM).forward(request, response);
	}
}
