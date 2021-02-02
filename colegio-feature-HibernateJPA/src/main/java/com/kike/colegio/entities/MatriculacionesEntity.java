package com.kike.colegio.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;



@Entity
@Table(name = "matriculaciones")
public class MatriculacionesEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;


	@Column(name = "fecha")
	private int fecha;
	
	@Column(name = "activo")
	private int activo;	
	
	
	@ManyToOne
    @MapsId("id") //Nombre de la PK en la clase Alumno
    @JoinColumn(name = "id_alumno") //Nombre de la columna (tabla matriculaciones)
    private AlumnoEntity alumnos;

    @ManyToOne
    @MapsId("id") //Nombre de la PK en la clase Alumno
    @JoinColumn(name = "id_asignatura") //Nombre de la columna (tabla matriculaciones)
    private AsignaturasEntity asignaturas;



	

  //Constructores, Getters y setters 

    
    
	public MatriculacionesEntity(int id, int fecha, int activo, AlumnoEntity alumnos, AsignaturasEntity asignaturas) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.activo = activo;
		this.alumnos = alumnos;
		this.asignaturas = asignaturas;
	}





	public MatriculacionesEntity() {
		super();
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public int getFecha() {
		return fecha;
	}





	public void setFecha(int fecha) {
		this.fecha = fecha;
	}





	public int getActivo() {
		return activo;
	}





	public void setActivo(int activo) {
		this.activo = activo;
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





}