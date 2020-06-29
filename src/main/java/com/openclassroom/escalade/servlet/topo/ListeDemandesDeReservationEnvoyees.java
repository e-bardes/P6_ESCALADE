package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.service.TopoService;

@WebServlet(name = "ListeDemandesDeReservationEnvoyees", urlPatterns = { "/listedemandesreservationenvoyees" })
public class ListeDemandesDeReservationEnvoyees extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private TopoService topoService;

	@Autowired
	public void setTopoService(TopoService topoService) {
		this.topoService = topoService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listedemandesreservationenvoyees", topoService.getAllReservationDemandsSendOfAUser(
				(Utilisateur) request.getSession().getAttribute("sessionUtilisateur")));

		request.getRequestDispatcher("/WEB-INF/liste-demandes-reservation-envoyees.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		topoService.deleteAReservationDemand(request.getParameter("topoId"), request.getParameter("utilisateurId"));

		response.sendRedirect(request.getContextPath() + "/listedemandesreservationenvoyees");
	}

}