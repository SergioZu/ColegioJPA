package com.kike.colegio.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kike.colegio.dao.CombosDAO;
import com.kike.colegio.dao.impl.CombosDAOImpl;
import com.kike.colegio.dtos.ComboDTO;

public class ComboUtils {

	
	public static void recuperacionComboMunicipios(HttpServletRequest request) {
		CombosDAO comboMunicipio = new CombosDAOImpl();
		List<ComboDTO> listaMunicipios = comboMunicipio.comboMunicipios();
		request.setAttribute("comboMunicipios", listaMunicipios);
	}
	
	
	public static void recuperarComboAlumnos(HttpServletRequest request) {	
		CombosDAO c = new CombosDAOImpl();		
		request.setAttribute("listaAlumnos", c.comboAlumnos());
	}
	
	public static void recuperarComboAsignaturas(HttpServletRequest request) {		
		CombosDAO c = new CombosDAOImpl();		
		request.setAttribute("listaAsignaturas", c.comboAsignaturas());
	}
}
