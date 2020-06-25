// pas encore utilisé

package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.TopoService;

@WebServlet(name = "ListeToposServlet", urlPatterns = { "/topo" })
public class ListeToposServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
    
	private TopoService topoService;
	
	@Autowired
	public void setTopoService(TopoService topoService) {
		this.topoService = topoService;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("listedestopos", topoService.getAllTopos());
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/liste-topos.jsp");
		disp.forward(request, response);
		
	}

}