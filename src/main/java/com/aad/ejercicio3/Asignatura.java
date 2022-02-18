package com.aad.ejercicio3;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Asignaturas")
public class Asignatura {

	int idAsignatura, totalHoras;
	String nombre;
	Set<Titulo> titulos = new HashSet<>();
	Aula aula;
	Asignaturas_Backup backup;

	public Asignatura() {
		super();
	}

	public Asignatura(int totalHoras, String nombre, Aula aula) {
		super();
		this.totalHoras = totalHoras;
		this.nombre = nombre;
		this.aula = aula;
	}

	public void addTitulo(Titulo t) {
		titulos.add(t);
	}

	@Id
	@GeneratedValue
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

	@ManyToMany(mappedBy = "asignaturas")
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Set<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(Set<Titulo> titulos) {
		this.titulos = titulos;
	}

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	@OneToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Asignaturas_Backup getBackup() {
		return backup;
	}

	public void setBackup(Asignaturas_Backup backup) {
		this.backup = backup;
	}

}
