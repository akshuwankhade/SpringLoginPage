<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>User Panel</title>

<link href='<spring:url value ="/resources/css/style.css"/>' rel="stylesheet"/>
<link href='<spring:url value ="/resources/css/bootstrap.min.css"/>' rel="stylesheet"/>

</head>
<body>
	<h1 align="center">This is a user home page</h1>
	<br/>
	
	<!-- Search bar -->
	
	<div align="center" class="search-container my-8">
		<input type="text" class="form-control" placeholder="search your contact"/>
	</div> <br>
	
	
	
	<!--  User Name : ${objUser.userName }<br/>
	User Password : ${objUser.userPasswd} -->
	
	<div>
		<table align="center">
			<tr>
			<th>User Name</th>
			<th>Email</th>
			<th>Country</th>
			<th>Action</th>
			</tr>
			
			<tr>
				<c:forEach var="user" items="${userData}" varStatus="count">
				<tr>
					
					<td>${user.userName }</td>
					<td>${user.userEmail}</td>
					<td>${user.country}</td>
					
					<td><form action="edit">
					<input type="hidden" name="id" value="${user.id}">
					<button type="submit" value="">Edit</button>
					</form>
					<form action="delete">
					<input type="hidden" name="id" value="${user.id}">
					<button type="submit" value="">Delete</button></td>
					</form>
				<tr>
				</c:forEach>
			</tr>
			
		</table>
	</div>
	
	
	<div>
	
	</div>
	
	<script type="text/javascript">
	$('#myModal').on('shown.bs.modal', function () {
		alert("I am working");
		
		})
	</script>
	<h2 align="center">${msg }</h2>
</body>
</html>