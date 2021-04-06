package com.clarome.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

    public static void main(String[] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CricketCoach theCoach = context.getBean("cricketCoach", CricketCoach.class);

        System.out.println(theCoach.getDailyWorkOut());
        System.out.println(theCoach.getDailyFortune());

        System.out.println(theCoach.getTeam());
        System.out.println(theCoach.getEmailAddress());

        context.close();
    }
}
