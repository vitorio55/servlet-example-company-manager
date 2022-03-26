package br.com.alura.gerenciador.servlet;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import br.com.alura.gerenciador.servlet.entities.Company;
import br.com.alura.gerenciador.servlet.entities.Database;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/formEditCompany")
public class FormEditCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pId = Integer.parseInt(request.getParameter("id"));

		Database db = new Database();
		Company c = db.getCompanies()
					.stream()
					.filter(e -> e.getId() == pId)
					.findAny()
					.orElseThrow(IllegalArgumentException::new);

		RequestDispatcher rd = request.getRequestDispatcher("/formEditCompany.jsp");
		request.setAttribute("company", c);
		rd.forward(request, response);
	}

}
