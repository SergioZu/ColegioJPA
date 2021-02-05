package com.kike.colegio.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "asignaturas")
public class AsignaturasEntity {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "curso")
	private int curso;

	@Column(name = "tasa")
	private int tasa;
	

	

	
	//Constructores, Getters y setters
	
	
	
	
	
	public AsignaturasEntity(int id, String nombre, int curso, int tasa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.tasa = tasa;
	}

	public AsignaturasEntity() {
		super();
	}

	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}


	public String getNombreAsignatura() {
		return nombre;
	}


	public void setNombreAsignatura(String nombre) {
		this.nombre = nombre;
	}


	public int getCurso() {
		return curso;
	}


	public void setCurso(int curso) {
		this.curso = curso;
	}


	public Integer getTasa() {
		return tasa;
	}


	public void setTasa(Integer tasa) {
		this.tasa = tasa;
	}



	
	
	
}