package com.openclassroom.escalade.servlet.site.commentary;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.SiteCommentaryService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "SupprimerCommentaireServlet", urlPatterns = { "/supprimer-commentaire" })
public class SupprimerCommentaireServlet extends AbstractServlet {

	private static final long serialVersionUID = 1L;

	private SiteCommentaryService siteCommentaryService;

	@Autowired
	public void setSiteCommentaryService(SiteCommentaryService siteCommentaryService) {
		this.siteCommentaryService = siteCommentaryService;
	}

	// suppression d'un commentaire par un admin
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		siteCommentaryService.deleteCommentary(request.getParameter("commentaireId"));

		request.getRequestDispatcher("/details-site?id=" + request.getParameter("siteId")).forward(request, response);

	}
}