package com.kike.colegio.controladores.notas;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.NotaDAO;
import com.kike.colegio.dao.impl.NotaDAOImpl;

/**
 * Servlet Implation class FormularioEliminarNotaController
 */
@WebServlet("/formularioborrarnota")
public class FormularioEliminarNotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioEliminarNotaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/borrarNotas.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String asignatura = request.getParameter("asignatura");
		String fecha = request.getParameter("fecha");
		
		NotaDAO n = new NotaDAOImpl();
		
		request.setAttribute("lista",n.obtenerNotaPorNombreAsignaturaFecha(nombre, asignatura, fecha));
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/borrarNotas.jsp");
		d.forward(request, response);
	}

}
