package com.kike.colegio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kike.colegio.dao.AsignaturaDAO;
import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.dtos.AsignaturaDTO;
import com.kike.colegio.utils.DBUtils;

public class AsignaturaDAOImpl implements AsignaturaDAO{

	@Override
	public List<AsignaturaDTO> obtenerAsignaturaPorIdNombreCursoTasa(String id, String nombre, String curso, String tasa) {
		String sql = "SELECT * FROM asignaturas WHERE id LIKE ? AND nombre LIKE ?  AND curso LIKE ? AND tasa LIKE ?";
		ResultSet asignaturasResultSet = null;
		Connection connection = DBUtils.DBConnection();
		List<AsignaturaDTO> listaAsignaturas = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + nombre + "%");
			ps.setString(3, "%" + curso + "%");
			ps.setString(4, "%" + tasa + "%");

			asignaturasResultSet = ps.executeQuery();

			while (asignaturasResultSet.next()) {
				AsignaturaDTO a = new AsignaturaDTO(asignaturasResultSet.getString(1), asignaturasResultSet.getString(2), 
											asignaturasResultSet.getString(3), asignaturasResultSet.getString(4));
				listaAsignaturas.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAsignaturas;
	}

	@Override
	public Integer insertarAsignatura(String id, String nombre, String curso, String tasa) {
		String sql = "INSERT INTO asignaturas (id, nombre, curso, tasa) VALUES (?, ?, ?, ?)";
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;

		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, nombre);
			ps.setString(3, curso);
			ps.setString(4, tasa);

			resultado = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return resultado;
	}
	@Override
	public Integer actualizarAsignatura(String idOld, String idNew, String nombre, String curso, String tasa) {
		String sql = "UPDATE asignaturas SET id=?, nombre=?, curso=?, tasa=?  WHERE id = ?;";
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, idNew);
			ps.setString(2, nombre);
			ps.setString(3, curso);
			ps.setString(4, tasa);
			ps.setString(5, idOld);
			
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
	public Integer eliminarAsignatura(String id) {
		String sql = "DELETE FROM asignaturas WHERE id = ?;";
		
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
	
	@Override
	public int obtenerNumeroAsignaturasMatriculadas(String idAlumno) {
		
		String sql = "SELECT count(*) FROM matriculaciones WHERE id_alumno = ?;";
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		int numAsigMatriculadas = 0;
		ResultSet rs = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, idAlumno);					
			
			rs = ps.executeQuery();
			rs.next();
			numAsigMatriculadas = rs.getInt(1);			
			
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
		
		return numAsigMatriculadas;
		
	}
	
	public double obtenerTasaAsignatura(String idAsignatura) {
		String sql = "SELECT tasa FROM asignaturas WHERE id LIKE ?";
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		double tasa = 0;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, idAsignatura);				
			
			rs = ps.executeQuery();
			rs.next();
			tasa = rs.getInt(1);
						
			
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
		
		return tasa;
	}
}
