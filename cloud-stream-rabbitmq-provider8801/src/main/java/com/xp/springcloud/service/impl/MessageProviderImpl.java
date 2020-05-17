package com.xp.springcloud.service.impl;

import com.xp.springcloud.service.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author Climb.Xu
 * @date 2020/5/12 9:56
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements MessageProvider {
    @Resource
    private MessageChannel output;
    @Override
    public Boolean send(String serial) {
        boolean result = output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("******serial: " + serial);
        return result;
    }
}
