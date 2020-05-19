package com.openclassroom.escalade.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.UtilisateurConnecte;
import com.openclassroom.escalade.service.UtilisateurConnecteService;

@WebServlet(name = "RegisterServlet", urlPatterns = { "/register" })
public class RegisterServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String USER = "utilisateur";
	public static final String FORM = "form";
	public static final String VUE = "register.jsp";
	
	private UtilisateurConnecteService utilisateurConnecteService;
	
	@Autowired
	public void setUtilisateurConnecteService(UtilisateurConnecteService utilisateurConnecteService) {
		this.utilisateurConnecteService = utilisateurConnecteService;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		UtilisateurConnecte utilisateur = utilisateurConnecteService.inscriptionUtilisateur(request);
		
		request.setAttribute(FORM, utilisateurConnecteService);
		request.setAttribute(USER, utilisateur);
		
		request.getRequestDispatcher(VUE).forward(request, response);
		
		// response.sendRedirect("register");
;
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VUE).forward(request, response);
	}
	
}
