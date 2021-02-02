package com.kike.colegio.dtos;

public class ComboDTO {

	private Integer id;
	private String descripcion;

	public ComboDTO() {
		super();
	}

	public ComboDTO(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
