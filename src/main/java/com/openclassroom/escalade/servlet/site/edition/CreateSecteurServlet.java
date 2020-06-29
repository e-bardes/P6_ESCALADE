
package com.openclassroom.escalade.servlet.site.edition;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.SiteEditionService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "CreateSecteurServlet", urlPatterns = { "/createsecteur" })
public class CreateSecteurServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private SiteEditionService siteEditionService;

	@Autowired
	public void setSiteInformationService(SiteEditionService siteEditionService) {
		this.siteEditionService = siteEditionService;
	}

	// création d'un secteur en lui donnant un nom
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String siteId = request.getParameter("siteId");

		siteEditionService.createSecteur(siteId, request.getParameter("nomSecteur"));

		response.sendRedirect(request.getContextPath() + "/modifierinformations?siteId=" + siteId);
	}
}
