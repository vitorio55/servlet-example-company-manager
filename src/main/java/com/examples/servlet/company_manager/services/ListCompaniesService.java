package com.examples.servlet.company_manager.services;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.examples.servlet.company_manager.models.Company;
import com.examples.servlet.company_manager.models.Database;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/companies")
public class ListCompaniesService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Company> companies = new Database().getCompanies();

		String headerAccept = request.getHeader("Accept");
		String resultBody = "";
		response.setContentType(headerAccept);

		if (headerAccept.contains("application/json")) {
			Gson gson = new Gson();
			resultBody = gson.toJson(companies);
		} else if (headerAccept.contains("application/xml")) {
			XStream xstream = new XStream();
			xstream.alias("company", Company.class);
			resultBody = xstream.toXML(companies);
		} else {
			resultBody = "Unknown request accept header value: " + headerAccept;
			response.setContentType("text/plain");
		}

		response.getWriter().print(resultBody);
	}
}
