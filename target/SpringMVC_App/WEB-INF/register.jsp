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
<div align="center" class="row">
	<div class="col-sm-4"></div>
	<div class="col-sm-4">
		<form:form action="ProcessRegistration" modelAttribute="objReg">
		
			<h2>User Registration</h2>
		
			<div class="form-group">
				<form:label path="userName">Name</form:label>
				<form:input path="userName" class="form-control"/> <br> <br>
			</div>
			
			<div class="form-group">
				<form:label path="userEmail" >User Name</form:label>
				<form:input path="userEmail" class="form-control"/> <br> <br>
			</div>
			
			<div class="form-group">
				<form:label path="password" >User Password</form:label>
				<form:input path="password" class="form-control"/> <br> <br>
			</div>
			
			<div class="form-group">
				<form:label path="country" >Country</form:label> 
				<form:select path="country" class="form-control"> 
					<form:option value="" label="--Select--"></form:option>
					<form:option value="SI" label="Singapore"></form:option>
					<form:option value="IND" label="India"></form:option>
					<form:option value="CH" label="China"></form:option>
					<form:option value="USA" label="United State"></form:option> 
				</form:select>
			</div> <br>
			
			<div class="form-group">
				<form:label path="gender">Gender</form:label>
				<form:radiobutton path = "gender" value = "M" label = "Male"/>
				<form:radiobutton path = "gender" value = "F" label = "Female"/>
				<form:radiobutton path = "gender" value = "O" label = "Other"/>
			</div>	<br>
			
			<div class="form-group">
				<input type="submit" value="Register Now" class="form-control btn btn-"/>
			</div>	
			
		</form:form>
		<h2>${objReg.msg }</h2>
	</div>
	<div class="col-sm-4"></div>	
</div>
	
</body>
</html>

