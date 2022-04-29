package com.learn2code.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

public class BeanScopeDemoApp {

    public static void main (String [] arg){
        // create application context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //get a spring bean
        Coach theCoach = context.getBean("baseBallCoach",Coach.class);

        Coach alphaCoach = context.getBean("baseBallCoach",Coach.class);

        // check is they are same

        boolean result=(theCoach==alphaCoach);

        //print the result
        System.out.println(" Singleton: Pointing to the same object : "+ result );

        System.out.println(" Singleton: Memory location for theCoach : "+theCoach);

        System.out.println(" Singleton: Memory location for theAlphaCoach : "+alphaCoach);

        // For ProtoType scope

        //get a spring bean
        theCoach = context.getBean("tennisCoach",Coach.class);

        alphaCoach = context.getBean("tennisCoach",Coach.class);

        // check is they are same

        result=(theCoach==alphaCoach);

        //print the result
        System.out.println(" ProtoType: Pointing to the same object : "+ result );

        System.out.println(" ProtoType: Memory location for theCoach : "+theCoach);

        System.out.println(" ProtoType: Memory location for theAlphaCoach : "+alphaCoach);

        context.close();
    }



}
