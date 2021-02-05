package com.kike.colegio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kike.colegio.dao.MatriculacionDAO;
import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.dtos.MatriculacionDTO;
import com.kike.colegio.dtos.NotaDTO;
import com.kike.colegio.utils.DBUtils;

public class MatriculacionDAOImpl implements MatriculacionDAO {

	@Override
	public List<MatriculacionDTO> obtenerMatriculacionesPorIdasigNombreAsigIdalumNombrealumFechaActivo(String idAsig,
			String nombreAsig, String idAlum, String nombreAlum, String fecha, String activo) {
		String sql = "SELECT asig.id, asig.nombre, a.id, a.nombre, m.fecha, m.activo, m.id "
				+ "FROM asignaturas asig JOIN matriculaciones m ON asig.id = m.id_asignatura "
				+ "JOIN alumnos a ON a.id = m.id_alumno "
				+ "WHERE asig.id LIKE ? AND asig.nombre LIKE ? AND a.id LIKE ? AND a.nombre LIKE ? AND m.fecha >= ? AND m.activo = ?;";
		
		String sqlFechaVacia = "SELECT asig.id, asig.nombre, a.id, a.nombre, m.fecha, m.activo, m.id "
				+ "FROM asignaturas asig JOIN matriculaciones m ON asig.id = m.id_asignatura "
				+ "JOIN alumnos a ON a.id = m.id_alumno "
				+ "WHERE asig.id LIKE ? AND asig.nombre LIKE ? AND a.id LIKE ? AND a.nombre LIKE ? AND m.activo = ?;";

		Connection connection = DBUtils.DBConnection();
		ResultSet MatriculacionRs = null;
		List<MatriculacionDTO> listaMatriculaciones = new ArrayList<>();
		PreparedStatement ps = null;
		
		if(activo == null) {
			activo = "0";
		}

		try {
			
			if(fecha == "") {
				ps = connection.prepareStatement(sqlFechaVacia);				
				ps.setString(1, "%" +idAsig+ "%");
				ps.setString(2, "%" +nombreAsig+ "%");
				ps.setString(3, "%" +idAlum+ "%");
				ps.setString(4, "%" +nombreAlum+ "%");				
				ps.setString(5, activo);
				
			}else {
				ps = connection.prepareStatement(sql);				
				ps.setString(1, "%" +idAsig+ "%");
				ps.setString(2, "%" +nombreAsig+ "%");
				ps.setString(3, "%" +idAlum+ "%");
				ps.setString(4, "%" +nombreAlum+ "%");
				ps.setString(5, fecha);
				ps.setString(6, activo);
			}	
			
			MatriculacionRs = ps.executeQuery();

			while (MatriculacionRs.next()) {

				MatriculacionDTO m = new MatriculacionDTO(MatriculacionRs.getInt(7) ,MatriculacionRs.getInt(1), MatriculacionRs.getString(2), MatriculacionRs.getInt(3), 
						MatriculacionRs.getString(4), MatriculacionRs.getString(5), MatriculacionRs.getInt(6));
				
				listaMatriculaciones.add(m);

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

		return listaMatriculaciones;
	}

	@Override
	public Integer insertarMatriculacion(String idAsignatura, String idAlumno, String tasa, String fecha) {
		String sql1 = "INSERT INTO matriculaciones (id_asignatura, id_alumno, fecha, activo) VALUES (?, ?, ?, 1);";
		String sql2 = "INSERT INTO caja (idmatricula, importe) VALUES (?, ?)";
		
		String sqlIdMatricula = "SELECT id FROM matriculaciones WHERE id_asignatura = ? AND id_alumno = ?;";
		
		if (fecha == "") {
			Date cDate = new Date();
			fecha = new SimpleDateFormat("yyyy-MM-dd").format(cDate);			 
		}	
		
		Connection connection = DBUtils.DBConnection();
		
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement psId = null;
		ResultSet rs = null;
		Integer resultado = null;
		
		try {			
			connection.setAutoCommit(false);
			
			ps1 = connection.prepareStatement(sql1);
			ps1.setString(1, idAsignatura);
			ps1.setString(2, idAlumno);		
			ps1.setString(3, fecha);
			
			ps1.executeUpdate();
			
			//Recupero el id de la matrícula insetada
			psId = connection.prepareStatement(sqlIdMatricula);
			psId.setString(1, idAsignatura);
			psId.setString(2, idAlumno);
			
			rs = psId.executeQuery();
			rs.next();
			
			ps2 = connection.prepareStatement(sql2);
			ps2.setString(1, rs.getString(1)); //Paso el id recuprado de la select anterior
			ps2.setString(2, tasa);				
			
			resultado = ps2.executeUpdate();
			
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				ps1.close();
				ps2.close();
				psId.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}

	@Override
	public Integer borrarMatriculacion(String idMatricula) {
		String sql1 = "DELETE FROM caja WHERE idmatricula = ?;";
		String sql2 = "DELETE FROM matriculaciones WHERE id = ?;";
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		Integer resultado = null;
		
		try {
			
			connection.setAutoCommit(false);
			
			ps1 = connection.prepareStatement(sql1);
			ps1.setString(1, idMatricula);
			ps1.executeUpdate();
			
			ps2 = connection.prepareStatement(sql2);
			ps2.setString(1, idMatricula);
			resultado = ps2.executeUpdate();
			
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				ps1.close();
				ps2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}

}
