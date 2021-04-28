package it.clarome.hbn.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.clarome.hbn.entity.Instructor;
import it.clarome.hbn.entity.InstructorDetail;
import it.clarome.hbn.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		System.out.println("-----------------------------");
		
		try {
			int instructorDetailID = 4;
			
			InstructorDetail instructorDetail;
						
			session.beginTransaction();
						
			instructorDetail = session.get(InstructorDetail.class, instructorDetailID);
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(instructorDetail);
			
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
