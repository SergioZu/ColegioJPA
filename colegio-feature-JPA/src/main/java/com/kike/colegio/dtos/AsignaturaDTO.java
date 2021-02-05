package com.kike.colegio.dtos;

public class AsignaturaDTO {
	
	private int id;
	private String nombre;
	private int curso;
	private int tasa;
	
	
	
	
	public AsignaturaDTO() {
		super();
	}




	public AsignaturaDTO(int id, String nombre, int curso, int tasa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.tasa = tasa;
	}

	



	public AsignaturaDTO(int tasa) {
		super();
		this.tasa = tasa;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public int getCurso() {
		return curso;
	}




	public void setCurso(int curso) {
		this.curso = curso;
	}




	public int getTasa() {
		return tasa;
	}




	public void setTasa(int tasa) {
		this.tasa = tasa;
	}
	
	
	
	

}
