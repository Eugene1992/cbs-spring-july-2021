package com.cbs.edu.springcore.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        Performer juggler = applicationContext.getBean(Performer.class);

        juggler.perform();
    }
}
