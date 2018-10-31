<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Last Page</h1>
	
     <form action="/Bank/bank" method= "get">
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
			Bank Name  :    <input type="text" name ="bankname">
			
			Account    :	<input type="text" name ="account">
			
			SSN        :	<input type="text" name ="ssn">
			
						
						<input type="submit" value ="finish">
			
		
		</pre>
	</form>
</body>
</html>