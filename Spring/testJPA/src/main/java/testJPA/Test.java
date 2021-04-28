package testJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testJPAPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Libro l = em.find(Libro.class, 1);
		System.out.println(l.getTitoloLibro());
				
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
