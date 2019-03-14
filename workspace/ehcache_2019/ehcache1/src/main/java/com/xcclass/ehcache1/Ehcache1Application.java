package com.xcclass.ehcache1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = {"com.xcclass.ehcache1.mapper"})
public class Ehcache1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ehcache1Application.class, args);
    }

}

