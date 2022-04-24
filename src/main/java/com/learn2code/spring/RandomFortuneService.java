package com.learn2code.spring;

import java.util.Random;

public class RandomFortuneService implements FortuneService{

    private String [] data ={
            "Beware of the wolf in sheep's clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward"
    };

    // Random number generator

    private Random myRandom = new Random();

    @Override
    public String getFortune() {

        int index = myRandom.nextInt(data.length);

        return data[index];
    }
}
