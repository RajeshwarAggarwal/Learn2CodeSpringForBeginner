package com.learn2code.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class SwimCoach implements Coach{

    private FortuneService fortuneService;


    public SwimCoach(FortuneService fortuneService){
        System.out.println("SwimCoach : Constructor is called.");
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkOut(){
        return "Swim 100 mtrs as warm up.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    /*// Init method
    public void doMyStuffAtStartUp(){
        System.out.println("BaseBallCoach : Inside init method and doing some startup work");
    }

    // Destroy method
    public void doMyStuffAtCleanUp(){
        System.out.println("BaseBallCoach : Inside destroy method and doing some cleanup work");
    }*/
}
