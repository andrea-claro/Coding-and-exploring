package com.clarome.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
        Coach theCoach1 = context.getBean("baseballCoach", Coach.class);

        System.out.print(theCoach1.getDailyWorkOut());

        context.close();
    }
}
