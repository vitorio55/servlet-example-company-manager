package com.examples.servlet.company_manager.actions;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Action {

	// We can say this implements the Command Design Pattern 

	private String redirect;
	private String forward;
	
	public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}
}
