package com.example.mapper_test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.example.mapper_test.mapper")
public class MapperTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapperTestApplication.class, args);
    }

}
