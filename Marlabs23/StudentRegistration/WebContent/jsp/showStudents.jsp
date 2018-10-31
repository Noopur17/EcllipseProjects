<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="taglib_includes.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-family: Arial; font-size:smaller;">
	<center>
	
	
	<table style="border-collapse: collapse;" border="1" bordercolor="#006699" width="500">
		<tr bgcolor="lightblue">
			<th>Id</th>
			<th>Name</th>			
			<th>Gender</th>	
			<th>Department</th>
			<th>Email</th>
			<th>Phone No</th>
			<th></th>
		</tr>
		<c:if test="${empty SEARCH_CONTACTS_RESULTS_KEY}">
		<tr>
			<td colspan="4">No Results found</td>
		</tr>
		</c:if>
		<c:if test="${! empty SEARCH_CONTACTS_RESULTS_KEY}">
			<c:forEach var="contact" items="${SEARCH_CONTACTS_RESULTS_KEY}">		
		    <tr>
				<td><c:out value="${contact.studentId}"></c:out></td>
				<td><c:out value="${contact.studentName}"></c:out></td>
				<td><c:out value="${contact.gender}"></c:out> </td>
				<td><c:out value="${contact.department}"></c:out></td>
				<td><c:out value="${contact.email}"></c:out></td>
				<td><c:out value="${contact.phoneno}"></c:out></td>
				<td>
					&nbsp;<a href="updateContact.do?id=${contact.id}">Edit</a>
					&nbsp;&nbsp;<a href="javascript:deleteContact('deleteContact.do?id=${contact.id}');">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</c:if>				
	</table>	
	</center>
		
</body>
</html>