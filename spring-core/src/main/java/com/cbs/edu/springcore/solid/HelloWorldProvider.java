package com.cbs.edu.springcore.solid;

public class HelloWorldProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello world!";
    }
}
