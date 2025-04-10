package com.hotel.gerencia;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;

@Component
public class GerenciaConsumer {

    @RabbitListener(queues = "hotel-gerente")
    public void receiveEmergencia(byte[] message) {
        System.out.println("\n🚨 GERÊNCIA RECEBEU EMERGÊNCIA 🚨");
        System.out.println(new String(message, StandardCharsets.UTF_8));
        System.out.println("=".repeat(50) + "\n");
    }

    @RabbitListener(queues = "hotel-gerente")
    public void receiveRelatorioDiario(byte[] message) {
        System.out.println("\n📊 GERÊNCIA RECEBEU RELATÓRIO DIÁRIO 📊");
        System.out.println(new String(message, StandardCharsets.UTF_8));
        System.out.println("=".repeat(50) + "\n");
    }
}
