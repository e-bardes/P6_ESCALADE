package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.GestionSitesService;

@WebServlet(name = "ModifierNomSecteurServlet", urlPatterns = { "/modifiernomsecteur" })
public class ModifierNomSecteurServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private GestionSitesService gestionSitesService;

	@Autowired
	public void setGestionSitesService(GestionSitesService gestionSitesService) {
		this.gestionSitesService = gestionSitesService;
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String secteurId = request.getParameter("secteurId");

		request.setAttribute("secteur", gestionSitesService.getSecteurDetails(secteurId));
		request.getRequestDispatcher(
				"/modifierinformations?siteId=" + request.getParameter("siteId") + "&nameEditing=" + secteurId)
				.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		gestionSitesService.editerNomSecteur(request.getParameter("secteurId"), request.getParameter("nomSecteur"));
		response.sendRedirect(
				request.getContextPath() + "/modifierinformations?siteId=" + request.getParameter("siteId"));
	}
}
