package com.cbs.edu.springcore.spring;

public class HelloWorldProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello world!";
    }
}
