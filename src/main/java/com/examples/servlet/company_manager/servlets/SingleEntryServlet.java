package com.examples.servlet.company_manager.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.examples.servlet.company_manager.actions.Action;
import com.examples.servlet.company_manager.actions.ActionFactory;
import com.examples.servlet.company_manager.actions.CreateCompany;
import com.examples.servlet.company_manager.actions.DeleteCompany;
import com.examples.servlet.company_manager.actions.EditCompany;
import com.examples.servlet.company_manager.actions.FormCreateCompany;
import com.examples.servlet.company_manager.actions.ListCompanies;
import com.examples.servlet.company_manager.actions.ShowCompany;

@WebServlet("/entry")
public class SingleEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionParam = request.getParameter("action");
		ActionFactory factory = new ActionFactory();
		Action action = factory.createAction(actionParam);
		action.execute(request, response);

		if (action != null && action.getForward() != null && !action.getForward().isBlank()) {
			RequestDispatcher rd = request.getRequestDispatcher(action.getForward());
			rd.forward(request, response);
		} else if (action != null && action.getRedirect() != null && !action.getRedirect().isBlank()) {
			response.sendRedirect(action.getRedirect());
		}
	}
}
