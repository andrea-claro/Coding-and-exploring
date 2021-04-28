package it.clarome.hbn.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.clarome.hbn.entity.Course;
import it.clarome.hbn.entity.Instructor;
import it.clarome.hbn.entity.InstructorDetail;
import it.clarome.hbn.entity.Student;

public class DeleteCourseDemo {

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
			int courseID = 10;
			Course course;
						
			session.beginTransaction();
			
			course = session.get(Course.class, courseID);
			session.delete(course);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
