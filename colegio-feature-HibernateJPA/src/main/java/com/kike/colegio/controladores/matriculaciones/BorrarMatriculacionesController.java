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

/**
 * Servlet Implation class BorrarMatriculacionesController
 */
@WebServlet("/borrarmatriculaciones")
public class BorrarMatriculacionesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarMatriculacionesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/vistas/matriculaciones/borrarMatriculaciones.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idMatricula = request.getParameter("idMatricula");
		
		MatriculacionDAO m = new MatriculacionDAOImpl();
		
		Integer resultado = m.borrarMatriculacion(idMatricula);
		
		request.setAttribute("resultado", resultado);
		
		RequestDispatcher d = request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/vistas/matriculaciones/borrarMatriculaciones.jsp");
		d.forward(request, response);
		
	}

}
