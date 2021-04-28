package it.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.interfaces.Stampabili;
import it.model.Citta;
import it.model.Indirizzo;

public class TestApplication {

	public static void main(String[] args) {
		ApplicationContext context = new  ClassPathXmlApplicationContext("beans.xml");
		Stampabili persona = context.getBean("persona", it.interfaces.Stampabili.class);
		persona.stampa();
		
		System.out.println("-----------------------ESEMPIO LISTA---------------------------------------");
		Citta citta = context.getBean("citta", it.model.Citta.class);
		for(Indirizzo i : citta.getLista()){
			i.stampa();
			System.out.println("--------------------------");
		}
		
		citta.getLista().forEach(t->System.out.println(t));
		
		citta.getLista().stream()
			.filter(t->t.getProvincia().equals("Napoli"))
			.forEach(t->System.out.println(t));
	}

}
