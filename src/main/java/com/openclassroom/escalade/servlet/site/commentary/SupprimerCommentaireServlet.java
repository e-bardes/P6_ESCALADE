package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.GestionSitesService;

@WebServlet(name = "SupprimerCommentaireServlet", urlPatterns = { "/supprimercommentaire" })
public class SupprimerCommentaireServlet extends AbstractServlet {

	private static final long serialVersionUID = 1L;
	
	private GestionSitesService gestionSitesService;
	
	@Autowired
	public void setGestionSitesService(GestionSitesService gestionSitesService) {
		this.gestionSitesService = gestionSitesService;
	}
	
	// à partir de détails-site.jsp
	// suppression d'un commentaire par un admin
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		gestionSitesService.supprimerCommentaire(request.getParameter("commentaireId"));
		
		request.getRequestDispatcher("/details-site?id=" + request.getParameter("siteId")).forward(request, response);;
//		response.sendRedirect(request.getContextPath() + "/details-site?id=" + 
//				request.getParameter("siteId"));
	}
}