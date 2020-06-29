package com.openclassroom.escalade.servlet.authentification;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "RegisterSuccessServet", urlPatterns = { "/registersuccess" })
public class RegisterSuccessServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setAttribute("nom", request.getParameter("nom"));
		request.setAttribute("prenom", request.getParameter("prenom"));
		request.setAttribute("adressePostal", request.getParameter("adressePostal"));
		request.setAttribute("adresseMail", request.getParameter("adresseMail"));
		
		request.getRequestDispatcher("/WEB-INF/registerSuccess.jsp").forward(request, response);
	}
	
}