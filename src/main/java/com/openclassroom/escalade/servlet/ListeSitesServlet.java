package com.openclassroom.escalade.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.CotationBloc;
import com.openclassroom.escalade.domain.CotationFalaise;
import com.openclassroom.escalade.domain.Departement;
import com.openclassroom.escalade.domain.Site;
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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listeCotationBloc", Arrays.asList(CotationBloc.values()));
		request.setAttribute("listeCotationFalaise", Arrays.asList(CotationFalaise.values()));
		request.setAttribute("listeDepartements", Arrays.asList(Departement.values()));

		if (request.getParameter("filtrage").contentEquals("true")) {
			request.setAttribute("listeDesSites", request.getAttribute("listeDesSites"));
		} else {
			request.setAttribute("listeDesSites", gestionSitesService.getAllSites());
		}

		@SuppressWarnings("unchecked")
		List<Site> listeSites = (List<Site>) request.getAttribute("listeDesSites");
		request.setAttribute("listeNbSecteurs", gestionSitesService.getNbSecteursOfSelectedSites(listeSites));
		request.setAttribute("listeNbVoies", gestionSitesService.getNbVoiesOfSelectedSites(listeSites));
		request.setAttribute("cotationList", gestionSitesService.getMinAndMaxCotationOfSelectedSites(listeSites));

		request.getRequestDispatcher("/WEB-INF/liste-sites.jsp").forward(request, response);

	}
}