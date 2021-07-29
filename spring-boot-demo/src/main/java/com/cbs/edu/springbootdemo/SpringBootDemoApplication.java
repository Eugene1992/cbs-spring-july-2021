package com.cbs.edu.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cbs.edu.springbootstarterdemo.config.BitcoinPriceService;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {

    @Autowired
    private BitcoinPriceService bitcoinPriceService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        bitcoinPriceService.printCurrentPriceByTimeOut();
    }

}
