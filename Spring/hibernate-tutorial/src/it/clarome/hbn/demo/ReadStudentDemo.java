package it.clarome.hbn.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.clarome.hbn.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		
		try {
			System.out.println("Creating the student");
			Student student = new Student("andrea", "claro", "andrea-99@virgilio.it");
			
			session.beginTransaction();
			
			System.out.println("Saving the student");
			
			session.save(student);
			session.getTransaction().commit();
			
			System.out.println("Student saved");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
