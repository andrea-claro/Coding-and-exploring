package com.example.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.example.service.GreetingMessageService;
import com.example.service.GreetingMessageServiceImpl;



 public class Main{

		public static void main(String[] args) {
//			Resource res = new ClassPathResource("bean2.xml");
//			BeanFactory ctx = new XmlBeanFactory(res);
//			GreetingMessageService gm =(GreetingMessageService) ctx.getBean("greetingMessageServiceImpl");
			
			BeanFactory ctx = new ClassPathXmlApplicationContext("bean.xml");
			System.out.println("Test - Singleton --");
			GreetingMessageService msg =(GreetingMessageService) ctx.getBean("greetingMessageServiceImpl");
			GreetingMessageService msg2 = (GreetingMessageService) ctx.getBean("greetingMessageServiceImpl");
			
			System.out.println("Reference 1 : "+msg+ " Azione : "+msg.greetUser());
			System.out.println("Reference 2 : "+msg2+ " Azione : "+msg2.greetUser());
			
			System.out.println("-- Test se Singleton o Prototype con metodi --");
			System.out.println(ctx.isSingleton("greetingMessageServiceImpl"));
			System.out.println(ctx.isPrototype("greetingMessageServiceImpl"));
			System.out.println("-- Test su instance type --");
			System.out.println(ctx.isTypeMatch("greetingMessageServiceImpl", GreetingMessageServiceImpl.class)); //GreetingMessageService.class
			System.out.println("-- Test se container contiene bean --");
			System.out.println(ctx.containsBean("greetingMessageServiceImpl"));
		
			System.out.println(ctx.getBean("greetingMessageServiceImpl") instanceof GreetingMessageServiceImpl);
			
			System.out.println("-- Test Prototype Bean -- ");
			ApplicationContext context = new    ClassPathXmlApplicationContext("bean2.xml"); 
			GreetingMessageService greetingMessageService =  context.getBean("greetingMessageServiceImpl",  GreetingMessageService.class);
			GreetingMessageService greetingMessageService2 = context.getBean("greetingMessageServiceImpl",  GreetingMessageService.class);
			
			System.out.println(greetingMessageService.greetUser());
			System.out.println("Reference 1: " + greetingMessageService);
			System.out.println("Reference 2: " + greetingMessageService2);
		}

	}
