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
		<h2>Listado de notas</h2>
		<div class="form">
			<form action="http://localhost:8080/colegio/listadonotas" method="post">
				<label for="id">Id Alumno</label> 
				<input type="text" id="id"	name="id"> <br> 
				
				<label for="nombre">Nombre Alumno</label> 
				<input type="text" id="nombre" name="nombre"><br>
				
				<label for="asignatura">Asignatura</label> 
				<input type="text" id="asignatura" name="asignatura"><br>
				
				<label for="nota">Nota</label> 
				<input type="text" id="nota" name="nota"><br>
				
				<label for="fecha">Fecha</label> 
				<input type="date" id="fecha" name="fecha"><br>
				
				<input type="submit" value="Enviar">
			</form>

		</div>
		
		<table>
		
		<tr>
			<th>Id Alumno</th>
			<th>Nombre Alumno</th>
			<th>Asignatura</th>
			<th>Nota</th>
			<th>Fecha</th>
		</tr>
		
		<c:forEach items="${lista}" var="nota">
			<tr>
				<td> ${nota.idAlumno}</td>
				<td> ${nota.nombreAlumno}</td>
				<td> ${nota.nombreAsignatura}</td>
				<td> ${nota.nota}</td>
				<td> ${nota.fecha}</td>
			</tr>
		</c:forEach>

	</table>

	</div>
	


</body>
</html>