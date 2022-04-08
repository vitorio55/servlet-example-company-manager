package com.examples.servlet.company_manager.actions;

import java.io.IOException;

import com.examples.servlet.company_manager.models.Database;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteCompany extends Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pId = Integer.parseInt(request.getParameter("id"));
		System.out.println("Deleting company with id " + pId + "...");
		
		Database db = new Database();
		db.removeCompanyById(pId);

		setRedirect("entry?action=ListCompanies");
	}
}
