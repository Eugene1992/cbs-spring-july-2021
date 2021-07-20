package com.cbs.edu.springcore.decoupled;

public class HelloWorldProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello world!";
    }
}
