<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Second Form</title>
</head>
<body>
	<h1 align="center">Second Page</h1>
	<form action="/Bank/contact" method= "get">
	<%
		Object obj = request.getAttribute("errors");
		String errorMsg = "";
		if (obj != null){
			errorMsg = (String) obj;
		}
	%>
	<font color = "red" size ="10">
		<%=errorMsg %>
	</font>
		<pre>
			Address  :  <input type="text" name ="address">
			
			City     :	<input type="text" name ="city">
			
			State    :	<input type="text" name ="state">
			
			Country  :	<input type="text" name ="country">
			
			Phone    :	<input type="text" name ="phone">
						
						
						<input type="submit" value ="next">
		</pre>
	</form>
</body>
</html>