 <%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="admin.css" type="text/css" title="no title"/>
	<title>P E O P L E</title>
</head>

<html>
	<body class="mdi">

		<display:table name="applicationScope.people"/>
		
		<form method="post" action="people">
			<label>ID:</label>
			<input type="text" name="id" size="25">
			<input type="submit" name="id" value="Find" title="Find Person by ID">
		</form>
		
		<c:if test="${person ne null }">
			<c:out value="Found" />
			<c:out value="${person.firstName}" />
			<c:out value="${person.lastName}" />
		</c:if>
        <c:if test="${error ne null}">
            <span class="error">
            <c:out value="Error: " />
            <c:out value="${error.message}"/>
                   </span>
        </c:if>

		
		<form method="post" action="update">
			<input type="hidden" name="update" />
			<label>ID of person to update: </label>
			<input type="text" name="id" size="3">
			<label>New first Name: </label>
			<input type="text" name="firstName" size="25">
			<label>New last Name: </label>
			<input type="text" name="lastName" size="25">
			<input type="submit" value="Update">
		</form>
		
	</body>
</html>
