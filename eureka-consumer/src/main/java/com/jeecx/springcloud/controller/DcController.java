package com.jeecx.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ===========================
 * Created with IntelliJ IDEA.
 * User：yanghl
 * Date：2018/1/31
 * Time：13:32
 * ===========================
 */
@RestController
public class DcController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    //RestTemplate对象实现对服务提供者接口的调用。
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String dc(){

        //先通过loadBalancerClient的choose函数来负载均衡的选出一个eureka-client的服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() +"/dc";
        System.out.println(url);
        return restTemplate.getForObject(url,String.class);

    }
}
