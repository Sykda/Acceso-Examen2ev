package com.aad.ejercicio3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Estudiantes")
public class Estudiante {

	String dni;
	String nombre;
	Titulo titulo;

	public Estudiante() {
		super();
	}

	public Estudiante(String dni, String nombre, Titulo titulo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.titulo = titulo;
	}

	@Id
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

}
