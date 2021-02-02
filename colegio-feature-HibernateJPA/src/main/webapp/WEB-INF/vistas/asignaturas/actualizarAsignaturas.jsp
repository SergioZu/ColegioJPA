<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/formularios.css">
<link rel="stylesheet" href="css/tablas.css">
</head>
<body>
	<h2>Gestión de colegio</h2>
	<%@include file="/menu.html"%>
	<h2>Modificación de asignaturas</h2>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/colegio/formularioactualizarasignatura" method="post">
				<label for="id">Id Asignatura</label> 
				<input type="text" id="id"	name="id"> 
				<label for="nombre">Nombre Asignatura</label> 
				<input type="text" id="nombre" name="nombre">
				<br> 
				<label for="curso">Curso</label> 
				<input type="text" id="curso" name="curso">
				<label for="curso">Tasa</label> 
				<input type="text" id="tasa" name="tasa">
				<input type="submit" value="Enviar">
			</form>
		</div>	
	
	
		<c:forEach items="${lista}" var="asignatura">
			<div class="form">
				<form action="http://localhost:8080/colegio/actualizarasignatura" method="post">
					<input class="hidden" type="text" name="idOld" id="idOld" value="${asignatura.id}">
					<label for="id">Id Asignatura</label> 
					<input type="text" id="id"	name="id" value="${asignatura.id}"> 
					<label for="nombre">Nombre Asignatura</label> 
					<input type="text" id="nombre" name="nombre" value="${asignatura.nombre}"><br> 
					
					<label for="curso">Curso</label>
					<input type="text" id="curso" name="curso" value="${asignatura.curso}">
					<label for="curso">Tasa</label>
					<input type="text" id="tasa" name="tasa" value="${asignatura.tasa}">
					
					<input type="submit" value="Modificar">
				</form>
			</div>
		</c:forEach>
		
		<c:if test="${resultado == 1}">
			<b>Asignatura modificada correctamente</b>
		</c:if>
	
	</div>
	


</body>
</html>