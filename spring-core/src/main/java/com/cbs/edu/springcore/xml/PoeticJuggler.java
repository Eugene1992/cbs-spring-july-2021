package com.cbs.edu.springcore.xml;

public class PoeticJuggler extends Juggler {

    private Poem poem;

    public PoeticJuggler(String name, long beanBugs, Poem poem) {
        super(name, beanBugs);
        this.poem = poem;
    }

    @Override
    public void perform() {
        super.perform();
        poem.recite();
    }
}
