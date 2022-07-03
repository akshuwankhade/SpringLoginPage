<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
     <%@ page isELIgnored = "false" %>
  
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href='<spring:url value ="/resources/css/style.css"/>' rel="stylesheet"/>
<link href='<spring:url value ="/resources/css/bootstrap.min.css"/>' rel="stylesheet"/>
</head>
<body>
	 <div id="edit_profile" class="form-group" align="center">
		<table >
			<h2>Edit Profile</h2>
			
			<form action="update" >
			
			<div>
				<!--User ID : ${userData.id }
				<input type="hidden" id="id" name="id" value="${userData.id}" />-->
				User ID : <input type="id" name="id" value="${userData.id }" readonly="readonly"/>
			</div>
			
			<div>
				User Name : <input type="text"  name="name" value="${userData.userName }" />
			</div>

			<div class="form-group">
				User Password : <input type="text" name="password"
					value="${userData.userPasswd }" />
			</div>
			
			<div class="form-group">
				Email : <input type="email" name="userEmail" value="${userData.userEmail }" />
			</div>
			
			<div class="form-group">
				Country : <input type="text" name="country" value="${userData.country }" />
			</div>
			
			<div>
			<input type="submit" value="save" class="btn btn-info">
			</div>
		
		</form>

		</table>
	</div> 

</body>
</html>