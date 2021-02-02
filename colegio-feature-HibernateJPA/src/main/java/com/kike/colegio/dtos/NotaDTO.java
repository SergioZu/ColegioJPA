package com.kike.colegio.dtos;

public class NotaDTO {
	
	private Integer id;
	private Integer idAlumno;
	private String nombreAlumno;	
	private Integer idAsignatura;
	private String nombreAsignatura;
	private Double nota;
	private String fecha;
	
	
	
	/**
	 * @param id
	 * @param idAlumno
	 * @param nombreAlumno
	 * @param idAsignatura
	 * @param nombreAsignatura
	 * @param nota
	 * @param fecha
	 */
	public NotaDTO(Integer id, Integer idAlumno, String nombreAlumno, Integer idAsignatura, String nombreAsignatura,
			Double nota, String fecha) {
		super();
		this.id = id;
		this.idAlumno = idAlumno;
		this.nombreAlumno = nombreAlumno;
		this.idAsignatura = idAsignatura;
		this.nombreAsignatura = nombreAsignatura;
		this.nota = nota;
		this.fecha = fecha;
	}

	/**
	 * @param idAlumno
	 * @param nombreAlumno
	 * @param idAsignatura
	 * @param nombreAsignatura
	 * @param nota
	 * @param fecha
	 */
	public NotaDTO(Integer idAlumno, String nombreAlumno, Integer idAsignatura, String nombreAsignatura, Double nota,
			String fecha) {
		super();
		this.idAlumno = idAlumno;
		this.nombreAlumno = nombreAlumno;
		this.idAsignatura = idAsignatura;
		this.nombreAsignatura = nombreAsignatura;
		this.nota = nota;
		this.fecha = fecha;
	}

	/**
	 * 
	 */
	public NotaDTO() {
		super();
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
	 * @return the nota
	 */
	public Double getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(Double nota) {
		this.nota = nota;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
