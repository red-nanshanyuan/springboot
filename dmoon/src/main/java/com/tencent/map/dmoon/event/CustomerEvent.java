package com.tencent.map.dmoon.event;

import com.tencent.map.dmoon.model.MessageEntity;
import org.springframework.context.ApplicationEvent;

public class CustomerEvent extends ApplicationEvent {
    private MessageEntity messageEntity;

    public CustomerEvent(Object source, MessageEntity messageEntity) {
        super(source);
        this.messageEntity = messageEntity;
    }

    public MessageEntity getMessageEntity() {
        return messageEntity;
    }
}
