package com.aad.ejercicio3;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * 
 * @author Robert M.P.
 *
 */

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// loads configuration and mappings
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		registry.build();

		// obtains the session
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Titulo DAM = new Titulo(2000, "DAM");
		session.save(DAM);
		Estudiante estudanteDam1 = new Estudiante("027206542", "Miguel Arias", DAM);
		Estudiante estudanteDam2 = new Estudiante("027278452", "Ana García", DAM);
		session.save(estudanteDam1);
		session.save(estudanteDam2);

		Titulo DAW = new Titulo(2000, "DAW");
		session.save(DAW);
		Estudiante estudanteDaw1 = new Estudiante("027406542", "María Sanchez", DAW);
		Estudiante estudanteDaw2 = new Estudiante("457278452", "Juan González", DAW);
		session.save(estudanteDaw1);
		session.save(estudanteDaw2);

		Aula aula111 = new Aula(111, "Edificio 1");
		Aula aula811 = new Aula(811, "Edificio 8");
		session.save(aula111);
		session.save(aula811);

		Asignatura bbdd = new Asignatura(192, "Bases de datos", aula111);
		Asignatura programacion = new Asignatura(192, "Programación", aula111);
		Asignatura entornosDeDesarrollo = new Asignatura(96, "Entornos de desarrollo", aula811);
		Asignatura lenguajesDeMarcas = new Asignatura(128, "Lenguajes de marcas", aula811);
		DAW.addAsignatura(lenguajesDeMarcas);
		DAW.addAsignatura(entornosDeDesarrollo);

		DAM.addAsignatura(programacion);
		DAM.addAsignatura(bbdd);

		session.save(bbdd);
		session.save(programacion);
		session.save(entornosDeDesarrollo);
		session.save(lenguajesDeMarcas);

		session.getTransaction().commit();

		// Select
		String hql1 = "from Titulo";
		Query query1 = session.createQuery(hql1);
		List<Titulo> listTitulos = query1.getResultList();

		System.out.println("\n Tabla Titulos");
		for (Titulo i : listTitulos) {

			System.out.println(i.getId() + " / " + i.getNombre() + " / " + i.getDuracion() + " / ");
		}
		System.out.println("\n");

		// Select
		String hql2 = "from Estudiante";
		Query query2 = session.createQuery(hql2);
		List<Estudiante> listEstudiantes = query2.getResultList();

		System.out.println("\n Tabla Estudiantes");
		for (Estudiante i : listEstudiantes) {

			System.out.println(i.getDni() + " / " + i.getNombre() + " / ");
		}
		System.out.println("\n");

		// Select
		String hql3 = "from Aula";
		Query query3 = session.createQuery(hql3);
		List<Aula> listAulas = query3.getResultList();

		System.out.println("\n Tabla Aulas");
		for (Aula i : listAulas) {

			System.out.println(i.getNumAula() + " / " + i.getEdificio() + " / ");
		}
		System.out.println("\n");

		// Select
		String hql4 = "from Asignatura";
		Query query4 = session.createQuery(hql4);
		List<Asignatura> listAsignatura = query4.getResultList();

		System.out.println("\n Tabla Asignaturas");
		for (Asignatura i : listAsignatura) {

			System.out.println(i.getIdAsignatura() + " / " + i.getNombre() + " / " + i.getTotalHoras() + " / ");
		}
		System.out.println("\n");

		// Select
		String hql5 = "from Asignatura p inner join p.aula";

		Query query5 = session.createQuery(hql5);
		List<Object[]> listResult = query5.getResultList();

		for (Object[] aRow : listResult) {
			Asignatura asignatura = (Asignatura) aRow[0];
			Aula aula = (Aula) aRow[1];
			System.out.println(asignatura.getIdAsignatura() + " / " + asignatura.getNombre() + " / "
					+ asignatura.getTotalHoras() + " / " + aula.getNumAula() + " / " + aula.getEdificio() + " / ");
		}

		// Delete
		session.beginTransaction();

		String hql = "delete from Titulo where nombre = :nombre";

		Query query = session.createQuery(hql);
		query.setParameter("nombre", "DAW");

		int rowsAffected = query.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println("Deleted " + rowsAffected + " rows.");
		}

		// Select
		String hql6 = "from Estudiante";
		Query query6 = session.createQuery(hql6);
		List<Estudiante> listEstudiantesMod = query6.getResultList();

		System.out.println("\n Tabla Estudiantes");
		for (Estudiante i : listEstudiantesMod) {

			System.out.println(i.getDni() + " / " + i.getNombre() + " / ");
		}
		System.out.println("\n");

		// Select
		String hql7 = "from Titulo";
		Query query7 = session.createQuery(hql7);
		List<Titulo> listTitulosMod = query7.getResultList();

		System.out.println("\n Tabla Titulos");
		for (Titulo i : listTitulosMod) {

			System.out.println(i.getId() + " / " + i.getNombre() + " / " + i.getDuracion() + " / ");
		}
		System.out.println("\n");

		session.getTransaction().commit();

		// Backup update sentence: insert into asignaturas_backup values
		// (asignatura.idAsignatura, asignatura.nombre, asignatura.totalhoras);

		session.close();
	}
}