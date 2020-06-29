package com.openclassroom.escalade.servlet.site.edition;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.SiteEditionService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "AjouterLongueurServlet", urlPatterns = { "/ajouterlongueur" })
public class AjouterLongueurServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private SiteEditionService siteEditionService;

	@Autowired
	public void setSiteInformationService(SiteEditionService siteEditionService) {
		this.siteEditionService = siteEditionService;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ajouter une longueur à une voie sélectionnée
		siteEditionService.addLongueur(request.getParameter("cotation"), request.getParameter("voieId"));
		response.sendRedirect(
				request.getContextPath() + "/modifierinformations?siteId=" + request.getParameter("siteId"));
	}
}