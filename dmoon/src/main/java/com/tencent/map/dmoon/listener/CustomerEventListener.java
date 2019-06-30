package com.tencent.map.dmoon.listener;

import com.tencent.map.dmoon.event.CustomerEvent;
import com.tencent.map.dmoon.model.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@Slf4j
/**
 * 该监听器自动注入，无需addListener
 * 无法监听ApplicationStarting、ApplicationEnvironmentPrepared、ApplicationPrepared事件；
 * 之后上下文初始化后的事件均可监听，包括ContextRefresh、ServletWebServerInitialized、Started、Ready
 */
public class CustomerEventListener {
    @EventListener
    public void handEvent(Object event) {
        log.info("事件(Object)： {}", event);
    }

    @EventListener
    public void handCustomerEvent(CustomerEvent customerEvent) {
        log.info("事件(CustomerEvent): {}", customerEvent);
    }

    @EventListener(condition = "#customEvent.messageEntity.code == 'ok'")
    public void handleCustomEventByCondition(CustomerEvent customEvent) {
        log.info("事件(CustomerEventCodeCondition): xiaoxi: {}, time: {}", customEvent.getMessageEntity(),
                customEvent.getTimestamp());
    }

    @EventListener
    public void handleObjectEvent(MessageEntity messageEntity) {
        log.info("事件(MessageEntity)");
    }
}
