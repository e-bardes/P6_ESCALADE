package com.openclassroom.escalade.servlet.site;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.SiteCommentaryService;
import com.openclassroom.escalade.service.SiteInformationService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "DetailsSitesServlet", urlPatterns = { "/details-site" })
public class DetailsSiteServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private SiteInformationService siteInformationService;

	@Autowired
	public void setSiteInformationService(SiteInformationService siteInformationService) {
		this.siteInformationService = siteInformationService;
	}

	private SiteCommentaryService siteCommentaryService;

	@Autowired
	public void setSiteCommentaryService(SiteCommentaryService siteCommentaryService) {
		this.siteCommentaryService = siteCommentaryService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		request.setCharacterEncoding("UTF-8");

		String siteId = request.getParameter("id");

		// on stocke en mémoire tous les attributs d'un site
		request.setAttribute("site", siteInformationService.getSiteDetails(siteId).orElse(null));
		// on stocke tous les commentaires d'un site
		request.setAttribute("listecommentaires", siteCommentaryService.getCommentaries(null, siteId));
		// on stocke toutes les réponses de tous les commentaires d'un site
		request.setAttribute("listerepcommentaires", siteCommentaryService.getAllResponsesOfASite(siteId));

		request.getRequestDispatcher("/WEB-INF/details-site.jsp").forward(request, response);
	}
}
