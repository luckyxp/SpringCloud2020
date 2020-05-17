package com.xp.springcloud.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Climb.Xu
 * @date 2020/5/12 15:23
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @StreamListener(Sink.INPUT)
    public void receiveMsg(Message<String> message) {
        System.out.println(message.getPayload());
    }
}
