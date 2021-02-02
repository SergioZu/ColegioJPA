package com.kike.colegio.dtos;

public class AsignaturaDTO {
	
	private String id;
	private String nombre;
	private String curso;
	private String tasa;
	
	
	
	
	public AsignaturaDTO() {
		super();
	}
	
	
	public AsignaturaDTO(String id, String nombre, String curso, String tasa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.tasa = tasa;
	}


	public AsignaturaDTO(String id, String nombre, String curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getTasa() {
		return tasa;
	}
	public void setTasa(String tasa) {
		this.tasa = tasa;
	}
	
	

}
