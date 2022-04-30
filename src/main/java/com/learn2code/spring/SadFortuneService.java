package com.learn2code.spring;

import org.springframework.stereotype.Component;

public class SadFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "Today is the bad day! ";
    }
}
