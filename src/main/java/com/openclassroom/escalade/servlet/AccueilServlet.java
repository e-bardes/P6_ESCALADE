package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.UtilisateurService;

@WebServlet(name = "AccueilServlet", urlPatterns = { "/accueil" })
public class AccueilServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	UtilisateurService utilisateurService;

	@Autowired
	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/menu.jsp").forward(request, response);
	}
}
