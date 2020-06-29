package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// filtre qui permet de rediriger vers une redirect-authentification.jsp si on tente d'ajouter un commentaire
// en étant déconnecté.
// à terme, il sera utilisé pour d'autres fonctionnalités qui demandent d'être authentifié
@WebFilter(urlPatterns = { "/postercommentaire", "/modifierinformations", "/topospersonnel", "/toposdisponibles",
		"/listedemandesreservationenvoyees", "/toposdemandes", "/listedemandesreservationrecues" })
public class RestrictionFilter implements Filter {

	public RestrictionFilter() {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();

		if (session.getAttribute("sessionUtilisateur") == null) {
			res.sendRedirect(req.getContextPath() + "/redirectauthentification");

		} else {
			chain.doFilter(req, res);

		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
