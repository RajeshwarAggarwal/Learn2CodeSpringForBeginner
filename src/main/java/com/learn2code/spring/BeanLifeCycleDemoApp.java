package com.learn2code.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

    public static void main (String [] arg){
        // create application context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanlifeCycle-applicationContext.xml");

        //get a spring bean
        Coach theCoach = context.getBean("myTrackCoach",Coach.class);

        //use the bean
        System.out.println(theCoach.getDailyWorkOut());

        context.close();
    }



}
