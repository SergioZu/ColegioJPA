package com.kike.colegio.dao.implhib;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.kike.colegio.dao.AsignaturaDAO;
import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.dtos.AsignaturaDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.entities.AsignaturasEntity;
import com.kike.colegio.utils.DBUtils;

public class AsignaturaDAOImplJpa implements AsignaturaDAO{


	@Override
	public List<AsignaturaDTO> obtenerAsignaturaPorIdNombreCursoTasa(String id, String nombre, String curso,
			String tasa) {
		String jpql = " select new com.kike.colegio.dtos.AsignaturaDTO "
				+ " (a.id, a.nombre, a.curso, a.tasa)"
				+ "FROM AsignaturasEntity a where  CAST( a.id AS string )  LIKE :id  AND a.nombre LIKE :nombre  AND CAST( a.curso AS string )  LIKE :curso  AND CAST( a.tasa AS string )  LIKE :tasa ";

		
		
		EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		javax.persistence.Query query = em.createQuery(jpql).setParameter("id", "%" + id + "%")
				.setParameter("nombre", "%" + nombre + "%")
				.setParameter("curso", "%" + curso + "%")
				.setParameter("tasa", "%" + tasa + "%");
		List<AsignaturaDTO> lista = query.getResultList();
		em.close();


		return lista;
	}

	@Override
	public Integer insertarAsignatura(String id, String nombre, String curso, String tasa) {

		AsignaturasEntity a = new AsignaturasEntity(Integer.parseInt(id), nombre, Integer.parseInt(curso), Integer.parseInt(tasa));
		
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
	public Integer actualizarAsignatura(String idOld, String idNew, String nombre, String curso, String tasa) {
		
				
				EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
				EntityManager em = emf.createEntityManager();
				
				em.getTransaction().begin();
				//Recuperamos la entidad a actualizar
				AsignaturasEntity a = em.find(AsignaturasEntity.class, Integer.parseInt(idOld));		
				//Actualizamos sus valores con los nuevos
				a.setId(Integer.parseInt(idNew));
				a.setNombreAsignatura(nombre);
				a.setCurso(Integer.parseInt(curso));
				a.setTasa(Integer.parseInt(tasa));
				
				//La entidad es automáticamente actualizada cuando se hace commit
		        em.getTransaction().commit();
		        em.close();

				return a.getId();
	}

	@Override
	public Integer eliminarAsignatura(String id) {
	
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		
		s.beginTransaction();
		Query query = s.createQuery("DELETE FROM AsignaturasEntity where id = :id").setParameter("id", Integer.parseInt(id));
		int result = query.executeUpdate();		
		s.close();		
		return result;
	}

	@Override
	public int obtenerNumeroAsignaturasMatriculadas(String idAlumno) {
		
		String jpql = "select new com.kike.colegio.dtos.MatriculacionDTO "
				+ " ( a.id ) "
				+ " FROM MatriculacionesEntity m, AlumnoEntity a "
				+ " WHERE m.alumnos.id=a.id  and"
				+ " CAST( a.id AS string ) LIKE :idAlum  ";

	
		
		EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		javax.persistence.Query query = em.createQuery(jpql).setParameter("idAlum",  idAlumno );
		List<AsignaturaDTO> lista = query.getResultList();
		em.close();
		
		int numAsigMatriculadas = lista.size();;
		
		return numAsigMatriculadas;
		
		
	}

	@Override
	public double obtenerTasaAsignatura(String idAsignatura) {
		String jpql = " select new com.kike.colegio.dtos.AsignaturaDTO (a.tasa) "
				+ "FROM AsignaturasEntity a where  CAST( a.id AS string )  LIKE :id ";

		
		EntityManagerFactory emf =  DBUtils.creadorEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		javax.persistence.Query query = em.createQuery(jpql).setParameter("id", "%" + idAsignatura + "%");
		List<AsignaturaDTO> lista = query.getResultList();
		em.close();


		 
		Double numtasa = (double) lista.get(0).getTasa();
		return numtasa;
	}
		
}
