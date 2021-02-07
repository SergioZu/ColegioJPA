package com.kike.colegio.dao.impljpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.kike.colegio.dao.CombosDAO;
import com.kike.colegio.dao.NotaDAO;
import com.kike.colegio.dtos.AsignaturaDTO;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.dtos.NotaDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.entities.AsignaturasEntity;
import com.kike.colegio.entities.NotasEntity;
import com.kike.colegio.utils.DBUtils;

public class CombosDAOImplJpa implements CombosDAO{

	@Override
	public List<ComboDTO> comboMunicipios() {
		
		String hql = "select new com.kike.colegio.dtos.ComboDTO (a.idMunicipio, a.nombre)" + " FROM MunicipiosEntity a ";
		
		EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		javax.persistence.Query query = em.createQuery(hql);
		List<ComboDTO> lista = query.getResultList();
		em.close();


		return lista;
	}
	
	@Override
	public List<ComboDTO> comboAlumnos() {
		String hql = "select new com.kike.colegio.dtos.ComboDTO (a.id, a.nombre)" + " FROM AlumnoEntity a ";
		EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		javax.persistence.Query query = em.createQuery(hql);
		List<ComboDTO> lista = query.getResultList();
		em.close();


		return lista;
	}

	@Override
	public List<ComboDTO> comboAsignaturas() {
		String hql = "select new com.kike.colegio.dtos.ComboDTO (a.id, a.nombre)" + " FROM AsignaturasEntity a ";
		EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		javax.persistence.Query query = em.createQuery(hql);
		List<ComboDTO> lista = query.getResultList();
		em.close();


		return lista;
	}
}
