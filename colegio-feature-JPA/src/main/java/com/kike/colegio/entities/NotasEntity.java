package com.kike.colegio.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "notas")
public class NotasEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name ="id_alumnos")
	private AlumnoEntity alumnos;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name ="id_asignaturas")
	private AsignaturasEntity asignaturas;
	
	@Column(name = "nota")
	private Double nota;

	@Column(name = "fecha")
	private String fecha;
	
	public NotasEntity(int id, AlumnoEntity alumnos, AsignaturasEntity asignaturas, Double nota, String fecha) {
		super();
		this.id = id;
		this.alumnos = alumnos;
		this.asignaturas = asignaturas;
		this.nota = nota;
		this.fecha = fecha;
	}







	public NotasEntity(AlumnoEntity alumnos, AsignaturasEntity asignaturas, Double nota, String fecha) {
		super();
		this.alumnos = alumnos;
		this.asignaturas = asignaturas;
		this.nota = nota;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AlumnoEntity getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(AlumnoEntity alumnos) {
		this.alumnos = alumnos;
	}

	public AsignaturasEntity getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(AsignaturasEntity asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	

	
	
	
}
