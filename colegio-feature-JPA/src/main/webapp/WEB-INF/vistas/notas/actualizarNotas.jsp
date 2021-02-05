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
		<h2>Modificación de notas</h2>
		<div class="form">
			<form action="http://localhost:8080/colegio/formularioactualizarnota" method="post">
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
	
	
		<c:forEach items="${lista}" var="notas">
			<div class="form">
				<form action="http://localhost:8080/colegio/actualizarnota" method="post">
					<input class="hidden" type="text" name="idNota" id="idNota" value="${notas.id}">
					<label for="alumnos">Alumnos</label> 								
					<select name="alumnos" >		
						<c:forEach items="${listaAlumnos}" var="alumno">			
							<option value="${alumno.id}">${alumno.id}-${alumno.descripcion} </option>
						</c:forEach>
						<option value="${notas.idAlumno}" selected>${notas.idAlumno}-${notas.nombreAlumno}</option>
					</select>
					
					<label for="asignaturas">Asignaturas</label> 						
					<select name="asignaturas"  >		
						<c:forEach items="${listaAsignaturas}" var="asignatura">			
							<option value="${asignatura.id}">${asignatura.id}-${asignatura.descripcion} </option>
						</c:forEach>
						<option value="${notas.idAsignatura}" selected>${notas.idAsignatura}-${notas.nombreAsignatura} </option>
					</select>
					<br>
					
					<label for="nota">Nota</label>
					<input type="text" id="nota" name="nota" value="${ notas.nota}">
					
					<label for="fecha">Fecha</label>
					<input type="date" id="fehca" name="fecha" value="${ notas.fecha}">
					
					<input type="submit" value="Modificar">
				</form>
			</div>
		</c:forEach>
		
		<c:if test="${resultado == 1 }">
			<h3>Nota modificada correctamente</h3>
		</c:if>
	
	</div>
	


</body>
</html>