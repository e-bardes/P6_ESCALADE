package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.UtilisateurService;


// exécuté lors du lancement du serveur
// accessible à partir de n'importe quelle page
@WebServlet(name = "AccueilServlet", urlPatterns = { "/" })
public class AccueilServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	UtilisateurService utilisateurService;

	@Autowired
	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// on vérifie si on peut connecter l'utilisateur automatiquement à partir d'un cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("email")) {
                	request.getSession().setAttribute(
                			"sessionUtilisateur",
                			utilisateurService.searchUser(cookie.getValue()));
                }
            }
        }
        request.getRequestDispatcher("/WEB-INF/menu.jsp").forward(request, response);
    }
}
