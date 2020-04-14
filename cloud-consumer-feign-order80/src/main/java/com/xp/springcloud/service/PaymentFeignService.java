package com.xp.springcloud.service;

import com.xp.springcloud.pojo.CommonResult;
import com.xp.springcloud.pojo.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Climb.Xu
 * @date 2020/4/14 19:51
 */
@Service
@FeignClient("cloud-payment-service")//调用哪个微服务
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}") //去"cloud-payment-service"访问"/payment/get/{id}"这个handler
    CommonResult getPaymentById(@PathVariable("id") Long id);
}
