package com.kike.colegio.controladores.alumno;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.kike.colegio.dao.impl.AlumnoDAOImpl;
import com.kike.colegio.dao.implhib.AlumnoDAOImplHib;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.utils.DBUtils;
import com.kike.colegio.dao.AlumnoDAO;


/**
 * Servlet Implation class Inicio
 */

@WebServlet("/listadoalumnos")
public class ListadoAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LoggerFactory.getLogger(ListadoAlumnosController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListadoAlumnosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

			RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumnos/listadoAlumnos.jsp");
			d.forward(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	 	
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		
	//	AlumnoDAO a = new AlumnoDAOImpl();
		AlumnoDAO aHib = new AlumnoDAOImplHib();
	 	
		List<AlumnoDTO>  listaAlumnos = aHib.obtenerAlumnosporIdyNombre(id, nombre);
		

		request.setAttribute("lista", listaAlumnos);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumnos/listadoAlumnos.jsp");
		d.forward(request, response);
	}

}
