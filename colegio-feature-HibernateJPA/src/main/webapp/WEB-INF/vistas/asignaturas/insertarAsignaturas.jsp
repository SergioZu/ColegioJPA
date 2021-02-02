<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


   <%@ page isELIgnored="false"%>
<html>
<head>
	 <link rel="stylesheet" href="css/index.css">
	 <link rel="stylesheet" href="css/formularios.css">
</head>
<body>
<header>
<h2>Inserción de nueva asignatura</h2>
</header>


<%@include file="/menu.html" %>

<div class="container">
	<div class="form"> 
		<form action="http://localhost:8080/colegio/insertarasignaturas" method="post" id="formulario">
		 
		  <label for="id">ID Asignatura</label>
		  <input type="text" id="id" name="id">
		  
		  <label for="nombre">Nombre Asignatura</label>
		  <input type="text" id="nombre" name="nombre"><br>
		  
		  <label for="curso">Curso</label>
		  <input type="text" id="curso" name="curso"><br>
		  
		  <label for="tasa">Tasa</label>
		  <input type="text" id="tasa" name="tasa"><br>
		  
		  <input type="submit" value="Enviar">
		</form> 
		

	</div>
	
		<c:if test="${resultado == 1}" >
   			<b>Alumno insertado correctamente</b>
		</c:if>
</div>





</body>
</html>