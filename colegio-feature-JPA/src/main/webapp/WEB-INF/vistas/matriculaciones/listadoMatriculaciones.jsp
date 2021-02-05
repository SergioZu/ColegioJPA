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
	<h2>Listado de Matriculaciones</h2>
	<%@include file="/menu.html"%>
	
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/colegio/listadomatriculaciones" method="post">
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
		
		<table>
		
		<tr>
			<th>Id Asignatura</th>
			<th>Nombre Asignatura</th>
			<th>Id Alumno</th>
			<th>Nombre Alumno</th>
			<th>Fecha</th>
			<th>Activo</th>
		</tr>
		
		<c:forEach items="${lista}" var="matriculacion">
			<tr>
				<td> ${matriculacion.idAsignatura}</td>
				<td> ${matriculacion.nombreAsignatura}</td>
				<td> ${matriculacion.idAlumno}</td>
				<td> ${matriculacion.nombreAlumno}</td>
				<td> ${matriculacion.fecha}</td>
				<td> 
					<c:if test="${matriculacion.activo == 1 }">
						<input type="checkbox" name="activo" id="activo" value="1" readonly="readonly" checked onclick="javascript: return false;">
					</c:if>
				</td>
			</tr>
		</c:forEach>

	</table>

	</div>
	


</body>
</html>