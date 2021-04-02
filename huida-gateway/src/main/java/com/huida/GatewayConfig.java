package com.huida;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @Author WYP
 * @Date 2021/4/2
 */
@Configuration
public class GatewayConfig {

    @Bean
    public GlobalFilter customFilter() {
        return new CustomGlobalFilter();
    }




}
