<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.examples.servlet.company_manager.models.Company"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url value="/entry?action=EditCompany" var="linkEditCompany"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit company</title>
</head>
<body>

	<a href="listCompanies">List registered companies</a>

	<h2>Edit company:</h2>

	<form action="${linkEditCompany}" method="POST">
		<input type="hidden" name="id" value="${company.id}"/>
		Name: <input type="text" name="name" value="${company.name}"/><br/>
		Established date: <input type="text" name="date" value="<fmt:formatDate value="${company.establishedDate}" pattern="dd/MM/yyyy"/>"/><br/>
		<button type="submit">Save</button>
	</form>

</body>
</html>