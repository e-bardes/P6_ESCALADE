
package com.openclassroom.escalade.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.CotationBloc;
import com.openclassroom.escalade.domain.CotationFalaise;
import com.openclassroom.escalade.service.GestionSitesService;

@WebServlet(name = "ModifierInformationsSiteServlet", urlPatterns = { "/modifierinformations" })
public class ModifierInformationsSiteServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private GestionSitesService gestionSitesService;

	@Autowired
	public void setGestionSitesService(GestionSitesService gestionSitesService) {
		this.gestionSitesService = gestionSitesService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		request.setAttribute("nameEditing", request.getParameter("nameEditing"));
		request.setAttribute("listeCotationBloc", Arrays.asList(CotationBloc.values()));
		request.setAttribute("listeCotationFalaise", Arrays.asList(CotationFalaise.values()));
		request.setAttribute("site", gestionSitesService.getSiteDetails(request.getParameter("siteId")).orElse(null));
		request.getRequestDispatcher("/WEB-INF/modifier-informations-site.jsp").forward(request, response);
	}
}
