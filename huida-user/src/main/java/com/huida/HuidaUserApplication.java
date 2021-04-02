package com.huida;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;


@EnableDubbo
@EnableFeignClients(defaultConfiguration = FeignClientsConfiguration.class)
@EnableDiscoveryClient
@SpringBootApplication
public class HuidaUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuidaUserApplication.class, args);

    }

}
