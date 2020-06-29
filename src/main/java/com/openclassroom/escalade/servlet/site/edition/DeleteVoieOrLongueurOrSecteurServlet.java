package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.GestionSitesService;

@WebServlet(name = "DeleteVoieOrLongueurOrSecteurServlet", urlPatterns = { "/deletevoieorlongueurorsecteur" })
public class DeleteVoieOrLongueurOrSecteurServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private GestionSitesService gestionSitesService;

	@Autowired
	public void setGestionSitesService(GestionSitesService gestionSitesService) {
		this.gestionSitesService = gestionSitesService;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String secteur = request.getParameter("secteurId");
		String voie = request.getParameter("voieId");

		if (secteur != null) {
			gestionSitesService.deleteSecteur(secteur);
		} else if (voie != null)
			gestionSitesService.deleteVoie(voie);
		else
			gestionSitesService.deleteLongueur(request.getParameter("longueurId"));

		response.sendRedirect(
				request.getContextPath() + "/modifierinformations?siteId=" + request.getParameter("siteId"));
	}
}