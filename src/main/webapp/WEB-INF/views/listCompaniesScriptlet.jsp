<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.examples.servlet.company_manager.models.Company"%>

<% 
	List<Company> companies = (List<Company>) request.getAttribute("companies");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List companies</title>
</head>
<body>

	<a href="formNewCompany.html">Register company</a>

	<h2>Companies:</h2>
	
	<%
		if (companies.isEmpty()) {
			out.println("No companies registerd.");
			return;
		}

		out.println("<ul>");
		for (Company e : companies) {
			out.println("\t\t<li>" + e.getName() + "</li>");
		}
		out.println("\t</ul>");			
	%>

</body>
</html>