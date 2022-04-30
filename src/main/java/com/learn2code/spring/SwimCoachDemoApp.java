package com.learn2code.spring;

import com.learn2code.spring.logger.MyLoggerConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimCoachDemoApp {

    public static void main (String [] arg){

        // create application context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyLoggerConfig.class,SportConfig.class);

        //get a spring bean
        Coach theCoach = context.getBean("swimCoach",Coach.class);

        // call bean methods
        System.out.println("SwimCoachDemoApp: "+theCoach.getDailyWorkOut());

        System.out.println("SwimCoachDemoApp: "+theCoach.getDailyFortune());

        context.close();
    }



}
