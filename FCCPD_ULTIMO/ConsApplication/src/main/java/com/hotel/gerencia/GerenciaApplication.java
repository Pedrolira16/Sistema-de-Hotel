package com.hotel.gerencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hotel.gerencia", "com.hotel.config"})
public class GerenciaApplication {
    public static void gerenciaRun(String[] args) {
        SpringApplication.run(GerenciaApplication.class, args);
        System.out.println("Consumidor da Gerência iniciado!");
    }
}
