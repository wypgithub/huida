package com.huida;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.google.common.collect.Maps;
import com.huida.api.UserService;
import com.huida.mapper.UserMapper;
import com.huida.pojo.User;
import com.huida.service.FeignRequest;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description
 * @Author WYP
 * @Date 2021/3/9
 */
@RestController
@RefreshScope
public class FeignController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FeignRequest feignRequest;

    @Reference(check = false)
    private UserService userService;



    @Value("${user.name}")
    private String userName;
    @Value("${value}")
    private String value;

    @GetMapping("/findConfig")
    public String findConfig() {

        System.out.println(1111111111);
        return String.format("获取配置中心数据;userName = %s;value=%s" ,userName, value);
    }

    @GetMapping("/getUserList")
    public List<User> getUserList() {


        System.out.println("aaaaaaaaaaaaaaaaa...xx");




        List<User> userList  = userMapper.selectList(null);

        userList.forEach(System.out::println);


       // userList.forEach((user)-> System.out.println(user.toString()));

        return userList;


        //return userMapper.listUsers();
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


    public static void main(String[] args) {
        HashMap<String, String> m1 = new HashMap<String, String>();//新的age 10  name 122  phone 1111
        HashMap<String, String> m2 = new HashMap<String, String>();//旧的age 11  name 122  sex  0
        m1.put("age","10");
        m1.put("name","122");
        m1.put("phone","111");

        m2.put("age","11");
        m2.put("name","122");
        m2.put("sex","0");


        Map<String, String> m3= Maps.newHashMap();
        m3.putAll(m1);
        m1.entrySet().removeAll(m2.entrySet());//获得差集
        m2.entrySet().removeAll(m3.entrySet());//获得差集
        System.out.println("update:");



    }
}
