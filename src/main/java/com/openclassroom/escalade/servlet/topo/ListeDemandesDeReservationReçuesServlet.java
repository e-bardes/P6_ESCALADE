package com.openclassroom.escalade.servlet.topo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.service.GestionTopoService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "ListeDemandesDeReservationReçuesServlet", urlPatterns = { "/listedemandesreservationrecues" })
public class ListeDemandesDeReservationReçuesServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private GestionTopoService gestionTopoService;

	@Autowired
	public void setTopoService(GestionTopoService gestionTopoService) {
		this.gestionTopoService = gestionTopoService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// les demandes peuvent concerner tous les topos qui sont actuellement
		// disponibles
		request.setAttribute("listedemandesreservationrecues",
				gestionTopoService.getAllDemandesDeReservationReceveidOfAUser(
						((Utilisateur) request.getSession().getAttribute("sessionUtilisateur")).getId()));

		request.getRequestDispatcher("/WEB-INF/liste-demandes-reservation-recues.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// demande accepté, alors le demandeur devient possesseur du topo
		if (Boolean.parseBoolean(request.getParameter("acceptation")) == true) {
			gestionTopoService.modifierDisponibilite(request.getParameter("topoId"),
					Long.parseLong(request.getParameter("utilisateurId")));
			// sinon la demande est refusé et le demandeur ne l'est plus
		} else {
			gestionTopoService.deleteAReservationDemand(request.getParameter("topoId"),
					request.getParameter("utilisateurId"));
		}
		response.sendRedirect(request.getContextPath() + "/listedemandesreservationrecues");
	}

}