package com.openclassroom.escalade.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.service.GestionSitesService;

@WebServlet(name = "SearchServlet", urlPatterns = { "/search" })
public class SearchServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	private GestionSitesService gestionSitesService;
	
	@Autowired
	public void setGestionSitesService(GestionSitesService gestionSitesService) {
		this.gestionSitesService = gestionSitesService;
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<String> criteriaList = new ArrayList<String>();
		criteriaList.add(request.getParameter("departement"));
		criteriaList.add(request.getParameter("cotation"));
		criteriaList.add(request.getParameter("nombreSecteurs"));
		criteriaList.add(request.getParameter("nombreVoies"));
		
		List<Site> searchResults = gestionSitesService.searchSites(criteriaList);
		
		System.out.println(searchResults);
		
		
	}
}
