package com.learn2code.spring;

import com.learn2code.spring.logger.MyLoggerConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PingPongCoachDemoApp {

    public static void main (String [] arg){

        // create application context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyLoggerConfig.class,SportConfig.class);

        //get a spring bean
        Coach theCoach = context.getBean("pingPongCoach",Coach.class);

        // call bean methods
        System.out.println("PingPonCoachDemoApp: "+theCoach.getDailyWorkOut());

        System.out.println("PingPonCoachDemoApp: "+theCoach.getDailyFortune());

        context.close();
    }



}
