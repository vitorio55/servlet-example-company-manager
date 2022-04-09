package com.examples.servlet.company_manager.servlets.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;

import com.examples.servlet.company_manager.actions.Action;
import com.examples.servlet.company_manager.actions.ActionFactory;
import com.examples.servlet.company_manager.models.User;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebFilter(urlPatterns = "/entry")
public class AuthorizationFilter implements Filter {

	ActionFactory factory = new ActionFactory();

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("--------------------------------------------");
		System.out.println(">> Authorization filter executing...");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		HttpSession session = httpRequest.getSession();
		String actionParam = request.getParameter("action");
		boolean userNotLoggedIn = session.getAttribute("loggedUser") == null;
		boolean isProtectedAction = !(actionParam.equals("FormLogin") || actionParam.equals("Login"));

		if (userNotLoggedIn && isProtectedAction) {
			System.out.println("User is not logged in, redirecting to login page");
			this.redirectUserToLoginForm(httpRequest, httpResponse);
			System.out.println(">> Authorization filter finished");
			return;
		}

		if (session.getAttribute("loggedUser") != null) {
			User u = (User) session.getAttribute("loggedUser");
			System.out.println(String.format("User <%s> is logged in", u.getLogin()));
		}

		System.out.println(">> Authorization filter finished");
		chain.doFilter(request, response);
	}

	private void redirectUserToLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = factory.createAction("FormLogin");
		action.execute(request, response);
		response.sendRedirect(action.getRedirect());
	}
}
