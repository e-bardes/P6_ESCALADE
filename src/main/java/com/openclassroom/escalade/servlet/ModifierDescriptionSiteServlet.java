package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.GestionSitesService;

@WebServlet(name = "ModifierDescriptionSiteServlet", urlPatterns = { "/modifierdescriptionsite" })
public class ModifierDescriptionSiteServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private GestionSitesService gestionSitesService;

	@Autowired
	public void setGestionSitesService(GestionSitesService gestionSitesService) {
		this.gestionSitesService = gestionSitesService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("site", gestionSitesService.getSiteDetails(request.getParameter("siteId")).orElse(null));
		request.getRequestDispatcher("/WEB-INF/modifier-description-site.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String siteId = request.getParameter("siteId");

		gestionSitesService.editerDescriptionSite(siteId, request.getParameter("descriptionSite"));

		response.sendRedirect(request.getContextPath() + "/modifierinformations?siteId=" + siteId);
	}
}