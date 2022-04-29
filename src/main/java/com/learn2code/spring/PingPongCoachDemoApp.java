package com.learn2code.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PingPongCoachDemoApp {

    public static void main (String [] arg){

        // create application context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //get a spring bean
        Coach theCoach = context.getBean("pingPongCoach",Coach.class);

        // call bean methods
        System.out.println("PingPonCoachDemoApp: "+theCoach.getDailyWorkOut());

        System.out.println("PingPonCoachDemoApp: "+theCoach.getDailyFortune());

        context.close();
    }



}
