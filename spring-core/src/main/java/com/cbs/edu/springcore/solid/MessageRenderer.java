package com.cbs.edu.springcore.solid;

public interface MessageRenderer {
    void render();

    MessageProvider getMessageProvider();

    void setMessageProvider(MessageProvider messageProvider);
}
