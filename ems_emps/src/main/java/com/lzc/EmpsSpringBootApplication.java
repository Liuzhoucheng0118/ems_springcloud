package com.lzc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/7 10:40
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.lzc.mapper")
public class EmpsSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmpsSpringBootApplication.class,args);
    }
}
