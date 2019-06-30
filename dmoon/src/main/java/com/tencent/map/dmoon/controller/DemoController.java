package com.tencent.map.dmoon.controller;

import com.tencent.map.dmoon.event.CustomerEvent;
import com.tencent.map.dmoon.model.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
@Slf4j
public class DemoController {
    @Autowired
    ApplicationEventPublisher eventPublisher;

    @GetMapping
    public String publish(String code, String message) {
        log.info("publish event: {}, {}", code, message);
        eventPublisher.publishEvent(new CustomerEvent(this, MessageEntity.builder().code(code)
                .message(message).build()));

        return "publish customerEvent success!";
    }

    @GetMapping("/obj")
    public String publishMessageEntity(String code, String message) {
        log.info("publish message entity: {}, {}", code, message);
        eventPublisher.publishEvent(MessageEntity.builder().code(code).message(message).build());

        return "publish message entity success!";
    }
}
