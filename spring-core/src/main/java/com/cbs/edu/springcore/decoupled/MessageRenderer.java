package com.cbs.edu.springcore.decoupled;

public interface MessageRenderer {
    void render();

    MessageProvider getMessageProvider();

    void setMessageProvider(MessageProvider messageProvider);
}
