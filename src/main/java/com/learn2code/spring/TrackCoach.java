package com.learn2code.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TrackCoach implements Coach{

    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

    public TrackCoach(){
    }

    @PostConstruct
    public void doMyStuffAtStartUp(){
        System.out.println("Inside TrackCoach.doMyStuffAtStartUp method : Initilisation inside custom method.");
    }

    @Override
    public String getDailyWorkOut(){
        return "Run a hard 5k.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("Inside TrackCoach.destroy Method : Cleaning up ..");
    }


}
