package com.cbs.edu.springcore.xml;

public final class Stage {

    private static Stage instance = new Stage();

    private Stage() {
    }

    public static Stage getInstance() {
        return instance;
    }
}
