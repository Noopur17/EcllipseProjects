<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/script.js" >

</script>
<style >
div{
color:red;
font-size:12px;
}
</style>
</head>
<body>
<s:form action="login" commandName="loginForm" onsubmit="return validate();">
	<div><s:errors path="username"/></div>
	<s:input path="username" id="uname"/>
	<div><s:errors path="password"/></div>
	<s:password path="password" id="pwd"/>
	<input type="submit" value="OK" />
</s:form>
</body>
</html>