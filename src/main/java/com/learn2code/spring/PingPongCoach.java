package com.learn2code.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach {

    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;

    public PingPongCoach(){
        System.out.println("PingPongCoach : Inside default constructor");
    }

    @Override
    public String getDailyWorkOut(){
        return "Pratice your pingPong drop shots.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }


}
