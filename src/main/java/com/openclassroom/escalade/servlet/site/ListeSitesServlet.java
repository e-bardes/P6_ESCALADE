package com.openclassroom.escalade.servlet.site;

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
import com.openclassroom.escalade.service.SiteInformationService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "ListeSitesServlet", urlPatterns = { "/site" })
public class ListeSitesServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private SiteInformationService siteInformationService;

	@Autowired
	public void setSiteInformationService(SiteInformationService siteInformationService) {
		this.siteInformationService = siteInformationService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ces trois lignes permettent de remplir les choix des critères de recherche
		request.setAttribute("listeCotationBloc", Arrays.asList(CotationBloc.values()));
		request.setAttribute("listeCotationFalaise", Arrays.asList(CotationFalaise.values()));
		request.setAttribute("listeDepartements", Arrays.asList(Departement.values()));

		// si on fait un filtrage en fonction d'un ou plusieurs critères
		if (request.getParameter("filtrage").contentEquals("true")) {
			request.setAttribute("listeDesSites", request.getAttribute("listeDesSites"));
			// sinon on récupère tous les sites existants
		} else {
			request.setAttribute("listeDesSites", siteInformationService.getAllSites());
		}

		// pour un affichage de quelques informations pour chacun des sites
		@SuppressWarnings("unchecked")
		List<Site> listeSites = (List<Site>) request.getAttribute("listeDesSites");
		request.setAttribute("listeNbSecteurs", siteInformationService.getNbSecteursOfSelectedSites(listeSites));
		request.setAttribute("listeNbVoies", siteInformationService.getNbVoiesOfSelectedSites(listeSites));
		request.setAttribute("cotationList", siteInformationService.getMinAndMaxCotationOfSelectedSites(listeSites));

		request.getRequestDispatcher("/WEB-INF/liste-sites.jsp").forward(request, response);

	}
}