package com.openclassroom.escalade.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.Departement;
import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.service.TopoService;

@WebServlet(name = "ListeToposPersonnelsServlet", urlPatterns = { "/topospersonnel" })
public class ListeToposPersonnelsServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private TopoService topoService;

	@Autowired
	public void setTopoService(TopoService topoService) {
		this.topoService = topoService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listedestopos", topoService
				.getAllToposOfAUser(((Utilisateur) request.getSession().getAttribute("sessionUtilisateur")).getId()));
		request.setAttribute("listeDepartements", Arrays.asList(Departement.values()));
		request.getRequestDispatcher("/WEB-INF/liste-topos-personnels.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		topoService.addTopo(request.getParameter("nomTopo"), request.getParameter("departement"),
				request.getParameter("date"), request.getParameter("isDisponible"), request.getParameter("description"),
				((Utilisateur) request.getSession().getAttribute("sessionUtilisateur")));
		response.sendRedirect(request.getContextPath() + "/topospersonnel");
	}

}