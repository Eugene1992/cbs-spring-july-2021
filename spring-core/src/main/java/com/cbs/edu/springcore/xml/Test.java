package com.cbs.edu.springcore.xml;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/test1.xml");

//        final Performer juke = applicationContext.getBean("Juke", Performer.class);
//        juke.perform();

//        final Performer poeticJuke = applicationContext.getBean("poeticJuke", PoeticJuggler.class);
//        poeticJuke.perform();
        //
//        final Stage stage = applicationContext.getBean("stage", Stage.class);

//        final Ticket ticket1 = applicationContext.getBean("ticket", Ticket.class);
//
//        final Ticket ticket2 = applicationContext.getBean("ticket", Ticket.class);
//
//        System.out.println(ticket1.hashCode());
//        System.out.println(ticket2.hashCode());

//        Auditorium auditorium = applicationContext.getBean("auditorium", Auditorium.class);
//        applicationContext.close();

//        Instrumentalist instrumentalist = applicationContext.getBean("instrumentalist", Instrumentalist.class);
//        instrumentalist.perform();

        OneManBand oneManBand = applicationContext.getBean("oneManBand", OneManBand.class);
        oneManBand.perform();
    }
}
