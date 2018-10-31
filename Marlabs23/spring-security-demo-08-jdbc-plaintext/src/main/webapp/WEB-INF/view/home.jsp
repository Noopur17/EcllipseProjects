<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	<p>
	Welcome to the luv2code company home page!
	</p>
	
	<p>
	User: <security:authentication property="principal.username"/>
	
	<br><br>
	
	Role(s): <security:authentication property="principal.authorities"/>
	
	</p>
	<!-- //add a link to point to /leaders.. this is for managers -->
	<security:authorize access="hasRole('MANAGER')">
	<p>
		<a href="${pageContext.request.contextPath }/leaders">LeaderShip Meeting</a>
		(only for Manager Peeps)
	</p>
	</security:authorize>
	
		<security:authorize access="hasRole('ADMIN')">
	
	<p>
		<a href="${pageContext.request.contextPath }/systems">IT System's Meeting</a>
		(only for Admin Peeps)
	</p>
	</security:authorize>
	
	
	<hr>
	<form:form action="${pageContext.request.contextPath }/logout"
		 method="POST">
	<input type="submit" value="Logout" />
	
	</form:form>
	
	
</body>

</html>