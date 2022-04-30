package com.learn2code.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.learn2code.spring"})
@PropertySource("sport.properties")
public class SportConfig {

    // define bean for fortune servcie
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    // define bean for swim coach and inject dependency
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }
}
