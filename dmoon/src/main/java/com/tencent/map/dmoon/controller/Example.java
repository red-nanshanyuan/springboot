package com.tencent.map.dmoon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping("/")
    public String hello() {
        return "Hello world!";
    }
}
