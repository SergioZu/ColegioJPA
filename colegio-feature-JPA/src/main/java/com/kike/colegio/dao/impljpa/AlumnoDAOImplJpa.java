package com.kike.colegio.dao.impljpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dtos.AlumnoDTO;

import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.utils.DBUtils;

public class AlumnoDAOImplJpa implements AlumnoDAO {

	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() {
		String hql = "select new com.kike.colegio.dtos.AlumnoDTO (a.id, a.nombre)" + " FROM AlumnoEntity a ";
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();

//		Query <AlumnoEntity> query = s.createQuery(hql, AlumnoEntity.class);
		Query query = s.createQuery(hql);
		List<AlumnoDTO> lista = query.getResultList();
		s.close(); // Cerramos la sesión

		return lista;
	}

	@Override
	public List<AlumnoDTO> obtenerAlumnosporIdyNombre(String id, String nombre) {

		String jpql = " select new com.kike.colegio.dtos.AlumnoDTO (a.id, a.nombre, m.nombre, m.idMunicipio, a.famNumerosa)"
				+ "FROM AlumnoEntity a, MunicipiosEntity m WHERE a.id = m.idMunicipio AND  CAST( a.id AS string )  LIKE :id AND a.nombre LIKE :nombre";

	
		EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		javax.persistence.Query query = em.createQuery(jpql).setParameter("id", "%" + id + "%").setParameter("nombre", "%" + nombre + "%");
		List<AlumnoDTO> lista = query.getResultList();
		em.close();


		return lista;
	}

	@Override
	public Integer insertarAlumno(String id, String nombre, String idMunicipio, String famNumerosa) {

		AlumnoEntity a = new AlumnoEntity(Integer.parseInt(id), nombre, Integer.parseInt(idMunicipio),
				Integer.parseInt(famNumerosa));
		
		EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();

		em.close();
		//Obtenemos el valor de la PK insertada para devolverlo
		return (Integer) emf.getPersistenceUnitUtil().getIdentifier(a);
	}

	@Override
	public Integer actualizarAlumno(String idOld, String idNew, String nombre, String idMunicipio, String famNumerosa) {
		
		//Conversión famNumerosa a Integer (0 o 1), ya que viene a "on" o null
		Integer familiaNumerosa = 	(famNumerosa == null) ? 0 : 1;
		
		
		EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		//Recuperamos la entidad a actualizar
		AlumnoEntity a = em.find(AlumnoEntity.class, Integer.parseInt(idOld));		
		//Actualizamos sus valores con los nuevos
		a.setId(Integer.parseInt(idNew));
		a.setNombre(nombre);
		a.setIdMunicipio(Integer.parseInt(idNew));
		a.setIdMunicipio(Integer.parseInt(idMunicipio));
		
		//La entidad es automáticamente actualizada cuando se hace commit
        em.getTransaction().commit();
        em.close();

		return a.getId();
	}

	@Override
	public Integer borrarAlumno(String id) {
		
		EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		//Recuperamos la entidad a borrar
		AlumnoEntity a = em.find(AlumnoEntity.class, Integer.parseInt(id));		
		if (a !=null) {
	        em.remove(a);
	        em.getTransaction().commit();
		}       
        em.close();
	    return 0;
	    
		/** Forma alternativa de llevar a cabo el delete con HQL */
//		s.beginTransaction();
//		Query query = s.createQuery("DELETE FROM AlumnoEntity where id = :id").setParameter("id", Integer.parseInt(id));
//		int result = query.executeUpdate();
//		s.close();
//		return result;
		
	    
	}
		
	
	


	@Override
	public boolean esFamiliaNumerosa(String idAlumno) {
		// TODO Auto-generated method stub
		return false;
	}
}