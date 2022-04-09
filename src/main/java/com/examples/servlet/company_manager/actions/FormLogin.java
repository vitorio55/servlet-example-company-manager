package com.examples.servlet.company_manager.actions;

import java.io.IOException;
import java.util.List;

import com.examples.servlet.company_manager.models.Company;
import com.examples.servlet.company_manager.models.Database;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormLogin extends Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setForward("/WEB-INF/views/formLogin.jsp");
		setRedirect("entry?action=FormLogin");
	}
}
