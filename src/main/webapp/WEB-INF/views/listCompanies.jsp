<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page
	import="java.util.List,com.examples.servlet.company_manager.models.Company"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:url value="/entry?action=DeleteCompany" var="linkDeleteCompany" />
<c:url value="/entry?action=ShowCompany" var="linkShowCompany" />
<c:url value="/entry?action=FormCreateCompany" var="linkCreateCompany" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List companies</title>
</head>
<body>

	<a href="${linkCreateCompany}">Register company</a>
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
					-- <a href="${linkDeleteCompany}&id=${e.id}">delete</a>
					- <a href="${linkShowCompany}&id=${e.id}">show</a>
				</li>
			</c:forEach>
		</ul>
	</c:if>

</body>
</html>