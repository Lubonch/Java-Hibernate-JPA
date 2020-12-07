package edu.epidata;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class MostrarDatos {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Editorial");
		EntityManager em = emf.createEntityManager();
		Reporte1(em);
		Reporte2(em);
		Reporte3(em);
		em.close();
		emf.close();
	}
	
	private static void Reporte1(EntityManager em) 
	{
		em.getTransaction().begin();
		TypedQuery<Reporte1DTO> q = em.
		createQuery("SELECT new "
					+ "edu.epidata.Reporte1DTO(p.id, count(*))"
					+ " FROM Libro l JOIN l.editores p"
					+ " WHERE l.anio = :anio"
					+ " GROUP BY p.id ",
				Reporte1DTO.class);

		q.setParameter("anio", 2017);

		List<Reporte1DTO> res = q.getResultList();
		//Imprime los resultados
		res.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
	}
	
	private static void Reporte2(EntityManager em) 
	{
		em.getTransaction().begin();
		TypedQuery<Reporte2DTO> q = em.
			createQuery("SELECT new "
				+ "edu.epidata.Reporte2DTO(p.id, sum(c.paginas))"
				+ " FROM Libro l JOIN l.capitulos c JOIN c.revisor p"
				+ " WHERE l.anio = :anio"
				+ " GROUP BY p.id ",
					Reporte2DTO.class);

		q.setParameter("anio", 2017);

		List<Reporte2DTO> res = q.getResultList();
		//Imprime los resultados
		res.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
	}
	private static void Reporte3(EntityManager em) 
	{
		em.getTransaction().begin();
		TypedQuery<Reporte3DTO> q = em.
				createQuery("SELECT new "
						+ "edu.epidata.Reporte3DTO(p.id, count(DISTINCT l.id))"
						+ " FROM Libro l JOIN l.capitulos c"
						+ " JOIN c.autores p"
						+ " GROUP BY p.id ",
					Reporte3DTO.class);

		List<Reporte3DTO> res = q.getResultList();
		//Imprime los resultados
		res.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
	}

}
