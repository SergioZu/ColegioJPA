<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


   <%@ page isELIgnored="false"%>
<html>
<head>
	 <link rel="stylesheet" href="css/index.css">
	 <link rel="stylesheet" href="css/formularios.css">
	 <title>Colegio</title>
</head>
<body>
<header>
<h2>Gestión de Colegio</h2>
</header>


<%@include file="/menu.html" %>
<h2>Insertar Notas</h2>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/colegio/insertarnota" method="post" id="formulario">
				<label for="alumnos">Alumnos</label> 								
				<select name="alumnos" form="formulario" >		
					<c:forEach items="${listaAlumnos}" var="alumno">			
						<option value="${alumno.id}">${alumno.id}-${alumno.descripcion} </option>
					</c:forEach>
				</select>
				
				<label for="asignaturas">Asignaturas</label> 								
				<select name="asignaturas" form="formulario" >		
					<c:forEach items="${listaAsignaturas}" var="asignatura">			
						<option value="${asignatura.id}">${asignatura.id}-${asignatura.descripcion} </option>
					</c:forEach>
				</select>
				
				<br>
				<label for="nota">Nota</label>
				<input type="nota" id="nota" name="nota">
				
				<label for="fecha">Fecha</label>
				<input type="date" id="fehca" name="fecha">
				<br>
				
				<input type="submit" value="Enviar">
			</form>
		</div>
		
		<c:if test="${resultado == 1}">
			<b>Nota insertada correctamente</b>
		</c:if>

	</div>



</body>
</html>