package com.openclassroom.escalade.servlet.site;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.CriteriaSearchService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "SearchServlet", urlPatterns = { "/search" })
public class SearchServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private CriteriaSearchService criteriaSearchService;

	@Autowired
	public void setCriteriaSearchService(CriteriaSearchService criteriaSearchService) {
		this.criteriaSearchService = criteriaSearchService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> criteriaList = new ArrayList<String>();
		criteriaList.add(request.getParameter("departement"));
		criteriaList.add(request.getParameter("cotation"));
		criteriaList.add(request.getParameter("nombreSecteurs"));
		criteriaList.add(request.getParameter("nombreVoies"));

		request.setAttribute("listeDesSites", criteriaSearchService.searchSites(criteriaList));

		request.getRequestDispatcher("/site?filtrage=true").forward(request, response);

	}
}
