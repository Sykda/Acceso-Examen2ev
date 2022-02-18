package com.aad.ejercicio3;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Titulos")
public class Titulo {

	int id, duracion;
	String nombre;
	Set<Estudiante> estudiantes = new HashSet<>();
	Set<Asignatura> asignaturas = new HashSet<>();

	public Titulo() {
		super();
	}

	public Titulo(int duracion, String nombre) {
		super();
		this.duracion = duracion;
		this.nombre = nombre;

	}

	public void addEstudiante(Estudiante e) {
		estudiantes.add(e);
	}

	public void addAsignatura(Asignatura a) {
		asignaturas.add(a);
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(mappedBy = "titulo", cascade = CascadeType.ALL)
	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@ManyToMany
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

}
