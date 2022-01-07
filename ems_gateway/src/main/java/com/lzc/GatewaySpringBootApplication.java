package com.lzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/7 16:11
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewaySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewaySpringBootApplication.class,args);
    }
}
