package com.cbs.edu.springbootstarterdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.Data;

public class CoinbaseBitcoinPriceService implements BitcoinPriceService {

    String URL = "https://api.coinbase.com/v2/prices/spot?currency=USD";

    @Autowired
    private BitcoinPriceCheckProperties checkProperties;

    @Override
    public String getCurrentPrice() {
        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<CoindeskBitcoinPriceResponse> response =
                restTemplate.getForEntity(URL, CoindeskBitcoinPriceResponse.class);

        return response.getBody().getData().getAmount();
    }

    @Override
    public void printCurrentPriceByTimeOut() throws Exception {
        final Integer checkTimeout = checkProperties.getTimeout();
        while (true) {
            Thread.sleep(checkTimeout * 1000);
            System.out.println(getCurrentPrice());
        }
    }

    @Data
    public static class CoindeskBitcoinPriceResponse {

        private Currency data;

        @Data
        private static class Currency {
            private String amount;
        }
    }
}
