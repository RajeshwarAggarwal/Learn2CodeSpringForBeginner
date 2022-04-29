package com.learn2code.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component("myCricketCoach")
public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public CricketCoach(){
        System.out.println("CricketCoach: Constructor called.");
    }

    @Autowired
    @Qualifier("randomFortuneService")
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

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("Inside CricketCoach : Cleaning up");
    }
}
