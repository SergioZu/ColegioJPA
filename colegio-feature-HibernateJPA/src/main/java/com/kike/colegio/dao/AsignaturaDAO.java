package com.kike.colegio.dao;

import java.util.List;

import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.dtos.AsignaturaDTO;

public interface AsignaturaDAO {
	

	List<AsignaturaDTO> obtenerAsignaturaPorIdNombreCursoTasa(String id, String nombre, String curso , String tasa);
	Integer insertarAsignatura(String id, String nombre, String curso, String tasa);
	Integer actualizarAsignatura(String idOld, String idNew, String nombre, String curso, String tasa);
	Integer eliminarAsignatura (String id);
	int obtenerNumeroAsignaturasMatriculadas(String idAlumno);
	double obtenerTasaAsignatura(String idAsignatura);
}
