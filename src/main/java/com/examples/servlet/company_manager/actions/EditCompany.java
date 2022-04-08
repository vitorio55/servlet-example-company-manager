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

public class EditCompany extends Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pId = Integer.valueOf(request.getParameter("id"));
		String pName = request.getParameter("name");
		System.out.println("Editing company with name " + pName + " and id " + pId + "...");

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

		setRedirect("entry?action=ListCompanies");
	}
}
