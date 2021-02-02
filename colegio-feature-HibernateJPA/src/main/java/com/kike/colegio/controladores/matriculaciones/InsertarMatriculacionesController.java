package com.kike.colegio.controladores.matriculaciones;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.MatriculacionDAO;
import com.kike.colegio.dao.impl.MatriculacionDAOImpl;
import com.kike.colegio.utils.ComboUtils;



/**
 * Servlet Implation class InsertarAlumnosController
 */

@WebServlet("/insertarmatriculacion")
public class InsertarMatriculacionesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarMatriculacionesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-Recuperar de la BBDD todos los municipios y meterlos en una lista
		
		ComboUtils.recuperarComboAlumnos(request);
		ComboUtils.recuperarComboAsignaturas(request);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/jsp/vistas/matriculaciones/insertarMatriculaciones.jsp");
		d.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idAlumno = request.getParameter("alumnos");
		String idAsignatura = request.getParameter("asignaturas");
		String tasa = request.getParameter("tasa");
		String fecha = request.getParameter("fecha");
		
		MatriculacionDAO m = new MatriculacionDAOImpl();
		
		Integer resultado = m.insertarMatriculacion(idAsignatura, idAlumno, tasa, fecha);
		
		request.setAttribute("resultado", resultado);
		ComboUtils.recuperarComboAlumnos(request);
		ComboUtils.recuperarComboAsignaturas(request);
				
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/jsp/vistas/matriculaciones/insertarMatriculaciones.jsp");
		d.forward(request, response);
		
	}

}
