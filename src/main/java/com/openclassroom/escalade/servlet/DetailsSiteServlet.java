package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.GestionSitesService;

@WebServlet(name = "DetailsSitesServlet", urlPatterns = { "/details-site" })
public class DetailsSiteServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private GestionSitesService gestionSitesService;

	@Autowired
	public void setGestionSitesService(GestionSitesService gestionSitesService) {
		this.gestionSitesService = gestionSitesService;
	}

	// à partir de liste-sites.jsp
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String siteId = request.getParameter("id");

		// on stocke en mémoire tous les attributs d'un site
		request.setAttribute("site", gestionSitesService.getSiteDetails(siteId).orElse(null));
		// on stocke tous les commentaires d'un site
		request.setAttribute("listecommentaires", gestionSitesService.getCommentaries(null, siteId));
		// on stocke tous les réponses de tous les commentaires d'un site
		request.setAttribute("listerepcommentaires", gestionSitesService.getAllResponsesOfASite(siteId));

		request.getRequestDispatcher("/WEB-INF/details-site.jsp").forward(request, response);
	}
}
