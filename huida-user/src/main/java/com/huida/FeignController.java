package com.huida;

import com.huida.api.UserService;
import com.huida.service.FeignRequest;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description
 * @Author WYP
 * @Date 2021/3/9
 */
@RestController
public class FeignController {

    @Autowired
    private FeignRequest feignRequest;

    @Reference(retries = 0, check = false)
    private UserService userService;


    @GetMapping("/test")
    public String findUser() {
        return feignRequest.echo("user-222");
    }

    @GetMapping("/test22")
    public String findUser22() {
        return "user-222";
    }

    @GetMapping("/test33")
    public String findDubbo() {
        return userService.dubboTest("dubbo");
    }
}
