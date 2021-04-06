package com.clarome.springdemo;

public class BaseballCoach implements Coach{

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkOut(){
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void doStartup(){
        System.out.println("Init method");
    }

    public void doDestroy(){
        System.out.println("Destroy method");
    }

}