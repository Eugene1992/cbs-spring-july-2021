package com.cbs.edu.springcore.base;

// not OOP oriented
// Single Responsibility principle not supported
public class Test {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(args[0]);
        } else {
            System.out.println("Hello world!");
        }
    }
}
