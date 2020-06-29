package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.service.TopoService;

@WebServlet(name = "ListeDemandesDeReservationReçuesServlet", urlPatterns = { "/listedemandesreservationrecues" })
public class ListeDemandesDeReservationReçuesServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private TopoService topoService;

	@Autowired
	public void setTopoService(TopoService topoService) {
		this.topoService = topoService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listedemandesreservationrecues", topoService.getAllDemandesDeReservationReceveidOfAUser(
				((Utilisateur) request.getSession().getAttribute("sessionUtilisateur")).getId()));

		request.getRequestDispatcher("/WEB-INF/liste-demandes-reservation-recues.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (Boolean.parseBoolean(request.getParameter("acceptation")) == true) {
			topoService.modifierDisponibilite(request.getParameter("topoId"),
					Long.parseLong(request.getParameter("utilisateurId")));
		} else {
			topoService.deleteAReservationDemand(request.getParameter("topoId"), request.getParameter("utilisateurId"));
		}
//		topoService.attribuerTopo(((Utilisateur) request.getSession().getAttribute("sessionUtilisateur")).getId(),
//				topoId);
		response.sendRedirect(request.getContextPath() + "/listedemandesreservationrecues");
	}

}