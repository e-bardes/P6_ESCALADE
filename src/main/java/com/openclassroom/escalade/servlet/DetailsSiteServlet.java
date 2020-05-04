package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.service.SiteService;

@WebServlet(name = "DetailsSitesServlet", urlPatterns = { "/details-site" })
public class DetailsSiteServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	private SiteService siteService;
	
	@Autowired
	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}
	
	// à partir de liste-sites.jsp
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Site site = null;
		for (Site nextSite : siteService.getAllSites()) {
			if (nextSite.getId() == Long.parseLong(id)) {
				site = nextSite;
				break;
			}
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("site", site);
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/details-site.jsp");
		disp.forward(request, response);
	}
	
	// à partir de commentaire.jsp
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/details-site.jsp");
		disp.forward(request, response);
	}
}
