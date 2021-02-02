package com.kike.colegio.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name = "caja")
public class CajaEntity {

	@Id
	@Column(name = "id")
	private int id;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "idmatricula", referencedColumnName= "id")
	private MatriculacionesEntity matriculacion;

	@Column(name = "importe")
	private Double importe;
	
	
	
	//Constructores, Getters y setters 
	
	
	public CajaEntity() {
		super();
	}
	
	
	public CajaEntity(int id, MatriculacionesEntity matriculacion, Double importe) {
		super();
		this.id = id;
		this.matriculacion = matriculacion;
		this.importe = importe;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public MatriculacionesEntity getMatriculacion() {
		return matriculacion;
	}


	public void setMatriculacion(MatriculacionesEntity matriculacion) {
		this.matriculacion = matriculacion;
	}


	public Double getImporte() {
		return importe;
	}


	public void setImporte(Double importe) {
		this.importe = importe;
	}





	
	
	

}