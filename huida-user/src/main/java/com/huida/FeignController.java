package com.huida;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.huida.api.UserService;
import com.huida.service.FeignRequest;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description
 * @Author WYP
 * @Date 2021/3/9
 */
@RestController
@RefreshScope
public class FeignController {


    @Autowired
    private FeignRequest feignRequest;

    @Reference(check = false)
    private UserService userService;



    //获取配置中心数据
    @Value("${user.name}")
    private String value;


    @GetMapping("/findConfig")
    public String findConfig() {

        return "获取配置中心数据;value = " + value;
    }



    @GetMapping("/findDubbo")
    public String findDubbo() {
        return userService.dubboTest("Values...");
    }

    @GetMapping("/getRequest")
    public String findUser() {
        return feignRequest.getRequest("This is Get Request");
    }

    @GetMapping("/postRequest")
    public String postRequest() {
        return feignRequest.postRequest("This is Post Request", "post content");
    }

}
