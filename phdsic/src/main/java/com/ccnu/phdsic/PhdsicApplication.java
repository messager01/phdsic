package com.ccnu.phdsic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ccnu.phdsic.mapper")
public class PhdsicApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhdsicApplication.class, args);
    }

}
