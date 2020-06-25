package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.service.TopoService;

@WebServlet(name = "ListeToposDisponiblesServlet", urlPatterns = { "/toposdisponibles" })
public class ListeToposDisponiblesServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private TopoService topoService;

	@Autowired
	public void setTopoService(TopoService topoService) {
		this.topoService = topoService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = ((Utilisateur) request.getSession().getAttribute("sessionUtilisateur")).getId();

		request.setAttribute("listedestopos", topoService.getAllToposDisponiblesWhichDontBelongToTheCurrentUser(id));

		request.setAttribute("idSessionUtilisateur", id);

		request.getRequestDispatcher("/WEB-INF/liste-topos-disponibles.jsp").forward(request, response);
	}

	// demande de réservation
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		topoService.demandeDeReservation(request.getParameter("topoId"),
				(Utilisateur) request.getSession().getAttribute("sessionUtilisateur"));
		response.sendRedirect(request.getContextPath() + "/toposdisponibles");
	}

}