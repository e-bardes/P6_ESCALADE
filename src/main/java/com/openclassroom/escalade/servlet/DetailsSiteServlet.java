package com.openclassroom.escalade.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.Commentaire;
import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.service.CommentaireService;
import com.openclassroom.escalade.service.SiteService;
import com.openclassroom.escalade.service.UtilisateurConnecteService;

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
	
	private UtilisateurConnecteService utilisateurConnecteService;
	
	@Autowired
	public void setUtilisateurConnecteService(UtilisateurConnecteService utilisateurConnecteService) {
		this.utilisateurConnecteService = utilisateurConnecteService;
	}
	
	// à partir de liste-sites.jsp
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String id = request.getParameter("id");
		
		Site site = null;
		for (Site nextSite : siteService.getAllSites()) {
			if (nextSite.getId() == Long.parseLong(id)) {
				site = nextSite;
				break;
			}
		}
		
		HttpSession session = request.getSession(false);
		session.setAttribute("site", site);
		
		session.setAttribute("listecommentaires", commentaireService.findBySite(
				(Site) session.getAttribute("site")));
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/details-site.jsp");
		disp.forward(request, response);
	}
	
	// à partir de commentaire.jsp
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// response.setContentType("text/html");
		
		HttpSession session = request.getSession();

		Commentaire commentaire = new Commentaire(
				utilisateurConnecteService.findByAdresseMail((String) session.getAttribute("adressemail")),
				(Site) session.getAttribute("site"),
				request.getParameter("contenuDuCommentaire"));

		commentaireService.save(commentaire);

		session.setAttribute("listecommentaires", commentaireService.findBySite(
				(Site) session.getAttribute("site")));
		
		System.out.println(session.getAttribute("listecommentaires"));
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/details-site.jsp");
		disp.forward(request, response);
	}
}
