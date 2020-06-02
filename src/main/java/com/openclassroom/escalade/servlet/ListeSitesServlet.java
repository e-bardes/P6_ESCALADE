package com.openclassroom.escalade.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.CotationBloc;
import com.openclassroom.escalade.domain.CotationFalaise;
import com.openclassroom.escalade.domain.Departement;
import com.openclassroom.escalade.service.GestionSitesService;

// accessible à partir de n'importe quelle page
@WebServlet(name = "ListeSitesServlet", urlPatterns = { "/site" })
public class ListeSitesServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
    
	private GestionSitesService gestionSitesService;
	
	@Autowired
	public void setGestionSitesService(GestionSitesService gestionSitesService) {
		this.gestionSitesService = gestionSitesService;
	}
	

	// on récupère la liste de tous les sites
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("listeDesSites", gestionSitesService.getAllSites());
		request.setAttribute("listeCotationBloc", Arrays.asList(CotationBloc.values()));
		request.setAttribute("listeCotationFalaise", Arrays.asList(CotationFalaise.values()));
		request.setAttribute("listeDepartements", Arrays.asList(Departement.values()));
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/liste-sites.jsp");
		disp.forward(request, response);
		
	}

}