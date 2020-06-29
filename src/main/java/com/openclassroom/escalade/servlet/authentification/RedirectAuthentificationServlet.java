package com.openclassroom.escalade.servlet.authentification;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openclassroom.escalade.servlet.AbstractServlet;

// à partir de details-site.jsp 
// quand on tente de poster un commentaire sans être authentifié
@WebServlet(urlPatterns = { "/redirectauthentification" })
public class RedirectAuthentificationServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/redirect-authentification.jsp").forward(request, response);
	}
}