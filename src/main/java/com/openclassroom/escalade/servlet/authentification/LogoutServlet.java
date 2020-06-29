package com.openclassroom.escalade.servlet.authentification;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// à partir de n'importe quelle page du moment qu'on est connecté
@WebServlet(name = "LogoutServlet", urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().invalidate();

		// on créer un cookie avec le même nom que quand on s'authentifie mais avec une
		// durée de vie de 0 pour
		// que l'autre soit remplacé et celle là détruit instantanément
		Cookie cookie = new Cookie("email", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);

		// on est redirigé vers l'accueil
		response.sendRedirect(request.getContextPath() + "/accueil");
	}
}
