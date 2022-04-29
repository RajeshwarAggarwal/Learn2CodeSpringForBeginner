package com.learn2code.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

    public static void main (String [] arg){
        // create application context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //get a spring bean
        Coach theCoach = context.getBean("trackCoach",Coach.class);
        Coach thetennisCoach = context.getBean("tennisCoach",Coach.class);

        //use the bean
        System.out.println(theCoach.getDailyWorkOut());

        context.close();
    }



}
