
package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.GestionSitesService;

@WebServlet(name = "CreateSecteurServlet", urlPatterns = { "/createsecteur" })
public class CreateSecteurServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private GestionSitesService gestionSitesService;

	@Autowired
	public void setGestionSitesService(GestionSitesService gestionSitesService) {
		this.gestionSitesService = gestionSitesService;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String siteId = request.getParameter("siteId");

		gestionSitesService.createSecteur(siteId, request.getParameter("nomSecteur"));

		response.sendRedirect(request.getContextPath() + "/modifierinformations?siteId=" + siteId);
	}
}
