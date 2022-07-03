<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<link href='<spring:url value ="/resources/css/style.css"/>' rel="stylesheet"/>
<link href='<spring:url value ="/resources/css/bootstrap.min.css"/>' rel="stylesheet"/>

</head>
<body>
<div style="margin:150px auto">
	<form:form action="Login-panel" modelAttribute="objUser">
		<div id="box" align="center">
			<h1>Login Here...</h1>
			<div>
                <form:input path="userName" class="form-control"/> <br> <br>
				<form:password path="userPasswd" class="form-control"/> <br> <br>
				<input type="submit" value="login" name="action" class="btn btn-info login"/>
				<input type="submit" value="Register Now" name="action" class="btn btn-info login"/>
				
			</div>
		</div>
	</form:form>
<h2 align="center">${msg }</h2>
</div>
	
</body>
</html>

