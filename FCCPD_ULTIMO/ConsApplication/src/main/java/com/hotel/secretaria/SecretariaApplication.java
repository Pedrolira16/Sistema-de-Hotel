package com.hotel.secretaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hotel.secretaria", "com.hotel.config"})
public class SecretariaApplication {
    public static void secretariaRun(String[] args) {
        SpringApplication.run(SecretariaApplication.class, args);
        System.out.println("Consumidor da Secretaria iniciado!");
    }
}
