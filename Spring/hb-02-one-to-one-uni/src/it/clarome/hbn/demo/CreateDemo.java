package it.clarome.hbn.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.clarome.hbn.entity.Instructor;
import it.clarome.hbn.entity.InstructorDetail;
import it.clarome.hbn.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		System.out.println("-----------------------------");
		
		try {
			Instructor instructor = new Instructor("andrea", "gullo", "nano@nono.com");
			InstructorDetail instructorDetail = new InstructorDetail("ciccione", "mangiare");
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			
			/*
			 * Because of cascade it will save even the instructorDetail
			 */
			session.save(instructor);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
