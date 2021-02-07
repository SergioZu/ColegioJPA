package com.kike.colegio.dao.impljpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.kike.colegio.dao.NotaDAO;
import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.dtos.NotaDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.entities.AsignaturasEntity;
import com.kike.colegio.entities.NotasEntity;
import com.kike.colegio.utils.DBUtils;

public class NotaDAOImplJpa implements NotaDAO{

	@Override
	public List<NotaDTO> obtenerNotaPorIdNombreAsignaturaNotaFecha(String idAlumno, String nombre, String asignatura,
			String nota, String fecha) {
		
			String jpql = "select new com.kike.colegio.dtos.NotaDTO"
					+ " (n.id, a.id, a.nombre, asig.id, asig.nombre, n.nota, n.fecha) "
					+ "FROM NotasEntity n,  AlumnoEntity a, AsignaturasEntity asig  "
					+ "where  n.alumnos.id=a.id and  n.asignaturas.id=asig.id and  CAST( a.id AS string )  LIKE :idAlumno AND a.nombre LIKE :nombre and asig.nombre LIKE :asignatura "
					+ "  AND CAST( n.nota AS string )  LIKE :nota  AND n.fecha  LIKE :fecha ";

			

			EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			javax.persistence.Query query = em.createQuery(jpql).setParameter("idAlumno", "%" + idAlumno + "%")
					.setParameter("nombre", "%" + nombre + "%")
					.setParameter("asignatura", "%" + asignatura + "%")
					.setParameter("nota", "%" + nota + "%")
					.setParameter("fecha", "%" + fecha + "%");
			List<NotaDTO> lista = query.getResultList();
			em.close();


			return lista;
	}

	@Override
	public List<NotaDTO> obtenerNotaPorNombreAsignaturaFecha(String nombre, String asignatura, String fecha) {
		String jpql = "select new com.kike.colegio.dtos.NotaDTO"
				+ " (n.id, a.id, a.nombre, asig.id, asig.nombre, n.nota, n.fecha) "
				+ "FROM NotasEntity n,  AlumnoEntity a, AsignaturasEntity asig  "
				+ "where a.nombre LIKE :nombre and asig.nombre LIKE :asignatura "
				+ "and n.fecha  LIKE :fecha ";
		

		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();

		Query query = s.createQuery(jpql)
				.setParameter("nombre", "%" + nombre + "%")
				.setParameter("asignatura", "%" + asignatura + "%")
				.setParameter("fecha", "%" + fecha + "%");
		
		List<NotaDTO> lista = query.getResultList();

		s.close(); // Cerramos la sesión

		return lista;
	}

	@Override
	public Integer insertarNota(String idAlumno, String idAsignatura, String nota, String fecha) {
		
		
		EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		
		
		AlumnoEntity a =em.find(AlumnoEntity.class,Integer.parseInt(idAlumno));
		AsignaturasEntity as =em.find(AsignaturasEntity.class,Integer.parseInt(idAsignatura));
		
		NotasEntity no = new NotasEntity(a, as, Double.parseDouble(nota), fecha);
		em.persist(no);
		
		em.getTransaction().commit();

		em.close();
		//Obtenemos el valor de la PK insertada para devolverlo
		return (Integer) emf.getPersistenceUnitUtil().getIdentifier(no);
	}

	@Override
	public Integer actualizarNota(String idNota, String idAlumno, String idAsignatura, String nota, String fecha) {
		
		
		

		EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		AlumnoEntity a =em.find(AlumnoEntity.class,Integer.parseInt(idAlumno));
		AsignaturasEntity as =em.find(AsignaturasEntity.class,Integer.parseInt(idAsignatura));
		
		NotasEntity no = em.find(NotasEntity.class, Integer.parseInt(idNota));		
		//Actualizamos sus valores con los nuevos
		
		no.setAlumnos(a);
		no.setAsignaturas(as);
		no.setNota(Double.parseDouble(nota));
		no.setFecha(fecha);
		
		//La entidad es automáticamente actualizada cuando se hace commit
        em.getTransaction().commit();
        em.close();

		return a.getId();
	}

	@Override
	public Integer eliminarNota(String id) {
		
		EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		//Recuperamos la entidad a borrar
		NotasEntity a = em.find(NotasEntity.class, Integer.parseInt(id));		
		if (a !=null) {
	        em.remove(a);
	        em.getTransaction().commit();
		}       
        em.close();
	    return 0;
	    
	}

}
