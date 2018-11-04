package com.chan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class Example {

    @RequestMapping("/")
    public String name() {
        return "this is my first spring boot app";
    }

    public static void main(String args[]) {
        SpringApplication.run(Example.class, args);
    }
}
