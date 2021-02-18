<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear / Editar Usuario</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">

</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<h1 class="text-center mt-3">Pantalla creaci&oacute;n / edici&oacute;n Usuario</h1>
	<br>
	<div class="container">
	
	<p>
	
	
	</p>

		<div class="row">

			<div class="col-sm-6">

				<form action="${pageContext.request.contextPath}/UserController" action="${pageContext.request.contextPath}/login" method="POST">

					<!-- NOMBRE --> 
					<div class="mb-3">
						<label for="input1" class="form-label">Nombre</label>
						<input type="text" class="form-control"	id="input1" name="firstname" placeholder="Nombre" value= "${user.firstname}">
					</div>
					<!-- APELLIDO --> 
					<div class="mb-3">
						<label for="input2" class="form-label">Apellido</label>
						<input type="text" class="form-control"	id="input2" name="lastname" placeholder="Apellido" value= "${user.lastname}">
					</div>
					<!-- EDAD --> 
					<div class="mb-3">
						<label for="input3" class="form-label">Edad</label>
						<input type="number" class="form-control" id="input3" name="age" placeholder="Edad" value="${user.age}">
					</div>
					<!-- NIF -->
					<div class="mb-3">
						<label for="input6" class="form-label">Nif</label>
						<input type="text" class="form-control"	id="input6" name="nif" placeholder="Nif" value="${user.nif}">
					</div>
					<!-- EMAIL -->
					<div class="mb-3">
						<label for="input4" class="form-label">Email</label>
						<input type="text" class="form-control"	id="input4" name="email" placeholder="Email" value = "${user.email}">
					</div>
					<!-- CONTRASEÑA -->
					<div class="mb-3">
						<label for="input5" class="form-label">Contrase&ntilde;a</label>
						<input type="password" class="form-control"	id="input5" name="password" placeholder="Password" value="${user.password}">
					</div>
					<!-- ¿ESTÁ CASADO? -->
					<div class="mb-3">
						<label for="input7" class="form-label">¿Está casado/a?</label>
						<c:choose>
							<c:when test="${user.married}">
							  <input class="form-check-input" type="checkbox" name="married" id="defaultCheck1" checked>
							</c:when>
							<c:otherwise>
							  <input class="form-check-input" type="checkbox" name="married" id="defaultCheck1">
							</c:otherwise>
						</c:choose>
						<!--   <input type="radio" id="input7" placeholder="Married" name="married" value="${user.married}">  -->
					</div>
					
					<!-- <input type  --> 
					
					<button type="submit" class="btn btn-primary">Enviar</button>

				</form>
				<a href= "${pageContext.request.contextPath}/UserController?action=LIST">Regresar a la lista de usuarios</a>
			</div>

		</div>

	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

</body>
</html>