package it.testapplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.modelabstract.ParentBean;
import it.modelabstract.ChildBean;

public class TestApplicationAbs {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		
//		ParentBean pb = (ParentBean)context.getBean("pBeanAbs");
//		pb.printAll();
//		Non Posso!!! IL pBeanAbs è stratto--> cercherebbe di instanziare una classe astratta!!
		
		ParentBean cb =(ChildBean) context.getBean("cBeanAbs");
		cb.printAll();
		
		
		cb.setName("Miaooooooo");
		cb.printAll();
		
		System.out.println("LookUP di CB2");
		ParentBean cb2 = (ChildBean) context.getBean("cBeanAbs");
		cb2.printAll();
		
		ParentBean p1 = new ChildBean();
		
		p1.printAll();
	}

}
