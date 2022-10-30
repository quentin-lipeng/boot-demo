package com.quentin.bootdemo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * If you need to run some specific code once the SpringApplication has started,
 * you can implement the ApplicationRunner or CommandLineRunner interfaces.
 * @author quentin
 * @create 2022-10-23 20:02
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    public static final Logger LOGGER = LoggerFactory.getLogger(MyCommandLineRunner.class);
    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Command line runner is running");
    }
}
