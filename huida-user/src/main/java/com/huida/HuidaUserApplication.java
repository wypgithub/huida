package com.huida;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.ImportResource;



@EnableFeignClients(defaultConfiguration = FeignClientsConfiguration.class)
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages	= {"com.huida.mapper"})
//@ImportResource("classpath:spring-aspect.xml")
public class HuidaUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuidaUserApplication.class, args);
    }

}
