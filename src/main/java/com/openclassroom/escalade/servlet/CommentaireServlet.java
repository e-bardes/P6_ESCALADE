package com.openclassroom.escalade.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.CommentaireService;

@WebServlet(name = "CommentaireServlet", urlPatterns = { "/postercommentaire" })
public class CommentaireServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private CommentaireService commentaireService;
	
	@Autowired
	public void setCommentaireService(CommentaireService commentaireService) {
		this.commentaireService = commentaireService;
	}
	
	
	// à partir de details-site.jsp
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher disp = request.getRequestDispatcher("commentaire.jsp");
		disp.forward(request, response);
		
	}
	
}
