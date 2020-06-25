package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.service.TopoService;

@WebServlet(name = "ListeDemandesDeReservationServlet", urlPatterns = { "/listedemandesreservation" })
public class ListeDemandesDeReservationServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private TopoService topoService;

	@Autowired
	public void setTopoService(TopoService topoService) {
		this.topoService = topoService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listedemandesreservation", topoService.getAllDemandesDeReservationOfAUser(
				((Utilisateur) request.getSession().getAttribute("sessionUtilisateur")).getId()));

		request.getRequestDispatcher("/WEB-INF/liste-demandes-reservation.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String topoId = request.getParameter("topoId");

		topoService.modifierDisponibilite(topoId);
		topoService.attribuerTopo(((Utilisateur) request.getSession().getAttribute("sessionUtilisateur")).getId(),
				topoId);
		response.sendRedirect(request.getContextPath() + "/listedemandesreservation");
	}

}