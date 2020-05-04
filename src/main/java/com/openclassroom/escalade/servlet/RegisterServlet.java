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

@WebServlet(name = "RegisterServlet", urlPatterns = { "/register" })
public class RegisterServlet extends AbstractServlet {
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
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresseMail = request.getParameter("adresse-mail");
		String adressePostal = request.getParameter("adresse-postal");
		
		List<UtilisateurConnecte> listeUtilisateurs = utilisateurConnecteService.findAll();
		
		RequestDispatcher disp = null;
		
		for (UtilisateurConnecte utilisateur: listeUtilisateurs) {
			if (utilisateur.getPassword().equals(password)
					|| utilisateur.getAdresseMail().equals(adresseMail)
					|| utilisateur.getAdressePostal().equals(adressePostal)) {
				// on stock un attribut, n'importe lequel pour le moment
				request.setAttribute("password", password);
				disp = request.getRequestDispatcher("register.jsp");
				disp.forward(request, response);
			}
		}
		
		UtilisateurConnecte utilisateurConnecte = new UtilisateurConnecte(
				login, password, nom, prenom, adresseMail, adressePostal);
		utilisateurConnecteService.save(utilisateurConnecte);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("login", login);
		
		disp = request.getRequestDispatcher("menu.jsp");
		disp.forward(request, response);
	}
	
}
