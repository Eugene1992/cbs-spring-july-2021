package com.cbs.edu.springcore.solid;

public class Test {
    public static void main(String[] args) {
        MessageProvider provider = new UserInputProvider();
        MessageRenderer renderer = new ConsoleMessageRenderer();
        renderer.setMessageProvider(provider);

        renderer.render();
    }
}
