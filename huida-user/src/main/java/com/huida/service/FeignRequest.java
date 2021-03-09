package com.huida.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description
 * @Author WYP
 * @Date 2021/3/9
 */
//@RequestMapping("/user/test")
@Component
@FeignClient(value = "huida-service")
public interface FeignRequest {
    @GetMapping(value = "/service/{param}")
    String echo(@PathVariable("param") String param);
}
