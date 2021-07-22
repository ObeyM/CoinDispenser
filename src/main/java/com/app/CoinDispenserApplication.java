package com.app;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoinDispenserApplication {

    static Logger logger = LoggerFactory.getLogger(CoinDispenserApplication.class);


    public static void main(String[] args) {

        logger.debug("Starting APP...");

        SpringApplication.run(CoinDispenserApplication.class, args);
    }
}
