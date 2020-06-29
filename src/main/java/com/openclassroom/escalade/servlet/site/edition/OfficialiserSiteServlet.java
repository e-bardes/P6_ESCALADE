package com.openclassroom.escalade.servlet.site.edition;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.service.SiteEditionService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "OfficialiserSiteServlet", urlPatterns = { "/modifierofficialisationSite" })
public class OfficialiserSiteServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private SiteEditionService siteEditionService;

	@Autowired
	public void setSiteEditionService(SiteEditionService siteEditionService) {
		this.siteEditionService = siteEditionService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String siteId = request.getParameter("siteId");
		siteEditionService.modifierOfficialisation(siteId);
		response.sendRedirect(request.getContextPath() + "/modifierinformations?siteId=" + siteId);
	}
}