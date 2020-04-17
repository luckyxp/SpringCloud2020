package com.xp.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Climb.Xu
 * @date 2020/4/16 21:11
 * 对PaymentHystrixService进行统一服务降级
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "===PaymentFallbackService=====paymentInfo_TimeOut,服务降级===";
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        return "===PaymentFallbackService=====paymentInfo_OK,服务降级===";
    }
}
