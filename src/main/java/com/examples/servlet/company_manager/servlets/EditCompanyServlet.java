package com.examples.servlet.company_manager.servlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.examples.servlet.company_manager.models.Company;
import com.examples.servlet.company_manager.models.Database;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editCompany")
public class EditCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pId = Integer.valueOf(request.getParameter("id"));
		String pName = request.getParameter("name");

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
		Date pEstablishedDate;

		try {
			pEstablishedDate = format.parse(request.getParameter("date"));
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}

		Database db = new Database();
		Company newCompanyData = new Company();
		newCompanyData.setEstablishedDate(pEstablishedDate);
		newCompanyData.setName(pName);
		db.editCompany(pId, newCompanyData);

		response.sendRedirect("listCompanies");
	}

}
