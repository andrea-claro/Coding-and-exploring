package com.clarome.springdemo;

public class MyApp{

    public static void main(String[] args) {
        Coach baseballCoach = new TrackCoach(new HappyFortune());

        System.out.println(baseballCoach.getDailyWorkOut());
    }
}