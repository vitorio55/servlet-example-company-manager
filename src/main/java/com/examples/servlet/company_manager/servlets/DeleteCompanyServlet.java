package com.examples.servlet.company_manager.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.examples.servlet.company_manager.models.Database;

@WebServlet("/deleteCompany")
public class DeleteCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pId = Integer.parseInt(request.getParameter("id"));

		Database db = new Database();
		db.removeCompanyById(pId);

		response.sendRedirect("listCompanies");
	}

}