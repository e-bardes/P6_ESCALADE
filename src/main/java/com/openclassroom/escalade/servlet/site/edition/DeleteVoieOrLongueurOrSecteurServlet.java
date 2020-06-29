package com.openclassroom.escalade.servlet.site.edition;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.SiteEditionService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "DeleteVoieOrLongueurOrSecteurServlet", urlPatterns = { "/deletevoieorlongueurorsecteur" })
public class DeleteVoieOrLongueurOrSecteurServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private SiteEditionService siteEditionService;

	@Autowired
	public void setSiteInformationService(SiteEditionService siteEditionService) {
		this.siteEditionService = siteEditionService;
	}

	// on supprime un des trois éléments en fonction du paramètre récupéré
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String secteur = request.getParameter("secteurId");
		String voie = request.getParameter("voieId");

		if (secteur != null) {
			siteEditionService.deleteSecteur(secteur);
		} else if (voie != null)
			siteEditionService.deleteVoie(voie);
		else
			siteEditionService.deleteLongueur(request.getParameter("longueurId"));

		response.sendRedirect(
				request.getContextPath() + "/modifierinformations?siteId=" + request.getParameter("siteId"));
	}
}