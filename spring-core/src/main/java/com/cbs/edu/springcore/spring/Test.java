package com.cbs.edu.springcore.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Google guice
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-conf.xml");

        MessageRenderer renderer = (MessageRenderer) applicationContext.getBean("consoleMessageRenderer");

        renderer.render();
    }
}
