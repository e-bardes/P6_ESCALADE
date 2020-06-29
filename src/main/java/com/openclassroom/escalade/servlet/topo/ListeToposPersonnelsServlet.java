package com.openclassroom.escalade.servlet.topo;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.Departement;
import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.service.GestionTopoService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "ListeToposPersonnelsServlet", urlPatterns = { "/topospersonnel" })
public class ListeToposPersonnelsServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private GestionTopoService gestionTopoService;

	@Autowired
	public void setTopoService(GestionTopoService gestionTopoService) {
		this.gestionTopoService = gestionTopoService;
	}

	// tous les topos de l'utilisateur courant
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long utilisateurId = ((Utilisateur) request.getSession().getAttribute("sessionUtilisateur")).getId();

		request.setAttribute("listedestopos", gestionTopoService.getAllToposOfAUser(utilisateurId));
		request.setAttribute("listeDepartements", Arrays.asList(Departement.values()));
		request.setAttribute("curentUserId", utilisateurId);

		request.getRequestDispatcher("/WEB-INF/liste-topos-personnels.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// ajout d'un topo dont le créateur est le propriétaire
		gestionTopoService.addTopo(request.getParameter("nomTopo"), request.getParameter("departement"),
				request.getParameter("date"), request.getParameter("description"), request.getParameter("isDisponible"),
				((Utilisateur) request.getSession().getAttribute("sessionUtilisateur")).getId());
		response.sendRedirect(request.getContextPath() + "/topospersonnel");
	}

}