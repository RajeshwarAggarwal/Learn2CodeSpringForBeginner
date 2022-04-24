package com.learn2code.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

public class BeanScopeDemoApp {

    public static void main (String [] arg){
        // create application context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        //get a spring bean
        Coach theCoach = context.getBean("myCoach",Coach.class);

        Coach alphaCoach = context.getBean("myCoach",Coach.class);

        // check is they are same

        boolean result=(theCoach==alphaCoach);

        //print the result
        System.out.println("Pointing to the same object : "+ result );

        System.out.println("Memory location for theCoach : "+theCoach);

        System.out.println("Memory location for theAlphaCoach : "+alphaCoach);

        context.close();
    }



}
