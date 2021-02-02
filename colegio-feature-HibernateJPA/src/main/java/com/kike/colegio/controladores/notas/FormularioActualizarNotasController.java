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
import com.kike.colegio.utils.ComboUtils;

/**
 * Servlet Implation class FormularioActualizarNotasController
 */
@WebServlet("/formularioactualizarnota")
public class FormularioActualizarNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioActualizarNotasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/actualizarNotas.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComboUtils.recuperarComboAlumnos(request);
		ComboUtils.recuperarComboAsignaturas(request);
		
		String nombre = request.getParameter("nombre");
		String asignatura = request.getParameter("asignatura");
		String fecha = request.getParameter("fecha");
		
		NotaDAO n = new NotaDAOImpl();
				
		request.setAttribute("lista", n.obtenerNotaPorNombreAsignaturaFecha(nombre, asignatura, fecha));
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/actualizarNotas.jsp");
		d.forward(request, response);
	}

}
