package com.learn2code.spring;

public class    BaseBallCoach implements Coach{

    private FortuneService fortuneService;

    public BaseBallCoach(FortuneService fortuneService){
        System.out.println("BasketBallCoach : Constructor is called.");
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkOut(){
        return "Spend 30mins on batting practice.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // Init method
    public void doMyStuffAtStartUp(){
        System.out.println("BaseBallCoach : Inside init method and doing some startup work");
    }

    // Destroy method
    public void doMyStuffAtCleanUp(){
        System.out.println("BaseBallCoach : Inside destroy method and doing some cleanup work");
    }
}
