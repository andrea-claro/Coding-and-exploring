package it.clarome.hbn.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.clarome.hbn.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			List<Student> students;

			session.beginTransaction();

			students = session.createQuery("from Student").getResultList();
			displayStudents(students);
			
			System.out.println("-----------------------------");
			
			students = session.createQuery("from Student s where s.lastName='liamo'").getResultList();
			displayStudents(students);
			
			System.out.println("-----------------------------");

			students = session.createQuery(
					"from Student s where s.lastName='liamo' OR s.firstName='triade'")
					.getResultList();
			displayStudents(students);
			
			System.out.println("-----------------------------");

			students = session.createQuery(
					"from Student s where s.email like 'andrea%'")
					.getResultList();
			displayStudents(students);

			session.getTransaction().commit();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student s : students) {
			System.out.println(s.toString());
		}
	}
}
