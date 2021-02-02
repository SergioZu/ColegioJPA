package com.kike.colegio.controladores.asignaturas;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dao.AsignaturaDAO;
import com.kike.colegio.dao.impl.AlumnoDAOImpl;
import com.kike.colegio.dao.impl.AsignaturaDAOImpl;

/**
 * Servlet Implation class BorrarAsignaturaController
 */
@WebServlet("/borrarasignatura")
public class BorrarAsignaturaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarAsignaturaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AsignaturaDAO a = new AsignaturaDAOImpl();
		
		String id = request.getParameter("id");;
		
		Integer resultado = a.eliminarAsignatura(id);
		request.setAttribute("resultado", resultado);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/borrarAsignaturas.jsp");		
		d.forward(request, response);
	}

}
