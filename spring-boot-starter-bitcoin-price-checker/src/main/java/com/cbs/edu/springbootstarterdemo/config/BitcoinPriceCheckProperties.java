package com.cbs.edu.springbootstarterdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "bitcoin-price-check")
public class BitcoinPriceCheckProperties {
    private Integer timeout;
}
