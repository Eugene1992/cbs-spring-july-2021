package com.cbs.edu.springcore.spring;

public interface MessageRenderer {
    void render();

    MessageProvider getMessageProvider();

    void setMessageProvider(MessageProvider messageProvider);
}
