package com.examples.servlet.company_manager.actions;

import java.io.IOException;

import com.examples.servlet.company_manager.models.Database;
import com.examples.servlet.company_manager.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		System.out.println("Executing log in for user <" + login + ">...");

		Database db = new Database();
		User authenticatedUser = db.authenticateUser(login, password);

		if (authenticatedUser != null) {
			System.out.println("User <" + login + "> authenticated!");
			HttpSession session = request.getSession();
			session.setAttribute("loggedUser", authenticatedUser);
			this.setRedirect("entry?action=ListCompanies");
		} else {
			System.out.println("Could not authenticate user <" + login +">");
			this.setRedirect("entry?action=FormLogin");
		}
	}

}
