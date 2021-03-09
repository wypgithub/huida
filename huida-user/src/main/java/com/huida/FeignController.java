package com.huida;

import com.huida.service.FeignRequest;
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
public class FeignController {

    @Autowired
    private FeignRequest feignRequest;

    @GetMapping("/test")
    public String findUser() {
        return feignRequest.echo("user-222");
    }

    @GetMapping("/test22")
    public String findUser22() {
        return "user-222";
    }
}
