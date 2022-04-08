package com.examples.servlet.company_manager.actions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.examples.servlet.company_manager.models.Company;
import com.examples.servlet.company_manager.models.Database;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreateCompany extends Action {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Creating a company");

		String pName = request.getParameter("name");
		String pEstablishedDate = request.getParameter("date");
		Date establishedDate = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			establishedDate = sdf.parse(pEstablishedDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Company c = new Company();
		c.setName(pName);
		c.setEstablishedDate(establishedDate);

		Database db = new Database();
		db.addCompany(c);

		setRedirect("entry?action=ListCompanies");
	}
}
