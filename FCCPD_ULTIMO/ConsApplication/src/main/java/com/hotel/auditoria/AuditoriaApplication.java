package com.hotel.auditoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hotel.auditoria", "com.hotel.config"})
public class AuditoriaApplication {
    public static void auditoriaRun(String[] args) {
        SpringApplication.run(AuditoriaApplication.class, args);
        System.out.println("Consumidor de Auditoria iniciado!");
    }
}
