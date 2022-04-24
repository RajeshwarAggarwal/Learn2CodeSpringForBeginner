package com.learn2code.spring;

import org.springframework.beans.factory.DisposableBean;

public class CricketCoach implements Coach, DisposableBean {

    private FortuneService fortuneService;
    private String email;
    private String team;

    public CricketCoach(){
        System.out.println("CricketCoach: Constructor called.");
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: SetFortuneService method called.");
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        System.out.println("CricketCoach: setEmail method gets called.");
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: setTeam method gets called.");
        this.team = team;
    }

    @Override
    public String getDailyWorkOut(){
        return "Fast bowling for 15 min";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public void destroy() throws Exception {

    }
}
