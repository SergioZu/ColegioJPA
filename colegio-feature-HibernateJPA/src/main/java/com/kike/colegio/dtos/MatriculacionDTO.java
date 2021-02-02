package com.kike.colegio.dtos;

public class MatriculacionDTO {
	private Integer id;
	private Integer idAsignatura;
	private String nombreAsignatura;
	private Integer idAlumno;
	private String nombreAlumno;
	private String fecha;
	private Integer activo;
	
	
	/**
	 * @param id
	 * @param idAsignatura
	 * @param nombreAsignatura
	 * @param idAlumno
	 * @param nombreAlumno
	 * @param fecha
	 * @param activo
	 */
	public MatriculacionDTO(Integer id, Integer idAsignatura, String nombreAsignatura, Integer idAlumno,
			String nombreAlumno, String fecha, Integer activo) {
		super();
		this.id = id;
		this.idAsignatura = idAsignatura;
		this.nombreAsignatura = nombreAsignatura;
		this.idAlumno = idAlumno;
		this.nombreAlumno = nombreAlumno;
		this.fecha = fecha;
		this.activo = activo;
	}

	/**
	 * @param idAsignatura
	 * @param nombreAsignatura
	 * @param idAlumno
	 * @param nombreAlumno
	 * @param fecha
	 * @param activo
	 */
	public MatriculacionDTO(Integer idAsignatura, String nombreAsignatura, Integer idAlumno, String nombreAlumno,
			String fecha, Integer activo) {
		super();
		this.idAsignatura = idAsignatura;
		this.nombreAsignatura = nombreAsignatura;
		this.idAlumno = idAlumno;
		this.nombreAlumno = nombreAlumno;
		this.fecha = fecha;
		this.activo = activo;
	}
	
	/**
	 * 
	 */
	public MatriculacionDTO() {
		super();
	}

	/**
	 * @return the idAsignatura
	 */
	public Integer getIdAsignatura() {
		return idAsignatura;
	}

	/**
	 * @param idAsignatura the idAsignatura to set
	 */
	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	/**
	 * @return the nombreAsignatura
	 */
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	/**
	 * @param nombreAsignatura the nombreAsignatura to set
	 */
	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	/**
	 * @return the idAlumno
	 */
	public Integer getIdAlumno() {
		return idAlumno;
	}

	/**
	 * @param idAlumno the idAlumno to set
	 */
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	/**
	 * @return the nombreAlumno
	 */
	public String getNombreAlumno() {
		return nombreAlumno;
	}

	/**
	 * @param nombreAlumno the nombreAlumno to set
	 */
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the activo
	 */
	public Integer getActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
