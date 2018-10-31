<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@include file="taglib_includes.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="saveStudent.do" method="post" commandName="saveStudents">
	<table>
		
		<tr>
			<td>NAME:</td>
			<td><form:input type="text" path="studentName" /></td>
		</tr>
		<tr>
			<td>GENDER:</td>						
							<td><form:select path="gender">
					            <form:option value="M" label="Male"/>
					            <form:option value="F" label="Female"/>
					        </form:select>						
						</td>
		</tr>
		<tr>
			<td>DEPARTMENT:td>	
						<td> <form:input type="text" path="department" ></form:input>
							</td>
		</tr>
		<tr>
			<td>EMAIL:</td>	
			<td><form:input type="text" path="email" /></td>
		</tr>
		<tr>
			<td>PHONE:</td>	
			<td><form:input type="text" path="phoneno" /></td>
		</tr>
		<tr>
			<td><input type="submit" name="submit" value="Register"/>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>