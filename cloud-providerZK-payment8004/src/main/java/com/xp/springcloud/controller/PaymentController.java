package com.xp.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Climb.Xu
 * @date 2020/4/8 1:36
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String paymentZk() {
        log.info("++++++++++");
        return "SpringCloud with Zookeeper: " + serverPort + " " + UUID.randomUUID().toString();
    }
}
