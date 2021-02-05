<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Matriculaciones</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/formularios.css">
<link rel="stylesheet" href="css/tablas.css">
</head>
<body>
	<h2>Gestión de colegio</h2>
	<%@include file="/menu.html"%>
	
	<div class="container">
		<h2>Borrar matriculaciones</h2>
		<div class="form">
			<form action="http://localhost:8080/colegio/formularioborrarmatriculaciones" method="post">
				<label for="idAsig">Id Asignatura</label> 
				<input type="text" id="idAsig"	name="idAsig"> 
				<label for="nombreAsig">Nombre Asignatura</label> 
				<input type="text" id="nombreAsig" name="nombreAsig">
				<br> 
				<label for="idAlum">Id Alumno</label> 
				<input type="text" id="idAlum"	name="idAlum"> 
				<label for="nombreAlum">Nombre Alum</label> 
				<input type="text" id="nombreAlum" name="nombreAlum">
				<br>
				<label for="fecha">Fecha</label> 
				<input type="date" id="fecha" name="fecha">			
				
				<label for="activo">Activo</label>	
				<input type="checkbox" name="activo" id="activo" value="1" readonly="readonly" checked onclick="javascript: return false;">
				
				<input type="submit" value="Enviar">
			</form>

		</div>	
		
		<c:forEach items="${lista}" var="matriculacion">
			<div class="form">
			<form action="http://localhost:8080/colegio/borrarmatriculaciones" method="post">
				<input class="hidden" type="text" name="idMatricula" id="idMatricula" value="${matriculacion.id}">
				<label for="idAsig">Id Asignatura</label> 
				<input type="text" id="idAsig"	name="idAsig" value="${matriculacion.idAsignatura }" readonly> 
				<label for="nombreAsig">Nombre Asignatura</label> 
				<input type="text" id="nombreAsig" name="nombreAsig" value="${matriculacion.nombreAsignatura }" readonly>
				<br> 
				<label for="idAlum">Id Alumno</label> 
				<input type="text" id="idAlum"	name="idAlum" value="${matriculacion.idAlumno }" readonly> 
				<label for="nombreAlum">Nombre Alumno</label> 
				<input type="text" id="nombreAlum" name="nombreAlum" value="${matriculacion.nombreAlumno }" readonly>
				<br>
				<label for="fecha">Fecha</label> 
				<input type="date" id="fecha" name="fecha" value="${matriculacion.fecha }" readonly>			
				
				<label for="activo">Activo</label>	
				<c:if test="${matriculacion.activo == 1 }">
					<input type="checkbox" name="activo" id="activo" value="1" readonly="readonly" checked onclick="javascript: return false;">
				</c:if>
				<c:if test="${matriculacion.activo != 1 }">
					<input type="checkbox" name="activo" id="activo" readonly="readonly" onclick="javascript: return false;">
				</c:if>						
				
				<input type="submit" value="Borrar">
			</form>

		</div>
		</c:forEach>
		
		<c:if test="${resultado == 1 }">
			<b>Matrícula borrada correctamente correctamente</b>
		</c:if>
	
	</div> <!-- Fin container -->
	