package com.aad.ejercicio3;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Aulas")
public class Aula {

	int numAula;
	String edificio;
	Set<Asignatura> asignaturas = new HashSet<>();

	public Aula() {
		super();
	}

	public Aula(int numAula, String edificio) {
		super();
		this.numAula = numAula;
		this.edificio = edificio;
	}

	public void addAsignatura(Asignatura a) {
		asignaturas.add(a);
	}

	@Id
	public int getNumAula() {
		return numAula;
	}

	public void setNumAula(int numAula) {
		this.numAula = numAula;
	}

	@OneToMany(mappedBy = "aula")
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

}
