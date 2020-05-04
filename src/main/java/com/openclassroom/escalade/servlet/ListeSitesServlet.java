package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.SiteService;

@WebServlet(name = "ListeSitesServlet", urlPatterns = { "/site" })
public class ListeSitesServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
    
	private SiteService siteService;
	
	@Autowired
	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("listeDesSites", siteService.getAllSites());
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/liste-sites.jsp");
		disp.forward(request, response);
		
	}

}