package com.kike.colegio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.utils.DBUtils;

public class AlumnoDAOImpl implements AlumnoDAO {

	private static Logger logger = LoggerFactory.getLogger(AlumnoDAOImpl.class);
	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() {

		List<AlumnoDTO> listaAlumnos = new ArrayList<>();

		try {
			Connection connection = DBUtils.DBConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM ALUMNOS");

			while (rs.next()) {
				AlumnoDTO a = new AlumnoDTO(rs.getInt(1), rs.getString(2), "");
				listaAlumnos.add(a);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaAlumnos;
	}

	@Override
	public List<AlumnoDTO> obtenerAlumnosporIdyNombre(String id, String nombre) {
		// String sql = "SELECT * FROM alumnos WHERE id LIKE ? AND nombre LIKE ?";
		logger.info("Inicio método obtenerAlumnosporIdyNombre");
		String sql = "SELECT a.id, a.nombre, m.nombre, m.id_municipio, a.familia_numerosa " + "FROM alumnos a, municipios m "
				+ "WHERE  a.id_municipio = m.id_municipio " + "AND a.id LIKE ? AND a.nombre LIKE ?";

		ResultSet alumnoResultSet = null;
		Connection connection = DBUtils.DBConnection();
		List<AlumnoDTO> listaAlumnos = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + nombre + "%");
			
			logger.info("Query a ejecutar" + ps);

			alumnoResultSet = ps.executeQuery();

			while (alumnoResultSet.next()) {
				AlumnoDTO a = new AlumnoDTO(alumnoResultSet.getInt(1), alumnoResultSet.getString(2),
						alumnoResultSet.getString(3), alumnoResultSet.getInt(4), alumnoResultSet.getInt(5));
				listaAlumnos.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAlumnos;
	}

	@Override
	public Integer insertarAlumno(String id, String nombre, String idMunicipio, String famNumerosa) {
		String sql = "INSERT INTO alumnos (id, nombre, id_municipio, familia_numerosa) VALUES (?, ?, ?, ?)";
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		if (famNumerosa == null) famNumerosa = "0";

		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, nombre);
			ps.setString(3, idMunicipio);
			ps.setString(4, famNumerosa);

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
	public Integer actualizarAlumno(String idOld, String idNew, String nombre, String idMunicipio , String famNumerosa) {
		String sql = "UPDATE alumnos SET id= ?, nombre = ? ,id_municipio = ?, familia_numerosa = ? WHERE id = ?";

		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;

	
		

		
		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, idNew);
			ps.setString(2, nombre);
			ps.setString(3, idMunicipio);
			ps.setString(4, famNumerosa);
			ps.setString(5, idOld);
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
	public Integer borrarAlumno(String id) {
		String sql = "DELETE FROM alumnos WHERE id = ?";

		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;

		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, id);

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
	public boolean esFamiliaNumerosa(String idAlumno) {
		String sql = "SELECT familia_numerosa FROM alumnos WHERE id LIKE ?";
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int famNumerosa = 0;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, idAlumno);					
			
			rs = ps.executeQuery();
			rs.next();
			famNumerosa = rs.getInt(1);
			
			if(famNumerosa==1) {
				return true;
			}
			
			
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
		
		return false;
		
	}

}
