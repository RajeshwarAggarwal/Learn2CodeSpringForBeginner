package com.learn2code.spring;

public class MyAppWithOutSpring {

    public static void main(String [] arg){
        // Create the object
        Coach theCoach= new TrackCoach();

        // use the object
        System.out.println(theCoach.getDailyWorkOut());
    }

}
