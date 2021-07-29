package com.cbs.edu.springbootstarterdemo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BitcoinPriceCheckProperties.class)
@ConditionalOnProperty(value = "bitcoin-price-check", havingValue = "on")
public class BitcoinCheckerConfiguration {

    @Bean
    public BitcoinPriceService bitcoinPriceService() {
        return new CoinbaseBitcoinPriceService();
    }
}
