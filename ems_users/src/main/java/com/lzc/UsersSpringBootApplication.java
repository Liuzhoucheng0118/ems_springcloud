package com.lzc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/7 10:40
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.lzc.mapper")
public class UsersSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsersSpringBootApplication.class,args);
    }
}
