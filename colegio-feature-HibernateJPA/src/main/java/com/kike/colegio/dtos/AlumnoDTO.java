package com.kike.colegio.dtos;

public class AlumnoDTO {
	
	private Integer id;
	private String nombre;
	private String municipio;
	private Integer idMunicipio;
	private Integer famNumerosa;
	
	
	public AlumnoDTO() {
		super();
	}
	
	


	public AlumnoDTO(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}




	public AlumnoDTO(Integer id, String nombre, String municipio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.municipio = municipio;
	}
	




	public AlumnoDTO(Integer id, String nombre, String municipio, Integer idMunicipio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.municipio = municipio;
		this.idMunicipio = idMunicipio;
	}




	public AlumnoDTO(Integer id, String nombre, String municipio, Integer idMunicipio, Integer famNumerosa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.municipio = municipio;
		this.idMunicipio = idMunicipio;
		this.famNumerosa = famNumerosa;
	}









	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getMunicipio() {
		return municipio;
	}


	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}




	public Integer getIdMunicipio() {
		return idMunicipio;
	}




	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}




	public Integer getFamNumerosa() {
		return famNumerosa;
	}




	public void setFamNumerosa(Integer famNumerosa) {
		this.famNumerosa = famNumerosa;
	}
	
	
	
	
	

}
