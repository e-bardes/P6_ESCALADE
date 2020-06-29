package com.openclassroom.escalade.servlet.topo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.GestionTopoService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "ChangementEtatEmprunt", urlPatterns = { "/changement-etat-emprunt" })
public class ChangementEtatEmpruntServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private GestionTopoService gestionTopoService;

	@Autowired
	public void setTopoService(GestionTopoService gestionTopoService) {
		this.gestionTopoService = gestionTopoService;
	}

	// servlet utilisé quand un utilisateur décide de rendre de lui même le topo à
	// son propriétaire
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		gestionTopoService.modifierDisponibilite(request.getParameter("topoId"),
				Long.parseLong(request.getParameter("utilisateurId")));
		gestionTopoService.deleteAReservationDemand(request.getParameter("topoId"),
				request.getParameter("utilisateurId"));

		response.sendRedirect(request.getContextPath() + "/topospersonnel");
	}

}
