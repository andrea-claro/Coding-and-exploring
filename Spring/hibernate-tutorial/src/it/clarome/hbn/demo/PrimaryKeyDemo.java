package it.clarome.hbn.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.clarome.hbn.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		
		try {
			System.out.println("Creating students");
			Student student1 = new Student("filippo", "cicco", "futone-99@virgilio.it");
			Student student2 = new Student("triade", "fronzoli", "mariano-99@virgilio.it");
			Student student3 = new Student("mario", "liamo", "alfonsina-99@virgilio.it");
			
			session.beginTransaction();
			
			System.out.println("Saving the student");
			
			session.save(student1);			
			session.save(student2);
			session.save(student3);

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
