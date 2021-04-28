package it.testapplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.LibroDAO;
import it.config.SpringJDBCConfiguration;
import it.dao.EmployeeDao;
import it.dao.imp.EmployeeDaoImpl;
import it.dao.imp.EmployeeService;
import it.model.Employee;
import model.Libro;

public class TestApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringJDBCConfiguration.class);
		
		//EmployeeDao edi = (EmployeeDao) context.getBean("EmployeeDaoImpl");
		//EmployeeDao edi = (EmployeeDao) context.getBean("pippo");
		LibroDAO ld = (LibroDAO) context.getBean("libroDAO");
				
		Libro l1 = ld.cercaLibro(1);
		
		System.out.println(l1.toString());
		
		EmployeeService service =(EmployeeService) context.getBean("employeeService"); 
		
		System.out.println(service.numRighe());
		
	}

}
