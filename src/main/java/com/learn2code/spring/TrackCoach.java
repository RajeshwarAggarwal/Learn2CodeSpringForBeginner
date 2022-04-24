package com.learn2code.spring;

import org.springframework.beans.factory.DisposableBean;

public class TrackCoach implements Coach, DisposableBean {
    private FortuneService fortuneService;

    public TrackCoach(){
    }

    public TrackCoach(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }

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

    @Override
    public void destroy() throws Exception {
        System.out.println("Inside TrackCoach.destroy Method : Cleaning up ..");
    }


}
