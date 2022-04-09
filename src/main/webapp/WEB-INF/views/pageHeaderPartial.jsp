<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/entry?action=Logout" var="linkLogout" />

----------------------------------------------------------------------<br>
| Logged User: ${loggedUser.login}<br>
| <a href="${linkLogout}">Logout</a><br>
----------------------------------------------------------------------<br>
