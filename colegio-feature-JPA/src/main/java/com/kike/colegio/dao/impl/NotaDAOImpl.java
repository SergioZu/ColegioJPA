package com.kike.colegio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kike.colegio.dao.NotaDAO;
import com.kike.colegio.dtos.NotaDTO;
import com.kike.colegio.utils.DBUtils;

public class NotaDAOImpl implements NotaDAO {

	@Override
	public List<NotaDTO> obtenerNotaPorIdNombreAsignaturaNotaFecha(String idAlumno, String nombre, String asignatura,
			String nota, String fecha) {
		String sql = "SELECT a.id, a.nombre, asig.id, asig.nombre, n.nota, n.fecha, n.id "
				+ " FROM alumnos a "
				+ " JOIN notas n on a.id = n.id_alumnos "
				+ " JOIN asignaturas asig on asig.id = n.id_asignaturas "
				+ " WHERE a.id like ? AND a.nombre like ? AND asig.nombre like ? AND n.nota like ? AND n.fecha >= ?";
		
		String sqlFechaVacia = "SELECT a.id, a.nombre, asig.id, asig.nombre, n.nota, n.fecha, n.id "
				+ " FROM alumnos a "
				+ " JOIN notas n on a.id = n.id_alumnos "
				+ " JOIN asignaturas asig on asig.id = n.id_asignaturas "
				+ " WHERE a.id like ? AND a.nombre like ? AND asig.nombre like ? AND n.nota like ?";

		Connection connection = DBUtils.DBConnection();
		ResultSet notaRs = null;
		List<NotaDTO> listaNotas = new ArrayList<>();
		PreparedStatement ps = null;

		try {
			
			if(fecha == "") {
				ps = connection.prepareStatement(sqlFechaVacia);				
				ps.setString(1, "%" +idAlumno+ "%");
				ps.setString(2, "%" +nombre+ "%");
				ps.setString(3, "%" +asignatura+ "%");
				ps.setString(4, "%" +nota+ "%");
				
			}else {
				ps = connection.prepareStatement(sql);				
				ps.setString(1, "%" +idAlumno+ "%");
				ps.setString(2, "%" +nombre+ "%");
				ps.setString(3, "%" +asignatura+ "%");
				ps.setString(4, "%" +nota+ "%");
				ps.setString(5, fecha);
			}	
			
			notaRs = ps.executeQuery();

			while (notaRs.next()) {

				NotaDTO a = new NotaDTO(notaRs.getInt(7),notaRs.getInt(1), notaRs.getString(2), notaRs.getInt(3), notaRs.getString(4), notaRs.getDouble(5), notaRs.getString(6));
				listaNotas.add(a);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {			
			try {
				ps.close();
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		return listaNotas;
	}

	@Override
	public Integer insertarNota(String idAlumno, String idAsignatura, String nota, String fecha) {
		String sql = "INSERT INTO notas (id_alumnos,id_asignaturas,nota,fecha)  VALUES (?, ?, ?, ?);";
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, idAlumno);
			ps.setString(2, idAsignatura);
			ps.setString(3, nota);
			
			if (fecha == "") {
				Date cDate = new Date();
			    String fDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate);
				ps.setString(4, fDate);
			}else {
				ps.setString(4, fecha);
			}			
			
			resultado = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}

	@Override
	public List<NotaDTO> obtenerNotaPorNombreAsignaturaFecha(String nombre, String asignatura, String fecha) {
		String sql = "SELECT a.id, a.nombre, asig.id, asig.nombre, n.nota, n.fecha, n.id "
				+ " FROM alumnos a "
				+ " JOIN notas n on a.id = n.id_alumnos "
				+ " JOIN asignaturas asig on asig.id = n.id_asignaturas "
				+ " WHERE a.nombre like ? AND asig.nombre like ? AND n.fecha >= ?";
		
		String sqlFechaVacia = "SELECT a.id, a.nombre, asig.id, asig.nombre, n.nota, n.fecha, n.id "
				+ " FROM alumnos a "
				+ " JOIN notas n on a.id = n.id_alumnos "
				+ " JOIN asignaturas asig on asig.id = n.id_asignaturas "
				+ " WHERE a.nombre like ? AND asig.nombre like ?";

		Connection connection = DBUtils.DBConnection();
		ResultSet notaRs = null;
		List<NotaDTO> listaNotas = new ArrayList<>();
		PreparedStatement ps = null;

		try {
			
			if(fecha == "") {
				ps = connection.prepareStatement(sqlFechaVacia);				
				ps.setString(1, "%" +nombre+ "%");
				ps.setString(2, "%" +asignatura+ "%");
				
			}else {
				ps = connection.prepareStatement(sql);				
				ps.setString(1, "%" +nombre+ "%");
				ps.setString(2, "%" +asignatura+ "%");
				ps.setString(3, fecha);
			}	

			notaRs = ps.executeQuery();

			while (notaRs.next()) {

				NotaDTO a = new NotaDTO(notaRs.getInt(7), notaRs.getInt(1), notaRs.getString(2), notaRs.getInt(3), notaRs.getString(4), notaRs.getDouble(5), notaRs.getString(6));
				listaNotas.add(a);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {			
			try {
				ps.close();
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		return listaNotas;
	}

	@Override
	public Integer actualizarNota(String idNota, String idAlumno, String idAsignatura, String nota, String fecha) {		
		
		String sql = "UPDATE notas SET id_alumnos= ?, id_asignaturas = ?, nota = ?, fecha = ? WHERE id = ?;";
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, idAlumno);
			ps.setString(2, idAsignatura);
			ps.setString(3, nota);
			ps.setString(4, fecha);
			ps.setString(5, idNota);
			
			resultado = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}

	@Override
	public Integer eliminarNota(String id) {
		String sql = "DELETE FROM notas WHERE id = ?;";
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			
			resultado = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}

	
}
