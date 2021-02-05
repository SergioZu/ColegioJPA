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
	
	<div class="container">
		<h2>Borrar asignatura</h2>
		<div class="form">
			<form action="http://localhost:8080/colegio/formularioborrarasignatura" method="post">
				<label for="id">Id Asignatura</label> 
				<input type="text" id="id"	name="id"> 
				<label for="nombre">Nombre Asignatura</label> 
				<input type="text" id="nombre" name="nombre">
				<br> 
				<label for="curso">Curso</label> 
				<input type="text" id="curso" name="curso">
				<label for="tasa">Tasa</label> 
				<input type="text" id="tasa" name="tasa">
				<input type="submit" value="Enviar">
			</form>
		</div>	
		
		<c:forEach items="${lista}" var="asignatura">
			<div class="form">
				<form action="http://localhost:8080/colegio/borrarasignatura" method="post">
				
					<label for="id">Id Asignatura</label> 
					<input type="text" id="id"	name="id" value="${asignatura.id}" readonly> 
					
					<label for="nombre">Nombre Asignatura</label> 
					<input type="text" id="nombre" name="nombre" value="${asignatura.nombre}" readonly><br> 
					
					<label for="curso">Curso</label> 					
					<input type="text" id="curso" name="curso" value="${asignatura.curso}" readonly>					
					
					<label for="tasa">Tasa</label> 					
					<input type="text" id="tasa" name="tasa" value="${asignatura.tasa}" readonly>	
					
					<input type="submit" value="Borrar">
				</form>
			</div>
		</c:forEach>
		
		<c:if test="${resultado == 1 }">
			<b>La asignatura ha sido borrada con éxito</b>
		</c:if>
	
	</div> <!-- Fin container -->
	