package com.malrang.chatservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatServiceApplication {
    private static final Logger logger = LoggerFactory.getLogger(ChatServiceApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ChatServiceApplication.class, args);
        logger.info("Application has started.");
    }

}
