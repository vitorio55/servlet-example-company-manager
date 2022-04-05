<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page
	import="java.util.List,com.examples.servlet.company_manager.models.Company"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:url value="/deleteCompany" var="linkServletDeleteCompany" />
<c:url value="/editCompany" var="linkServletEditCompany" />

<c:url value="/formEditCompany" var="linkFormServletEditCompany" />
<c:url value="/formNewCompany.jsp" var="linkFormNewCompany" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List companies</title>
</head>
<body>

	<a href="${linkFormNewCompany}">Register company</a>
	<br />

	<c:if test="${not empty company}">
		Company "${company}" was successfully registered!
	</c:if>

	<h2>Companies:</h2>

	<c:if test="${empty companies}">
		No companies registered.
	</c:if>

	<c:if test="${not empty companies}">
		<ul>
			<c:forEach items="${companies}" var="e">
				<li>
					${e.name} -- <fmt:formatDate value="${e.establishedDate}" pattern="dd/MM/yyyy" />
					-- <a href="${linkServletDeleteCompany}?id=${e.id}">delete</a>
					- <a href="${linkFormServletEditCompany}?id=${e.id}">edit</a>
				</li>
			</c:forEach>
		</ul>
	</c:if>

</body>
</html>