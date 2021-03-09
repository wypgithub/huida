package com.huida.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description
 * @Author WYP
 * @Date 2021/3/9
 */
@RestController
public class TestController {
    /**
     * 无论使用哪种注册中心(Eureka,Zookeeper,Consul)，该DiscoveryClient是通用的
     * 它是一个接口
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/test")
    public List<ServiceInstance> findUser() {
        return discoveryClient.getInstances("huida-service");
    }

    @GetMapping("/service/{param}")
    public String findUser(@PathVariable("param")String param) {
        return "huida-service======" + param;
    }
}
