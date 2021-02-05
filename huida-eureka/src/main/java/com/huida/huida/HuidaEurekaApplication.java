package com.huida.huida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HuidaEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuidaEurekaApplication.class, args);
    }

}
