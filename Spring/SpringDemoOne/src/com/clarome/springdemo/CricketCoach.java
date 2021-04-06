package com.clarome.springdemo;

public class CricketCoach implements Coach{

    private String emailAddress;
    private String team;

    private FortuneService fortuneService;

    public CricketCoach(){
        System.out.println("Inside no-args contructor");
    }

    public void setFortuneService(FortuneService fortuneService){
        System.out.println("Inside setter for fortuneService");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return "Practice fast bowling fort 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("Inside setter for emailAddress");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        System.out.println("Inside setter for team");
        this.team = team;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

}
