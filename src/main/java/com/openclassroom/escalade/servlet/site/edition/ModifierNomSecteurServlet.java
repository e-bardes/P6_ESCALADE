package com.openclassroom.escalade.servlet.site.edition;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.SiteEditionService;
import com.openclassroom.escalade.service.SiteInformationService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "ModifierNomSecteurServlet", urlPatterns = { "/modifiernomsecteur" })
public class ModifierNomSecteurServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private SiteInformationService siteInformationService;

	@Autowired
	public void setSiteInformationService(SiteInformationService siteInformationService) {
		this.siteInformationService = siteInformationService;
	}

	private SiteEditionService siteEditionService;

	@Autowired
	public void setSiteEditionService(SiteEditionService siteEditionService) {
		this.siteEditionService = siteEditionService;
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String secteurId = request.getParameter("secteurId");

		request.setAttribute("secteur", siteInformationService.getSecteurDetails(secteurId));
		request.getRequestDispatcher(
				"/modifierinformations?siteId=" + request.getParameter("siteId") + "&nameEditing=" + secteurId)
				.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		siteEditionService.editerNomSecteur(request.getParameter("secteurId"), request.getParameter("nomSecteur"));
		response.sendRedirect(
				request.getContextPath() + "/modifierinformations?siteId=" + request.getParameter("siteId"));
	}
}
