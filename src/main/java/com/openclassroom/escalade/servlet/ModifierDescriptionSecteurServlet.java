package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.GestionSitesService;

@WebServlet(name = "ModifierDescriptionSecteurServlet", urlPatterns = { "/modifierdescriptionsecteur" })
public class ModifierDescriptionSecteurServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private GestionSitesService gestionSitesService;

	@Autowired
	public void setGestionSitesService(GestionSitesService gestionSitesService) {
		this.gestionSitesService = gestionSitesService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("secteur", gestionSitesService.getSecteurDetails(request.getParameter("secteurId")));
		request.getRequestDispatcher("/WEB-INF/modifier-description-secteur.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String secteurId = request.getParameter("secteurId");
		long siteId = gestionSitesService.getSiteIdWithSecteurId(secteurId);

		gestionSitesService.editerDescriptionSecteur(secteurId, request.getParameter("descriptionSecteur"));

		response.sendRedirect(request.getContextPath() + "/modifierinformations?siteId=" + siteId);
	}
}