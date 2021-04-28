package it.clarome.hbn.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.clarome.hbn.entity.Course;
import it.clarome.hbn.entity.Instructor;
import it.clarome.hbn.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		System.out.println("-----------------------------");
		
		try {
			int instructorID = 1;
			Instructor instructor;
						
			session.beginTransaction();
			
			Query<Instructor> query = session.createQuery("Select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "where i.id =:instructorID", 
					Instructor.class);
			query.setParameter("instructorID", instructorID);
			
			instructor = query.getSingleResult();
			
			System.out.println(instructor.toString());
			
			session.close();
			
			System.out.println(instructor.getCourses());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
