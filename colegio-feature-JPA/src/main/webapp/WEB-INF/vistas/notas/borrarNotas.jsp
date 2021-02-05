<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Colegio</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/formularios.css">
<link rel="stylesheet" href="css/tablas.css">
</head>
<body>
	<h2>Gestión de colegio</h2>
	<%@include file="/menu.html"%>
	
	<div class="container">
	<h2>Borrar nota</h2>
		<div class="form">
			<form action="http://localhost:8080/colegio/formularioborrarnota" method="post">
				<label for="nombre">Nombre Alumno</label> 
				<input type="text" id="nombre"	name="nombre"> 
				<label for="asignatura">Asignatura</label> 
				<input type="text" id="asignatura" name="asignatura">
				<br> 
				<label for="fecha">Fecha</label>
				<input type="date" id="fehca" name="fecha">
				<input type="submit" value="Enviar">
			</form>
		</div>	
		
		<c:forEach items="${lista}" var="nota">
			<div class="form">
				<form action="http://localhost:8080/colegio/borrarnota" method="post">
				
					<input class="hidden" type="text" name="idNota" id="idNota" value="${nota.id}">
					
					<label for="nombre">Alumno</label>
					<input type="text" id="nombre" name="nombre" value="${ nota.nombreAlumno}" readonly>
					
					<label for="asignatura">Asignatura</label>
					<input type="text" id="asignatura" name="asignatura" value="${ nota.nombreAsignatura}" readonly>
					<br>
					<label for="nota">Nota</label>
					<input type="text" id="nota" name="nota" value="${ nota.nota}" readonly>
					
					<label for="fecha">Fecha</label>
					<input type="date" id="fehca" name="fecha" value="${ nota.fecha}" readonly>
					
					<input type="submit" value="Eliminar">
				</form>
			</div>
		</c:forEach>
		
		<c:if test="${resultado == 1 }">
			<h3>Nota borrada correctamente</h3>
		</c:if>
	
	</div> <!-- Fin container -->
	