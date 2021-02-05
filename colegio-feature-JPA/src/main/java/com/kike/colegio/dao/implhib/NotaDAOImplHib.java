package com.kike.colegio.dao.implhib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.kike.colegio.dao.NotaDAO;
import com.kike.colegio.dtos.NotaDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.entities.AsignaturasEntity;
import com.kike.colegio.entities.NotasEntity;
import com.kike.colegio.utils.DBUtils;

public class NotaDAOImplHib implements NotaDAO{

	@Override
	public List<NotaDTO> obtenerNotaPorIdNombreAsignaturaNotaFecha(String idAlumno, String nombre, String asignatura,
			String nota, String fecha) {
		
			String jpql = "select new com.kike.colegio.dtos.NotaDTO"
					+ " (n.id, a.id, a.nombre, asig.id, asig.nombre, n.nota, n.fecha) "
					+ "FROM NotasEntity n,  AlumnoEntity a, AsignaturasEntity asig  "
					+ "where  n.alumnos.id=a.id and  n.asignaturas.id=asig.id and  CAST( a.id AS string )  LIKE :idAlumno AND a.nombre LIKE :nombre and asig.nombre LIKE :asignatura "
					+ "  AND CAST( n.nota AS string )  LIKE :nota  AND n.fecha  LIKE :fecha ";

			SessionFactory factory = DBUtils.creadorSessionFactory();
			Session s = factory.getCurrentSession();
			s.beginTransaction();

			Query query = s.createQuery(jpql).setParameter("idAlumno", "%" + idAlumno + "%")
					.setParameter("nombre", "%" + nombre + "%")
					.setParameter("asignatura", "%" + asignatura + "%")
					.setParameter("nota", "%" + nota + "%")
					.setParameter("fecha", "%" + fecha + "%");
			List<NotaDTO> lista = query.getResultList();

			s.close(); // Cerramos la sesión

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
		
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();
		
		
		AlumnoEntity a =s.find(AlumnoEntity.class,Integer.parseInt(idAlumno));
		AsignaturasEntity as =s.find(AsignaturasEntity.class,Integer.parseInt(idAsignatura));
		
		NotasEntity no = new NotasEntity(a, as, Double.parseDouble(nota), fecha);
	
		 Integer idPk = (Integer) s.save(no);


		s.getTransaction().commit();

		return idPk;
	}

	@Override
	public Integer actualizarNota(String idNota, String idAlumno, String idAsignatura, String nota, String fecha) {
		
		
		
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();
		
		AlumnoEntity a =s.find(AlumnoEntity.class,Integer.parseInt(idAlumno));
		AsignaturasEntity as =s.find(AsignaturasEntity.class,Integer.parseInt(idAsignatura));
		
		NotasEntity no = new NotasEntity(Integer.parseInt(idNota),a, as, Double.parseDouble(nota), fecha);
		
		
		s.update(no);
		s.getTransaction().commit();

		return no.getId();
	}

	@Override
	public Integer eliminarNota(String id) {
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		
		s.beginTransaction();
		Query query = s.createQuery("DELETE FROM NotasEntity where id = :id").setParameter("id", Integer.parseInt(id));
		int result = query.executeUpdate();		
		s.close();		
		return result;
	}

}
