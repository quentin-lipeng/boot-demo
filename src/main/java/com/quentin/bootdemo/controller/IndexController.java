package com.quentin.bootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author quentin
 * @create 2022-10-16 16:03
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String index(@Value("${spring.application.name}") String arg) {
        return arg;
    }

}
