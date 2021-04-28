package it.clarome.hbn.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.clarome.hbn.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		
		try {
			
			int studentID = 2;
			Student student;
			
			session.beginTransaction();
			
			student = session.get(Student.class, studentID);
			
			session.delete(student);
			session.createQuery("delete from Student s where s.id=1").executeUpdate();
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
