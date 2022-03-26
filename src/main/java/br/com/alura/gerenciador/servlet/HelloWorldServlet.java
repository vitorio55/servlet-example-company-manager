package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setCharacterEncoding("UTF-16LE");
		resp.setContentType("text/html");

		var out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Hello world!");
		out.println("</body>");
		out.println("</html>");

		System.out.println("HelloWorldServlet was called.");
	}
	
}
