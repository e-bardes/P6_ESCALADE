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

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	private UtilisateurConnecteService utilisateurConnecteService;
	
	@Autowired
	public void setUtilisateurConnecteService(UtilisateurConnecteService utilisateurConnecteService) {
		this.utilisateurConnecteService = utilisateurConnecteService;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		List<UtilisateurConnecte> listeUtilisateurs = utilisateurConnecteService.findAll();
		
		RequestDispatcher disp = null;
		
		for (UtilisateurConnecte utilisateur: listeUtilisateurs) {
			if (utilisateur.getLogin().equals(login) && utilisateur.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("login", login);
				disp = request.getRequestDispatcher("menu.jsp");
				disp.forward(request, response);
			}
		}
		
		// n'importe quel attribut pour pouvoir vérifier une condition dans login.jsp
		request.setAttribute("password", password);
		disp = request.getRequestDispatcher("login.jsp");
		disp.forward(request, response);
	}
}
