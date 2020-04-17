package com.xp.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;

/**
 * @author Climb.Xu
 * @date 2020/4/14 21:24
 */
@Service
public class PaymentService {

    //=========服务降级
    public String paymentInfo_OK(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_OK , id: "+id+"========";
    }
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")//超过设定时间报异常,到fallback方法
    }) //一旦方法失败并抛出错误信息,就自动调用paymentInfo_TimeOutHandler方法
    public String paymentInfo_TimeOut(Integer id) {
        int timeout = 3;
        try { TimeUnit.SECONDS.sleep(timeout); } catch (InterruptedException e) { e.printStackTrace(); }
//        int s = 1 / 0; //遇到其他异常,也会进入fallback
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_TimeOut , id: "+id+"====耗时"+timeout+"秒====";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_TimeOutHandler , id: "+id+"====超时了====";
    }

    //=========服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            //com.netflix.hystrix.HystrixCommandProperties中含有commandProperties的所有value项的默认值
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //失败率达到多少后跳闸
            //在10000毫秒内的10次请求,有6次以上失败,则跳闸,10000毫秒内超过10次请求,也跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id<0){
            throw new RuntimeException("****id,不能<0");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功!!!   流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "不能为负数,调用失败,稍后再试 id: " + id;
    }
}
