package com.examples.servlet.company_manager.servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import com.examples.servlet.company_manager.models.Company;
import com.examples.servlet.company_manager.models.Database;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/listCompanies")
public class ListCompaniesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Database db = new Database();
		List<Company> companies = db.getCompanies();

		// In-servlet company printing
		// if (companies
		//			.stream()
		//			.peek(e -> out.println("<li>" + e.getName() + "</li>"))
		//			.collect(Collectors.toList())
		//			.isEmpty()) {
		//		System.out.println("No companies registered.");
		//	}

		// Redirect to scriptlet version of company listing
		// List<String> companiesNames = companies.stream().map(e -> e.getName()).collect(Collectors.toList()); 
		// RequestDispatcher rd = request.getRequestDispatcher("/listCompaniesScriptlet.jsp");
		
		// Redirect to non-scriptlet version of company listing
		RequestDispatcher rd = request.getRequestDispatcher("/listCompanies.jsp");

		request.setAttribute("companies", companies);
		rd.forward(request, response);
	}
}
