package com.xp.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.xp.springcloud.pojo.CommonResult;
import com.xp.springcloud.pojo.Payment;
import com.xp.springcloud.service.PaymentService;
import jdk.nashorn.internal.ir.CallNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Climb.Xu
 * @date 2020/4/8 1:36
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        log.info(payment + "===payment");
        int result = paymentService.create(payment);
        log.info("======插入结果: " + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败,serverPort: " + serverPort, null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("======插入结果: " + result);
        if (result != null) {
            return new CommonResult(200, "查询成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "没有对应记录.查询ID: " + id + " serverPort: " + serverPort, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        //eureka上的所有服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("********service: " + service);
        }

        //CLOUD-PAYMENT-SERVICE服务下的所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return new Object[]{this.discoveryClient, services, instances};
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "here is payment-zipkin,hello !!";
    }
}
