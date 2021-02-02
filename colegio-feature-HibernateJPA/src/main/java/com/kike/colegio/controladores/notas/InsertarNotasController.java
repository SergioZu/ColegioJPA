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
 * Servlet Implation class InsertarNotasController
 */
@WebServlet("/insertarnota")
public class InsertarNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarNotasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComboUtils.recuperarComboAlumnos(request);
		ComboUtils.recuperarComboAsignaturas(request);
		
		//Redirigir a la vista
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/insertarNotas.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recupero datos del formulario
		String idAlumno = request.getParameter("alumnos");
		String idAsignatura = request.getParameter("asignaturas");
		String fecha = request.getParameter("fecha");
		String nota = request.getParameter("nota");
				
		NotaDAO n = new NotaDAOImpl();
				
		Integer resultado =n.insertarNota(idAlumno, idAsignatura, nota, fecha);
				
		request.setAttribute("resultado", resultado);
		ComboUtils.recuperarComboAlumnos(request);
		ComboUtils.recuperarComboAsignaturas(request);
				
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/insertarNotas.jsp");
		d.forward(request, response);
	}

}
