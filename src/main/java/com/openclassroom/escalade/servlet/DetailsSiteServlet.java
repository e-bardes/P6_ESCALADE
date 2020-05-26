package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.CommentaireService;
import com.openclassroom.escalade.service.SiteService;
import com.openclassroom.escalade.service.UtilisateurService;

@WebServlet(name = "DetailsSitesServlet", urlPatterns = { "/details-site" })
public class DetailsSiteServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	private SiteService siteService;
	
	@Autowired
	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}
	
	private CommentaireService commentaireService;
	
	@Autowired
	public void setCommentaireService(CommentaireService commentaireService) {
		this.commentaireService = commentaireService;
	}
	
	// à partir de liste-sites.jsp
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String siteId = request.getParameter("id");
		
		// on stocke en mémoire tous les attributs d'un site
		request.setAttribute("site", siteService.getSiteDetails(siteId).orElse(null));
		// on stocke tous les commentaires d'un site
		request.setAttribute("listecommentaires", commentaireService.getCommentaries(null, siteId));
		// on stocke tous les réponses de tous les commentaires d'un site
		request.setAttribute("listerepcommentaires", 
				commentaireService.getAllResponsesOfASite(siteId));
	
		request.getRequestDispatcher("/WEB-INF/details-site.jsp").forward(request, response);
	}
	
	// à partir de détails-site.jsp
	// suppression d'un commentaire par un admin
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		commentaireService.supprimerCommentaire(request.getParameter("commentaireId"));
		response.sendRedirect(request.getContextPath() + "/details-site?id=" + 
				request.getParameter("siteId"));

	}
}
