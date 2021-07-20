package com.cbs.edu.springcore.decoupled;


public class Test {
    public static void main(String[] args) {
        DecoupledMessageFactory instance = DecoupledMessageFactory.getInstance();

        MessageProvider provider = instance.getMessageProvider();
        MessageRenderer renderer = instance.getMessageRenderer();
        renderer.setMessageProvider(provider);

        renderer.render();
    }
}
