package com.hotel.secretaria;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;

@Component
public class SecretariaConsumer {

    @RabbitListener(queues = "hotel-recepcionista")
    public void receiveNovaReserva(byte[] message) {
        System.out.println(new String(message, StandardCharsets.UTF_8));
        System.out.println("=".repeat(50) + "\n");
    }

    @RabbitListener(queues = "hotel-recepcionista")
    public void receiveAlteracaoReserva(byte[] message) {
        System.out.println(new String(message, StandardCharsets.UTF_8));
        System.out.println("=".repeat(50) + "\n");
    }

    @RabbitListener(queues = "hotel-recepcionista")
    public void receiveItemPerdido(byte[] message) {
        System.out.println(new String(message, StandardCharsets.UTF_8));
        System.out.println("=".repeat(50) + "\n");
    }

    @RabbitListener(queues = "hotel-recepcionista")
    public void receiveEmergencia(byte[] message) {
        System.out.println(new String(message, StandardCharsets.UTF_8));
        System.out.println("=".repeat(50) + "\n");
    }
}
