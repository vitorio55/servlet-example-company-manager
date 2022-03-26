package br.com.alura.gerenciador.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import br.com.alura.gerenciador.servlet.entities.Company;
import br.com.alura.gerenciador.servlet.entities.Database;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/newCompany")
public class NewCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Registering new company");

		String pName = request.getParameter("name");
		String pEstablishedDate = request.getParameter("date");
		Date establishedDate = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			establishedDate = sdf.parse(pEstablishedDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Company c = new Company();
		c.setName(pName);
		c.setEstablishedDate(establishedDate);

		Database db = new Database();
		db.addCompany(c);

		// Calling JSP
		//		RequestDispatcher rd = request.getRequestDispatcher("/newCompanyCreated.jsp");

		// Calling another Servlet
		//		RequestDispatcher rd = request.getRequestDispatcher("/listCompanies");
		//		request.setAttribute("company", c.getName());
		//		rd.forward(request, response);

		response.sendRedirect("listCompanies");
	}

}
