package com.openclassroom.escalade.servlet.site.edition;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.SiteEditionService;
import com.openclassroom.escalade.service.SiteInformationService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "ModifierDescriptionSecteurServlet", urlPatterns = { "/modifierdescriptionsecteur" })
public class ModifierDescriptionSecteurServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private SiteInformationService siteInformationService;

	@Autowired
	public void setSiteInformationService(SiteInformationService siteInformationService) {
		this.siteInformationService = siteInformationService;
	}

	private SiteEditionService siteEditionService;

	@Autowired
	public void setSiteEditionService(SiteEditionService siteEditionService) {
		this.siteEditionService = siteEditionService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("secteur", siteInformationService.getSecteurDetails(request.getParameter("secteurId")));
		request.getRequestDispatcher("/WEB-INF/modifier-description-secteur.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String secteurId = request.getParameter("secteurId");
		// au lieu de passer le site en paramètre on le récupère en bd
		long siteId = siteInformationService.getSiteIdWithSecteurId(secteurId);

		siteEditionService.editerDescriptionSecteur(secteurId, request.getParameter("descriptionSecteur"));

		response.sendRedirect(request.getContextPath() + "/modifierinformations?siteId=" + siteId);
	}
}