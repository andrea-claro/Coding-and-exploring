package it.clarome.hbn.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.clarome.hbn.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		
		try {
			
			int studentID = 3;
			Student student;
			List<Student> students;
			
			session.beginTransaction();
			
			student = session.get(Student.class, studentID);
			student.setFirstName("Lollo");
			session.createQuery("update Student set email='frccdd@ggff.it'").executeUpdate();
			System.out.println("-----------------------------");
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
