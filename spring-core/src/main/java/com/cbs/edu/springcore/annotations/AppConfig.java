package com.cbs.edu.springcore.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Performer duke() {
        return new Juggler("Duke", 5);
    }
}
