package com.cbs.edu.springcore.xml;

public class Juggler implements Performer {

    private String name;
    private long beanBugs;

    public Juggler(String name, long beanBugs) {
        this.name = name;
        this.beanBugs = beanBugs;
    }

    @Override
    public void perform() {
        System.out.println(name + " jugging " + beanBugs + " bugs!");
    }
}
