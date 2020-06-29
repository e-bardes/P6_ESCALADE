package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.service.TopoService;

@WebServlet(name = "ModifierDisponibliteTopoServlet", urlPatterns = { "/modifierdisponibilitetopo" })
public class ModifierDisponibliteTopoServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private TopoService topoService;

	@Autowired
	public void setTopoService(TopoService topoService) {
		this.topoService = topoService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		topoService.modifierDisponibilite(request.getParameter("topoId"),
				((Utilisateur) request.getSession().getAttribute("sessionUtilisateur")).getId());

		response.sendRedirect(request.getContextPath() + "/topospersonnel");
	}
}