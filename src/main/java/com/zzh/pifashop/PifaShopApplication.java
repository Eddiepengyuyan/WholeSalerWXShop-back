package com.zzh.pifashop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zzh.pifashop.mapper")
public class PifaShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PifaShopApplication.class, args);
    }

}
