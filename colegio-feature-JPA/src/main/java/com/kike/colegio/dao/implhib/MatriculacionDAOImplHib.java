package com.kike.colegio.dao.implhib;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import com.kike.colegio.dao.MatriculacionDAO;
import com.kike.colegio.dtos.MatriculacionDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.entities.AsignaturasEntity;
import com.kike.colegio.entities.CajaEntity;
import com.kike.colegio.entities.MatriculacionesEntity;
import com.kike.colegio.utils.DBUtils;

public class MatriculacionDAOImplHib implements MatriculacionDAO {

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
		
		
		

			SessionFactory factory = DBUtils.creadorSessionFactory();
			Session s = factory.getCurrentSession();
			s.beginTransaction();
			
			
			Query query = s.createQuery(jpql).setParameter("idAsig", "%" + idAsig + "%")
					.setParameter("nombreAsig", "%" + nombreAsig + "%")
					.setParameter("idAlum", "%" + idAlum + "%")
					.setParameter("aNombre", "%" + nombreAlum + "%")
					.setParameter("fecha", "%" + fecha + "%")
					.setParameter("activo", "%" + activo + "%");
			
			List<MatriculacionDTO> lista = query.getResultList();

			s.close(); // Cerramos la sesión

			return lista;
	}

	@Override
	public Integer insertarMatriculacion(String idAsignatura, String idAlumno, String tasa, String fecha) {
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();
		
		
		AlumnoEntity a =s.find(AlumnoEntity.class,Integer.parseInt(idAlumno));
		AsignaturasEntity as =s.find(AsignaturasEntity.class,Integer.parseInt(idAsignatura));
		
		Date cdareDate= new Date(1);
		String fdate=new SimpleDateFormat("yyy-MM-dd").format(cdareDate);
		
		if(fecha=="") {
			fecha=fdate;
		}
		
		MatriculacionesEntity no = new MatriculacionesEntity(a, as, fecha, 1);
		 Integer idPk = (Integer) s.save(no);
		
		CajaEntity cajaEntity=new CajaEntity((no.getId()+1), no,Double.parseDouble(tasa));
		
		s.save(cajaEntity);

		s.getTransaction().commit();
		s.close();

		return idPk;
	}

	@Override
	public Integer borrarMatriculacion(String idMatricula) {
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		
		s.beginTransaction();
		
		Query query1 = s.createQuery("DELETE FROM CajaEntity where idmatricula = :id").setParameter("id", Integer.parseInt(idMatricula));
		query1.executeUpdate();
		
		Query query2 = s.createQuery("DELETE FROM MatriculacionesEntity where id = :id").setParameter("id", Integer.parseInt(idMatricula));
		int result = query2.executeUpdate();		
		s.close();		
		return result;
		
		
	}

	
}