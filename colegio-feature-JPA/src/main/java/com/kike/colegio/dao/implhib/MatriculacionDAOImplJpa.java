package com.kike.colegio.dao.implhib;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import com.kike.colegio.dao.MatriculacionDAO;
import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.dtos.MatriculacionDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.entities.AsignaturasEntity;
import com.kike.colegio.entities.CajaEntity;
import com.kike.colegio.entities.MatriculacionesEntity;
import com.kike.colegio.utils.DBUtils;

public class MatriculacionDAOImplJpa implements MatriculacionDAO {

	@Override
	public List<MatriculacionDTO> obtenerMatriculacionesPorIdasigNombreAsigIdalumNombrealumFechaActivo(String idAsig,
			String nombreAsig, String idAlum, String nombreAlum, String fecha, String activo) {
		String jpql = "select new com.kike.colegio.dtos.MatriculacionDTO "
					+ " (m.id, asig.id, asig.nombre, a.id, a.nombre, m.fecha, m.activo) "
					+ " FROM MatriculacionesEntity m, AlumnoEntity a, AsignaturasEntity asig "
					+ " WHERE m.alumnos.id=a.id and  m.asignaturas.id=asig.id and"
					+ " CAST( asig.id AS string ) LIKE :idAsig AND asig.nombre LIKE :nombreAsig"
					+ " AND CAST( a.id AS string ) LIKE :idAlum  AND a.nombre LIKE :aNombre  AND m.fecha LIKE :fecha "
					+ " and  CAST( m.activo AS string ) LIKE :activo";
		
		

		EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		javax.persistence.Query query = em.createQuery(jpql).setParameter("idAsig", "%" + idAsig + "%")
				.setParameter("nombreAsig", "%" + nombreAsig + "%")
				.setParameter("idAlum", "%" + idAlum + "%")
				.setParameter("aNombre", "%" + nombreAlum + "%")
				.setParameter("fecha", "%" + fecha + "%")
				.setParameter("activo", "%" + activo + "%");
		List<MatriculacionDTO> lista = query.getResultList();
		em.close();


		return lista;

			
	}

	@Override
	public Integer insertarMatriculacion(String idAsignatura, String idAlumno, String tasa, String fecha) {
		EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		AlumnoEntity a =em.find(AlumnoEntity.class,Integer.parseInt(idAlumno));
		AsignaturasEntity as =em.find(AsignaturasEntity.class,Integer.parseInt(idAsignatura));
		
		Date cdareDate= new Date(1);
		String fdate=new SimpleDateFormat("yyy-MM-dd").format(cdareDate);
		
		if(fecha=="") {
			fecha=fdate;
		}
		
		MatriculacionesEntity no = new MatriculacionesEntity(a, as, fecha, 1);
		
		CajaEntity cajaEntity=new CajaEntity((no.getId()+1), no,Double.parseDouble(tasa));
		
		
		
		em.persist(no);
		em.persist(cajaEntity);
		em.getTransaction().commit();

		em.close();
		//Obtenemos el valor de la PK insertada para devolverlo
		return (Integer) emf.getPersistenceUnitUtil().getIdentifier(cajaEntity);
	}

	@Override
	public Integer borrarMatriculacion(String idMatricula) {
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		
		s.beginTransaction();
		Query query = s.createQuery("DELETE FROM MatriculacionesEntity where id = :id").setParameter("id", Integer.parseInt(idMatricula));
		int result = query.executeUpdate();		
		s.close();		
		return result;
		
		
	}

	
}