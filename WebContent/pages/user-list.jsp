<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de usuarios</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">	

</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class = "container">
		
		<h1>Lista de usuarios</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'pages/user-edit.jsp'">Crear nuevo usuario</button>
		</p>
	
		<table class = "table table-striped table-bordered">


			<tr class = "thead-dark">
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Edad</th>
				<th>NIF</th>
				<th>Email</th>
				<th>Contraseña</th>
				<th>¿Casado/a?</th>
				<th>Acciones a realizar</th>
			</tr>

			<c:forEach items="${lista}" var="user">

				<tr>
					<td>${user.firstname}</td>
					<td>${user.lastname}</td>
					<td>${user.age}</td>
					<td>${user.nif}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
					<td>
					 ${user.married}
					</td>
					<td> 
						<a href = "${pageContext.request.contextPath}/UserController?action=VIEW&id=${user.id}">Ver usuario</a>
						|
						<a href = "${pageContext.request.contextPath}/UserController?action=EDIT&id=${user.id}">Editar usuario</a> 
						| 
						<a href = "${pageContext.request.contextPath}/UserController?action=DELETE&id=${user.id}">Borrar usuario</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>