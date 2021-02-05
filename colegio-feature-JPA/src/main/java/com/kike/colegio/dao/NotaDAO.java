package com.kike.colegio.dao;

import java.util.List;

import com.kike.colegio.dtos.NotaDTO;


public interface NotaDAO {
	List<NotaDTO> obtenerNotaPorIdNombreAsignaturaNotaFecha(String idAlumno, String nombre, String asignatura, String nota, String fecha); 
	List<NotaDTO> obtenerNotaPorNombreAsignaturaFecha(String nombre, String asignatura, String fecha); 
	Integer insertarNota(String idAlumno, String idAsignatura,String nota, String fecha);
	Integer actualizarNota(String idNota, String idAlumno, String idAsignatura, String nota, String fecha);
	Integer eliminarNota(String id);
}
