package com.cbs.edu.springcore.decoupled;

import java.io.FileInputStream;
import java.util.Properties;

public class DecoupledMessageFactory {
    private static DecoupledMessageFactory factory;

    private MessageProvider provider;
    private MessageRenderer renderer;

    private Properties properties;

    static {
        factory = new DecoupledMessageFactory();
    }

    private DecoupledMessageFactory() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\Xiaomi\\OneDrive\\Desktop\\JDBC & Hibernate Student\\cbs-spring-july-2021\\spring-core\\src\\main\\resources\\message.properties"));

            final String providerClass = properties.getProperty("message.provider.class");
            final String rendererClass = properties.getProperty("message.renderer.class");

            provider = (MessageProvider) Class.forName(providerClass).newInstance();
            renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DecoupledMessageFactory getInstance() {
        return factory;
    }

    public MessageProvider getMessageProvider() {
        return provider;
    }

    public MessageRenderer getMessageRenderer() {
        return renderer;
    }
}
