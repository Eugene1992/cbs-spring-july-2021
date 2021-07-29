package com.cbs.edu.springbootstarterdemo.config;

public interface BitcoinPriceService {
    String getCurrentPrice();

    void printCurrentPriceByTimeOut() throws Exception;
}
