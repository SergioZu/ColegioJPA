package com.kike.colegio.controladores.asignaturas;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.kike.colegio.dao.impl.AlumnoDAOImpl;
import com.kike.colegio.dao.impl.AsignaturaDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.dtos.AsignaturaDTO;
import com.kike.colegio.utils.DBUtils;
import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dao.AsignaturaDAO;


/**
 * Servlet Implation class Inicio
 */

@WebServlet("/listadoasignaturas")
public class ListadoAsignaturasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LoggerFactory.getLogger(ListadoAsignaturasController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListadoAsignaturasController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

			RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/listadoAsignaturas.jsp");
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
		String curso = request.getParameter("curso");
		String tasa = request.getParameter("tasa");
		
		AsignaturaDAO a = new AsignaturaDAOImpl();
	 	List<AsignaturaDTO> listaAsignaturas = new ArrayList<>();
	 	
	 	listaAsignaturas = a.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa);
		

		request.setAttribute("lista", listaAsignaturas);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/listadoAsignaturas.jsp");
		d.forward(request, response);
	}

}
