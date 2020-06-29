
package com.openclassroom.escalade.servlet.site.edition;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openclassroom.escalade.domain.CotationBloc;
import com.openclassroom.escalade.domain.CotationFalaise;
import com.openclassroom.escalade.service.SiteInformationService;
import com.openclassroom.escalade.servlet.AbstractServlet;

@WebServlet(name = "ModifierInformationsSiteServlet", urlPatterns = { "/modifierinformations" })
public class ModifierInformationsSiteServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	private SiteInformationService siteInformationService;

	@Autowired
	public void setSiteInformationService(SiteInformationService siteInformationService) {
		this.siteInformationService = siteInformationService;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		request.setAttribute("nameEditing", request.getParameter("nameEditing"));
		request.setAttribute("listeCotationBloc", Arrays.asList(CotationBloc.values()));
		request.setAttribute("listeCotationFalaise", Arrays.asList(CotationFalaise.values()));
		request.setAttribute("site",
				siteInformationService.getSiteDetails(request.getParameter("siteId")).orElse(null));
		request.getRequestDispatcher("/WEB-INF/modifier-informations-site.jsp").forward(request, response);
	}
}
