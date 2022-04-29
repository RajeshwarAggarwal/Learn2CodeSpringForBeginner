package com.learn2code.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
public class TennisCoach implements Coach, DisposableBean {
    private FortuneService fortuneService;

    public TennisCoach(){
    }

    @Autowired
    @Qualifier("randomFortuneService")
    public void doCrazyStuff(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }

    @PostConstruct
    public void doMyStuffAtStartUp(){
        System.out.println("Inside TennisCoach.doMyStuffAtStartUp method : Initilisation inside custom method.");
    }

    @Override
    public String getDailyWorkOut(){
        return "Pratice hardly in Tennis Court.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Inside TennisCoach.destroy Method : Cleaning up ..");
    }


}
