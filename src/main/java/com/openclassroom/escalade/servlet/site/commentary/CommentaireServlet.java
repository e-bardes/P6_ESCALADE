package com.openclassroom.escalade.servlet.site.commentary;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.service.SiteCommentaryService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "CommentaireServlet", urlPatterns = { "/poster-commentaire" })
public class CommentaireServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private SiteCommentaryService siteCommentaryService;

	@Autowired
	public void setSiteCommentaryService(SiteCommentaryService siteCommentaryService) {
		this.siteCommentaryService = siteCommentaryService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String commentaireId = request.getParameter("commentaireId");

		request.setAttribute("siteId", request.getParameter("siteId"));
		request.setAttribute("commentaireId", commentaireId);
		request.setAttribute("isEditing", request.getParameter("isEditing"));

		// si on est entrain d'éditer un commentaire et non pas en créer un nouveau,
		// alors on aura besoin de charger en mémoire le commentaire entier pour pouvoir
		// afficher son contenu
		if (((String) request.getAttribute("isEditing")).contentEquals("true")) {
			request.setAttribute("commentaire",
					siteCommentaryService.getCommentary(Long.parseLong(commentaireId)).orElse(null));
		}

		request.getRequestDispatcher("/WEB-INF/commentaire.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String siteId = request.getParameter("siteId");
		String commentaireId = request.getParameter("commentaireId");
		String isEditing = request.getParameter("isEditing");
		String contenuDuCommentaire = request.getParameter("contenuDuCommentaire");

		// on vérifie si est entrain d'éditer ou ajouter un commentaire
		if (isEditing.contentEquals("true")) {
			siteCommentaryService.editCommentary(commentaireId, contenuDuCommentaire);
		} else {
			siteCommentaryService.addCommentary((Utilisateur) request.getSession().getAttribute("sessionUtilisateur"),
					siteId, contenuDuCommentaire, commentaireId);
		}

		response.sendRedirect(request.getContextPath() + "/details-site?id=" + siteId);
	}

}
