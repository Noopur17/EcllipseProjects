<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>First Form</title>
</head>
<body>
	<h1 align="center">First Page</h1>
	<form action="/Bank/personal" method= "get">
	
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
			First Name :	<input type="text" name ="fname"/>
			
			Last Name  :	<input type="text" name ="lname"/>
			
			Gender     :    <input type="radio" name="gender" value="male"> Male <input type="radio" name="gender" value="female"> Female<br>
					
					<input type="submit" value ="next"/>
			
		
		</pre>
	</form>
	
</body>
</html>