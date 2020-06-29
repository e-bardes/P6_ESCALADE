package com.openclassroom.escalade.servlet.site.edition;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.SiteEditionService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "AjouterVoieServlet", urlPatterns = { "/ajoutervoie" })
public class AjouterVoieServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private SiteEditionService siteEditionService;

	@Autowired
	public void setSiteInformationService(SiteEditionService siteEditionService) {
		this.siteEditionService = siteEditionService;
	}

	// ajout d'une voie que ce soit pour un site ou un secteur
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String siteId = request.getParameter("siteId");
		String secteurId = request.getParameter("secteurId");

		if (secteurId != null) {
			siteEditionService.addVoieInSecteur(request.getParameter("cotation"), request.getParameter("isEquipe"),
					secteurId);
		} else {
			siteEditionService.addVoieInSite(request.getParameter("cotation"), request.getParameter("isEquipe"),
					siteId);
		}

		response.sendRedirect(request.getContextPath() + "/modifierinformations?siteId=" + siteId);
	}
}
