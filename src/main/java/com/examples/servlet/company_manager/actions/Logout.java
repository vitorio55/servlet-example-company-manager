package com.examples.servlet.company_manager.actions;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Logout extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// There are at least two possibilities for implementing logout:
		// 1- Removing single session attribute
		// session.removeAttribute("loggedUser");
		// Or
		// 2- Invalidating whole session
		session.invalidate();
		this.setRedirect("entry?action=FormLogin");
	}
}
