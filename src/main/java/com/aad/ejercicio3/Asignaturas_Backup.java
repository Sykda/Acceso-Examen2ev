package com.aad.ejercicio3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Asignaturas_Backup {

	int idAsignatura, totalHoras;
	String nombre;
	Asignatura asignatura;

	public Asignaturas_Backup() {
		super();
	}

	public Asignaturas_Backup(int totalHoras, String nombre) {
		super();
		this.totalHoras = totalHoras;
		this.nombre = nombre;

	}

	public Asignaturas_Backup(int idAsignatura, int totalHoras, String nombre) {
		super();
		this.idAsignatura = idAsignatura;
		this.totalHoras = totalHoras;
		this.nombre = nombre;

	}

	@Id
	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public int getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(int totalHoras) {
		this.totalHoras = totalHoras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToOne(mappedBy = "backup")
	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

}
