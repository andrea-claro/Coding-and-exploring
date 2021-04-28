package it.testapplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.model.ChildBean;
import it.model.ParentBean;

public class TestApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ChildBean pb = (ChildBean) context.getBean("cBean2");
//		pb.setName("CIAO");
//		pb.setSurname("MIAOOOOO");
		pb.printAll();
		
		ChildBean cb2 =(ChildBean) context.getBean("cBean");
		cb2.printAll();
		
		System.out.println("-----Parent ---");
		ParentBean pB =(ParentBean) context.getBean("pBean");
	    pB.printAll();
		//((ChildBean)pb).printAll();
	}

}
