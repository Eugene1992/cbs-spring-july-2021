package com.cbs.edu.springcore.spring;

import java.util.Scanner;

public class UserInputProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return new Scanner(System.in).nextLine();
    }
}
