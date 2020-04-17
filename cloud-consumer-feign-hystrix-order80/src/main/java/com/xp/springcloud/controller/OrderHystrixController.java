package com.xp.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xp.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Climb.Xu
 * @date 2020/4/14 22:13
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_TimeOutHandler",commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000"))//当使用,全局的fallback时,fallback方法就不能有参数
public class OrderHystrixController     {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand //可以在类上使用@DefaultProperties(defaultFallback = "paymentInfo_TimeOutHandler") 全局fallback
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
//        int s = 1 / 0; 
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentInfo_TimeOutHandler() {
        return "对方繁忙,稍后重试";
    } //使用@DefaultProperties时,此方法不能有参数

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
     String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }
}
