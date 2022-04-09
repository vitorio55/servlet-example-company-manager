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
public class ControllerFilter implements Filter {

	ActionFactory factory = new ActionFactory();

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("--------------------------------------------");
		System.out.println(">> Controller filter executing...");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String actionParam = httpRequest.getParameter("action");
		Action action = factory.createAction(actionParam);
		action.execute(httpRequest, httpResponse);

		if (action != null && action.getForward() != null && !action.getForward().isBlank()) {
			RequestDispatcher rd = httpRequest.getRequestDispatcher(action.getForward());
			rd.forward(httpRequest, httpResponse);
		} else if (action != null && action.getRedirect() != null && !action.getRedirect().isBlank()) {
			httpResponse.sendRedirect(action.getRedirect());
		}

		System.out.println(">> Controller filter finished");
	}
}
