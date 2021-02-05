<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


   <%@ page isELIgnored="false"%>
<html>
<head>
	 <link rel="stylesheet" href="css/index.css">
	 <link rel="stylesheet" href="css/formularios.css">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	 <script>
	 $(document).ready(function(){
		$(document).on('change','#alumnos, #asignaturas', function(){
			$.ajax({
					  type: "POST",
					  url: 'http://localhost:8080/colegio/tasa',
					  data: {
						 alumnos: $("#alumnos").val(),
						 asignaturas: $("#asignaturas").val(),
						 fecha: $("fecha").val()
					  },
					  success: function(data) {
						 $('#tasa').val(data)
					  }
			});
		});
	 });
	 
	 

	 </script>
</head>
<body>
<header>
<h2>Inserción de nueva matrícula</h2>
</header>


<%@include file="/menu.html" %>

<div class="container">
	<div class="form" id="formulario"> 
		<form action="http://localhost:8080/colegio/insertarmatriculacion" method="post" >
		 
		  		<label for="alumnos">Alumnos</label> 								
				<select name="alumnos"  id="alumnos">		
					<c:forEach items="${listaAlumnos}" var="alumno">			
						<option value="${alumno.id}">${alumno.id}-${alumno.descripcion} </option>
					</c:forEach>
				</select>
				
				<label for="asignaturas">Asignaturas</label> 								
				<select name="asignaturas"  id="asignaturas">		
					<c:forEach items="${listaAsignaturas}" var="asignatura">			
						<option value="${asignatura.id}">${asignatura.id}-${asignatura.descripcion} </option>
					</c:forEach>
				</select> <br>
				
				<label for="tasa">Tasa</label> 	
				<input readonly type="text" id="tasa" name="tasa"><br>
				
				<label for="fecha">Fecha</label>
				<input type="date" name="fecha" id="fecha"/> <br>
		  
		  		<input type="submit" value="Insertar">
		</form> 	

	</div>
	
		<c:if test="${resultado == 1}" >
   			<b>Matriculación insertada correctamente</b>
		</c:if>
</div>

<div id="respuesta"></div>



</body>
</html>