package com.examples.servlet.company_manager.actions;

import java.io.IOException;

import com.examples.servlet.company_manager.models.Company;
import com.examples.servlet.company_manager.models.Database;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowCompany extends Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pId = Integer.parseInt(request.getParameter("id"));

		Database db = new Database();
		Company c = db.getCompanies()
					.stream()
					.filter(e -> e.getId() == pId)
					.findAny()
					.orElseThrow(IllegalArgumentException::new);

		request.setAttribute("company", c);
		setForward("/WEB-INF/views/showCompany.jsp");
	}
}
