package com.kike.colegio.controladores.asignaturas;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dao.AsignaturaDAO;
import com.kike.colegio.dao.CombosDAO;
import com.kike.colegio.dao.impl.AlumnoDAOImpl;
import com.kike.colegio.dao.impl.AsignaturaDAOImpl;
import com.kike.colegio.dao.impl.CombosDAOImpl;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.utils.ComboUtils;

/**
 * Servlet Implation class InsertarAlumnosController
 */

@WebServlet("/insertarasignaturas")
public class InsertarAsignaturasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarAsignaturasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/insertarAsignaturas.jsp");
		d.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// Recupero los datos del formulario
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String curso = request.getParameter("curso");
		String tasa = request.getParameter("tasa");
		
		AsignaturaDAO a = new AsignaturaDAOImpl();		
		Integer resultado = a.insertarAsignatura(id, nombre, curso, tasa);
		
		request.setAttribute("resultado", resultado);
		

		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/insertarAsignaturas.jsp");
		d.forward(request, response);
		
		
	}

}
