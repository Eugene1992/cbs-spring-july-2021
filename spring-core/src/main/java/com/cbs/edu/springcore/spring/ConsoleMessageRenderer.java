package com.cbs.edu.springcore.spring;

public class ConsoleMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider;

    public ConsoleMessageRenderer(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public void render() {
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
}
