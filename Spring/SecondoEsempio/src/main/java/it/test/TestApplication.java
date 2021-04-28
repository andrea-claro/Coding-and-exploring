package it.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.interfaces.Stampabili;
import it.model.Employee;
import it.model.Indirizzo;
import it.model.Persona;

public class TestApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean2.xml");
		System.out.println("------------------------------------------------");
		Employee emp1 =(Employee) ctx.getBean("employee");
		System.out.println("Emp1 : "+emp1);
		
		Employee emp2 = (Employee) ctx.getBean("employee2");
		System.out.println("Emp2 : "+emp2);
		
		Employee emp3 = (Employee) ctx.getBean("employee3");
		System.out.println(emp3);
		
		System.out.println("------------------------------------------------");
		ApplicationContext context = new  ClassPathXmlApplicationContext("beans.xml");
		Stampabili persona = context.getBean("persona", it.interfaces.Stampabili.class);
		persona.stampa();
		
		Stampabili p1 = context.getBean("persona",it.model.Persona.class);
		p1.stampa();
		
		Stampabili ind1 = context.getBean("indirizzo",it.model.Indirizzo.class);
		ind1.stampa();
		System.out.println("-----------Oggetto indirizzo");
		Stampabili p2 =(Indirizzo) context.getBean("indirizzo",it.interfaces.Stampabili.class);
		p2.stampa();
		
		System.out.println("-----Persona---");
		Persona p3 =(Persona) context.getBean("persona");
		p3.stampa();
		
		System.out.println("---Indirizzo----");
		Indirizzo ind2 =(Indirizzo) context.getBean("indirizzo");
		ind2.stampa();
		
		Indirizzo ind3 =(Indirizzo) context.getBean("ind2");
		ind3.stampa();
		System.out.println(ind3);
		Indirizzo ind4 =(Indirizzo) context.getBean("ind2");
		ind4.stampa();
		System.out.println(ind4);
		
		
	}

}
