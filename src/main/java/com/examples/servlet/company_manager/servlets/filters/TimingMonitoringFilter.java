package com.examples.servlet.company_manager.servlets.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

//@WebFilter(urlPatterns = "/entry")
public class TimingMonitoringFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("--------------------------------------------");
		System.out.println(">> Timing Monitoring filter executing...");

		long before = System.currentTimeMillis();
		String action = request.getParameter("action");

		chain.doFilter(request, response);

		long after = System.currentTimeMillis();
		System.out.println(">> Total execution time of action (" + action + "): " + (after - before) + "ms");
		System.out.println(">> Timing Monitoring filter finished");
	}

}
