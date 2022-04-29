package com.learn2code.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringWithAnotationDemoApp {

    public static void main (String [] arg){
        // create application context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //get a spring bean
        Coach theCoach = context.getBean("baseBallCoach",Coach.class);

        // use the bean
        System.out.println(theCoach.getDailyWorkOut());
        System.out.println(theCoach.getDailyFortune());

        //Setter Injection example
        CricketCoach theCricketCoach=context.getBean("myCricketCoach",CricketCoach.class);
        System.out.println(theCricketCoach.getDailyWorkOut());
        System.out.println(theCricketCoach.getDailyFortune());

            // callng new methods
            System.out.println(theCricketCoach.getTeam());
            System.out.println(theCricketCoach.getEmail());

        // Any Method Injection

        Coach tennisCoach = context.getBean("tennisCoach",Coach.class);
        System.out.println(tennisCoach.getDailyWorkOut());
        System.out.println(tennisCoach.getDailyFortune());

        // field Injection

        Coach trackCoach = context.getBean("trackCoach",Coach.class);
        System.out.println(trackCoach.getDailyWorkOut());
        System.out.println(trackCoach.getDailyFortune());

        context.close();
    }



}
