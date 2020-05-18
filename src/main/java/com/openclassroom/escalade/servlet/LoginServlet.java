package com.openclassroom.escalade.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.UtilisateurConnecte;
import com.openclassroom.escalade.service.UtilisateurConnecteService;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" }) // si ça devient l'entrée du site faut mettre rien et pas login
public class LoginServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String USER = "utilisateur";
	public static final String FORM = "form";
	public static final String SESSION_USER = "sessionUtilisateur";
	public static final String VUE = "/WEB-INF/login.jsp";
	
	private UtilisateurConnecteService utilisateurConnecteService;
	
	@Autowired
	public void setUtilisateurConnecteService(UtilisateurConnecteService utilisateurConnecteService) {
		this.utilisateurConnecteService = utilisateurConnecteService;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		UtilisateurConnecte utilisateur = utilisateurConnecteService.connexionUtilisateur(request);
		
		HttpSession session = request.getSession();
		
		if(utilisateurConnecteService.getErreurConnexion() == null) {
			session.setAttribute(SESSION_USER, utilisateur);
		} else {
			session.setAttribute(SESSION_USER, null);
		}
		
		request.setAttribute(FORM, utilisateurConnecteService);
		request.setAttribute(USER, utilisateur);
		
		request.getRequestDispatcher(VUE).forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher(VUE).forward(request, response);
	}
}
