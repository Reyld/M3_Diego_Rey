<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfil del usuario</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">	
</head>
<body>
	<h1> Este es el perfil del usuario ${user.id}</h1>
	<br>
		<a href= "${pageContext.request.contextPath}/UserController?action=LIST">Regresar a la lista de usuarios</a><hr>
		<br>
	<b>Nombre:</b> ${user.firstname}	<hr>
	<b>Apellido:</b> ${user.lastname} <hr>
	<b>Edad:</b> ${user.age}<hr>
	<b>NIF: </b>${user.nif}<hr>
	<b>Email:  </b>${user.email}<hr>
	<b>Contraseña: </b>ESTE CAMPO EST&Aacute; RESTRINGIDO. <hr>
	<b>¿Esta casado?: </b>${user.married} <hr>
	

</body>
</html>