package com.kike.colegio.dao;

import java.util.List;

import com.kike.colegio.dtos.AlumnoDTO;

public interface AlumnoDAO {
	
	Integer insertarAlumno(String id, String nombre, String idMunicipio, String famNumerosa);
	
	
	List<AlumnoDTO> obtenerTodosAlumnos();
	List<AlumnoDTO> obtenerAlumnosporIdyNombre(String id, String nombre);
	Integer actualizarAlumno(String idOld, String idNew, String nombre, String idMunicipio, String famNumerosa);
	Integer borrarAlumno (String id);
	public boolean esFamiliaNumerosa(String idAlumno);
}
