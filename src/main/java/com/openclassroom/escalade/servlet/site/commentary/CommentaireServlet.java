package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.service.GestionSitesService;

@WebServlet(name = "CommentaireServlet", urlPatterns = { "/postercommentaire" })
public class CommentaireServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private GestionSitesService gestionSitesService;
	
	@Autowired
	public void setGestionSitesService(GestionSitesService gestionSitesService) {
		this.gestionSitesService = gestionSitesService;
	}
	
	
	// à partir de details-site.jsp
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String commentaireId = request.getParameter("commentaireId");
		
		request.setAttribute("siteId", request.getParameter("siteId"));
		request.setAttribute("commentaireId", commentaireId);
		request.setAttribute("isEditing", request.getParameter("isEditing"));
		
		// si on est entrain d'éditer un commentaire et non pas en créer un nouveau,
		// alors on aura besoin de charger en mémoire le commentaire entier pour pouvoir afficher son contenu
		if(((String) request.getAttribute("isEditing")).contentEquals("true")) {
			request.setAttribute("commentaire", 
					gestionSitesService.getCommentary(Long.parseLong(commentaireId)).orElse(null));
		}
		
		request.getRequestDispatcher("/WEB-INF/commentaire.jsp").forward(request, response);
	}
	
	// à partir de commentaire.jsp
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String siteId = request.getParameter("siteId");
		String commentaireId = request.getParameter("commentaireId");
		String isEditing = request.getParameter("isEditing");
		String contenuDuCommentaire = request.getParameter("contenuDuCommentaire");

		// on vérifie si est entrain d'éditer ou ajouter un commentaire
		if (isEditing.contentEquals("true")) {
			gestionSitesService.editerCommentaire(commentaireId, contenuDuCommentaire);
		} else {
			gestionSitesService.addCommentary(
				(Utilisateur) request.getSession().getAttribute("sessionUtilisateur"),
				siteId,
				contenuDuCommentaire,
				commentaireId);
		}

		response.sendRedirect(request.getContextPath() + "/details-site?id=" + siteId);
	}
	
}
