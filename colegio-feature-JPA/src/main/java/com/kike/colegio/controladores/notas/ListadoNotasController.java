package com.kike.colegio.controladores.notas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.NotaDAO;
import com.kike.colegio.dao.impl.NotaDAOImpl;
import com.kike.colegio.dao.implhib.NotaDAOImplHib;
import com.kike.colegio.dtos.NotaDTO;

/**
 * Servlet Implation class ListadoNotasController
 */
@WebServlet("/listadonotas")
public class ListadoNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoNotasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/listadoNotas.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAlumno = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String asignatura = request.getParameter("asignatura");
		String nota = request.getParameter("nota");
		String fecha = request.getParameter("fecha");
		
		NotaDAO a = new NotaDAOImplHib();
	 	List<NotaDTO> listaNota = new ArrayList<>();
	 	
	 	listaNota = a.obtenerNotaPorIdNombreAsignaturaNotaFecha(idAlumno, nombre, asignatura, nota, fecha);
		

		request.setAttribute("lista", listaNota);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/listadoNotas.jsp");
		d.forward(request, response);
	}

}
