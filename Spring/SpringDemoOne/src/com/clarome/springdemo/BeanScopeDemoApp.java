package com.clarome.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
        Coach theCoach1 = context.getBean("baseballCoach", Coach.class);
        Coach theCoach2 = context.getBean("baseballCoach", Coach.class);

        if(theCoach1 == theCoach2){
            System.out.println("Pointing to the same object");
        } else {
            System.out.println("Not pointing to the same object");
        }
        context.close();
    }
}
