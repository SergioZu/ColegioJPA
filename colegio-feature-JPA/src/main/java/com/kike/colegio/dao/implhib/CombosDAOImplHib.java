package com.kike.colegio.dao.implhib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.kike.colegio.dao.CombosDAO;
import com.kike.colegio.dao.NotaDAO;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.dtos.NotaDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.entities.AsignaturasEntity;
import com.kike.colegio.entities.NotasEntity;
import com.kike.colegio.utils.DBUtils;

public class CombosDAOImplHib implements CombosDAO{

	@Override
	public List<ComboDTO> comboMunicipios() {
		
		String hql = "select new com.kike.colegio.dtos.ComboDTO (a.idMunicipio, a.nombre)" + " FROM MunicipiosEntity a ";
		
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();


		Query query = s.createQuery(hql);
		List<ComboDTO> lista = query.getResultList();
		s.close(); // Cerramos la sesión

		return lista;
	}
	
	@Override
	public List<ComboDTO> comboAlumnos() {
		String hql = "select new com.kike.colegio.dtos.ComboDTO (a.id, a.nombre)" + " FROM AlumnoEntity a ";
		List<ComboDTO> listaAlumnos = new ArrayList<>();
		
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();


		Query query = s.createQuery(hql);
		List<ComboDTO> lista = query.getResultList();
		s.close(); // Cerramos la sesión

		return lista;
	}

	@Override
	public List<ComboDTO> comboAsignaturas() {
		String hql = "select new com.kike.colegio.dtos.ComboDTO (a.id, a.nombre)" + " FROM AsignaturasEntity a ";
		List<ComboDTO> listaAsignaturas = new ArrayList<>();
		
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();


		Query query = s.createQuery(hql);
		List<ComboDTO> lista = query.getResultList();
		s.close(); // Cerramos la sesión

		return lista;
	}
}
